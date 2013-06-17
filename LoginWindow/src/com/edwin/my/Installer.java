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
//    private InstanceContent content = new InstanceContent();

    @Override
    public void restored() {
        // TODO
//        ProxyFactory.classLoaderProvider = new ProxyFactory.ClassLoaderProvider() {
//            @Override
//            public ClassLoader get(ProxyFactory pf) {
//                return Thread.currentThread().getContextClassLoader();
//            }
//        };
//
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

        //for hiberanter
//        ProxyFactory.classLoaderProvider = new ProxyFactory.ClassLoaderProvider() {
//            @Override
//            public ClassLoader get(ProxyFactory pf) {
//                return Thread.currentThread().getContextClassLoader();
//            }
//        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        dlg.setProgressbar();
//        dlg.updateUI();
//        dlg.setProgressbarVisible();
        checkLogin(e);

//        d.setClosingOptions(null);
    }

//    @Override
//    public boolean closing() {
//        NotifyDescriptor d = new NotifyDescriptor.Confirmation(
//                "确定退出吗？",
//                "退出",
//                NotifyDescriptor.YES_NO_OPTION);
//        if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.YES_OPTION) {
//            return true;
//        } else {
//
//            return false;
//        }
//    }
    private void checkLogin(ActionEvent e) {
        if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
            LifecycleManager.getDefault().exit();
        } else {

            Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
            for (QueryErp qr : c) {
                try {

                    ResultSet rs = qr.checkUserLogin(dlg.getUsername(), dlg.getPassword());
                    if (rs.next()) {

//                        System.out.println(dlg.getUsername() + "          " + dlg.getPassword());
//                        System.out.println(c.iterator().next().checkUserLogin(dlg.getUsername(), dlg.getPassword()));
//                        StringBuffer sb = null;
//                        sb.append("欢迎：" + rs.getString("ME002") + "  " + rs.getString("MV002"));
//                        PreVector ps = new PreVector();
//                        ps.setLoginUserName(rs.getString("MA001"));
//                        ps.setLoginUserDep(rs.getString("MV004"));
                        d.setClosingOptions(null);
//                        StatusDisplayer.getDefault().setStatusText(sb.toString());
                        StatusDisplayer.getDefault().setStatusText("欢迎：" + rs.getString("MA001") + "  " + rs.getString("ME002") + "  " + rs.getString("MV002"), 65535);
                        PreVectorInterface ps = Lookup.getDefault().lookup(PreVectorInterface.class);
                        ps.setLoginUserName(rs.getString("MA001").trim());
                        ps.setLoginUserDep(rs.getString("ME002").trim());
//                        LoginUser lg = new LoginUser(ps.getLoginUserName());
//                        content.set(Collections.singleton(ps), null);

                    } else {

                        dlg.setInfo("Wrong user name or password");
                    }
                } catch (ClassNotFoundException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }

            }

        }

//        if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
//            LifecycleManager.getDefault().exit();
//        } else {
//
//            Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
//
//            while (c.iterator().hasNext()) {
//                try {
//                    if (c.iterator().next().checkUserLogin(dlg.getUsername(), dlg.getPassword())) {
//                        System.out.println(dlg.getUsername() + "          " + dlg.getPassword());
//                        System.out.println(c.iterator().next().checkUserLogin(dlg.getUsername(), dlg.getPassword()));
//
//                        d.setClosingOptions(null);
//
//                    } else {
//
//                        dlg.setInfo("Wrong user name or password");
//
//                        System.out.println(dlg.getUsername() + "          " + dlg.getPassword());
//                        System.out.println(c.iterator().next().checkUserLogin(dlg.getUsername(), dlg.getPassword()));
//                    };
//                } catch (ClassNotFoundException ex) {
//                    Exceptions.printStackTrace(ex);
//                } catch (SQLException ex) {
//                    Exceptions.printStackTrace(ex);
//                }
//
//            }
//
//
//        }
    }

}
