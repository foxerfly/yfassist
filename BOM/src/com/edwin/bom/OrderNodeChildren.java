/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import com.edwin.my.RCPSessionFactory;
import java.util.ArrayList;
import java.util.Collections;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author John
 */
public class OrderNodeChildren extends Children.Keys<String> {

    private ArrayList<String> bomList = new ArrayList<String>();
    private String ph = "";
    private String root="";

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = getNode().getDisplayName().trim();
    }
    

    public ArrayList<String> getBomList() {
        return bomList;
    }

    public void setBomList(String ph) {

        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();

        bomList = (ArrayList<String>) s.createSQLQuery("SELECT TR009 from COPTR where TR001=? AND TR002=? AND TR004=? AND TR009<>?").setString(0, QueryCondition.getPh()).setString(1, QueryCondition.getPzh()).setString(2, ph).setString(3, QueryCondition.getPh()).list();

//        System.out.println(bomList);
        tx.commit();
        s.close();

//        this.bomList = bomList;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    @Override
    protected Node[] createNodes(String key) {

        OrderNode od = new OrderNode(key);
        od.setDisplayName(key);
        od.setIconBaseWithExtension("ICONS/exdPersistentClassMapping.gif");
        return new Node[]{od};
    }

    public OrderNodeChildren(String ph) {
        setPh(ph);
        setBomList(ph);
    }

    @Override
    protected void removeNotify() {

        setKeys(Collections.EMPTY_SET);

    }

    @Override
    protected void addNotify() {

        if (!bomList.equals(null) && !bomList.isEmpty()) {
            setKeys(this.bomList);
        }
    }

}
