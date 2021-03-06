/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.excel;

import com.edwin.my.Excel.Excel;
import java.awt.HeadlessException;
import java.io.File;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.edwin.my.excel//InputExcel//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "InputExcelTopComponent",
iconBase = "ICON/chart_bar_delete.png",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.edwin.my.excel.InputExcelTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_InputExcelAction",
preferredID = "InputExcelTopComponent")
@Messages({
    "CTL_InputExcelAction=InputExcel",
    "CTL_InputExcelTopComponent=InputExcel Window",
    "HINT_InputExcelTopComponent=This is a InputExcel window"
})
public final class InputExcelTopComponent extends TopComponent {

    public InputExcelTopComponent() {
        initComponents();
        setName(Bundle.CTL_InputExcelTopComponent());
        setToolTipText(Bundle.HINT_InputExcelTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ExcelIn = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXList1 = new org.jdesktop.swingx.JXList();
        jButton1 = new javax.swing.JButton();

        ExcelIn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "品号", "总数", "金工在制", "抛光在制", "表面处理在制"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ExcelIn);
        ExcelIn.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(InputExcelTopComponent.class, "InputExcelTopComponent.ExcelIn.columnModel.title0_1")); // NOI18N
        ExcelIn.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(InputExcelTopComponent.class, "InputExcelTopComponent.ExcelIn.columnModel.title1_1")); // NOI18N
        ExcelIn.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(InputExcelTopComponent.class, "InputExcelTopComponent.ExcelIn.columnModel.title2_1")); // NOI18N
        ExcelIn.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(InputExcelTopComponent.class, "InputExcelTopComponent.ExcelIn.columnModel.title3_1")); // NOI18N
        ExcelIn.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(InputExcelTopComponent.class, "InputExcelTopComponent.ExcelIn.columnModel.title4")); // NOI18N

        jScrollPane2.setViewportView(jXList1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/chart_bar_delete.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(InputExcelTopComponent.class, "InputExcelTopComponent.jButton1.text")); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        readExcel();


    }//GEN-LAST:event_jButton1ActionPerformed

    private javax.swing.JFileChooser f;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ExcelIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXList jXList1;
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

    private void readExcel() throws HeadlessException {
        // TODO add your handling code here:
        Object[][] rowData=null;
        f= new javax.swing.JFileChooser();
        this.add(f);
        FileNameExtensionFilter filter=new FileNameExtensionFilter("xls", "xlsx");
        f.setFileFilter(filter);
        int i= f.showOpenDialog(this);
        if(i==JFileChooser.APPROVE_OPTION){

//            String excelFile=f.getCurrentDirectory().toString()  +"\\"+f.getSelectedFile().getName();
            File excelFile=f.getSelectedFile();
            Collection<? extends Excel> ex=Lookup.getDefault().lookupAll(Excel.class);
            for(Excel exd:ex) {
//            System.out.println(exd.getClass().toString());
//            ex.readExcel(excelFile);
//            System.out.println(exd.readExcel(excelFile));
//                rowData=exd.readExcel(excelFile);
                setExcelIn(rowData);
            }


        }
    }

    private void setExcelIn(Object[][] rowData){

        ((DefaultTableModel)ExcelIn.getModel()).setRowCount(0);










    }
}
