/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlImplements;

import java.sql.Connection;

/**
 *
 * @author EDWIN
 */
public abstract class MyJdbc {

    private static Connection connc;

    public static void setConn(Connection conn) {

        connc = conn;
    }

    public static Connection getConn() {
        return connc;
    }
    
}
