/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.warehouse;

import com.edwin.myswingx.ButtonRenderer;

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
        myJXTable1.setModel(gs.getTableModel());
        myJXTable1.getColumn(0).setCellRenderer(new ButtonRenderer());
        
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
        myJXTable1 = new com.edwin.myswingx.MyJXTable();

        myJXTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(myJXTable1);
        myJXTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myJXTable1.columnModel.title0")); // NOI18N
        myJXTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myJXTable1.columnModel.title1")); // NOI18N
        myJXTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myJXTable1.columnModel.title2")); // NOI18N
        myJXTable1.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SelectBills.class, "SelectBills.myJXTable1.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.edwin.myswingx.MyJXTable myJXTable1;
    // End of variables declaration//GEN-END:variables
}
