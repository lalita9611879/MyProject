package restaurant;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createdatafororders {
	
	private static final String createTableSQLforOrders = "create table orders (\r\n" + "  id  int primary key,\r\n" +
	        "  Name varchar(20),\r\n" +"Date  date,\r\n"+ "EmailID varchar(20),\r\n" + "ContactNumber bigint,\r\n" +
			"Food varchar(20),\r\n "+"Soups varchar(22),\r\n"+"Breakfast varchar(20),\r\n"+"Lunch varchar(20),\r\n"+
	        "Dishes varchar(20),\r\n" +"Icecreams varchar(20),\r\n "+"FreshJuices varchar(20),\r\n "+"OrderFor varchar(12),\r\n"+
			"Address varchar(30),\r\n"+"Branch varchar(20),\r\n)";

	    public static void main(String[] argv) throws SQLException {
	        createdatafororders createTableExample = new createdatafororders();
	        createTableExample.createTable();
	    }

	    public void createTable() throws SQLException {

	        System.out.println(createTableSQLforOrders);
	        // Step 1: Establishing a Connection
	        try (Connection connection = H2JDBCUtils.getConnection();
	            // Step 2:Create a statement using connection object
	            Statement statement = connection.createStatement();) {

	            // Step 3: Execute the query or update query
	            statement.execute(createTableSQLforOrders);

	        } catch (SQLException e) {
	            // print SQL exception information
	            H2JDBCUtils.printSQLException(e);
	        }
	    }
	
