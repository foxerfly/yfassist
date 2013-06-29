/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.buliao;

import PreVector.PreVectorInterface;
import SqlInterface.QueryErp;
import com.edwin.DepartMaterial.TmpDb;
import com.edwin.authorize.RCPAuthorize;
import com.edwin.my.RCPSessionFactory;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.edwin.buliao//DepartAddMaterial//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "DepartAddMaterialTopComponent",
        iconBase = "com/edwin/Depart/application_view_tile.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "生产", id = "com.edwin.buliao.DepartAddMaterialTopComponent")
@ActionReference(path = "Menu/生产" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_DepartAddMaterialAction",
        preferredID = "DepartAddMaterialTopComponent")
@Messages({
    "CTL_DepartAddMaterialAction=车间补料单",
    "CTL_DepartAddMaterialTopComponent=车间补料单",
    "HINT_DepartAddMaterialTopComponent=This is a DepartAddMaterial window"
})

public final class DepartAddMaterialTopComponent extends TopComponent {

    private List<Action> ca = null;
    private com.edwin.Depart.MaterialList listPane;
    private Point currentMousePoint = null;
    private DialogDescriptor d = null;
    private DialogDescriptor dlgBuliaoDetail = null;
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

    private ActionListener acBuliaoDetail = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            dlgBuliaoDetail.setClosingOptions(null);
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

    public DepartAddMaterialTopComponent() {
        initComponents();
        setName(Bundle.CTL_DepartAddMaterialTopComponent());
        setToolTipText(Bundle.HINT_DepartAddMaterialTopComponent());
//        tableList.setModel(new MyJTableModel("品号", "品名", "规格", "单位", "快捷码", "补料数量").buildModel());
//        tableList.setDragEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popmenu = new javax.swing.JPopupMenu();
        buliaoDetail = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        materialNo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();

        org.openide.awt.Mnemonics.setLocalizedText(buliaoDetail, org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.buliaoDetail.text")); // NOI18N
        buliaoDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buliaoDetailActionPerformed(evt);
            }
        });
        popmenu.add(buliaoDetail);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.jLabel1.text")); // NOI18N

        materialNo.setText(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.materialNo.text")); // NOI18N
        materialNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                materialNoKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/wand.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        tableList.getTableHeader().setReorderingAllowed(false);
        tableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableListMouseReleased(evt);
            }
        });
        tableList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tableListMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(tableList);
        tableList.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.tableList.columnModel.title0")); // NOI18N
        tableList.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.tableList.columnModel.title1")); // NOI18N
        tableList.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.tableList.columnModel.title2")); // NOI18N
        tableList.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.tableList.columnModel.title3")); // NOI18N
        tableList.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.tableList.columnModel.title4")); // NOI18N
        tableList.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(DepartAddMaterialTopComponent.class, "DepartAddMaterialTopComponent.tableList.columnModel.title5")); // NOI18N
        tableList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(materialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int randomID = new Random().nextInt();
        try {
            genericMocteHibernate(randomID);
            //        try {
            //            int randomID = new Random().nextInt();
            //            genericMocte(randomID);
            //        } catch (SQLException ex) {
            //            Exceptions.printStackTrace(ex);
            //        } catch (ClassNotFoundException ex) {
            //        }
            //        }
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void materialNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_materialNoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !materialNo.getText().trim().equals("")) {
            try {
                doGetMocta();
            } catch (ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

    }//GEN-LAST:event_materialNoKeyReleased

    private void tableListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseReleased
        // TODO add your handling code here:
//        this.getActions();

        if (evt.getButton() == MouseEvent.BUTTON3) {
            popmenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableListMouseReleased

    private void buliaoDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buliaoDetailActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(tableList, "good", "提示", JOptionPane.OK_OPTION);

        dlgBuliaoDetail = new DialogDescriptor(new BuliaoDetail((String) tableList.getValueAt(tableList.rowAtPoint(getCurrentMousePoint()), 0)), "补料信息详情", true, acBuliaoDetail);
        DialogDisplayer.getDefault().notifyLater(dlgBuliaoDetail);

    }//GEN-LAST:event_buliaoDetailActionPerformed

    private void tableListMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseMoved
        // TODO add your handling code here:
//
//        int row = tableList.rowAtPoint(evt.getPoint());
//        int col = tableList.rowAtPoint(evt.getPoint());
        setCurrentMousePoint(evt.getPoint());

    }//GEN-LAST:event_tableListMouseMoved

    private void setCurrentMousePoint(Point point) {

        this.currentMousePoint = point;
    }

    private Point getCurrentMousePoint() {

        return this.currentMousePoint;
    }

    private void doGetMocta() throws ClassNotFoundException, SQLException {

        this.listPane = new com.edwin.Depart.MaterialList(materialNo.getText().trim());

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
        BigDecimal b = BigDecimal.ZERO;
        HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
        int rowCount = tableList.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            b = new BigDecimal(tableList.getValueAt(row, 5).toString());
            mPH.put((String) tableList.getValueAt(row, 0), b);
        }
        return mPH;
    }

    protected void genericMocteHibernate(int randomID) throws ClassNotFoundException, SQLException {
        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
        Set<String> set = new HashSet<String>();

        PreVectorInterface prI = Lookup.getDefault().lookup(PreVectorInterface.class);
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        String procedureSql = "{CALL me_procGeneratorMocte(?)}";
        ResultSet rs = null;
        Iterator<String> iterator;
        mPH = getTableList();
        set = mPH.keySet();  //获取K
        if (!set.isEmpty()) {    //如果Set不为空
            iterator = set.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                TmpDb tdb = new TmpDb();
                tdb.setPh(key);
                tdb.setRandomId(randomID);
                tdb.setDepartment(prI.getLoginUserDep());
                tdb.setUsername(prI.getLoginUserName());
                tdb.setValue(mPH.get(key));
                tdb.setGdate(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()));
                s.save(tdb);

            }
        }
        tx.commit();

