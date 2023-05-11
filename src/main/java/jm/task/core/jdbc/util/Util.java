package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String SCHEMA_URL = "jdbc:mysql://localhost:3306/projectdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Statement getSchemaStatement() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD).createStatement();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(SCHEMA_URL, USERNAME, PASSWORD);
    }
}
