/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edwin.my.Cost;

import SqlInterface.QueryErp;
import java.beans.IntrospectionException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author Administrator edwin
 */
public class OutLineViewNodeChildren  extends Children.Keys<String>{
    private ArrayList<String> cs = new ArrayList<String>();

    private ArrayList<String> getBomDetail(String ph) throws ClassNotFoundException, SQLException {

        ArrayList<String> bomList = new ArrayList<String>();
        ResultSet rs;
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        String sql = "SELECT MD001,MD003 FROM BOMMD LEFT JOIN INVMB ON MB001=MD001 WHERE MD001=? AND MB025<>'P'";
        rs = qr.rsErp(sql, ph);
        while (rs.next()) {
            bomList.add(rs.getString("MD003"));
        } 

        return bomList;
    }


    public OutLineViewNodeChildren(String ROOT) {
//        add(nn);
        //  getNodesSelf();
        ArrayList<String> bomList = new ArrayList<String>();
        try {
            bomList = getBomDetail(ROOT);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        cs = (ArrayList<String>) bomList.clone();
    }

    @Override
    protected Node[] createNodes(String key) {
//        AbstractNode node = new AbstractNode(Children.LEAF);
        OutLineViewNode node = null;
        try {
            node = new OutLineViewNode(key);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        node.setDisplayName(key);

        node.setIconBaseWithExtension("ICONS/methodPrivate.png");
        return new Node[]{node};
    }

    @Override
    protected void addNotify() {
//        if (cs.equals(null) || cs.isEmpty()) {
//            getNodesSelf();
//            setKeys(this.cs);
//        }
        if (!cs.equals(null) && !cs.isEmpty()) {
            setKeys(this.cs);
        }

    }

    @Override
    protected void removeNotify() {
        setKeys(Collections.EMPTY_SET);
    }
}
