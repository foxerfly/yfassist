/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponentGroup;
import org.openide.windows.WindowManager;

//@ActionID(
//        category = "Edit",
//        id = "com.edwin.my.Cost.CloseCostAction")
//@ActionRegistration(
//        iconBase = "ICONS/animate_stop.png",
//        displayName = "#CTL_CloseCostAction")
//@ActionReferences({
//    @ActionReference(path = "Menu/Tools", position = -150),
//    @ActionReference(path = "Toolbars/File", position = 3333)
//})
//@Messages("CTL_CloseCostAction=CloseCostAction")
public final class CloseCostAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        TopComponentGroup tg = WindowManager.getDefault().findTopComponentGroup("CostGroup");
        if (tg == null) {
//            System.out.println("error");
            return;
        } else {
            tg.close();
        }
    }
}
