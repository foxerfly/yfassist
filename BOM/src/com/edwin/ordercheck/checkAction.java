/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.ordercheck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponentGroup;
import org.openide.windows.WindowManager;

@ActionID(
        category = "基础资料",
        id = "com.edwin.ordercheck.checkAction"
        )
@ActionRegistration(
        iconBase = "ICONS/help.png",
        iconInMenu = true,
        displayName = "#CTL_checkAction"
        )
@ActionReference(path = "Menu/基础资料", position = 3333)
@Messages("CTL_checkAction=检查特征属性")
public final class checkAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body

        TopComponentGroup group = WindowManager.getDefault().findTopComponentGroup("ordercheckGroup");
        if (group != null) {
            group.close();
            group.open();
//             WindowManager.getDefault().findTopComponent("OrderDetailCheckTopComponent").open();
//            WindowManager.getDefault().findTopComponent("OrderDetailsTopComponent").open();
        } else {
            JOptionPane.showConfirmDialog(null, "未找到窗口");
        }

    }
}
