/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.buliao;

import com.edwin.Depart.*;
import SqlInterface.QueryErp;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author John
 */
public class MaterialList extends javax.swing.JPanel {

//    private TableCellEditor editor = mList.getCellEditor();
    /**
     * Creates new form MaterialList
     */
    public MaterialList() {
        initComponents();

    }

    public MaterialList(String s) {
        initComponents();
        try {
            setMlist(s);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }

        mList.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                cellVauleChangedListener(e);
            }
        });

    }

    private void cellVauleChangedListener(TableModelEvent e) {

        BigDecimal i = BigDecimal.valueOf((Double) mList.getValueAt(mList.getSelectedRow(), 1));
        if (i.compareTo(BigDecimal.ZERO) > 0) {
            if (e.getType() == TableModelEvent.UPDATE) {
                if (e.getColumn() == 1) {
//                boolean b = (Boolean) mList.getValueAt(mList.getSelectedRow(), 0);
//                if (b) {
                    mList.setValueAt(true, mList.getSelectedRow(), 0);
//                }

                }
            }
//        System.out.println(mList.getSelectedRow());
        }
    }

    //获取选择的品号，及数量
    public HashMap<String, BigDecimal> getMList() {

        HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
        int rowCount = mList.getRowCount();

        for (int row = 0; row < rowCount; row++) {

            if ((Boolean) mList.getValueAt(row, 0)) //如何选中为true 则put
            {
                mPH.put((String) mList.getValueAt(row, 2), BigDecimal.valueOf((Double) mList.getValueAt(row, 1)));
            }
        }

        return mPH;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mList = new org.jdesktop.swingx.JXTable();

        mList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "选中", "数量 ", "品号", "品名", "规格", "快捷码"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mList.setRowHeight(25);
        mList.setSelectionBackground(new java.awt.Color(102, 255, 102));
        mList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(mList);
        mList.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(MaterialList.class, "MaterialList.mList.columnModel.title0")); // NOI18N
        mList.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(MaterialList.class, "MaterialList.mList.columnModel.title1")); // NOI18N
        mList.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(MaterialList.class, "MaterialList.mList.columnModel.title2")); // NOI18N
        mList.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(MaterialList.class, "MaterialList.mList.columnModel.title3")); // NOI18N
        mList.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(MaterialList.class, "MaterialList.mList.columnModel.title4")); // NOI18N
        mList.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(MaterialList.class, "MaterialList.mList.columnModel.title5")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable mList;
    // End of variables declaration//GEN-END:variables

    public void setMlist(String s) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
        Object[] rowData = {false, 0.0, "", "", "", ""};
        int row = 0;

        ((DefaultTableModel) mList.getModel()).setRowCount(0);

        for (QueryErp qr : c) {
            rs = qr.getMoctaMaterial(s);
            while (rs.next()) {

                ((DefaultTableModel) mList.getModel()).addRow(rowData);
                ArrayList<String> list = new ArrayList<String>();
                list.add(rs.getString("MB001"));
                list.add(rs.getString("MB002"));
                list.add(rs.getString("MB003"));
                list.add(rs.getString("MB110"));

                int column = 2;

                for (Iterator<String> it = list.iterator(); it.hasNext();) {
                    String el = it.next();
                    mList.setValueAt(el, row, column);
                    column++;
                }
                row++;
                list.removeAll(list);
            }
        }

    }
}
