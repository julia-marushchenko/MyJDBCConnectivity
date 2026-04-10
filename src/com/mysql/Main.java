/**
 *  Java program to demonstrate java JDBC connectivity.
 */

package com.mysql;

import java.sql.*;

/**
 *  Main class.
 */
public class Main {

    // JVM entry point.
    public static void main(String[] args) throws SQLException {

        // Getting users wit name Jack.
        demoMethod();

    }

    // Method to connect to SQL server.
    public static void demoMethod(String input) throws SQLException {
        String sql = "SELECT * FROM users";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db",
                "root", "toor");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Printing the results.
        while (resultSet.next()) {
            System.out.println(resultSet.getString("user_name"));
        }

        // Closing resources.
        resultSet.close();
        statement.close();
        connection.close();

        // Output:  Jack
                    Bernard
                    Jack
                    Kate

    }
}
