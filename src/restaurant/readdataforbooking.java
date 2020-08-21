package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class readdataforbooking {
	
	private static final String QUERY = "select id,Name,Date, EmailID,ContactNumber,NoofPeople,Branch from Booking where id =?";

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
                int NoofPeople = rs.getInt("NoofPeople");
                String Branch = rs.getString("Branch");
                
                System.out.println(id + "," + name + "," + Date + "," + EmailID + "," + ContactNumber+","+NoofPeople+","+Branch);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
	
	
	
	

}
