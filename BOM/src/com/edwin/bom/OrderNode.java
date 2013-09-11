/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import com.edwin.my.RCPSessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.JMenuItem;
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
        return new Action[]{new MyAction("取标准BOM"), new MyAction("变更品号"), new MyAction("插入品号")
        };
    }

    private class MyAction extends AbstractAction {

        public MyAction(String key) {
//            JMenuItem mStandard=new JMenuItem("取标准BOM");  
//            JMenuItem mUpdate=new JMenuItem("变更品号");  
//            JMenuItem mInsert=new JMenuItem("插入品号");  
//            
//            putValue(NAME , "取标准BOM");
//            putValue(NAME, "变更品号");
//            putValue(NAME, "插入品号");
            putValue(NAME, key);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

//            System.out.println(e.getActionCommand());
            BomFun bm=new BomFun();
            
            switch (e.getActionCommand()) {

                case "取标准BOM":
                    importStandBom();
                    break;
                case "变更品号":
                    changeBom();
                    break;
                case "插入品号":
                    insertBom();
                    break;

            }

        }

    }

    private void insertBom() {
        
    }

    private void changeBom() {
        
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
                    gs = new getStandBom();
                    gs.insertCOPTRBom(getRoot(ph));
                    d.setClosingOptions(null);

                }
            }
        };
        d = new DialogDescriptor("确定重新取标准BOM吗，将会清空原配置信息", "重取：" + getPh() + "标准BOM信息", true, ac);

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
