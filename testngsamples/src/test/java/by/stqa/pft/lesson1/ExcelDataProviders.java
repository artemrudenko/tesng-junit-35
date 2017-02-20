package by.stqa.pft.lesson1;


import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataProviders {

  private static HSSFWorkbook readFile(String filename) throws IOException {
    try (FileInputStream fis = new FileInputStream(filename)) {
      return new HSSFWorkbook(fis);
    }
  }

  @DataProvider
  public static Object[][] excelDataProvider(Method m) throws IOException {
    if (m.isAnnotationPresent(ExcelDataSource.class)) {
      int length = m.getParameterTypes().length;
      ExcelDataSource dataSource = m.getAnnotation(ExcelDataSource.class);
      List<Object[]> result = new ArrayList<Object[]>();
      URL url = m.getDeclaringClass().getResource("/" + dataSource.value());
      HSSFWorkbook wb = ExcelDataProviders.readFile(url.getPath());
      String sheetname = dataSource.sheetname();

      for (int k = 0; k < wb.getNumberOfSheets(); k++) {
        HSSFSheet sheet = wb.getSheetAt(k);
        if(!sheetname.equals("") && !sheet.getSheetName().equals(sheetname)){
          continue;
        }
        int rows = sheet.getPhysicalNumberOfRows();
//        starting from 1 to skip header row
        for (int r = 1; r < rows; r++) {
          HSSFRow row = sheet.getRow(r);
          if (row == null) {
            continue;
          }

          Object[] parameters = new Object[length];
          for (int c = 0; c < length; c++) {
            HSSFCell cell = row.getCell(c);
            parameters[c] = (cell != null)? cell.getStringCellValue(): null;
          }
          result.add(parameters);
        }
      }
      wb.close();
      return result.toArray(new Object[result.size()][]);
    } else {
      throw new Error("There is no @CsvDataSource annotation on method " + m);
    }
  }

  @DataProvider
  public static Iterator<Object[]> lazyExcelDataProvider(Method m) throws IOException {
    if (m.isAnnotationPresent(ExcelDataSource.class)) {
      int length = m.getParameterTypes().length;
      ExcelDataSource dataSource = m.getAnnotation(ExcelDataSource.class);
      URL url = m.getDeclaringClass().getResource("/" + dataSource.value());
      HSSFWorkbook wb = ExcelDataProviders.readFile(url.getPath());
      return new ExcelSheetIterator(wb.getSheet(dataSource.sheetname()), length);
    } else {
      throw new Error("There is no @ExcelDataSource annotation on method " + m);
    }
  }

  private static class ExcelSheetIterator implements Iterator<Object[]> {

    private final HSSFSheet sheet;
    private int lastRowId = 0;
    private int length;

    public ExcelSheetIterator(HSSFSheet sheet, int length) throws FileNotFoundException {
      this.length = length;
      this.sheet = sheet;
    }

    @Override
    public boolean hasNext() {
      return sheet.getRow(lastRowId+1) != null;
    }

    @Override
    public Object[] next() {
      HSSFRow row = sheet.getRow(++lastRowId);
      Object[] parameters = new Object[length];
      for (int c = 0; c < length; c++) {
        HSSFCell cell = row.getCell(c);
        parameters[c] = (cell != null)? cell.getStringCellValue(): null;
      }
      return parameters;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}