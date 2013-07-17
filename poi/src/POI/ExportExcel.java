/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author John
 */
public abstract class ExportExcel {

    public static Boolean ExportStandardExcel() {
        FileOutputStream fout = null;
        try {
            FileInputStream is = new FileInputStream("D:\\temp\\21341.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(is);
            XSSFSheet sheet = wb.createSheet();
            XSSFRow row = sheet.createRow(1);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue("品号s");
            File f = new File("D:\\TEST.xls");
            f.createNewFile();
            fout = new FileOutputStream(f);
            wb.write(fout);
            fout.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportExcel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(ExportExcel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                fout.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ExportExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
