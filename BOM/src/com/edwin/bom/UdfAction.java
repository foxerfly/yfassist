/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

/**
 *
 * @author EDWIN
 */
public class UdfAction extends AbstractAction {

    private DialogDescriptor d;
    private getStandBom gs;
    private String ph;

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public UdfAction(String key) {
//            JMenuItem mStandard=new JMenuItem("取标准BOM");  
//            JMenuItem mUpdate=new JMenuItem("变更品号");  
//            JMenuItem mInsert=new JMenuItem("插入品号");  
//            
//            putValue(NAME , "取标准BOM");
//            putValue(NAME, "变更品号");
//            putValue(NAME, "插入品号");
        putValue(NAME, key);
        setPh(key);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//            System.out.println(e.getActionCommand());
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
                    BomFun bm = new BomFun();
                    bm.insertCOPTRBom(bm.getRoot(ph));
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

    private void changeBom() {

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
                    d.setClosingOptions(null);
//                if (logger.isDebugEnabled()  {
//                    logger.debug("Entry number: ");
//                }
                } else {
                    BomFun bm = new BomFun();
                    bm.insertCOPTRBom(bm.getRoot(ph));
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

    private void insertBom() {
    }

}
