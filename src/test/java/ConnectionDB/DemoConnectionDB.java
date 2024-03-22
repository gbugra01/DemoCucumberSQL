package ConnectionDB;

import java.sql.*;

public class DemoConnectionDB {
    public static final String Data_URL="jdbc:mysql://localhost/db";
    public static final String USER_DB="root";
    public static final String PASSWORD_DB="password";

    public static void  main(String[] args) throws SQLException {
        Connection connect = null;
        String sql="SELECT * FROM SiteProduct";
            try {
                connect = DriverManager.getConnection(Data_URL, USER_DB, PASSWORD_DB);
                Statement   statement= connect.createStatement();
                ResultSet data=statement.executeQuery(sql);
                if (connect !=null){
                    System.out.println("sdasdasdasd");
                }
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
                }
            }


