/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.SFC;

import com.edwin.SFC.Cmsmd;
import com.edwin.my.RCPSessionFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author EDWIN
 */
public class DepartNodeChildren extends Children.Keys<String> {

//    Node[] nn=new DepartNode().createNodes("Rnll");
    private ArrayList<String> cs = new ArrayList<String>();
    private String departHQL = "";

    private ArrayList<String> getNodesSelf(String Root) {

        Session s = RCPSessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        Query qr;
        if (Root.equals("生产车间")) {
            departHQL = "from Cmsmd";
            qr = s.createQuery(departHQL);
        } else {
            departHQL = "from Cmsmd as a where a.md001=?";
            qr = s.createQuery(departHQL);
            qr.setParameter(0, Root);

        }
        for (Iterator it = qr.list().iterator(); it.hasNext();) {
            Cmsmd cmsmd = (Cmsmd) it.next();
            cs.add(cmsmd.getMd001().trim() + " " + cmsmd.getMd002().trim());
        }

        tx.commit();
        s.close();
        return cs;
    }

    public DepartNodeChildren(String Root) {
//        add(nn);
        getNodesSelf(Root);
    }

    @Override
    protected Node[] createNodes(String key) {
//        DepartNode node = new DepartNode(key);
        AbstractNode anode = new AbstractNode(Children.LEAF);
        anode.setDisplayName(key);
        anode.setIconBaseWithExtension("ICONS/connected_host.png");
        return new Node[]{anode};
    }

    @Override
    protected void addNotify() {
//        super.addNotify(); //To change body of generated methods, choose Tools | dsTemplates.
        if (cs.equals(null) || cs.isEmpty()) {
            setKeys(this.cs);
        }
        setKeys(this.cs);
    }

    @Override
    protected void removeNotify() {
//        super.removeNotify(); //To change body of generated methods, choose Tools | Templates.
        setKeys(Collections.EMPTY_SET);
    }

}
