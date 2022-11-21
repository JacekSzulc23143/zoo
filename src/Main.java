import java.sql.*;

public class Main {


    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();
        boolean connected = dbConnector.connect();
        if (connected) {
            Animal dog = new Animal(4, "dog", "Szarik");
            dog.save(dbConnector);
        } else {
            System.out.println("Nie udało się połączyć z bazą danych");
        }
    }
}