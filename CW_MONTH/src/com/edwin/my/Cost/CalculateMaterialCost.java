/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import SqlInterface.QueryErp;
import java.sql.SQLException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author EDWIN
 */
public class CalculateMaterialCost {

    String ROOT = "";
    String procName = "{CALL me_COST_cal(?)}";

    public CalculateMaterialCost(String ROOT) {
        this.ROOT = ROOT;
    }

    public Boolean calResult() {

        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        if (qr instanceof QueryErp) {

            try {

                if (qr.rsErpProc(procName, ROOT)) {
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

        }

        return false;
    }
}
