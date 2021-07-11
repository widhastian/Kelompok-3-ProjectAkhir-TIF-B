/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Connectionz {
    
static Connection con;
   
    public static Connection GetConnection(){
        try{
   
    Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop3_ilnaa","root","");
    }catch(Exception ex){
        System.out.println(""+ex);
    }
        return con;
    }

    
}
