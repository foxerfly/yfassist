/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

/**
 *
 * @author EDWIN
 */
public abstract class QueryCondition {
 
    private static String ph = "";
    private static String pzh = "";

    public static String getPh() {
        return ph;
    }

    public static void setPh(String ph) {
        QueryCondition.ph = ph;
    }

    public static String getPzh() {
        return pzh;
    }

    public static void setPzh(String pzh) {
        QueryCondition.pzh = pzh;
    }
    
}
