package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    public Connection connect;
    public Statement statement;

    public void connect() {
        String connection = "mysql://root:root@md-mysql:3306/agis2md_test";
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://366884cdce3b:3306/agis2md_test?"
                            + "user=stage_aventusgroup_ro&password=q12wQ!@Wq12w");
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
