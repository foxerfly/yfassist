/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import javax.swing.JTextField;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;

/**
 *
 * @author Administrator
 */
public class NodeProperties {

    private GetINVMB gb;
    private String parentNodeName = "";
    private String sonNodeName = "";

    public NodeProperties(String root) {

        gb = new GetINVMB(root);
    }

    public NodeProperties(String sonNodeName, String parentNodeName) {

        this.parentNodeName = parentNodeName;
        this.sonNodeName = sonNodeName;
        gb = new GetINVMB(sonNodeName, parentNodeName);
    }

    public Node.Property[] getPropeties() {

        Node.Property[] props = new Node.Property[13];

        props[0] = new PropertySupport.ReadOnly<String>("品名", String.class, "品名", "品名") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMB002();
            }
        };

//        propStav.setValue("suppressCustomEditor", Boolean.TRUE);
        props[1] = new PropertySupport.ReadOnly<String>("规格", String.class, "规格", "规格") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMB003();
            }
        };
        props[2] = new PropertySupport.ReadOnly<String>("单位", String.class, "单位", "单位") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMB004();
            }
        };

        props[3] = new PropertySupport.ReadOnly<String>("快捷码", String.class, "快捷码", "快捷码") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMB110();
            }
        };

        props[4] = new PropertySupport.ReadWrite<String>("料", String.class, "料", "料") {
            JTextField jt = new JTextField("0");

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMaterialPrice().toString();
//                return Double.valueOf(jt.getText());

            }

            @Override
            public void setValue(String val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                jt.setText(String.valueOf(val));
            }
        };

        props[5] = new PropertySupport.ReadWrite<String>("人工", String.class, "人工", "人工") {
            JTextField jt = new JTextField("0");

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getLaborePrice().toString();
//                return Double.valueOf(jt.getText());

            }

            @Override
            public void setValue(String val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                jt.setText(String.valueOf(val));
            }
        };

        props[6] = new PropertySupport.ReadWrite<String>("制费", String.class, "制费", "制费") {
            JTextField jt = new JTextField("0");

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMadePrice().toString();
//                return Double.valueOf(jt.getText());

            }

            @Override
            public void setValue(String val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                jt.setText(String.valueOf(val));
            }
        };

        props[7] = new PropertySupport.ReadWrite<String>("委外", String.class, "委外", "委外") {
            JTextField jt = new JTextField("0");

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getCooperationPrice().toString();
//                return Double.valueOf(jt.getText());

            }

            @Override
            public void setValue(String val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                jt.setText(String.valueOf(val));
            }
        };

        props[8] = new PropertySupport.ReadOnly<String>("单价", String.class, "单价", "单价") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getSumPrice().toString();
//                return String.valueOf(jt.getText());
            }
        };

        props[9] = new PropertySupport.ReadOnly<String>("属性", String.class, "属性", "属性") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMB025();
            }
        };

        props[10] = new PropertySupport.ReadOnly<String>("标准组成用量", String.class, "标准组成用量", "标准组成用量") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMD006().toString();
//                return String.valueOf(jt.getText());
            }
        };

        props[11] = new PropertySupport.ReadOnly<String>("标准底数", String.class, "标准底数", "标准底数") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getMD007().toString();
//                return String.valueOf(jt.getText());
            }
        };

        props[12] = new PropertySupport.ReadOnly<String>("累计组成用量", String.class, "累计组成用量", "累计组成用量") {
            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return gb.getVZ().toString();
//                return String.valueOf(jt.getText());
            }
        };

        for (int i = 0; i < props.length; i++) {
            props[i].setValue("suppressCustomEditor", Boolean.TRUE);
        }

        return props;
    }
}
