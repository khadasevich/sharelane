package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    public Connection connect;
    public Statement statement;

    public void connect() {
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/aqa15?"
                            + "user=root&password=admin&useSSL=true&serverTimezone=GMT");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }
}
