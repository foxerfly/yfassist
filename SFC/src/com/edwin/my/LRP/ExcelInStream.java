/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.LRP;

import SqlInterface.QueryErp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author John
 */
public class ExcelInStream extends javax.swing.JPanel {

    /**
     * Creates new form ExcelInStream
     */
    public ExcelInStream() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMain = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ExcelInStream.class, "ExcelInStream.jLabel1.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(ExcelInStream.class, "ExcelInStream.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ExcelInStream.class, "ExcelInStream.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbMain.setAutoCreateRowSorter(true);
        tbMain.setModel(new javax.swing.table.DefaultTableModel(
            setRowData(), getColumnName()
        ));
        tbMain.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbMain.setRowHeight(24);
        tbMain.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tbMain);

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox1, org.openide.util.NbBundle.getMessage(ExcelInStream.class, "ExcelInStream.jCheckBox1.text")); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox2, org.openide.util.NbBundle.getMessage(ExcelInStream.class, "ExcelInStream.jCheckBox2.text")); // NOI18N
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ((DefaultTableModel) tbMain.getModel()).setRowCount(0);
        int columnLength = getColumnName().size();
        String sql = "select TD001,TD002,TD003,TD008,TD015,CASE TD016 WHEN 'Y' THEN '自动结束' WHEN 'y' THEN '指定结束' WHEN 'N' THEN  '未结束' ELSE '' END  TD016 ,TD004,TD005,TD006,PURTD.UDF02, TD009 \n"
                + ",CASE WHEN AAA.CD020<>0 THEN '无待检' else '有待检' END CD020\n"
                + "FROM PURTD\n"
                + "left join(\n"
                + "select distinct CD010,CD011,CD012, ISNULL(min(CD020),0) CD020\n"
                + "from PURCD \n"
                + "left join PURTD ON TD001=CD010 AND TD002=CD011 AND TD003=CD012 \n"
                + "GROUP BY CD010,CD011,CD012)  AS AAA ON AAA.CD010=TD001 AND AAA.CD011=TD002 AND AAA.CD012=TD003 WHERE TD001=? AND  TD002=? AND  TD003=? ";
        ArrayList<String> al = new ArrayList<String>();
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        ResultSet rs;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xlsx", "xls");
        fc.addChoosableFileFilter(filter);
//        fc.setFileFilter(filter);
        int i = fc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            jTextField1.setText(fc.getSelectedFile().getPath());
            try {
                jTextField1.setText(fc.getSelectedFile().getPath());

                //                OPCPackage fin = OPCPackage.open(fc.getSelectedFile().getPath());
                XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(fc.getSelectedFile().getPath())));
                XSSFSheet sheet = wb.getSheetAt(0);
                for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {//获取每行
                    al.removeAll(al);

                    XSSFRow row = sheet.getRow(j);
                    for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {//获取每个单元格
                        al.add(row.getCell(k).getStringCellValue());
//                        System.out.println(row.getCell(k).getStringCellValue());

                    }
                    rs = qr.rsErp(sql, al);
                    while (rs.next()) {
                        int length = 0;
                        int jj = 1;
                        ((DefaultTableModel) tbMain.getModel()).addRow(setRowData());
                        int rowc = tbMain.getRowCount() - 1;
                        for (; length < columnLength; length++) {
                            tbMain.setValueAt(rs.getString(jj), rowc, length);
                            jj++;
                        }

                    }
                }

                //
                //                for (Iterator<Row> it = sheet.iterator(); it.hasNext();) {
                //                    XSSFRow row = (XSSFRow) it.next();
                //                    al.removeAll(al);
                //                    int length=0;
                //                    for (Iterator<Cell> itcell = row.iterator(); itcell.hasNext();) {
                //                        XSSFCell cell = (XSSFCell) itcell.next();
                //                        al.add(cell.getStringCellValue());
                //                    }
                //                    rs=qr.rsErp(sql, al);
                //                    while(rs.next()){
                //                        for(;length<columnLength;length++)
                //                         ((DefaultTableModel) tbMain.getModel()).addRow(setRowData());
                //                         tbMain.setValueAt(rs.getString(length), tbMain.getRowCount()+1, length);
                //                    }
                //                }
                //                fin.close();
                //            } catch (InvalidFormatException ex) {
                //                Exceptions.printStackTrace(ex);
                //            } catch (IOException ex) {
                //                Exceptions.printStackTrace(ex);
                //            } catch (ClassNotFoundException ex) {
                //                Exceptions.printStackTrace(ex);
                //            } catch (SQLException ex) {
                //                Exceptions.printStackTrace(ex);
                //            }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            } catch (ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }

        };

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        int rowc = tbMain.getRowCount();
        if (jCheckBox2.isSelected()) {
            tbMain.selectAll();
            for (int i = 0; i < rowc; i++) {
                if (tbMain.getValueAt(i, 11).equals("有待检")) {
                    tbMain.removeRowSelectionInterval(i, i);
                }
            }
        } else {
            tbMain.clearSelection();
        }

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            tbMain.selectAll();
        } else {
            tbMain.clearSelection();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private Vector getColumnName() {

        String[] ss = {"单别", "单号", "序号", "采购数量", "已交数量", "是否结束", "品号", "品名",
            "规格", "快捷码", "单位", "有无待检"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ss));
        Vector vc = new Vector(list);
        return vc;
    }

    private String[] getColumnNmameString() {

        String[] ss = {"单别", "单号", "序号", "采购数量", "已交数量", "是否结束", "品号", "品名",
            "规格", "快捷码", "单位"};
        return ss;
    }

    private Vector setRowData() {

        Vector vc = new Vector();
//        vc.add(false);
        return vc;
    }

    public ArrayList<ArrayList<String>> getSelectedPURTD() {
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        int rowc = tbMain.getRowCount();
        for (int i = 0; i < rowc; i++) {
            al.removeAll(al);
            if (tbMain.isRowSelected(i)) {
                al.add((String) tbMain.getValueAt(i, 0));
                al.add((String) tbMain.getValueAt(i, 1));
                al.add((String) tbMain.getValueAt(i, 2));
            }
            if (!al.isEmpty()) {
                all.add((ArrayList<String>) al.clone());
            }
//                 System.out.println(all);
        }
        return all;
    }

    private Object[] rowInit = {false, null, null, null, null, null, null, null, null, null, null, null};
    private JFileChooser fc = new JFileChooser();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbMain;
    // End of variables declaration//GEN-END:variables
}
