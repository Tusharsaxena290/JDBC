package connection;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatabaseHelper {
    public ResultSet getEmployeeDetails(Connection connection) {
        ResultSet resultSet = null;
        String selectAllEmployee="SELECT * FROM EMPLOYEE";
        try{
            Statement statement=connection.createStatement();
            resultSet=statement.executeQuery(selectAllEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}