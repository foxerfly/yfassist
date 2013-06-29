/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.authorize;

import SqlImplements.PreVectorImp;
import com.edwin.my.RCPSessionFactory;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
        if (!this.getKeyName(key).equals("")) {
            Session s = RCPSessionFactory.openSession();
            Transaction tx = s.beginTransaction();

            Criteria c = s.createCriteria(UserAuthorize.class);
            c.add(Restrictions.eq("userId", super.getLoginUserName().trim()));
            c.add(Restrictions.eq("authorizeId", key));
            List ouathResult = c.list();
            tx.commit();
            s.close();
            if (ouathResult.isEmpty()) {
//            for (Iterator it = ouathResult.iterator(); it.hasNext();) {
//                UserAuthorize ui = (UserAuthorize) it.next();
//                System.out.println(ui.getUserId());
//            }
                NotifyDescriptor d = new NotifyDescriptor.Message("【" + super.getLoginUserName().trim() + "】你没有" + this.keyName + "权限");
                DialogDisplayer.getDefault().notify(d);
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public String getKeyName(String key) {

        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        Query qr = s.createQuery("from AuthorizeDetail as a where a.authorizeId=?");
        qr.setParameter(0, key);
        if (qr.list().isEmpty()) {
            NotifyDescriptor d = new NotifyDescriptor.Message("程序未注册，请联系信息部注册程序，注册信息为： " + key);
            DialogDisplayer.getDefault().notify(d);
        } else {
            AuthorizeDetail ad = (AuthorizeDetail) qr.list().iterator().next();
            keyName = ad.getAuthorizeName().trim();
            tx.commit();
            s.close();
            return keyName;
        }
        return "";
    }

}
