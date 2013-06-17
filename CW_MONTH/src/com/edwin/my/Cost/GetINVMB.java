/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import SqlInterface.QueryErp;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import java.text.DecimalFormat;

/**
 *
 * @author EDWIN
 */
public class GetINVMB {

    ArrayList alist = new ArrayList();
    private String ph = "";
    private String sql1 = "SELECT INVMB.MB001 MB001,INVMB.MB002 MB002,INVMB.MB003 MB003,INVMB.MB110 MB110,INVMB.MB004 MB004,INVMB.MB025 MB025,\n"
            + "	ISNULL(INVMBD.materialPrice,0) materialPrice,ISNULL(INVMBD.laborePrice,0) laborePrice, ISNULL(INVMBD.madePrice,0) madePrice, ISNULL(INVMBD.cooperationPrice,0)  cooperationPrice, \n"
            + " INVMBD.MD006, INVMBD.MD007,INVMBD.VZ,INVMBD.sumPrice \n"
            + "FROM  INVMBD \n"
            + "LEFT JOIN INVMB ON RTRIM(INVMBD.MB001)=INVMB.MB001 WHERE INVMBD.MB001=?";
    private String sql2 = "SELECT INVMB.MB001 MB001,INVMB.MB002 MB002,INVMB.MB003 MB003,INVMB.MB110 MB110,INVMB.MB004 MB004,INVMB.MB025 MB025,\n"
            + "	ISNULL(INVMBD.materialPrice,0) materialPrice,ISNULL(INVMBD.laborePrice,0) laborePrice, ISNULL(INVMBD.madePrice,0) madePrice, ISNULL(INVMBD.cooperationPrice,0)  cooperationPrice, BOMMD.MD006, BOMMD.MD007\n"
            + "FROM  BOMMD LEFT JOIN INVMB ON INVMB.MB001=MD003 \n"
            + "LEFT JOIN INVMBD ON RTRIM(INVMBD.MB001)=INVMB.MB001 WHERE MD003=? AND MD001=?";
    private String sql3 = "SELECT INVMB.MB001 MB001,INVMB.MB002 MB002,INVMB.MB003 MB003,INVMB.MB110 MB110,INVMB.MB004 MB004,INVMB.MB025 MB025,\n"
            + "	ISNULL(INVMBD.materialPrice,0) materialPrice,ISNULL(INVMBD.laborePrice,0) laborePrice, ISNULL(INVMBD.madePrice,0) madePrice, ISNULL(INVMBD.cooperationPrice,0)  cooperationPrice, INVMBD.MD006, INVMBD.MD007,INVMBD.VZ,INVMBD.sumPrice \n"
            + "FROM  BOMMD LEFT JOIN INVMB ON INVMB.MB001=MD003 \n"
            + "LEFT JOIN INVMBD ON RTRIM(INVMBD.MB001)=INVMB.MB001 WHERE MD003=? AND MD001=?";
    private String MB001 = "";
    private String MB002 = "";
    private String MB003 = "";
    private String MB110 = "";
    private String MB004 = "";
    private String MB025 = "";
    private BigDecimal materialPrice = BigDecimal.ZERO;
    private BigDecimal laborePrice =  BigDecimal.ZERO;
    private BigDecimal madePrice =  BigDecimal.ZERO;
    private BigDecimal cooperationPrice =  BigDecimal.ZERO;
    private BigDecimal pirce =  BigDecimal.ZERO;
    private BigDecimal MD006 =  BigDecimal.ONE;
    private BigDecimal MD007 = BigDecimal.ONE;
    private BigDecimal VZ =  BigDecimal.ONE;
    private BigDecimal sumPrice =  BigDecimal.ONE;
    
//    
//    public BigDecimal formatValue(Double val) {
//
//        DecimalFormat df = new DecimalFormat("##.0000");
//        return BigDecimal.valueOf(df.format(val));
//    }

