/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.admin;

import jodd.datetime.JDateTime;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.api.visual.widget.ComponentWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.edwin.admin//VisualAdmin//EN",
        autostore = false
        )
@TopComponent.Description(
        preferredID = "VisualAdminTopComponent",
        iconBase = "ICONS/annotationtypes.gif",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
        )
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "系统管理", id = "com.edwin.admin.VisualAdminTopComponent")
@ActionReference(path = "Menu/系统管理" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_VisualAdminAction",
        preferredID = "VisualAdminTopComponent"
        )
@Messages({
    "CTL_VisualAdminAction=可视 控制",
    "CTL_VisualAdminTopComponent=可视控制",
    "HINT_VisualAdminTopComponent=This is a VisualAdmin window"
})
public final class VisualAdminTopComponent extends TopComponent {

    public VisualAdminTopComponent() {
        initComponents();
        setName(Bundle.CTL_VisualAdminTopComponent());
        setToolTipText(Bundle.HINT_VisualAdminTopComponent());
//        jScrollPane1.setViewportView(cs.createView());
//        lw = new LayerWidget(cs);
//        cs.addChild(lw);
//        wcw = new ComponentWidget(cs,  new MyJXTable(new MyJTableModel("权限ID", "权限名", "所属模块", "描述").buildModel()));
//        lw.addChild(wcw);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(VisualAdminTopComponent.class, "VisualAdminTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText(org.openide.util.NbBundle.getMessage(VisualAdminTopComponent.class, "VisualAdminTopComponent.jTextField1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(339, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JDateTime jd=new JDateTime(System.currentTimeMillis());
        jTextField1.setText(jd.toString()+"     "+jd.getDateTimeStamp().toString());
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private LayerWidget lw;
    private ComponentWidget wcw;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
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
}
