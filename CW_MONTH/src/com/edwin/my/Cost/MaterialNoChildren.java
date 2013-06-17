/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author John
 */
public class MaterialNoChildren extends Children.Keys<MaterialNO> {

    public MaterialNoChildren() {
    }
    private String[] MaterialNOs = new String[]{
        "Adventure",
        "Drama",
        "Comedy",
        "Romance",
        "Thriller"};


    @Override
    protected Node[] createNodes(MaterialNO key) {
        MaterialNO[] mo;
        int length=MaterialNOs.length;
        for(int j=0;j<length;j++){
           key.setPh(MaterialNOs[j]);
        }


        AbstractNode node = new AbstractNode(Children.LEAF);
        node.setDisplayName(key.getPh());
        node.setIconBaseWithExtension("ICONS/methodPrivate.png");
        return new Node[]{node};

    }
}
