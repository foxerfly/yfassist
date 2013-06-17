/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my;

/**
 *
 * @author EDWIN
 */
public class LoginUser {

    public LoginUser(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private static String userName = "";

    public Boolean getAuthorize(String key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

}
