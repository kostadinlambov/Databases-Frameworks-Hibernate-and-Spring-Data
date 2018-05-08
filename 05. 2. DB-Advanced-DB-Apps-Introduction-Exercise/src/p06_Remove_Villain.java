import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class p06_Remove_Villain {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    //Replace with your user name
    private static final String USERNAME = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer villainId = Integer.parseInt(reader.readLine());

        String deleteFromMapTable = "DELETE FROM minions_villains WHERE  villain_id = ?";
        String deleteFromVillain = "DELETE FROM villains WHERE  villain_id = ?";
        String selectVillain = "SELECT * FROM villains WHERE  villain_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillain);
            selectVillainStatement.setInt(1, villainId);
            ResultSet villainResultSet = selectVillainStatement.executeQuery();

            if(villainResultSet.next()){
                String villainName = villainResultSet.getString("name");
                PreparedStatement deleteFromMapStatement = connection.prepareStatement(deleteFromMapTable);
                deleteFromMapStatement.setInt(1, villainId);
                int minionsCount = deleteFromMapStatement.executeUpdate();
                deleteFromMapStatement.close();

                PreparedStatement deleteFromVillainStatement = connection.prepareStatement(deleteFromVillain);
                deleteFromVillainStatement.setInt(1, villainId);
                deleteFromVillainStatement.executeUpdate();
                deleteFromVillainStatement.close();

                System.out.printf("%s was deleted\n", villainName);
                System.out.printf("%d minions released\n", minionsCount);
            }else{
                System.out.println("No such villain was found\n");
            }

            selectVillainStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
