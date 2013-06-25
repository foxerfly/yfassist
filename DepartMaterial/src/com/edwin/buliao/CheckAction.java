/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.buliao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.cookies.EditorCookie;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "com.edwin.buliao.CheckAction")
@ActionRegistration(
        iconBase = "ICONS/bookmarksTable.png",
        displayName = "#CTL_CheckAction")
@ActionReferences({
    @ActionReference(path = "Menu/生产", position = 3333, separatorBefore = 3283, separatorAfter = 3383),
    @ActionReference(path = "Editors/text/x-java/Popup", position = 1300, separatorBefore = 1250, separatorAfter = 1350)
})
@Messages("CTL_CheckAction=检查补单明细")
public final class CheckAction implements ActionListener {

    private final EditorCookie context;

    public CheckAction(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
    }
}
