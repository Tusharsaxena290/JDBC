package connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Execution {
    public static void main(String[] args) {
        EmployeeDatabaseConnection employeeDatabaseConnection=new EmployeeDatabaseConnection();
        if (EmployeeDatabaseConnection.attemptConnection()==true){
            System.out.println("Connection Established");
        }
        else{
            System.out.println("not connected");
        }

        EmployeeDatabaseHelper employeeDatabaseHelper=new EmployeeDatabaseHelper();
        ResultSet AllEmpSet=employeeDatabaseHelper.getEmployeeDetails(employeeDatabaseConnection.getConnection());
        while(true){
            try{
                if(!AllEmpSet.next()){
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                System.out.println("Employee Data: "+AllEmpSet.getString("empId")+AllEmpSet.getString("empName")+AllEmpSet.getString("empSalery"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
