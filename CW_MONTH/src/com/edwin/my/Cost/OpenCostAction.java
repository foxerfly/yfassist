/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import com.edwin.authorize.RCPAuthorize;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.StatusDisplayer;
import org.openide.nodes.Node;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.TopComponentGroup;
import org.openide.windows.WindowManager;
import org.openide.windows.Workspace;

@ActionID(
        category = "Tools",
        id = "com.edwin.my.Cost.OpenCost")
@ActionRegistration(
        iconBase = "ICONS/amazon.png",
        displayName = "#CTL_OpenCost")
@ActionReferences({
    @ActionReference(path = "Menu/Tools", position = -150),
    @ActionReference(path = "Toolbars/File", position = 3433)
})
@Messages("CTL_OpenCost=成本计算")
public final class OpenCostAction extends AbstractAction {

//    private Lookup.Result<PreVector> results = Utilities.actionsGlobalContext().lookupResult(PreVector.class);
    private Boolean accessControl = false;
    private String userName = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
//        System.out.println("error");

        RCPAuthorize ar = new RCPAuthorize();
        accessControl = ar.oAuth("OpenCostAction");
        TopComponentGroup tg = WindowManager.getDefault().findTopComponentGroup("CostGroup");
        if (accessControl == false) {
//            System.out.println("error");
            return;
        } else if (accessControl == true) {
//            StatusDisplayer.getDefault().setStatusText("欢迎：" + ar.getLoginUserName(), 65535);
//            System.out.println(tg);
            tg.close();
            tg.open();
            Mode brief = WindowManager.getDefault().findMode("anonymousMode_2");
            Mode detail = WindowManager.getDefault().findMode("anonymousMode_1");
            brief.dockInto(WindowManager.getDefault().findTopComponent("OrderBriefTopComponent"));
            detail.dockInto(WindowManager.getDefault().findTopComponent("OrderDetailTopComponent"));
            WindowManager.getDefault().findTopComponent("MainCostViewTopComponent").open();
            WindowManager.getDefault().findTopComponent("OrderBriefTopComponent").open();
            WindowManager.getDefault().findTopComponent("OrderDetailTopComponent").open();
            WindowManager.getDefault().findTopComponent("MainCostViewTopComponent").requestActive();
//            WindowManager.getDefault().findTopComponent("OrderBriefTopComponent").requestActive();
//            WindowManager.getDefault().findTopComponent("OrderDetailTopComponent").requestActive();

        }
//            else if (accessControl == false) {
//
//            NotifyDescriptor d = new NotifyDescriptor.Message("【" + ar.getLoginUserName() + "】你没有成本计价权限");
//            DialogDisplayer.getDefault().notify(d);
//
//        }
    }

//    private boolean oAuth() {
//
//        PreVectorInterface ps = Lookup.getDefault().lookup(PreVectorInterface.class);
//        this.userName = ps.getLoginUserName();
//        accessControl = ps.getAuthorize();
//        return accessControl;
//    }
//
//    @Override
//    public void resultChanged(LookupEvent ev) {
//        Collection< ? extends PreVector> lgs = results.allInstances();
//        if (!lgs.isEmpty()) {
//
//            PreVector lg = lgs.iterator().next();
//            userName = lg.getLoginUserName();
//            System.out.println(userName);
//            accessControl = lg.getAuthorize("成本计价");
//
//        }
//
//    }
}
