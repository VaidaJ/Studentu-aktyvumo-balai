/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentuBalai;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Vaidos
 */
public class DB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         getConnection();
    }
    
    public static Connection getConnection(){
        try {
            Properties pr = new Properties();
            InputStream input = new FileInputStream("config.properties");
            pr.load(input);
            
            Class.forName("com.mysql.jdbc.Driver");
            String DB_URL = "jdbc:mysql://localhost/" + pr.getProperty("databaseName");
            String USER = pr.getProperty("login");
            String PASS = pr.getProperty("pass");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;                 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }         
    }
}