//        SQLQuery query = s.createSQLQuery("{ ? = call me_procGeneratorMocte(?)}");
//        query.setParameter(0, randomID);
//        List list = query.list();
        s.close();

//        for (Iterator it = list.iterator(); it.hasNext();) {
//            Object ss = it.next();
//            JOptionPane.showMessageDialog(this, "生成补料单号为：  " + ss.toString());
//
//        }
        rs = qr.rsErpProc(procedureSql, randomID);
        String sss = "";
        while (rs.next()) {
            sss = sss + "  【" + rs.getString(1).trim() + "】  ";
//            System.out.println(rs.getString(1));
        }
        if (sss.equals("")) {
            JOptionPane.showMessageDialog(this, "无可补工单及可补量，未生成任何单据");
        } else {
            JOptionPane.showMessageDialog(this, "生成补料单号为：  " + sss);
        }

        rs.close();

    }

    protected void genericMocte(int randomID) throws SQLException, ClassNotFoundException {
        // TODO add your handling code here:
        HashMap<String, BigDecimal> mPH = new HashMap<String, BigDecimal>();
        Collection<? extends QueryErp> c = Lookup.getDefault().lookupAll(QueryErp.class);
        Set<String> set = new HashSet<String>();
//        int randomID = new Random().nextInt();
        PreVectorInterface prI = Lookup.getDefault().lookup(PreVectorInterface.class);
        String insertSql = "INSERT INTO tmpDB(USERNAME,DEPARTMENT,GDate,randomID,PH,VALUE) VALUES('" + prI.getLoginUserName() + "','" + prI.getLoginUserDep() + "',CONVERT(VARCHAR(8),GETDATE(),112)," + randomID + ",?,?)";
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
            int i = 1;
            while (rs.next()) {
                JOptionPane.showMessageDialog(this, "生成补料单号为：  " + rs.getString(i));
//                resultNO.append(rs.getString(i) + "          ");
            }
        }

        rs.close();

//        JOptionPane.showConfirmDialog(this, "生成补料单号为：  " + resultNO.toString());
//        resultsOfMocte.setText("生成补料单号为：  " + resultNO.toString());
    }

    private RCPAuthorize ar = new RCPAuthorize();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buliaoDetail;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField materialNo;
    private javax.swing.JPopupMenu popmenu;
    private javax.swing.JTable tableList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
        if (!ar.oAuth("DepartAddMaterial")) {
            super.close();
        }
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
