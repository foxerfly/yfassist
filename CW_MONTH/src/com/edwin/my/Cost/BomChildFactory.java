/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import SqlInterface.QueryErp;
import java.sql.ResultSet;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Lookup;

/**
 *
 * @author EDWIN
 */
public class BomChildFactory extends ChildFactory<String> {


    @Override
    protected Node createNodeForKey(String key) {
        return super.createNodeForKey(key); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    protected boolean createKeys(List<String> toPopulate) {
        String sql = "SELECT MD003 FROM BOMMD WHERE MD001=?";
        QueryErp qr = Lookup.getDefault().lookup(QueryErp.class);
        ResultSet rs;
//        rs = qr.rsErp(sql, null)
        return true;
    }
}
