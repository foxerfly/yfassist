/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlImplements;

import com.edwin.my.Excel.Excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author John
 */

@ServiceProvider(
        service = Excel.class)
public class ExcelImp implements  Excel{

    @Override
    public ArrayList< ArrayList >  readExcel(File directoryAndfileName) {
         ArrayList< ArrayList > rowData=new ArrayList <ArrayList> ();
         ArrayList rowDataDetail=new ArrayList();
        try {
            FileInputStream fi=new FileInputStream(directoryAndfileName);
            try {
                int rownum=0;
                int column=0;
                XSSFWorkbook rwb=new XSSFWorkbook(fi);
                XSSFSheet st=rwb.getSheetAt(0);

                for(int i=1;i<st.getLastRowNum();i++){

//                    for(int j=0;j<st.get)

                }



            } catch (IOException ex) {
                Logger.getLogger(ExcelImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowData;
    }



}
