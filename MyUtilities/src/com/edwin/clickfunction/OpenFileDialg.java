/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.clickfunction;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author edwin
 */
public class OpenFileDialg {

    private JFileChooser fileChooser = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "excel文件", "xls", "xlsx");

    public String getAbsolutFilePath() {
        String filePath = "";
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
        }

        return filePath;
    }

}
