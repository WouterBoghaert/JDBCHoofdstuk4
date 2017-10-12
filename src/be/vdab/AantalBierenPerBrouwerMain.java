package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AantalBierenPerBrouwerMain {
    private static final String URL = "jdbc:mysql://localhost/bieren?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String AANTAL_BIEREN_PER_BROUWER = 
            "select brouwers.naam, count(*) as aantal " +
            "from bieren inner join brouwers on bieren.brouwerid = brouwers.id " +
            "group by brouwers.id, brouwers.naam " +
            "order by brouwers.naam";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(AANTAL_BIEREN_PER_BROUWER)){
            while (resultSet.next()){
                System.out.println(resultSet.getString("naam") + " " +
                        resultSet.getInt("aantal"));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }        
    }
    
}
