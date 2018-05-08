import java.sql.*;

public class p01_Initial_Setup {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    //Replace with your user name
    private static final String USERNAME = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) throws SQLException {
        String createQuery = "CREATE DATABASE minions_db;";
        String useQuery = "USE minions_db;";


        String createMinionTableQuery = "CREATE TABLE minions (\n" +
                "minion_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "name VARCHAR(50),\n" +
                "age INT,\n" +
                "town_id INT, " +
                "CONSTRAINT fk_town_minions FOREIGN KEY (town_id)" +
                "REFERENCES towns(town_id)" +
                ");";

        String createTownTableQuery = "CREATE TABLE towns (\n" +
                "town_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "name VARCHAR(50),\n" +
                "country VARCHAR(50)" +
                ");";

        String createVillainsTableQuery = "CREATE TABLE villains (\n" +
                "villain_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "name VARCHAR(50),\n" +
                "evilness_factor VARCHAR(20)" +
                ");";

        String mapTable = "CREATE TABLE minions_villains (\n" +
                "minion_id INT,\n" +
                "villain_id INT,\n" +
                "PRIMARY KEY (minion_id, villain_id),\n" +
                "FOREIGN KEY (minion_id) REFERENCES minions(minion_id),\n" +
                "FOREIGN KEY (villain_id) REFERENCES villains(villain_id)\n" +
                ");";

        String insertVillains = "INSERT INTO villains(name, evilness_factor) " +
                "VALUES ('Grue', 'good'), ('Ivo', 'bad'),('John', 'evil')," +
                "('John', 'bad'),('Norse', 'super evil');";

        String insertTowns = "INSERT INTO towns(name, country) " +
                "VALUES ('London', 'UK'), ('Sofia', 'Bulgaria'),('New York', 'USA')," +
                "('Paris', 'France'),('Rim', 'Italy'), ('Varna', 'Bulgaria'), ('Plovdiv', 'Bulgaria');";

        String insertMinions = "INSERT INTO minions(name, age, town_id) " +
                "VALUES ('Rob', 5, 1), ('Sturd', 4, 3),('Bob', 7, 5)," +
                "('Mat', 2, 4),('Buffy', 1, 2);";

        String insertMaps = "INSERT INTO minions_villains(minion_id, villain_id) " +
                "VALUES (1, 3), (2, 4),(5,1)," +
                "(3, 4),(4,2),(1,4),(4,4),(5,5),(4,5),(1, 1), (1, 2)" +
                ",(2, 1), (2, 2),(2, 3), (2, 5);";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownTableQuery);
            statement.executeUpdate(createMinionTableQuery);
            statement.executeUpdate(createVillainsTableQuery);
            statement.executeUpdate(mapTable);

            statement.executeUpdate(insertVillains);
            statement.executeUpdate(insertTowns);
            statement.executeUpdate(insertMinions);
            statement.executeUpdate(insertMaps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
