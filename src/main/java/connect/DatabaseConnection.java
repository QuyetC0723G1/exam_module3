package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static String URL = "jdbc:mysql://localhost:3306/exam_module3";
    static String USERNAME = "root";
    static String PASSWORD = "quyetthu";
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
