package restaurant;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class createdataforbooking {
	
	    private static final String createTableSQLforBooking = "create table Booking (\r\n" + " id  int ,\r\n" +
	        "  Name varchar(20),\r\n" +"Date  date,\r\n"+ "EmailID varchar(20),\r\n" +"ContactNumber bigint,\r\n"+
	    		"NoofPeople int,\r\n" +
	        "Branch varchar(10)\r\n)";

	    public static void main(String[] argv) throws SQLException {
	        createdataforbooking createTableExample = new createdataforbooking();
	        createTableExample.createTable();
	    }

	    public void createTable() throws SQLException {

	        System.out.println(createTableSQLforBooking);
	        // Step 1: Establishing a Connection
	        try (Connection connection = H2JDBCUtils.getConnection();
	            // Step 2:Create a statement using connection object
	            Statement statement = connection.createStatement();) {

	            // Step 3: Execute the query or update query
	            statement.execute(createTableSQLforBooking);

	        } catch (SQLException e) {
	            // print SQL exception information
	            H2JDBCUtils.printSQLException(e);
	        }
	    }
	}
