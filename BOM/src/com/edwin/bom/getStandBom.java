/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import SqlInterface.QueryErp;
import java.sql.SQLException;
import java.util.ArrayList;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author John
 */
public class getStandBom {

    //PH ,          PZH         SJCP,   BJCJ,       BJPH
    //1 配置品号，2：配置号，3：上阶品号,4:本阶层级,5：本阶品号
    private ArrayList<String> bomList;
    String procName = "{CALL me_procRetrieveStandBom(?,?,?,?,?)}";

    //往COPTR表插入BOM
    public boolean insertCOPTRBom(ArrayList<String> bomList) {

        if (!bomList.isEmpty()) {
            this.bomList = (ArrayList<String>) bomList.clone();
        }
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        if (qr instanceof QueryErp) {

            try {
                
               

                if (qr.rsErpProcS(procName, bomList)) {
//                     System.out.println(bomList);
                    return true;
                } else {
                    return false;
                }

//            System.out.println(this.ph);
            } catch (ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }

            return false;

        }
        return false;
    }
}
