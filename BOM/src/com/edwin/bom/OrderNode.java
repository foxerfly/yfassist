/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import com.edwin.bomtable.Coptr;
import com.edwin.bomtable.CoptrId;
import com.edwin.my.RCPSessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.nodes.AbstractNode;

/**
 *
 * @author John
 */
public class OrderNode extends AbstractNode {

    private DialogDescriptor d;
    private getStandBom gs;
    private String ph;
    private String root;

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

        bomList.add((String) lsa.get(0).toString().trim());
        bomList.add((String) lsb.get(0).toString().trim());
        bomList.add(ph.toString().trim());
//        System.out.println(bomList);
        return bomList;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public OrderNode(String key) {
//        super(children);
        super(new OrderNodeChildren(key));
        setPh(key);

    }

    @Override
    public Action[] getActions(boolean context) {
        return new Action[]{new MyAction() {
        }};
    }

    private class MyAction extends AbstractAction {

        public MyAction() {
            putValue(NAME, "取标准BOM");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            importStandBom();

        }

    }

    private void importStandBom() {
        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
                    d.setClosingOptions(null);
//                if (logger.isDebugEnabled()  {
//                    logger.debug("Entry number: ");
//                }
                } else {
                    gs = new getStandBom(getRoot(ph));
                    gs.insertCOPTRBom();
                    d.setClosingOptions(null);

                }
            }
        };
        d = new DialogDescriptor("", getPh(), true, ac);
        d.setClosingOptions(new Object[]{});
        d.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(DialogDescriptor.PROP_VALUE)
                        && e.getNewValue() == DialogDescriptor.CLOSED_OPTION) {
                    d.setClosingOptions(null);
                }
            }
        });
        DialogDisplayer.getDefault().notifyLater(d);
    }

}
