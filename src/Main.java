import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String mysqlurl = "jdbc:mysql://localhost:3306/smart?createDatabaseIfNotExist=true";
        String username = "root";
        String password = "password";

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setSender("Delighted");
        transaction.setReceipient("Qudus");

        try(Connection connection = DriverManager.getConnection(mysqlurl, username,password)) {
            save(transaction,connection);

        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
    private static Transaction save(Transaction transaction,Connection connection){
        try {
            String sql = "INSERT into transactions (id, sender, recipient) VALUES (?,?,?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,transaction.getId());
            statement.setString(2,transaction.getSender());
            statement.setString(3, transaction.getReceipient());
            statement.execute();
            return transaction;
        }catch (SQLException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
