/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.Depart;

import PreVector.PreVectorInterface;
import SqlInterface.QueryErp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.Lookups;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.edwin.Depart//DepartMaterial//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "DepartMaterialTopComponent",
        iconBase = "com/edwin/Depart/application_view_tile.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "生产", id = "com.edwin.Depart.DepartMaterialTopComponent")
@ActionReference(path = "Menu/生产" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_DepartMaterialAction",
        preferredID = "DepartMaterialTopComponent")
@Messages({
    "CTL_DepartMaterialAction=生成车间备料单",
    "CTL_DepartMaterialTopComponent=生成车间备料单",
    "HINT_DepartMaterialTopComponent=This is a DepartMaterial window"
})
public final class DepartMaterialTopComponent extends TopComponent {

//    static Logger logger = Logger.getLogger(DepartMaterialTopComponent.class);
    private List<Action> ca = null;
    private MaterialList listPane;
    private DialogDescriptor d = null;
    private ActionListener ac = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
                d.setClosingOptions(null);
//                if (logger.isDebugEnabled()  {
//                    logger.debug("Entry number: ");
//                }
            } else {

                HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
                mPH = listPane.getMList();
                try {
                    addList(mPH);
                } catch (ClassNotFoundException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }
                d.setClosingOptions(null);
            }
        }
    };

    //添加tableList内容
    private void addList(HashMap<String, BigDecimal> mPH) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
        Object[] rowData = {"", "", "", "", "", 0.0,};
        Set<String> set = new HashSet<String>();
        String sql = "SELECT MB001,MB002,MB003,MB004,MB110 FROM INVMB WHERE MB001=?";
        ArrayList list = new ArrayList();
        Iterator<String> iterator;

        ((DefaultTableModel) tableList.getModel()).setRowCount(0);

        for (QueryErp qr : c) {
            set = mPH.keySet();  //获取K
            if (!set.isEmpty()) {    //如果Set不为空
                int row = 0;
                iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    rs = qr.rsErp(sql, key);
                    if (rs.next()) {
                        list.add(rs.getString("MB001").trim());
                        list.add(rs.getString("MB002").trim());
                        list.add(rs.getString("MB003").trim());
                        list.add(rs.getString("MB004").trim());
                        list.add(rs.getString("MB110").trim());
                    }
                    list.add(mPH.get(key));

                    ((DefaultTableModel) tableList.getModel()).addRow(rowData);
                    for (int column = 0; column < 6; column++) {
                        tableList.setValueAt(list.get(column), row, column);
                    }
                    list.removeAll(list);
                    row++;
                }
            }
        }
    }

    public DepartMaterialTopComponent() {
        initComponents();
        setName(Bundle.CTL_DepartMaterialTopComponent());
        setToolTipText(Bundle.HINT_DepartMaterialTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        materialNo = new javax.swing.JTextField();
        generateMocte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();
        resultsOfMocte = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jMenuItem1, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.jMenuItem1.text")); // NOI18N
        jPopupMenu1.add(jMenuItem1);

        jCheckBoxMenuItem1.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxMenuItem1, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.jCheckBoxMenuItem1.text")); // NOI18N
        jPopupMenu1.add(jCheckBoxMenuItem1);

        jRadioButtonMenuItem1.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButtonMenuItem1, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.jRadioButtonMenuItem1.text")); // NOI18N
        jPopupMenu1.add(jRadioButtonMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxMenuItem2, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.jCheckBoxMenuItem2.text")); // NOI18N
        jPopupMenu1.add(jCheckBoxMenuItem2);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.jLabel1.text")); // NOI18N

        materialNo.setText(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.materialNo.text")); // NOI18N
        materialNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                materialNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                materialNoKeyReleased(evt);
            }
        });

        generateMocte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/wand.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(generateMocte, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.generateMocte.text")); // NOI18N
        generateMocte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateMocteActionPerformed(evt);
            }
        });

        tableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "材料品号", "材料品名", "材料规格", "单位", "快捷码", "需补数量"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableList.setRowHeight(25);
        tableList.setSelectionBackground(new java.awt.Color(102, 255, 102));
        tableList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tableList);
        tableList.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.tableList.columnModel.title0")); // NOI18N
        tableList.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.tableList.columnModel.title1")); // NOI18N
        tableList.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.tableList.columnModel.title2")); // NOI18N
        tableList.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.tableList.columnModel.title5")); // NOI18N
        tableList.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.tableList.columnModel.title3")); // NOI18N
        tableList.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.tableList.columnModel.title4")); // NOI18N

        resultsOfMocte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(resultsOfMocte, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.resultsOfMocte.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(DepartMaterialTopComponent.class, "DepartMaterialTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(resultsOfMocte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(materialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generateMocte, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultsOfMocte, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(materialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateMocte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateMocteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateMocteActionPerformed
        try {

            genericMocte();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_generateMocteActionPerformed

    private void materialNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_materialNoKeyPressed
        // TODO add your handling code here:
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            try {
//                doGetMocta();
//            } catch (ClassNotFoundException ex) {
//                Exceptions.printStackTrace(ex);
//            } catch (SQLException ex) {
//                Exceptions.printStackTrace(ex);
//            }
//
//        }
    }//GEN-LAST:event_materialNoKeyPressed

    private void materialNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_materialNoKeyReleased
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                doGetMocta();
            } catch (ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }

        }

    }//GEN-LAST:event_materialNoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MaterialList listPane2 = new MaterialList();
        listPane2.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generateMocte;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField materialNo;
    private javax.swing.JLabel resultsOfMocte;
    private javax.swing.JTable tableList;
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

    private void doGetMocta() throws ClassNotFoundException, SQLException {

        this.listPane = new MaterialList(materialNo.getText().trim());

        d = new DialogDescriptor(listPane, "选择物料", true, ac);
        d.setClosingOptions(new Object[]{});

        d.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(DialogDescriptor.PROP_VALUE)
                        && e.getNewValue() == DialogDescriptor.CLOSED_OPTION) {
                    d.setClosingOptions(null);
                }
            }
        });

        DialogDisplayer.getDefault().notifyLater(d);
