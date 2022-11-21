import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();
        boolean connected = dbConnector.connect();
        if (connected) {
            Scanner scanner = new Scanner(System.in);
            int id = 1;

            System.out.println("Wybierz: ");
            System.out.println("1. dodawanie zwierząt do bazy danych");
            System.out.println("2. liczenie zwierząt w bazie danych");
            System.out.println("3. usuwanie zwierząt z bazy danych");
            System.out.println("0. wyjdź z programu");

            String select = scanner.nextLine();

            if(Objects.equals(select, "1")) {
                System.out.println("Podaj gatunek: ");
                String species = scanner.nextLine();

                System.out.println("Podaj imię: ");
                String name = scanner.nextLine();

                Animal animal = new Animal(id, species, name);
                animal.save(dbConnector);
                id++;
                System.out.println("Pomyślnie dodano zwierzę");
            } else if(Objects.equals(select, "2")) {
                Animal.count(dbConnector);
            } else if(Objects.equals(select, "3")) {
                Animal.deleteAll(dbConnector);
            } else if(Objects.equals(select, "0")) {
                System.out.println("close");
            }
        } else {
            System.out.println("Nie udało się połączyć z bazą danych");
        }
    }
}