package dbconnection;

import constants.SQLQueries;
import models.StudentModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteSqlQueries extends DBConnector {

    public ResultSet selectFrom(String tableName) {
        connect();
        try {
            return statement
                    .executeQuery(String.format(SQLQueries.SELECT_FROM, tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close();
        return null;
    }

    public void addStudentViaExecute(String name) {
        connect();
        try {
            statement
                    .execute(String.format(SQLQueries.ADD_STUDENT, name, 2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close();
    }

    public ResultSet selectByQuery(String query) {
        connect();
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close();
        return null;
    }

    public StudentModel getStudent(ResultSet resultSet) throws SQLException {
        StudentModel studentModel = StudentModel.builder().build();
        while (resultSet.next()) {
            studentModel.setId(resultSet.getString("id"));
            studentModel.setName(resultSet.getString("name"));
            studentModel.setGroupId(resultSet.getString("group_id"));
        }
        return studentModel;
    }

    public void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String groupId = resultSet.getString("group_id");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("GROUP ID: " + groupId);
        }
    }

    public void addUser() throws SQLException {
        connect();
        PreparedStatement preparedStatement = connect
                .prepareStatement("INSERT INTO aqa15.students values (default, ?, ?)");
        preparedStatement.setString(1, "Dmitry");
        preparedStatement.setInt(2, 2);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
