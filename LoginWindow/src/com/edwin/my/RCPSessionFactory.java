/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my;

import HibernateCFG.HibernateCFG;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;

/**
 *
 * @author EDWIN
 */
public abstract class RCPSessionFactory extends ModuleInstall {

    private static String cfg = "hibernate.cfg.xml";

    @Override
    public void close() {
        sessionFactory.close();
        super.close(); //To change body of generated methods, choose Tools | Templates.

    }
//
//
//    @Override
//    public void restored() {
//        super.restored(); //To change body of generated methods, choose Tools | Templates.
//        ProxyFactory.classLoaderProvider = new ProxyFactory.ClassLoaderProvider() {
//            @Override
//            public ClassLoader get(ProxyFactory pf) {
//                return Thread.currentThread().getContextClassLoader();
//            }
//        };
//        NotifyDescriptor d = new NotifyDescriptor.Message("【你没有权限");
//
//    }

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.

//            sessionFactory = new Configuration().configure().buildSessionFactory();
            HibernateCFG HC = Lookup.getDefault().lookup(HibernateCFG.class);
            cfg = HC.getconfigurationCFG();
            sessionFactory = new Configuration().configure(cfg).buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {

        return sessionFactory.openSession();
    }

    public static Session currentSession() {

        return sessionFactory.getCurrentSession();
    }
}
