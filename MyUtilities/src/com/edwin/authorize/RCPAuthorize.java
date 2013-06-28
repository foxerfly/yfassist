/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.authorize;

import SqlImplements.PreVectorImp;
import com.edwin.my.RCPSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author John
 */
public class RCPAuthorize extends PreVectorImp {

    private String keyName = "";

    public Boolean oAuth(String key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getKeyName(key);
        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();

        tx.commit();
        s.close();

        NotifyDescriptor d = new NotifyDescriptor.Message("【" + super.getLoginUserName().trim() + "】你没有" + this.keyName + "权限");
        DialogDisplayer.getDefault().notify(d);
        return false;

    }

    public String getKeyName(String key) {

        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        Query qr = s.createQuery("from AuthorizeDetail as a where a.authorizeId=?");
        qr.setParameter(0, key);
        AuthorizeDetail ad = (AuthorizeDetail) qr.list().iterator().next();
        keyName = ad.getAuthorizeName().trim();
        tx.commit();
        s.close();
        return keyName;

    }

}
