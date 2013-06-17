/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.JTextField;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;

/**
 *
 * @author EDWIN
 */
public class OrderDetailNode extends AbstractNode {

    private String ROOT = "";
    private DialogDescriptor d;
    private GetINVMB gb;
    private EditCost ec;

    public OrderDetailNode(String ROOT) {
        super(new OrderDetailChildren(ROOT));
        this.ROOT = ROOT;
        gb = new GetINVMB(ROOT);
    }

//    @Override
//    protected Sheet createSheet() {
//        Sheet s1= super.createSheet(); //To change body of generated methods, choose Tools | Templates.
//        Sheet.Set ss=s1.get(Sheet.PROPERTIES);
//        if(ss==null){
//            ss=Sheet.createPropertiesSet();
//            s1.put(ss);
//        }
//
//        Property[] props=new Property[5];
//         props[0]= new PropertySupport.ReadOnly<String>("品名", String.class, "品名", "品名") {
//
//            @Override
//            public String getValue() throws IllegalAccessException, InvocationTargetException {
//                return gb.getMB002();
//            }
//        };
//
//
////        propStav.setValue("suppressCustomEditor", Boolean.TRUE);
//         props[1]= new PropertySupport.ReadOnly<String>("规格", String.class, "规格", "规格") {
//
//            @Override
//            public String getValue() throws IllegalAccessException, InvocationTargetException {
//                return gb.getMB003();
//            }
//        };
//         props[2]= new PropertySupport.ReadOnly<String>("单位", String.class, "单位", "单位") {
//
//            @Override
//            public String getValue() throws IllegalAccessException, InvocationTargetException {
//                return gb.getMB004();
//            }
//        };
//
//         props[3]= new PropertySupport.ReadOnly<String>("快捷码", String.class, "快捷码", "快捷码") {
//
//            @Override
//            public String getValue() throws IllegalAccessException, InvocationTargetException {
//                return gb.getMB110();
//            }
//        };
//
//        props[4] = new PropertySupport.ReadWrite<Double>("料", Double.class, "料", "料") {
//
//            JTextField jt = new JTextField("0");
//
//            @Override
//            public Double getValue() throws IllegalAccessException, InvocationTargetException {
//                return gb.getMaterialPrice();
//            }
//
//            @Override
//            public void setValue(Double val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//                jt.setText(String.valueOf(val));
//            }
//        };
//
//        
//
//          for(int i=0;i<props.length;i++){
//                props[i].setValue("suppressCustomEditor", Boolean.TRUE);
//          }
//        ss.put(props);
////        s1.put(ss);
//
//        return s1;
//    }
    @Override
    public Action[] getActions(boolean context) {
//        return super.getActions(context); //To change body of generated methods, choose Tools | Templates.
        return new Action[]{new MyAction() {
            }};
    }

    private void adjustCost() {
        // TODO add your handling code here:
        ec = new EditCost(ROOT);
        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
                    d.setClosingOptions(null);
//                if (logger.isDebugEnabled()  {
//                    logger.debug("Entry number: ");
//                }
                } else {
                    try {
                        ec.saveToCost();
                    } catch (ClassNotFoundException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (SQLException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                    d.setClosingOptions(null);
                }
            }
        };
        d = new DialogDescriptor(ec, ROOT, true, ac);
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

    //implements Presenter.Popup
    private class MyAction extends AbstractAction {

        public MyAction() {
            putValue(NAME, "修改单位成本");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            Event obj = getLookup().lookup(Event.class);
//            JOptionPane.showMessageDialog(null, "Hello from " + obj);

            adjustCost();

        }
//
//        @Override
//        public JMenuItem getPopupPresenter() {
//            JMenu result = new JMenu("Submenu");  //remember JMenu is a subclass of JMenuItem
//            result.add(new JMenuItem((Action) this));
//            return result;
//
//        }
    }
}
