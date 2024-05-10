package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/quanlythuvien";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "26092002";
public static Connection getConnection(){
    try {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return conn;
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
public static void closeConnect(Connection conn){
    try {
        if(conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