    public void Out(Object obj) {
        System.out.println(obj);
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public BigDecimal getVZ() {
        return VZ;
    }

    public void setVZ(BigDecimal VZ) {
        this.VZ = VZ;
    }


    public BigDecimal getMD006() {
        return MD006;
    }

    public void setMD006(BigDecimal MD006) {
        this.MD006 = MD006;
    }

    public BigDecimal getMD007() {
        return MD007;
    }

    public void setMD007(BigDecimal MD007) {
        this.MD007 = MD007;
    }

//    public BigDecimal getPirce() {
//
//        return formatValue((MD006 / MD007) * (materialPrice + laborePrice + madePrice + cooperationPrice));
//    }

    public BigDecimal getLaborePrice() {
        return laborePrice;
    }

    public void setLaborePrice(BigDecimal laborePrice) {
        this.laborePrice = laborePrice;
//        System.out.println(this.laborePrice);
    }

    public BigDecimal getMadePrice() {
        return madePrice;
    }

    public void setMadePrice(BigDecimal madePrice) {
        this.madePrice = madePrice;
    }

    public BigDecimal getCooperationPrice() {
        return cooperationPrice;
    }

    public void setCooperationPrice(BigDecimal cooperationPrice) {
        this.cooperationPrice = cooperationPrice;
    }

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public String getMB001() {
        return MB001;
    }

    public void setMB001(String MB001) {
        this.MB001 = MB001;
    }

    public String getMB002() {
        return MB002;
    }

    public void setMB002(String MB002) {
        this.MB002 = MB002;
    }

    public String getMB003() {
        return MB003;
    }

    public void setMB003(String MB003) {
        this.MB003 = MB003;
    }

    public String getMB110() {
        return MB110;
    }

    public void setMB110(String MB110) {
        this.MB110 = MB110;
    }

    public String getMB004() {
        return MB004;
    }

    public void setMB004(String MB004) {
        this.MB004 = MB004;
    }

    public String getMB025() {
        return MB025;
    }

    public void setMB025(String MB025) {
        this.MB025 = MB025;
    }

    public GetINVMB(String root) {

        this.ph = root;
        try {
            getInvmbDetail();
//            System.out.println(this.ph);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    public GetINVMB(String sonNodeName, String parentNodeName) {

        try {
            getInvmbDetail(sonNodeName, parentNodeName);
//            System.out.println(this.ph);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    public ArrayList getInvmbDetail() throws ClassNotFoundException, SQLException {

        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        ResultSet rs = qr.rsErp(sql1, ph);
        alist.removeAll(alist);
        if (rs.next()) {
            alist.add(rs.getString("MB001"));
            setMB001(rs.getString("MB001").toString().trim());

            alist.add(rs.getString("MB002"));
            setMB002(rs.getString("MB002").toString().trim());

            alist.add(rs.getString("MB003"));
            setMB003(rs.getString("MB003").toString().trim());

            alist.add(rs.getString("MB110"));
            setMB110(rs.getString("MB110").toString().trim());

            alist.add(rs.getString("MB004"));
            setMB004(rs.getString("MB004").toString().trim());

            alist.add(rs.getString("MB025"));
            setMB025(rs.getString("MB025").toString().trim());

            alist.add(rs.getBigDecimal("materialPrice"));
            setMaterialPrice(rs.getBigDecimal("materialPrice"));

            alist.add(rs.getBigDecimal("laborePrice"));
            setLaborePrice(rs.getBigDecimal("laborePrice"));

            alist.add(rs.getBigDecimal("madePrice"));
            setMadePrice(rs.getBigDecimal("madePrice"));

            alist.add(rs.getBigDecimal("cooperationPrice"));
            setCooperationPrice(rs.getBigDecimal("cooperationPrice"));

            alist.add(rs.getBigDecimal("MD006"));
            setMD006(rs.getBigDecimal("MD006"));

            alist.add(rs.getBigDecimal("MD007"));
            setMD007(rs.getBigDecimal("MD007"));

            alist.add(rs.getBigDecimal("VZ"));
            setVZ(rs.getBigDecimal("VZ"));

            alist.add(rs.getBigDecimal("sumPrice"));
            setSumPrice(rs.getBigDecimal("sumPrice"));


        }
        rs.close();
        return alist;

    }

    public ArrayList getInvmbDetail(String sonNodeName, String parentNodeName) throws ClassNotFoundException, SQLException {

        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        ResultSet rs = qr.rsErp(sql3, sonNodeName, parentNodeName);
        alist.removeAll(alist);
        if (rs.next()) {
            alist.add(rs.getString("MB001"));
            setMB001(rs.getString("MB001").toString().trim());

            alist.add(rs.getString("MB002"));
            setMB002(rs.getString("MB002").toString().trim());

            alist.add(rs.getString("MB003"));
            setMB003(rs.getString("MB003").toString().trim());

            alist.add(rs.getString("MB110"));
            setMB110(rs.getString("MB110").toString().trim());

            alist.add(rs.getString("MB004"));
            setMB004(rs.getString("MB004").toString().trim());

            alist.add(rs.getString("MB025"));
            setMB025(rs.getString("MB025").toString().trim());

            alist.add(rs.getBigDecimal("materialPrice"));
            setMaterialPrice(rs.getBigDecimal("materialPrice"));

            alist.add(rs.getBigDecimal("laborePrice"));
            setLaborePrice(rs.getBigDecimal("laborePrice"));

            alist.add(rs.getBigDecimal("madePrice"));
            setMadePrice(rs.getBigDecimal("madePrice"));

            alist.add(rs.getBigDecimal("cooperationPrice"));
            setCooperationPrice(rs.getBigDecimal("cooperationPrice"));

            alist.add(rs.getBigDecimal("MD006"));
            setMD006(rs.getBigDecimal("MD006"));

            alist.add(rs.getBigDecimal("MD007"));
            setMD007(rs.getBigDecimal("MD007"));

            alist.add(rs.getBigDecimal("VZ"));
            setVZ(rs.getBigDecimal("VZ"));

            alist.add(rs.getBigDecimal("sumPrice"));
            setSumPrice(rs.getBigDecimal("sumPrice"));

        }
        rs.close();
        return alist;

    }
}
