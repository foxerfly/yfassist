/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author John
 */
public class ExportExcel {

    public static Boolean ExportStandardExcel(String s) {
        
        FileOutputStream fout = null;
        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet();
            HSSFRow row = sheet.createRow(0);

            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0:
                        row.createCell(i).setCellValue("品号");
                        break;
                    case 1:
                        row.createCell(i).setCellValue("原材料成本");
                        break;
                    case 2:
                        row.createCell(i).setCellValue("人工成本");
                        break;
                    case 3:
                        row.createCell(i).setCellValue("制费");
                        break;
                    case 4:
                        row.createCell(i).setCellValue("加工费");
                        break;
                }
            }

//            File f = new File("D:/成本导入模板.xls");
            File f = new File(s);
            
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
