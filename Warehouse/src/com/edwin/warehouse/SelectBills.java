/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.warehouse;

import com.edwin.myswingx.CheckBoxEditor;
import com.edwin.myswingx.CheckBoxRenderer;
import javax.swing.JCheckBox;

/**
 *
 * @author John
 */
public class SelectBills extends javax.swing.JPanel {

    /**
     * Creates new form SelectBills
     */
    public SelectBills() {
        initComponents();
        myDefaultJXTable1.setModel(gs.getTableModel());
        myDefaultJXTable1.getColumn(0).setCellRenderer(new CheckBoxRenderer());
        myDefaultJXTable1.getColumn(0).setCellEditor(new CheckBoxEditor(new JCheckBox()));

    }

    private GetSfctcModel gs = new GetSfctcModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myDefaultJXTable1 = new com.edwin.myswingx.MyDefaultJXTable();

        myDefaultJXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(myDefaultJXTable1);
        myDefaultJXTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myDefaultJXTable1.columnModel.title0")); // NOI18N
        myDefaultJXTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myDefaultJXTable1.columnModel.title1")); // NOI18N
        myDefaultJXTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myDefaultJXTable1.columnModel.title2")); // NOI18N
        myDefaultJXTable1.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myDefaultJXTable1.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.edwin.myswingx.MyDefaultJXTable myDefaultJXTable1;
    // End of variables declaration//GEN-END:variables
}
