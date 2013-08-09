/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.LRP.MOCTA;

import com.edwin.my.RCPSessionFactory;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author John
 */
public class GetTaList {
    
    private ArrayList<String> al=new ArrayList<String>();

    public  ArrayList<String> getList(){
        
        Session s=RCPSessionFactory.openSession();
        Transaction tx=s.beginTransaction();
        s.createQuery("from Cmsmq WHERE SUBSTRING(mq003,1,2)='51' OR SUBSTRING(mq003,1,2)='52' ");
        
        
        
        
        
        tx.commit();
        s.close();
        return al;
    }
    
    
}
