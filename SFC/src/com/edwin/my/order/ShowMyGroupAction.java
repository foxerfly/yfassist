/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.order;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JToggleButton;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;
import org.openide.windows.TopComponentGroup;
import org.openide.windows.WindowManager;

@ActionID(
    category = "Edit",
id = "com.edwin.my.order.ShowMyGroupAction" )
@ActionRegistration(
    iconBase = "com/edwin/my/order/application_tile_horizontal.png",
displayName = "#CTL_ShowMyGroupAction" )
@ActionReference(path = "Toolbars/File", position = 0 )
@Messages("CTL_ShowMyGroupAction=ShowMyGroupAction")

public final class ShowMyGroupAction extends AbstractAction implements Presenter.Toolbar{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
//        TopComponentGroup group = WindowManager.getDefault().findTopComponentGroup("MyGroup");
//
//        if (group == null) {
//            System.out.println("not found groups");
//            return;
//        }
//
//        group.open();
    }

    @Override
    public Component getToolbarPresenter() {
        return new OpenGroup();
    }




}
