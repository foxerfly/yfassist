/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.bar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
    category = "Edit",
id = "com.edwin.my.bar.SFCsearchAction")
@ActionRegistration(
    iconBase = "com/edwin/my/bar/find.png",
displayName = "#CTL_SFCsearchAction")
@ActionReference(path = "Toolbars/File", position = 100)
@Messages("CTL_SFCsearchAction=SFCsearchAction")
public final class SFCsearchAction extends AbstractAction implements Presenter.Toolbar{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }

    @Override
    public Component getToolbarPresenter() {
        return new SFCsearchBar();
    }
}
