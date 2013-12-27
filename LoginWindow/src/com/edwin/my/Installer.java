/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my;

import PreVector.PreVectorInterface;
import SqlInterface.QueryErp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.openide.DialogDescriptor;
import org.openide.LifecycleManager;
import org.openide.DialogDisplayer;
import org.openide.awt.StatusDisplayer;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

public class Installer extends ModuleInstall implements ActionListener {

    private DialogDescriptor d = null;
    private LoginPanel dlg = new LoginPanel();

    @Override
    public void restored() {
        d = new DialogDescriptor(dlg, "易飞外挂", true, this);
        d.setClosingOptions(new Object[]{});
        d.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(DialogDescriptor.PROP_VALUE)
                        && e.getNewValue() == DialogDescriptor.CLOSED_OPTION) {
                    LifecycleManager.getDefault().exit();
                }
            }
        });
        DialogDisplayer.getDefault().notifyLater(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkLogin(e);
    }

    private void checkLogin(ActionEvent e) {
        if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
            LifecycleManager.getDefault().exit();
        } else {

            Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
            for (QueryErp qr : c) {
                try {

                    ResultSet rs = qr.checkUserLogin(dlg.getUsername(), dlg.getPassword());
                    if (rs.next()) {

                        d.setClosingOptions(null);
                        StatusDisplayer.getDefault().setStatusText("欢迎：" + rs.getString("MA001") + "  " + rs.getString("ME002") + "  " + rs.getString("MV002"), 65535);
                        PreVectorInterface ps = Lookup.getDefault().lookup(PreVectorInterface.class);
                        ps.setLoginUserName(rs.getString("MA001").trim());
                        ps.setLoginUserDep(rs.getString("ME002").trim());

                    } else {

                        dlg.setInfo("密码错误");
                    }
                } catch (ClassNotFoundException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }

            }

        }

    }

}
