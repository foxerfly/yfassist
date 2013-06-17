/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Cost;

import java.util.ArrayList;

/**
 *
 * @author EDWIN
 */
public class MaterialNODetail {

    private String MB001 = "";  //品号
    private String MB002 = ""; //品名
    private String MB003 = ""; //规格
    private String MB110 = "";  //快捷码
    private String MB004 = "";  //单位
    private String MB025 = "";  //品号属性
    private ArrayList<String> phList = new ArrayList<String>();

    //返回一个品号
    public MaterialNODetail(String ph) {
        this.MB001 = ph;

    }

    //返回品号，品名，规格，快捷码，单位等
    public MaterialNODetail(ArrayList<String> phList) {

        this.phList = phList;
        this.MB001 = phList.get(0);
    }

    public String getPh() {
        return MB001;
    }

    public ArrayList<String> getPhList() {
        return phList;
    }

    public void setPh(String ph) {
        this.MB001 = ph;
    }
}
