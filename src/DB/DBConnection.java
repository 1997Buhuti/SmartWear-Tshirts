/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpman
 */
public class DBConnection {
    
    private Connection con = null;
    private static DBConnection dbocnnection;
    private DBConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartwear","root","");
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        
        if(dbocnnection==null){
            dbocnnection= new DBConnection();        
        }
        
        return dbocnnection;
    }
    
    public Connection getConnection(){
        
        return con;
    }
    
}
