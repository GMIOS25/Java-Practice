package Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	private static String url = "jdbc:mysql://localhost:3306/ontap";
    private static String username = "root";
    private static String password = "25082005";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully.");
            return conn;    
        } catch (Exception e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            return conn;
        }
    }


}
