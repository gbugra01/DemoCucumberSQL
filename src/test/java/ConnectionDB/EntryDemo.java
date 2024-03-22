package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EntryDemo {
    public static void main(String[] args) throws SQLException,ClassNotFoundException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc://mysql://localhost:3306/db", "user", "password");
            Statement statement = connection.createStatement();
            if (connection != null) {
                System.out.println("hhhhh");
            }
            //ekleme icin parametre kullanımı
            // preparedStatement.setString(1,"webelement");
            // preparedStatement.setInt(2,3232);
            //islemi gerceklestirmek icin
            //preparedStatement.executeUpdate();
            //sonra kapatmak icin
            //preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

}

