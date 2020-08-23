package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertdataforEorders {
	
	private static final String INSERT_ORDERS_SQL = "INSERT INTO orders" +
	        "  (id, name,date,EmailID,ContactNumber,Food,Soups,Breakfast,Lunch,Dishes,Icecreams,FreshJuices,OrderFor,Address,Branch"
	        + ") VALUES " +
	        " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	    public static void main(String[] argv) throws SQLException {
	        insertdataforEorders createTableExample = new insertdataforEorders();
	        createTableExample.insertRecord();
	    }

	    public void insertRecord() throws SQLException {
	        System.out.println(INSERT_ORDERS_SQL);
	       
	        try (Connection connection = H2JDBCUtils.getConnection();
	           
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, "Lalita");
	            preparedStatement.setString(3, "2020-8-22");
	            preparedStatement.setString(4, "drlalita96@gmail.com");
	            preparedStatement.setInt(5, 987654321);
	            preparedStatement.setString(6, "Vegetarian");
	            preparedStatement.setString(7, "VegetableManchowSoup");
	            preparedStatement.setString(8, "CholeBhatura");
	            preparedStatement.setString(9, "TawaPulao");
	            preparedStatement.setString(10, "PaneerMakhani");
	            preparedStatement.setString(11, "Cassata");
	            preparedStatement.setString(12, "StrawberryJuice");
	            preparedStatement.setString(13, "Delivery");
	            preparedStatement.setString(14, "Periyarnagar,chennai-82");
	            preparedStatement.setString(15, "Mylapore");
	            
	            
	            
	            

	            System.out.println(preparedStatement);
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {

	            
	            H2JDBCUtils.printSQLException(e);
	        }

	        // Step 4: try-with-resource statement will auto close the connection.
	    }
	
	

}
