import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class MainTest {
    @Test
    public void testDatabaseConnection(){

        String mysqlurl = "jdbc:mysql://localhost:3306/smart?createDatabaseIfNotExist=true";
        String username = "root";
        String password = "password";
        try(Connection connection = DriverManager.getConnection(mysqlurl, username,password)){
            assertNotNull(connection);
        }catch (SQLException exception){
            exception.printStackTrace();
            System.err.println("Error: " + exception);
        }
    }
}
