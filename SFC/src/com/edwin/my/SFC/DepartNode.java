/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.SFC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.cookies.EditCookie;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;

/**
 *
 * @author John
 */
public class DepartNode extends AbstractNode implements EditCookie, ActionListener {

//    public DepartNode(Children children) {
//        super(children);
//    }
    public DepartNode(String Root) {
        super(new DepartNodeChildren(Root));
    }

    @Override
    public void edit() {
    }

    @Override
    protected Sheet createSheet() {
        return super.createSheet(); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
