import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class p05_Change_Town_Names_Casing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    //Replace with your user name
    private static final String USERNAME = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String countryName = reader.readLine();

        String selectTownsQuery = " SELECT  t.name AS  town_name " +
                "FROM towns AS t\n" +
                " WHERE t.country = ?;";

        String townsQuery = " UPDATE towns AS t\n" +
                " SET t.name = UPPER(name)\n" +
                " WHERE t.country = ?;";

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement townsUpdateStatement = connection.prepareStatement(townsQuery);
            townsUpdateStatement.setString(1, countryName);
            int  updatedTownsCount = townsUpdateStatement.executeUpdate();
            townsUpdateStatement.close();

            if(updatedTownsCount > 0){
                System.out.printf("%d town names were affected.\n", updatedTownsCount);

                PreparedStatement selectTownsStatement = connection.prepareStatement(selectTownsQuery);
                selectTownsStatement.setString(1, countryName);
                ResultSet townsResults = selectTownsStatement.executeQuery();

                List<String> townsList = new ArrayList<>();
                while (townsResults.next()){
                    String townName = townsResults.getString("town_name");
                    townsList.add(townName);
                }

                selectTownsStatement.close();
                System.out.println(townsList.toString());
            }else{
                System.out.println("No town names were affected.\n");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
