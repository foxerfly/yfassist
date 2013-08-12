/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.warehouse;

import com.edwin.my.RCPSessionFactory;
import com.edwin.myswingx.MyJTableModel;
import com.edwin.myswingx.MyJXTable;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author John
 */
public class GetSfctcModel {

    protected DefaultTableModel getTableModel() {
        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        List<Object[][]> ll = s.createSQLQuery("SELECT '-1' ROWID,TB001,TB002,TB003,TB004,TB005,RTRIM(TB006) TB006\n"
                + "    FROM SFCTB AS SFCTB\n"
                + "    LEFT JOIN CMSMQ  AS CMSMQ ON MQ001=TB001\n"
                + "    WHERE  TB013='Y' AND MQ003='D1'  \n"
                + "               AND TB012='N' AND NOT EXISTS(SELECT TOP 1 TC001 FROM MOCTC WHERE TC019=TB001 AND TC020=TB002)\n"
                + "    AND TB003>CONVERT(CHAR(8),DATEADD(D,-15,GETDATE()),112)").list();

        MyJTableModel mj = new MyJTableModel("选择","单别", "单号", "转移日期", "移出类别", "移出地", "移出地名称");
        DefaultTableModel dd = new DefaultTableModel(getObjectAllRow(ll), mj.getColumnNamesObject());
        tx.commit();
        s.close();
        return dd;
    }

    public Object[][] getObjectAllRow(List<Object[][]> ll) {

        Object[][] ooDate = new Object[ll.size()][];

        for (int i = 0; i < ll.size(); i++) {
            ooDate[i] = ll.get(i);
        }

        return ooDate;

    }

}
