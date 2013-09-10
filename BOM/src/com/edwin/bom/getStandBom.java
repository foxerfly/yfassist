/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.bom;

import java.util.ArrayList;

/**
 *
 * @author John
 */
public class getStandBom {

    //1 配置品号，2：配置号，3：本阶品号
    private ArrayList<String> bomList;

    public getStandBom(ArrayList<String> bomList) {
        if (!bomList.isEmpty()) {
            this.bomList = (ArrayList<String>) bomList.clone();
        }
    }

    public Boolean generateBom() {
        return false;
    }

    //往COPTR表插入BOM
    public void insertCOPTRBom() {
    }
}
