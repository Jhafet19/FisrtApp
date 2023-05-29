package ms.edu.utez.firstapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    final String DBNAME = "pelisplus",
            USSER = "root",
            PASSWO0RD = "root",
            TIMEZONE = "America/Mexico_city",
            USSEL = "false",
            PUBLIKEY = "true",
            DDLAUTO = "true", HOST = "localhost";

    public Connection connect() {
        String dataSource = String.format("jdbc:mysql://%s:3306/%s?user=%s&password=%s&servletTimezone=%s&useSSl=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNotExist=%s"
                , HOST, DBNAME, USSER, PASSWO0RD, TIMEZONE, USSEL, PUBLIKEY, DDLAUTO);
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            Connection conn = new MySQLConnection().connect();
            if(conn != null){
                System.out.println("Conexión realizada");
                conn.close();
            }else{
                System.out.println("Conexión fallida");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
