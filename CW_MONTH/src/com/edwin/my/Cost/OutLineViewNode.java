/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.JTextField;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;

/**
 *
 * @author Administrator
 */
public class OutLineViewNode extends AbstractNode {

    private String ROOT = "";
    private DialogDescriptor d;
//    private GetINVMB gb;
    private EditCost ec;

    public OutLineViewNode(String ROOT) throws IntrospectionException {
        super(new OutLineViewNodeChildren(ROOT));
        this.ROOT = ROOT;
//        gb=new GetINVMB(ROOT);
    }

    @Override
    protected Sheet createSheet() {
        Sheet s1 = super.createSheet(); //To change body of generated methods, choose Tools | Templates.
        Sheet.Set ss = s1.get(Sheet.PROPERTIES);
        if (ss == null) {
            ss = Sheet.createPropertiesSet();
            s1.put(ss);
        }
        Node.Property[] props = null;
        if (this.getParentNode() != null) {
            props = new NodeProperties(ROOT, this.getParentNode().getDisplayName()).getPropeties();
//            System.out.println("-------");
//            System.out.println(ROOT);
//            System.out.println(this.getParentNode().getDisplayName());
//            System.out.println("-------");

        } else {
            props = new NodeProperties(ROOT).getPropeties();
//            System.out.println("++++++++");
        }
        ss.put(props);
//        s1.put(ss);

        return s1;
    }

    @Override
    public Action[] getActions(boolean context) {
//        return super.getActions(context); //To change body of generated methods, choose Tools | Templates.
        return new Action[]{new OutLineViewNode.MyAction() {
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
