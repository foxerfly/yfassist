/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlInterface;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author John
 */
public interface QueryErp {

//
    /*
     * 常用数据库查询
     */
    //一个参数预查询
    public ResultSet rsErp(String sql) throws ClassNotFoundException, SQLException;

    public ResultSet rsErp(String sql, String param) throws ClassNotFoundException, SQLException;

    public ResultSet rsErp(String sql, String param1, String param2) throws ClassNotFoundException, SQLException;

    public ResultSet rsErp(String sql, ArrayList<String> list) throws ClassNotFoundException, SQLException;

    //调用存储过程 无参
    public ResultSet rsErpProc(String procedure) throws ClassNotFoundException, SQLException;

    //调用存储过程 传参
    public ResultSet rsErpProc(String procedure, int param) throws ClassNotFoundException, SQLException;

    //调用存付过程 传参 String
    public Boolean rsErpProc(String procedure, String param) throws ClassNotFoundException, SQLException;

    public ResultSet rsErpProc(String procedure, ArrayList<String> list) throws ClassNotFoundException, SQLException;

    public Boolean rsErpProcList(String procedure, ArrayList list) throws ClassNotFoundException, SQLException;

    //调用插入语句
    public boolean InsertErp(String sql, ArrayList list) throws ClassNotFoundException, SQLException;

    //更新语句
    public boolean updateErp(String sql) throws ClassNotFoundException, SQLException;

    public boolean updateErp(String sql, ArrayList<BigDecimal> alist) throws ClassNotFoundException, SQLException;

    /*
     * 系统函数
     */
    public Connection connErp() throws ClassNotFoundException, SQLException;  //连接

    public ResultSet checkUserLogin(String userName, String passWord) throws ClassNotFoundException, SQLException; //验证登陆

    public ResultSet getMoctaMaterial(String Material) throws ClassNotFoundException, SQLException;   //获得可用工单领料品号，返回结果集

    /*
     * 1、随机生成randomID,以randomID，品号，需求数、等插入tmpDB
     * 2、调用Procedure，传入randomID，获取品号，需求数，生成领料单，并返回结果集 单别+单号
     *
     *
     create table tmpDB(
     USERNAME CHAR(20),
     DEPARTMENT CHAR(10),
     GDate char(10),
     randomID int,
     PH	char(20),
     VALUE decimal(20,4) )
     *
     *
     */
//    //读取由generateTempDB生成的xml档,tmpDB.xml  生成领料单，传入参数为品名，需求数量，返回生成的 单别-单号 如果失败返回NONE-NONE
//    public ArrayList<String> generateMocte()  throws ClassNotFoundException, SQLException;
//    //以hashmap传入，生成xml文档 超领标志，材料品号，需求数量，工单别，工单号，仓库
//    public boolean generateTempDB(HashMap<String, BigDecimal> T)  throws ClassNotFoundException, SQLException;
    //获取指定品号的材料成本，人工成本，制造费用，委外加工成本
    public HashMap getInvmbCost(String ph) throws ClassNotFoundException, SQLException;
}
