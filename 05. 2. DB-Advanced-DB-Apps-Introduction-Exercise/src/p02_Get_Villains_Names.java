import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class p02_Get_Villains_Names {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    //Replace with your user name
    private static final String USERNAME = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        String selectVillainsQuery = " SELECT v.villain_id, v.name, COUNT(*) AS count_villains FROM  villains AS v\n" +
                " INNER JOIN minions_villains AS mv\n" +
                " USING (villain_id)\n" +
                " GROUP BY v.villain_id\n" +
                " HAVING count_villains  > 3\n" +
                " ORDER BY count_villains DESC;";

        String useQuery = "USE minions_db;";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()){

            statement.executeQuery(useQuery);

            PreparedStatement getVillainsStatement = connection.prepareStatement(selectVillainsQuery);
            ResultSet resultSet = getVillainsStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                int count = resultSet.getInt("count_villains");

                System.out.println(name + " " + count);
            }
            getVillainsStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
