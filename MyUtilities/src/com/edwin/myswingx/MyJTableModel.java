/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import java.util.Arrays;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWIN
 */
//输入字符串组即可以返回加好列名的modle
public class MyJTableModel {

    private Vector vcColumnNames = null;
    protected Vector vcData = null;

    public MyJTableModel(String... columnNames) {
//        vcColumnNames.clear();
        setColumnNames(columnNames);
    }

    /**
     *
     * @param columnNames
     */
    public MyJTableModel(String[] columnNames, Map mp) {
//        vcColumnNames.clear();
        setColumnNames(columnNames);

    }

    public Vector setColumnNames(String... columnNames) {
        vcColumnNames = new Vector((Arrays.asList(columnNames)));
        return vcColumnNames;
    }

    public Vector setData() {
        return vcData;
    }

    public DefaultTableModel buildModel() {
//        setColumnNames(columnNames);
        return new DefaultTableModel(vcData, vcColumnNames);
    }

    public DefaultTableModel buildSpecModel() {
//        setColumnNames(columnNames);
        return new DefaultTableModel(vcData, vcColumnNames);
    }

}
