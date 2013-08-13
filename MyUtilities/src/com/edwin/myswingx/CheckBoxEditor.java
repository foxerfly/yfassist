/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author John
 */
public class CheckBoxEditor extends DefaultCellEditor implements TableCellEditor {

    private JCheckBox checkBox = new JCheckBox();

    public CheckBoxEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        checkBox.setSelected((boolean) value);
        checkBox.setBorder(null);
        return checkBox;
    }

    @Override
    public Object getCellEditorValue() {
        return checkBox.isSelected() ? true : false;
    }

}
