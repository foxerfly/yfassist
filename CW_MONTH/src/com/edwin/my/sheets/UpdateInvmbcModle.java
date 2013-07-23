/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.sheets;

import com.edwin.CWMONTH.Invmbc;
import com.edwin.my.RCPSessionFactory;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 * 更新数据库，传入品号，料，工，费，加工费 判断插入或者更新数据，若结果为ERROR，返回值
 *
 * @author John
 */
public class UpdateInvmbcModle {

    private String ph = "";
    private BigDecimal materialPrice = BigDecimal.ZERO;
    private BigDecimal laborePrice = BigDecimal.ZERO;
    private BigDecimal madePrice = BigDecimal.ZERO;
    private BigDecimal cooperationPrice = BigDecimal.ZERO;

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getLaborePrice() {
        return laborePrice;
    }

    public void setLaborePrice(BigDecimal laborePrice) {
        this.laborePrice = laborePrice;
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

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public boolean insertOrUpdate() {

        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        Invmbc iid = null;

        Query q = s.createQuery("from Invmbc as c where c.mb001=:specph");
        q.setString("specph", ph);
        List result = q.list();

        if (result.isEmpty()) {
            iid = new Invmbc();
            iid.setGuid(UUID.randomUUID().toString().trim());
            iid.setMb001(this.getPh());
//            System.out.println("empty"+this.getPh());
        } else {
            iid = (Invmbc) result.iterator().next();
//            System.out.println("exists" + iid.getMb001());
        }
        try {
            iid.setLaborePrice(this.getLaborePrice());
            iid.setMadePrice(this.getMadePrice());
            iid.setMaterialPrice(this.getMaterialPrice());
            iid.setCooperationPrice(this.getCooperationPrice());
            s.save(iid);
            tx.commit();
        } catch (HibernateException hibernateException) {
            NotifyDescriptor nd = new NotifyDescriptor.Message("品号：" + this.getPh() + "  更新错误！", NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notifyLater(nd);
            if (tx != null) {
                tx.rollback();
//                s.close();
                return false;
            }
        } finally {
            s.close();
            return true;
        }

    }

}
