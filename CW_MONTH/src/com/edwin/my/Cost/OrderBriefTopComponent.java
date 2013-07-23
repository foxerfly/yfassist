/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import SqlInterface.QueryErp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.edwin.my.Cost//OrderBrief//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "OrderBriefTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "com.edwin.my.Cost.OrderBriefTopComponent")
@ActionReference(path = "Menu/Window/财务" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_OrderBriefAction",
        preferredID = "OrderBriefTopComponent")
@Messages({
    "CTL_OrderBriefAction=单据窗口",
    "CTL_OrderBriefTopComponent=单据窗口",
    "HINT_OrderBriefTopComponent=This is a OrderBrief window"
})
public final class OrderBriefTopComponent extends TopComponent implements ListSelectionListener {

    public OrderBriefTopComponent() {
        initComponents();
        setName(Bundle.CTL_OrderBriefTopComponent());
        setToolTipText(Bundle.HINT_OrderBriefTopComponent());
//        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, true);
        jTable1.getSelectionModel().addListSelectionListener(this);
        jTable1.getTableHeader().setReorderingAllowed(false);
        associateLookup(new AbstractLookup(content));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputVar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        checkOrder = new javax.swing.JCheckBox();

        inputVar.setText(org.openide.util.NbBundle.getMessage(OrderBriefTopComponent.class, "OrderBriefTopComponent.inputVar.text")); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/callhierarchy.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(OrderBriefTopComponent.class, "OrderBriefTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(304, 370));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "品号", "品名", "规格", "快捷码", "单位","属性"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(24);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        checkOrder.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(checkOrder, org.openide.util.NbBundle.getMessage(OrderBriefTopComponent.class, "OrderBriefTopComponent.checkOrder.text")); // NOI18N
        checkOrder.setToolTipText(org.openide.util.NbBundle.getMessage(OrderBriefTopComponent.class, "OrderBriefTopComponent.checkOrder.toolTipText")); // NOI18N
        checkOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(checkOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputVar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(checkOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

//        jTable1.getSelectionModel().clearSelection();l
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        try {

            if (checkOrder.isSelected() == true) {

                queryOrderBrief(1);
            } else {

                queryOrderBrief(2);
            }

        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void checkOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOrderActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);

        if (checkOrder.isSelected()) {
            inputVar.setText("A013083053");
        } else {
            inputVar.setText("A0401-201007-04601");
        }
    }//GEN-LAST:event_checkOrderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkOrder;
    private javax.swing.JTextField inputVar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private InstanceContent content = new InstanceContent();

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
        super.close();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    private void queryOrderBrief(int flag) throws ClassNotFoundException, SQLException {
        // TODO add your handling code here:
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        String sql = "";
        String[] rowData = new String[6];
        ResultSet rs;
        String sContent = "";
        if (flag == 1) {
            sContent = "%" + inputVar.getText().trim() + "%";
            sql = "SELECT TD004,TD005,TD006,MB110,MB004,MB025 FROM COPTD LEFT JOIN INVMB ON MB001=TD004 WHERE TD002 LIKE ?";
        } else {
            sContent = inputVar.getText().trim();
            sql = "SELECT MB001,MB002,MB003,MB110,MB004,MB025 FROM INVMB WHERE MB001=?";
        }
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        rs = qr.rsErp(sql, sContent);

        int row = 0;
        int lastColumn = 6;
        while (rs.next()) {
            ((DefaultTableModel) jTable1.getModel()).addRow(rowData);
            int column = 0;
            int qq = 1;
            for (; column < lastColumn; column++) {
                jTable1.setValueAt(rs.getString(qq), row, column);
                qq++;
            }
            row++;
        }

    }

    public MaterialNO getROOTph() {
        if (jTable1.getRowCount() > 0) {
            ArrayList<String> phList = new ArrayList<String>();

            phList.add((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            phList.add((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            phList.add((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
            phList.add((String) jTable1.getValueAt(jTable1.getSelectedRow(), 3));
            phList.add((String) jTable1.getValueAt(jTable1.getSelectedRow(), 4));
            phList.add((String) jTable1.getValueAt(jTable1.getSelectedRow(), 5));
//        MaterialNO mo=new MaterialNO((String) jTable1.getValueAt(jTable1.getSelectedRow(),0));

            MaterialNO mo = new MaterialNO(phList);
            return mo;
        }
        return null;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            MaterialNO mo = this.getROOTph();
            if (mo instanceof MaterialNO) {
                content.set(Collections.singleton(mo), null);
            }
        }
    }
}
