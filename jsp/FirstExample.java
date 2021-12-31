import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class FirstExample {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static final String USER = "system";
   static final String PASS = "0814";
   static final String QUERY = "SELECT fname FROM Employees";

   public static void main(String[] args) throws ClassNotFoundException {
      // Open a connection
      Class.forName("oracle.jdbc.driver.OracleDriver");
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}