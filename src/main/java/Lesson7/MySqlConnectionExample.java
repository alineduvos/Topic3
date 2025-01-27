package Lesson7;

import java.sql.*;

public class MySqlConnectionExample {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "batman";
    private static final String password = "77er";

    public static void main(String[] args)  {

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, username, password);

            if(connection!=null){
                System.out.println("Successfully connected to Mysql!");
            }

            

        }catch (SQLException e){
            System.out.println("There was a problem : "+e.getMessage());
        }finally {
            // close the connection
           try{
               if(connection!=null){
                   connection.close();
               }
           }catch (SQLException e){
               System.out.println("Error closing connection : "+e.getMessage());
           }
        }


    }

}
