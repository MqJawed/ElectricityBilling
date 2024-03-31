package electricitybillingsystem;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/electricity";
            c = DriverManager.getConnection(url,"root","123");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
