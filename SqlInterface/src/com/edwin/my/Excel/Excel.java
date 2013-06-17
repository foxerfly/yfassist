/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.Excel;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public interface Excel {

    public ArrayList< ArrayList > readExcel(File f);   //检查输入的EXCEL

}
