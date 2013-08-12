/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import com.edwin.my.RCPSessionFactory;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author EDWIN
 */
//根据查询的SQL语句，自动创建modle
public class MySqlJTableModel extends MyJTableModel {

    private String dataSql="";
    private ArrayList<String> al=new ArrayList<String>();
    
    
    public String getDataSql() {
        return dataSql;
    }

    public void setDataSql(String dataSql) {
        this.dataSql = dataSql;
    }
    
   
    

    
    

   

    
}
