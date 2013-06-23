/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import javax.swing.JTable;
import org.hibernate.context.internal.JTASessionContext;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author EDWIN
 */
public class MyJXTable extends JXTable {

    public MyJXTable(MyJTableModel mj) {
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setDragEnabled(false);
    }

}
