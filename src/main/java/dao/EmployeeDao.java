package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;


public class EmployeeDao {
	
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, employee.getFirstName());
	            preparedStatement.setString(3, employee.getLastName());
	            preparedStatement.setString(4, employee.getUsername());
	            preparedStatement.setString(5, employee.getPassword());
	            preparedStatement.setString(6, employee.getAddress());
	            preparedStatement.setString(7, employee.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public int loginEmployee(Employee employee) throws ClassNotFoundException {
		 String sql = "SELECT Id FROM employee"
		 				+ " WHERE 1=1"
		 				+ " AND username = ?"
		 				+ " AND password = ? ";
		 
	     Class.forName("com.mysql.jdbc.Driver");

	     try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		            preparedStatement.setString(1, employee.getUsername());
		            preparedStatement.setString(2, employee.getPassword());
		            

		            
		            // Step 3: Execute the query or update query
		            ResultSet set = preparedStatement.executeQuery();
		            if(set.next()) {
		            	if (set.getInt(1) > 0) {
		            		return set.getInt(1);
		            	} else {
		            		return 0;
		            	}
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return 0;
		        }
		
		 return 0;
	 }

}
