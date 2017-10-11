package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String SELECT_GEMIDDELDE_VERKOOPPRIJS =
        "select avg(verkoopprijs) as gemiddelde from planten";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                statement.executeQuery(SELECT_GEMIDDELDE_VERKOOPPRIJS)){
            if(resultSet.next()){
                System.out.println(resultSet.getBigDecimal("gemiddelde"));
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }    
}
