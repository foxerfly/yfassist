/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import com.edwin.bomtable.Invmb;
import com.edwin.my.RCPSessionFactory;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.nodes.Node;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.edwin.bom//OrderBom//EN",
        autostore = false
        )
@TopComponent.Description(
        preferredID = "OrderBomTopComponent",
        iconBase = "ICONS/action.gif",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
        )
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "基础资料", id = "com.edwin.bom.OrderBomTopComponent")
@ActionReference(path = "Menu/基础资料" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_OrderBomAction",
        preferredID = "OrderBomTopComponent"
        )
@Messages({
    "CTL_OrderBomAction=产品配置",
    "CTL_OrderBomTopComponent=产品配置",
    "HINT_OrderBomTopComponent=This is a OrderBom window"
})
public final class OrderBomTopComponent extends TopComponent implements ExplorerManager.Provider, PropertyChangeListener {

    public OrderBomTopComponent() {
        initComponents();
        setName(Bundle.CTL_OrderBomTopComponent());
        setToolTipText(Bundle.HINT_OrderBomTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mb001 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mb002 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        udf07 = new javax.swing.JTextField();
        mb009 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mb110 = new javax.swing.JTextField();
        mb003 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mb109 = new javax.swing.JTextField();
        mb025 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mb004 = new javax.swing.JTextField();
        mb034 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        udf03 = new javax.swing.JTextField();
        udf05 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderBomTable = new com.edwin.myswingx.MyJXTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        myJXTable3 = new com.edwin.myswingx.MyJXTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        beanTreeView1 = new org.openide.explorer.view.BeanTreeView();
        beanTreeView2 = new org.openide.explorer.view.BeanTreeView();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel1.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel2.text")); // NOI18N

        jTextField2.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jTextField2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel3.text")); // NOI18N

        mb001.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb001.text")); // NOI18N
        mb001.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel4.text")); // NOI18N

        mb002.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb002.text")); // NOI18N
        mb002.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel5.text")); // NOI18N

        udf07.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.udf07.text")); // NOI18N
        udf07.setEnabled(false);

        mb009.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb009.text")); // NOI18N
        mb009.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel7.text")); // NOI18N

        mb110.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb110.text")); // NOI18N
        mb110.setEnabled(false);

        mb003.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb003.text")); // NOI18N
        mb003.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel9.text")); // NOI18N

        mb109.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb109.text")); // NOI18N
        mb109.setEnabled(false);

        mb025.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb025.text")); // NOI18N
        mb025.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel10.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel11.text")); // NOI18N

        mb004.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb004.text")); // NOI18N
        mb004.setEnabled(false);

        mb034.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.mb034.text")); // NOI18N
        mb034.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel12.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel13.text")); // NOI18N

        udf03.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.udf03.text")); // NOI18N
        udf03.setEnabled(false);

        udf05.setText(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.udf05.text")); // NOI18N
        udf05.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jLabel14.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mb034, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mb001, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mb009, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mb004, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(udf07, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mb002, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mb025, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mb003, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(udf03)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mb109, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mb110, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(udf05, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(mb002, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mb001, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(mb110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(mb003, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(udf07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(mb009, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(mb109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(mb025, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mb004, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(mb034, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(udf03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(udf05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        orderBomTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(orderBomTable);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jScrollPane2.TabConstraints.tabTitle"), jScrollPane2); // NOI18N

        myJXTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(myJXTable3);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.jScrollPane3.TabConstraints.tabTitle"), jScrollPane3); // NOI18N

        beanTreeView1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.beanTreeView1.TabConstraints.tabTitle"), beanTreeView1); // NOI18N
        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(OrderBomTopComponent.class, "OrderBomTopComponent.beanTreeView2.TabConstraints.tabTitle"), beanTreeView2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        QueryCondition.setPh(this.jTextField1.getText().trim());
        QueryCondition.setPzh(this.jTextField2.getText().trim());

        OrderNode od = new OrderNode(QueryCondition.getPh());
        od.setIconBaseWithExtension("ICONS/exdPersistentClassMapping.gif");

        em.setRootContext(od);
        em.getRootContext().setDisplayName(QueryCondition.getPh());

    }//GEN-LAST:event_jButton1ActionPerformed

    private ExplorerManager em = new ExplorerManager();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.view.BeanTreeView beanTreeView1;
    private org.openide.explorer.view.BeanTreeView beanTreeView2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField mb001;
    private javax.swing.JTextField mb002;
    private javax.swing.JTextField mb003;
    private javax.swing.JTextField mb004;
    private javax.swing.JTextField mb009;
    private javax.swing.JTextField mb025;
    private javax.swing.JTextField mb034;
    private javax.swing.JTextField mb109;
    private javax.swing.JTextField mb110;
    private com.edwin.myswingx.MyJXTable myJXTable3;
    private com.edwin.myswingx.MyJXTable orderBomTable;
    private javax.swing.JTextField udf03;
    private javax.swing.JTextField udf05;
    private javax.swing.JTextField udf07;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
        em.addPropertyChangeListener(this);
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
        em.removePropertyChangeListener(this);
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

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        String ph = "";
        Node[] no = em.getSelectedNodes();

        for (Node n : no) {
            ph = n.getDisplayName().trim();
        }

//        System.out.println(ph);
        List list = s.createQuery("from Invmb as a where a.mb001=:mb001 ").setParameter("mb001", ph).list();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Invmb tI = (Invmb) it.next();
            try {
                mb001.setText(tI.getMb001().toString().trim());
                mb002.setText(tI.getMb002().toString().trim());
                mb003.setText(tI.getMb003().toString().trim());
                mb004.setText(tI.getMb004().toString().trim());
                mb009.setText(tI.getMb009().toString().trim());
                mb025.setText(tI.getMb025().toString().trim());
                mb034.setText(tI.getMb034().toString().trim());
                mb109.setText(tI.getMb109().toString().trim());
                mb110.setText(tI.getMb110().toString().trim());

                if (tI.getUdf03().toString().trim().equals(null)) {
                    udf03.setText("");
                } else {
                    udf03.setText(tI.getUdf03().toString().trim());
                }

                if (tI.getUdf03().toString().trim().equals(null)) {
                    udf05.setText("");
                } else {
                    udf05.setText(tI.getUdf05().toString().trim());
                }

                if (tI.getUdf03().toString().trim().equals(null)) {
                    udf07.setText("");
                } else {
                    udf07.setText(tI.getUdf07().toString().trim());
                }

            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        tx.commit();
        s.close();
    }
}
