/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.SFC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.cookies.EditCookie;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.netbeans.api.actions.Editable;

@ActionID(
        category = "Edit",
        id = "com.edwin.my.SFC.DepartNodeAction")
@ActionRegistration(
        //        iconBase = "com/edwin/my/SFC/16x16.gif",
        displayName = "#CTL_DepartNodeAction")
@ActionReference(path = "Toolbars/File", position = 3233)
@Messages("CTL_DepartNodeAction=DepartNodeAction")
public final class DepartNodeAction implements ActionListener {

    private final EditCookie context;

    public DepartNodeAction(EditCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
        context.edit();
    }
}
