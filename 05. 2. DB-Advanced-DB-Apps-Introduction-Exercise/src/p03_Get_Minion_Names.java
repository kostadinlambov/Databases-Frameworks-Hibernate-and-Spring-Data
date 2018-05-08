import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class p03_Get_Minion_Names {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    //Replace with your user name
    private static final String USERNAME = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int minionId = Integer.parseInt(reader.readLine());

        String minionNamesQuery = " SELECT v.villain_id,  v.name AS villain_name, " +
                "m.name AS minion_name, m.age AS minion_age FROM villains AS v\n" +
                " INNER JOIN minions_villains AS mv\n" +
                " USING (villain_id)\n" +
                " INNER JOIN minions AS m\n" +
                " USING (minion_id)\n" +
                " WHERE v.villain_id = ?;";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement minionsStatement = connection.prepareStatement(minionNamesQuery);
            minionsStatement.setInt(1, minionId);
            ResultSet resultSet = minionsStatement.executeQuery();

            Map<String, Integer> minionsMap = new LinkedHashMap<>();
            String villainName = null;

            while (resultSet.next()) {
                villainName = resultSet.getString("villain_name");
                String minionName = resultSet.getString("minion_name");
                int minionAge = resultSet.getInt("minion_age");
                minionsMap.putIfAbsent(minionName, minionAge);
            }

            final int[] count = {1};
            if(villainName != null){
                System.out.println("Villain: " + villainName);

                minionsMap.entrySet().stream().forEach(minion -> {
                    System.out.printf("%d. %s %d%n", count[0], minion.getKey(), minion.getValue());
                    count[0]++;
                });

            }else{
                System.out.printf("No villain with ID %d exists in the database.", minionId);
            }

            minionsStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
