package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class readdatafororders {
	
	private static final String QUERY = "select id, name,date,EmailID,ContactNumber,Food,Soups,Breakfast,Lunch,Dishes,Icecreams,FreshJuices,OrderFor,Address,Branch from orders where id =?";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 8);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String Date = rs.getString("Date");
                String EmailID = rs.getString("EmailID");
                int ContactNumber = rs.getInt("ContactNumber");
                String Food = rs.getString("Food");
                String Soups = rs.getString("Soups");
                String Breakfast = rs.getString("Breakfast");
                String Lunch = rs.getString("Lunch");
                String Dishes = rs.getString("Dishes");
                String Icecreams = rs.getString("Icecreams");
                String FreshJuices = rs.getString("FreshJuices");
                String OrderFor=rs.getString("OrderFor");
                String Address=rs.getString("Address");
                String Branch=rs.getString("Branch");
                		
                
                
                
                
                System.out.println(id + "," + name + "," + Date + "," + EmailID + "," + ContactNumber+","+Food+","+Soups+","+Breakfast+","+Lunch+","+Dishes+","+Icecreams+","+FreshJuices+","+OrderFor+","+Address+","+Branch);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
	
	
	
	
	

}
