/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.SFC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import org.netbeans.core.api.multiview.MultiViews;
import org.netbeans.core.spi.multiview.MultiViewDescription;
import org.netbeans.core.spi.multiview.MultiViewFactory;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.CloneableTopComponent;
import org.openide.windows.TopComponent;
import org.openide.windows.TopComponentGroup;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Tools",
        id = "com.edwin.my.SFC.MPS")
@ActionRegistration(
        iconBase = "com/edwin/my/SFC/asterisk_yellow.png",
        displayName = "#CTL_MPS")
@ActionReferences({
    @ActionReference(path = "Menu/Tools", position = 50),
    @ActionReference(path = "Toolbars/File", position = 3333)
})
// separatorBefore = -50, separatorAfter = 50
@Messages("CTL_MPS=生产计划")
public final class MPSaction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {

//        TopComponent[] findTopComponents = WindowManager.getDefault().getOpenedTopComponents(WindowManager.getDefault().findMode("editor"));
//        for (TopComponent topComponent : findTopComponents) {
//            if (!topComponent.getClass().getAnnotation(TopComponent.Description.class).preferredID().equals("主排程计划")||!topComponent.getClass().getAnnotation(TopComponent.Description.class).preferredID().equals("物料需求状况")) {
        MPSViewPanelDescription mps1 = new MPSViewPanelDescription();  //主生产计划
        MPSmaterialReqDescription mps2 = new MPSmaterialReqDescription(); //物料需求
        MultiViewDescription[] descArry = {mps1, mps2};
        TopComponent otc = MultiViewFactory.createMultiView(descArry, mps1);

        TopComponentGroup group = WindowManager.getDefault().findTopComponentGroup("SFCGroups");
        if (group == null) {
            System.out.println("not find groups");
            return;
        } else {
            group.open();
            otc.open();
        }

    }
}
