/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.exportutil;

/**
 *
 * @author EDWIN
 */
public class ExpandBomModel {

    private String ph;

    //false 下展
    //true 上展
    private boolean orient = false;

    //false :单级展开
    //true 多级展开
    private boolean step = false;

    public boolean isOrient() {
        return orient;
    }

    public void setOrient(boolean orient) {
        this.orient = orient;
    }

    public boolean isStep() {
        return step;
    }

    public void setStep(boolean step) {
        this.step = step;
    }

    public ExpandBomModel(String ph) {
        setPh(ph);
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }
    

}
