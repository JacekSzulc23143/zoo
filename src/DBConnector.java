import java.sql.*;

public class DBConnector {
    private static final String DATABASE_ADDRESS = "jdbc:postgresql://localhost:5432/zoo";
    private static final String USER = "Jacek";
    private static final String PASS = "Jacek77!@#$";
    private Connection connection;

    public boolean connect() {
        try {
            // Class.forName("org.postgresql.Driver"); //  niezbędne w starszych wersjach Javy
            connection = DriverManager.getConnection(DATABASE_ADDRESS, USER, PASS);
            System.out.println("Udało się połączyć z bazą");
            return true;
        } catch (Exception e) {
//            System.out.println("Problem z połączeniem");
            e.printStackTrace();
            return false;
        }
    }

    public void execute(String sql) {
        try {
            Statement statement = connection.createStatement(); // obiekt Statement -obsługa zapytań
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer countRows(String tableName) {
        try {
            String sql = "select count(*) from + tableName";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            results.next();
            return results.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
