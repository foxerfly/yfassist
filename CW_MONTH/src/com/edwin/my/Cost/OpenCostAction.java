/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import com.edwin.authorize.RCPAuthorize;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.StatusDisplayer;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponentGroup;
import org.openide.windows.WindowManager;

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
@Messages("CTL_OpenCost=OpenCost")
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
        if (tg == null) {
//            System.out.println("error");
            return;
        } else if (accessControl == true) {
//            StatusDisplayer.getDefault().setStatusText("欢迎：" + ar.getLoginUserName(), 65535);
            tg.open();
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
