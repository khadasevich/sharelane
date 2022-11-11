package dbconnection;

import constants.SQLQueries;
import models.StudentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDemo {

    public static void main(String[] args) {
        ExecuteSqlQueries executeSqlQueries = new ExecuteSqlQueries();
        ResultSet results = executeSqlQueries.selectFrom("user_email");

    }
}
