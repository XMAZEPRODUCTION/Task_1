package jm.task.core.jdbc.util;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    private static Connection connection;
    public static Connection getJDBCConnection (){
            try {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return connection;
    }


}
