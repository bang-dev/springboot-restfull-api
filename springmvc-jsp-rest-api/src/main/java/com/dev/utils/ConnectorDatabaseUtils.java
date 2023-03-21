package com.dev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDatabaseUtils {
    private static String uriConnect;
    private static String userConnect;
    private static String passConnect;
    private static Connection connection;

    static {
        uriConnect = "jdbc:mysql://localhost:3306/db_dev_blog_personal"; // Uniform Resource Identifier
        userConnect = "root";
        passConnect = "abc123";
    }


    public static String getUriConnect() {
        return uriConnect;
    }

    public static void setUriConnect(String uriConnect) {
        ConnectorDatabaseUtils.uriConnect = uriConnect;
    }

    public static String getUserConnect() {
        return userConnect;
    }

    public static void setUserConnect(String userConnect) {
        ConnectorDatabaseUtils.userConnect = userConnect;
    }

    public static String getPassConnect() {
        return passConnect;
    }

    public static void setPassConnect(String passConnect) {
        ConnectorDatabaseUtils.passConnect = passConnect;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectorDatabaseUtils.connection = connection;
    }

    public static Connection openConnectionDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(uriConnect, userConnect, passConnect);
        } catch (ClassNotFoundException | SQLException exc) {
            exc.printStackTrace();
        }
        return connection;
    }

    public static void disConnection() throws SQLException{
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
