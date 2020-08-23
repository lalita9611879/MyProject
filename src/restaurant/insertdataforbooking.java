package restaurant;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insertdataforbooking {
	
	private static final String INSERT_BOOKING_SQL = "INSERT INTO Booking" +
	        "  (id,Name,Date, EmailID,ContactNumber,NoofPeople,Branch ) VALUES " +
	        " (?, ?, ?, ?, ?,?,?)";

	    public static void main(String[] argv) throws SQLException {
	       insertdataforbooking createTableExample = new insertdataforbooking();
	        createTableExample.insertRecord();
	    }

	    public void insertRecord() throws SQLException {
	        System.out.println(INSERT_BOOKING_SQL);
	        // Step 1: Establishing a Connection
	        try (Connection connection = H2JDBCUtils.getConnection();
	            // Step 2:Create a statement using connection object
	        		
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
	            preparedStatement.setInt(1, 8);
	            preparedStatement.setString(2, "Lalita");
	            preparedStatement.setString(3,"2020-8-22");
	            preparedStatement.setString(4, "drlalita96@gmail.com");
	            preparedStatement.setInt(5, 987654321);
	               preparedStatement.setInt(6,10);
	            preparedStatement.setString(7,"Mylapore");
	           

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {

	            // print SQL exception information
	            H2JDBCUtils.printSQLException(e);
	        }

	        // Step 4: try-with-resource statement will auto close the connection.
	    }

		

}
