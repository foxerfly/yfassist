/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import SqlInterface.QueryErp;
import com.edwin.my.RCPSessionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author EDWIN
 */
public class BomFun {

    private ArrayList<String> bomList;
    private String insertProcName = "{CALL me_procRetrieveStandBom(?,?,?,?,?)}";
    private String updateProcName = "{CALL me_procRetrieveStandBom(?,?,?,?,?)}";
    private String addProcName = "{CALL me_procRetrieveStandBom(?,?,?,?,?)}";

    //往COPTR表插入BOM
    public boolean insertCOPTRBom(ArrayList<String> bomList) {

        if (!bomList.isEmpty()) {
            this.bomList = (ArrayList<String>) bomList.clone();
        }
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        if (qr instanceof QueryErp) {

            try {

                if (qr.rsErpProcS(insertProcName, bomList)) {
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

    public ArrayList<String> getRoot(String ph) {

        ArrayList<String> bomList = new ArrayList<String>();
        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        List lsa = s.createSQLQuery("SELECT TR004 \n"
                + "FROM COPTR \n"
                + "WHERE TR001=? AND TR002=? AND TR009=?").setString(0, QueryCondition.getPh()).setString(1, QueryCondition.getPzh()).setString(2, ph).list();

        List lsb = s.createSQLQuery("SELECT TR003\n"
                + "FROM COPTR \n"
                + "WHERE TR001=? AND TR002=? AND TR009=?").setString(0, QueryCondition.getPh()).setString(1, QueryCondition.getPzh()).setString(2, ph).list();
//        System.out.println(bomList);
        tx.commit();
        s.close();

        bomList.add(QueryCondition.getPh().toString().trim());  //配置品号
        bomList.add(QueryCondition.getPzh().toString().trim()); //配置号
        if (!lsa.isEmpty()) {
            bomList.add((String) lsa.get(0).toString().trim());     //上阶品号
        } else {
            bomList.add(ph);
        }
        if (!lsb.isEmpty()) {
            bomList.add((String) lsb.get(0).toString().trim());    //本阶层级
        } else {
            bomList.add("000");
        }
        bomList.add(ph.toString().trim());                     //本阶品号
//        System.out.println(bomList);
        return bomList;
    }

    public boolean changeBom() {
        return false;
    }

    public boolean insertBom() {
        return false;
    }

    /*
     传入品号，配置号，修改/完成状态  true/false
     */
    public boolean changeOrderBom(boolean state) throws ClassNotFoundException, SQLException {

        String sql = "SELECT DISTINCT TC001,TC002\n"
                + "FROM COPTC \n"
                + "INNER JOIN  COPTD  ON TD001=TC001 AND TD002=TC002 \n"
                + "WHERE TD004=? AND TD053=?  AND TC027<>'V' AND TC016<>'N' \n";

        String sqlPreUpdate = "UPDATE COPTC SET UDF08=TC016,UDF10='PZHPRE'  WHERE TC001=? AND TC002=?";
        String sqlUpdate = "UPDATE COPTC SET TC016='N' ,UDF10='PZHDO' WHERE UDF10='PZHPRE'";
        String sqlRecovery = "UPDATE COPTC SET TC016=RTRIM(UDF08) ,UDF10=''   WHERE UDF10='PZHDO'";

        String TC001 = "";
        String TC002 = "";
        ArrayList<String> alist = new ArrayList<String>();
        ResultSet rs;
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        if (qr instanceof QueryErp) {
            rs = qr.rsErp(sql, QueryCondition.getPh(), QueryCondition.getPzh());
            while (rs.next()) {
                TC001 = rs.getString("TC001");
                TC002 = rs.getString("TC002");
                alist.add(TC001);
                alist.add(TC002);
                qr.rsErpS(sqlPreUpdate, alist);
                alist.removeAll(alist);
            }
            if (state == true) {

                if (qr.updateErp(sqlUpdate)) {
                    return true;
                }

            } else {
                if (qr.updateErp(sqlRecovery)) {
                    return true;
                }
            }

        }
        return false;
    }
}
