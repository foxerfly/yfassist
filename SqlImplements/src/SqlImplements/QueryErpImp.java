/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlImplements;

import HibernateCFG.HibernateCFG;
import SqlInterface.QueryErp;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author John
 */
@ServiceProvider(
        service = QueryErp.class)
//        path = "SqlImp",
//        position = 10,
//        supersedes = {"com.edwin.sql.DefaultSqlImp"})
public class QueryErpImp implements QueryErp {

    private Connection conn = null;

    private static final String forname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static final String c_url = "jdbc:sqlserver://192.168.1.4:1433;databasename=mytest";
    private static final String c_name = "sa";
    private static final String c_password = "fanski=123";

    private static final String h_url = "jdbc:sqlserver://127.0.0.1:1433;databasename=fanski";
    private static final String h_name = "sa";
    private static final String h_password = "86916503";

    @Override
    public Connection connErp() {

        DriverManager.setLoginTimeout(5);
        HibernateCFG CFG = Lookup.getDefault().lookup(HibernateCFG.class);
//        long time = System.currentTimeMillis();
        try {
            Class.forName(forname);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(QueryErpImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage().trim(), "警告", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection(c_url, c_name, c_password);
            CFG.SetconfigurationCFG("Chibernate.cfg.xml");

        } catch (SQLException ex) {
            try {
                //            Logger.getLogger(QueryErpImp.class.getName()).log(Level.SEVERE, null, ex);
                conn = DriverManager.getConnection(h_url, h_name, h_password);
                CFG.SetconfigurationCFG("hibernate.cfg.xml");
            } catch (SQLException ex1) {
                //                Logger.getLogger(QueryErpImp.class.getName()).log(Level.SEVERE, null, ex1);
                JOptionPane.showMessageDialog(null, ex1.getMessage().trim(), "警告", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }

//        System.out.println(CFG.getconfigurationCFG());
        MyJdbc.setConn(conn);
        return conn;
    }

    @Override
    public ResultSet checkUserLogin(String userName, String passWord) throws ClassNotFoundException, SQLException {

        connErp();

        boolean status = false;
//        String sql = "select RTRIM(MA001),RTRIM(UDF01) from DSCSYS..DSCMA WHERE MA001=? AND UDF01=?";
        String sql = "select RTRIM(MA001) MA001,ISNULL(RTRIM(MV002),'未知') MV002,ISNULL(RTRIM(MV004),'未知') MV004,ISNULL(RTRIM(ME002),'未知') ME002,RTRIM(DSCSYS..DSCMA.UDF01) UDF01 from \n "
                + "DSCSYS..DSCMA LEFT JOIN fanski..CMSMV ON MV001=MA001 LEFT JOIN CMSME ON ME001=MV004 WHERE MA001=? AND DSCSYS..DSCMA.UDF01=?\n";

        ResultSet rs = null;
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        pstmt.setString(1, userName);
        pstmt.setString(2, passWord);
        rs = pstmt.executeQuery();

//        if (rs.next()) {
//            status = true;
//        } else {
//            status = false;
//        }
//
//        return status;
        return rs;
    }

    //获得可用工单领料品号，返回结果集  品号，品名，规格，快捷码，
    @Override
    public ResultSet getMoctaMaterial(String Material) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        String sql = "SELECT DISTINCT RTRIM(MB001) MB001,MB002,MB003,RTRIM(MB110) MB110\n"
                + "FROM MOCTB \n"
                + "LEFT JOIN MOCTA ON TA001=TB001 AND TA002=TB002 \n"
                + "LEFT JOIN INVMB ON MB001=TB003\n"
                + "WHERE TA011 IN ('2','3') AND (MOCTA.TA006 LIKE ? OR MOCTA.UDF03 LIKE ? )\n"
                + "AND MOCTA.TA001+MOCTA.TA002  IN(SELECT TC004+TC005 FROM SFCTC WHERE TC004=MOCTA.TA001 AND TC005=MOCTA.TA002) ";

        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        pstmt.setString(1, "%" + Material + "%");
        pstmt.setString(2, "%" + Material + "%");
        rs = pstmt.executeQuery();

        return rs;

    }

    //一个参数预查询
    @Override
    public ResultSet rsErp(String sql, String param) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        pstmt.setString(1, param);
        rs = pstmt.executeQuery();

        return rs;

    }

    @Override
    public ResultSet rsErpProc(String procedure, int param) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement cstmt = null;
//		String sqls = "{CALL procPurchaseSelect(?,?,?)}";
        cstmt = conn.prepareCall(procedure, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        cstmt.setInt(1, param);
        rs = cstmt.executeQuery();
        return rs;

    }

    //insert tmpDB
    @Override
    public boolean InsertErp(String sql, ArrayList list) throws ClassNotFoundException, SQLException {

        int listLength = 1;
        boolean state = false;

        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        for (Object c : list) {
            pstmt.setObject(listLength, c);
            listLength++;
        }

//        System.out.println(sql);
//        System.out.println(list.iterator().next().toString());
        int i = pstmt.executeUpdate();
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ResultSet rsErpProc(String procedure) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement cstmt = null;
//		String sqls = "{CALL procPurchaseSelect(?,?,?)}";
        cstmt = conn.prepareCall(procedure, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = cstmt.executeQuery();
        return rs;
    }

    @Override
    public boolean updateErp(String sql) throws ClassNotFoundException, SQLException {

        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        int i = pstmt.executeUpdate();
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ResultSet rsErp(String sql) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement cstmt = null;
        cstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = cstmt.executeQuery();
        return rs;
    }

    @Override
    public HashMap getInvmbCost(String ph) throws ClassNotFoundException, SQLException {
        HashMap hm = null;
        String materialPrice = "materialPrice";  //材料费用
        String laborePrice = "laborePrice";  //人工费用
        String madePrice = "madePrice";  //制造费用
        String cooperationPrice = "cooperationPrice";  //委外加工费用
        ResultSet rs = null;
        String sql = "SELECT TOP 1 materialPrice,laborePrice,madePrice,cooperationPrice FROM CWCOST WHERE MB001=? ORDER BY lastmodidate DESC";
        rs = rsErp(sql, ph);
        if (rs.next()) {
            hm.put(materialPrice, rs.getBigDecimal("materialPrice"));
            hm.put(laborePrice, rs.getBigDecimal("laborePrice"));
            hm.put(madePrice, rs.getBigDecimal("madePrice"));
            hm.put(cooperationPrice, rs.getBigDecimal("cooperationPrice"));
        }
        return hm;
    }

    @Override
    public ResultSet rsErp(String sql, ArrayList<String> list) throws ClassNotFoundException, SQLException {

        if (!list.isEmpty()) {
            int i = 1;
            ResultSet rs = null;
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            for (String s : list) {
                pstmt.setString(i, s);
                i++;
            }
            rs = pstmt.executeQuery();
            return rs;
        }
        return null;
    }

    @Override
    public ResultSet rsErpProc(String procedure, ArrayList<String> list) throws ClassNotFoundException, SQLException {
        if (!list.isEmpty()) {
            ResultSet rs = null;
            PreparedStatement cstmt = null;
//		String sqls = "{CALL procPurchaseSelect(?,?,?)}";
            cstmt = conn.prepareCall(procedure, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            int i = 1;
            for (String s : list) {
                cstmt.setString(i, s);
                i++;
            }
            rs = cstmt.executeQuery();
            return rs;
        }
        return null;
    }

    @Override
    public ResultSet rsErp(String sql, String param1, String param2) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        pstmt.setString(1, param1);
        pstmt.setString(2, param2);
        rs = pstmt.executeQuery();

        return rs;
    }

    @Override
    public Boolean rsErpProc(String procedure, String param) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement cstmt = null;
//		String sqls = "{CALL procPurchaseSelect(?,?,?)}";
        cstmt = conn.prepareCall(procedure, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        cstmt.setString(1, param);
        rs = cstmt.executeQuery();  //要把proc里的set nocount on  这样才会有返回结果集 否则会返回计数，那么就会提示该语句无结果集了
        if (rs.next()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean updateErp(String sql, ArrayList<BigDecimal> list) throws ClassNotFoundException, SQLException {

        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        int z = 1;
        for (BigDecimal s : list) {
            pstmt.setBigDecimal(z, s);
            z++;
        }

        int i = pstmt.executeUpdate();
        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Boolean rsErpProcList(String procedure, ArrayList list) throws ClassNotFoundException, SQLException {
        if (!list.isEmpty()) {

//            System.out.println(list);
            PreparedStatement cstmt = null;
//		String sqls = "{CALL procPurchaseSelect(?,?,?)}";
            cstmt = conn.prepareCall(procedure, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            int i = 1;
            for (Object s : list) {
                cstmt.setObject(i, s);
                i++;
            }
            cstmt.execute();
            return true;
        }
        return false;

    }

    @Override
    public Boolean rsErpProcS(String procedure, ArrayList<String> list) throws ClassNotFoundException, SQLException {

        if (!list.isEmpty()) {
            ResultSet rs = null;
            CallableStatement cstmt = null;
//		String sqls = "{CALL procPurchaseSelect(?,?,?)}";
            cstmt = conn.prepareCall(procedure);
//            
//            cstmt.registerOutParameter(1, java.sql.Types.CHAR);
//            cstmt.registerOutParameter(2, java.sql.Types.CHAR);
//            cstmt.registerOutParameter(3, java.sql.Types.CHAR);
//            cstmt.registerOutParameter(4, java.sql.Types.CHAR);
//            cstmt.registerOutParameter(5, java.sql.Types.CHAR);
//            
            int i = 1;
            for (String s : list) {
//                System.out.println(s);
                cstmt.setString(i, s);
                i++;
            }
//            i--;
//            
            rs = cstmt.executeQuery();

//            for(;i>0;i--)
//                System.out.println(cstmt.getString(i));
//
//            rs.last();
//            int length = rs.getRow();
//            rs.beforeFirst();
//            for (int z = 0; z < length; z++) {
//                System.out.println(rs.getString(0));
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getString(3));
//                System.out.println(rs.getString(4));
        }
        return true;

    }

}
