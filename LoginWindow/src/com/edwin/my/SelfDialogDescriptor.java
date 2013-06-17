/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my;

import java.awt.event.ActionListener;
import org.openide.DialogDescriptor;

/**
 *
 * @author John
 */
public class SelfDialogDescriptor extends DialogDescriptor {

    public SelfDialogDescriptor(Object innerPane, String title, boolean isModal, ActionListener bl) {
        super(innerPane, title, isModal, bl);
    }

}
