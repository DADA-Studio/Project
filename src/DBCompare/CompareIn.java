package DBCompare;

import java.sql.*;

public class CompareIn {
    public CompareIn(){}

    public boolean doCompare(String User, String PW) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String username = "sa";
            String password = "844701730";
            String url = "jdbc:sqlserver://localhost;DatabaseName=DADAstudio";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "select* FROM Table_users1 WHERE username='" + User + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (conn == null) {
                return false;
            }

            rs.next();
            String yan=rs.getString("password");
            yan=yan.trim();
            if (PW.equals(yan)) {
                return true;
            }


            rs.close();
            stmt.close();
            conn.close();
            return false;


            //完成后记得关闭数据库连接   

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
