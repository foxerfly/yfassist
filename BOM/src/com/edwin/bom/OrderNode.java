/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author John
 */
public class OrderNode extends AbstractNode{

    public OrderNode(String key) {
//        super(children);
        super(new OrderNodeChildren(key));
    }
    
        
    
    
    
    
}
