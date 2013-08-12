/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author John
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2,
            boolean arg3, int arg4, int arg5) {
        this.setText((arg1 == null) ? "null" : arg1.toString());
        return this;
    }

}
