package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String SELECT_ALLE_LEVERANCIERS = 
        "select naam, aantalkinderen from leveranciers order by naam";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALLE_LEVERANCIERS)){
            while(resultSet.next()){
                System.out.print(resultSet.getString("naam") + " ");
                int aantalKinderen = resultSet.getInt("aantalkinderen");
                System.out.println(resultSet.wasNull()?"onbekend":aantalKinderen);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