//                d.setModal(true);

    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == DialogDescriptor.CANCEL_OPTION) {
//             d.setClosingOptions(null);
//             System.out.println("gggggggggggggggg");
//        } else {
//
//                d.setClosingOptions(null);
//                  System.out.println("zzzzzzzzzzzzzzzzzzzz");
//            }
//        }

    //获取选择的品号，及数量
    public HashMap<String, BigDecimal> getTableList() {
        HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
        int rowCount = tableList.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            mPH.put((String) tableList.getValueAt(row, 0), (BigDecimal) tableList.getValueAt(row, 5));
        }
        return mPH;
    }

    protected void genericMocte() throws SQLException, ClassNotFoundException {
        // TODO add your handling code here:
        HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
        Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
        Set<String> set = new HashSet<String>();
        int randomID = new Random().nextInt();
        PreVectorInterface prI = Lookup.getDefault().lookup(PreVectorInterface.class);
        String insertSql = "INSERT INTO tmpDB(USERNAME,DEPARTMENT,GDate,randomID,PH,VVALUE) VALUES(" + prI.getLoginUserName() + "," + prI.getLoginUserDep() + ",CONVERT(VARCHAR(8),GETDATE(),112)," + randomID + ",?,?)";
        String procedureSql = "{CALL me_procGeneratorMocte(?)}";
        ArrayList list = new ArrayList();
        Iterator<String> iterator;
        ResultSet rs = null;
        StringBuffer resultNO = null;

        mPH = getTableList();
        for (QueryErp qr : c) {
            set = mPH.keySet();  //获取K
            if (!set.isEmpty()) {    //如果Set不为空
                iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    list.add(key);
                    list.add(mPH.get(key));
                    if (!qr.InsertErp(insertSql, list)) {
                        throw new UnsupportedOperationException("生单失败，请联系信息部");
                    };
                    list.removeAll(list);
                }
            }
            rs = qr.rsErpProc(procedureSql, randomID);
            int i = 0;
            while (rs.next()) {
                resultNO.append(rs.getString(i) + "          ");
                i++;
            }
        }
        resultsOfMocte.setText("生成补料单号为：  " + resultNO.toString());

    }

    @Override
    public Action[] getActions() {

        if (ca == null) {
            ca = new ArrayList<Action>(Arrays.asList(super.getActions()));
            ca.add(null);
            Lookup lkp = Lookups.forPath("ContextActions/MyTC");
            ca.addAll(lkp.lookupAll(Action.class));
        }
        return ca.toArray(new Action[ca.size()]);
    }
}
