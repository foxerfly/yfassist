/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.qrcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

//@ActionID(
//        category = "Edit",
//        id = "com.edwin.my.qrcode.qrCode")
//@ActionRegistration(
//        iconBase = "ICON/qr.png",
//        displayName = "#CTL_qrCode")
//@ActionReference(path = "Toolbars/File", position = 100)
//@Messages("CTL_qrCode=二维码生成器")
public final class qrCode implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        Icon ic = new ImageIcon(getClass().getResource("/ICON/qr.png"));
        JOptionPane.showInternalInputDialog(TopComponent.getRegistry().getActivated(), e, "请扫描二维码", JOptionPane.INFORMATION_MESSAGE, ic, null, this);
    }
}
