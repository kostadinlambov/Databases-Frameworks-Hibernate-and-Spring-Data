import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class p04_AddMinions {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    //Replace with your user name
    private static final String USERNAME = "root";
    //Replace with your password
    private static final String PASSWORD = "Attfsp201080";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionTokens = reader.readLine().split("\\s+");

        String minionName = minionTokens[1];
        Integer age = Integer.parseInt(minionTokens[2]);
        String townName = minionTokens[3];

        String[] villainsTOkens = reader.readLine().split("\\s+");
        String villainName = villainsTOkens[0];


        String selectTownQuery = "SELECT * FROM towns WHERE name = ?";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ?";
        String selectMinionQuery = "SELECT * FROM minions WHERE name = ?";



        String insertTownQuery = "INSERT INTO towns(name) VALUE (?)";
        String insertVillainQuery = "INSERT INTO villains(name, evilness_factor) VALUE (?, 'evil')";

        String insertMinionQuery = "INSERT INTO minions(name, age, town_id) VALUE (?,?,?)";
        String insertMapTableQuery = "INSERT INTO minions_villains(minion_id, villain_id) VALUE (?,?)";

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // Statement statement = connection.createStatement();

           ) {
            PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();


            if(!townResult.next()){
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1, townName);
                insertTownStatement.executeUpdate();
                System.out.printf("Town %s was added to the database.\n", townName);
                insertTownStatement.close();
            }

            int townId = 0;
            ResultSet townResultUpdated = townStatement.executeQuery();

            if(townResultUpdated.next()){
                 townId = townResultUpdated.getInt("town_id");
            }

            townStatement.close();

            //###############################

            PreparedStatement selectVillainStatement= connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1, villainName);

            ResultSet villainResult = selectVillainStatement.executeQuery();

            if(!villainResult.next()){
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                System.out.printf("Villain %s was added to the database.\n", villainName);
                insertVillainStatement.close();
            }

            int villainId = 0;
            ResultSet villainResultUpdated = selectVillainStatement.executeQuery();

            if(villainResultUpdated.next()){
                villainId = villainResultUpdated.getInt("villain_id");
            }

            selectVillainStatement.close();

            //###############################

            PreparedStatement insertMinionStatement= connection.prepareStatement(insertMinionQuery);
            insertMinionStatement.setString(1, minionName);
            insertMinionStatement.setInt(2, age);
            insertMinionStatement.setInt(3, townId);
            insertMinionStatement.executeUpdate();

            insertMinionStatement.close();

            //###############################

            PreparedStatement selectMinionStatement= connection.prepareStatement(selectMinionQuery);
            selectMinionStatement.setString(1, minionName);

            ResultSet minionResult = selectMinionStatement.executeQuery();
            int minionId = 0;
            if(minionResult.next()){
                 minionId = minionResult.getInt("minion_id");
            }

            selectMinionStatement.close();

            //###############################

            PreparedStatement insertMaptableStatement = connection.prepareStatement(insertMapTableQuery);
            insertMaptableStatement.setInt(1, minionId);
            insertMaptableStatement.setInt(2, villainId);
            insertMaptableStatement.executeUpdate();

            System.out.printf("Successfully added %s to be minion of %s", minionName,  villainName);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}


