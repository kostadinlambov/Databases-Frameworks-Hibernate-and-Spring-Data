import sun.security.util.Password;

import java.sql.*;

public class JDBC_Intro {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo_db?createDatabaseIfNotExist=true&allowMultiQueries=true";
    //Replace with your user name
    private static final String USER = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        System.out.println("Connection established successfully");

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection established successfully");


            try (Statement stmt = connection.createStatement()) {
                String query = "CREATE TABLE IF NOT EXISTS users (" +
                        "id int AUTO_INCREMENT PRIMARY KEY," +
                        "username varchar(20)," +
                        "password varchar(20));";
                stmt.executeUpdate(query);
            }

//            try(Statement stmt = connection.createStatement()){
//                String query = "INSERT INTO users (username, password)" +
//                        "VALUES ('Ivan', '123'), ('Gosho', 'abc')";
//                stmt.executeUpdate(query);
//            }


            if (loginGood(connection, "Ivan", "123")) {
                System.out.println("Ivan logged in successfully!");
            }

            if (loginGood(connection, "Gosho", "123")) {
                System.out.println("Gosho logged in successfully!");
            }

            if (loginGood(connection, "' or 1=1 #", "whatever")) {
                System.out.println("Hacker logged in successfully!");
            }

            if (loginGood(connection, "'; INSERT INTO users(username, password) VALUES('hacker','') #", "whatever")) {
                System.out.println("Hacker NOT logged in");
            }

            if (loginGood(connection, "hacker", "")) {
                System.out.println("Hacker 2 logged in successfully!");
            }
        }
    }

    private static boolean loginGood(Connection conn, String user, String password) throws SQLException {
        String query = "SELECT  COUNT(id) " +
                "FROM users " +
                "WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int usersCount = rs.getInt(1);
            return usersCount > 0;
        }
    }

    private static boolean login(Connection conn, String user, String password) throws SQLException {
        String query = "SELECT  COUNT(id) " +
                "FROM users " +
                "WHERE username='" + user + "' AND password='" + password + "'";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int usersCount = rs.getInt(1);
            return usersCount > 0;
        }
    }


}
