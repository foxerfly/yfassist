/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Lookup;

/**
 *
 * @author EDWIN
 */
public class OrderDetailChildrenFactory extends ChildFactory<String> {

//     private Lookup.Result<MaterialNODetail> resultDetail = null;
    @Override
    protected boolean createKeys(List<String> toPopulate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Node createNodeForKey(String key) {







        return super.createNodeForKey(key); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Node[] createNodesForKey(String key) {
        return this.createNodesForKey(key); //To change body of generated methods, choose Tools | Templates.
    }
}
