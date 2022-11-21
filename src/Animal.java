public class Animal {
    Integer id;
    String species;
    String name;

    public Animal(Integer id, String species, String name) {
        this.id = id;
        this.species = species;
        this.name = name;
    }

    public void save(DBConnector dbConnector) {
        String sql = "insert into animal values (";
        sql += this.id + ",";
        sql += "'" + this.species + "',";
        sql += "'" + this.name + "')";
        dbConnector.execute(sql);
        System.out.println("Zapisałem zwierze " + this.name);
    }

    public void count(DBConnector dbConnector) {
        Integer numberOfRows = dbConnector.countRows("animal");
        System.out.println("W tabeli animal jest " + numberOfRows + "wierszy");
    }

    public void deleteAll(DBConnector dbConnector) {
        dbConnector.execute("delete from animal");
        System.out.println("Usunąłem wszystkie zwierzęta");
    }


}
