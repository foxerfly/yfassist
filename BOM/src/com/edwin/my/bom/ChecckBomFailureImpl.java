/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.bom;

import SqlInterface.QueryErp;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author John
 */
public class ChecckBomFailureImpl implements Runnable {

    private Icon time = new ImageIcon(getClass().getResource("/ICON/time.png"));
    public boolean threadFlag = false;
    int timeDuration = 0;

    public ChecckBomFailureImpl(int i) {

//        checkBomSequence();
        this.timeDuration = i;

    }

    //检查是否有审核失败，如果有，则更新
    private void checkBomSequence() throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        String searchSql = "SELECT TOP 1 ISNULL(SUBSTRING(BOMCB.MODI_DATE,1,8),'') GDATE,MD001,MD003,MD002,CB004,MB025,MD031,CB031\n"
                + "from BOMMD\n"
                + "LEFT JOIN BOMCB ON CB001=MD001 AND CB005=MD003\n"
                + "LEFT JOIN INVMB ON MB001=MD003\n"
                + "WHERE MD031='N' and CB031='Y' AND CB022='Y'  \n"
                + "ORDER BY  BOMCB.MODI_DATE";
        String updateSql = "UPDATE BOMMD\n"
                + "SET MD031='Y'\n"
                + "from BOMMD\n"
                + "LEFT JOIN BOMCB ON CB001=MD001 AND CB005=MD003\n"
                + "WHERE MD031='N' and CB031='Y' AND CB022='Y' ";


        Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
        for (QueryErp qr : c) {

            rs = qr.rsErp(searchSql);
            if (rs.next()) {
                qr.updateErp(updateSql);
//                JOptionPane.showConfirmDialog(null, "修改成功");
                NotificationDisplayer.getDefault().notify("", time, "发现异常，已更新", null, NotificationDisplayer.Priority.HIGH);
            } else {
//                JOptionPane.showConfirmDialog(null, "未发现审核失败");
            }

        }
    }

    @Override
    public void run() {
        try {

            while (!threadFlag) {
                checkBomSequence();
                System.out.println("----");
                Thread.sleep(timeDuration * 60 * 1000);
            }
            System.out.println("线程中止");

        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (InterruptedException ex) {
//            Exceptions.printStackTrace(ex);
            throw new RuntimeException("Interrupted", ex);

        }





    }
}
