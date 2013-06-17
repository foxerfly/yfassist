/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.bom;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

/**
 *
 * @author EDWIN
 */
@ActionID(
        category = "File",
        id = "com.edwin.my.bom")
@ActionRegistration(
        iconBase = "com/edwin/my/bom/accept.png",
        displayName = "#CTL_checkBom")
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1200),
    @ActionReference(path = "Toolbars/File", position = 200)
})
@Messages("CTL_checkBom=checkBom")
public final class checkBom extends AbstractAction implements Presenter.Toolbar {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
//        String s=JOptionPane.showInputDialog("请输入");
    }

    @Override
    public Component getToolbarPresenter() {
        return new MyToolbar();
    }
}
