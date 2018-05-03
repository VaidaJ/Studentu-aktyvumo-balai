/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentuBalai;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vaidos
 */
public class Grupe {
    static DB db;
    private String kodas;
    private String studiju_programa;
    private int metai;

    public Grupe(String kodas, String studiju_programa, int metai) {
        this.kodas = kodas;
        this.studiju_programa = studiju_programa;
        this.metai = metai;
    }

    public String getKodas() {
        return kodas;
    }

    public String getStudiju_programa() {
        return studiju_programa;
    }

    public int getMetai() {
        return metai;
    }
    
    public static ArrayList<Grupe> grupeList(){
        ArrayList<Grupe> grupeList = new ArrayList<Grupe>();
        try{
        Connection connection = db.getConnection();
            Statement stmt = (Statement) connection.createStatement();
            String sql = "SELECT * FROM grupe";
            ResultSet rs = stmt.executeQuery(sql);   
            while( rs.next()){
                Grupe grupe = new Grupe(rs.getString("kodas"), rs.getString("studiju_programa"), rs.getInt("stojimo_metai"));
                grupeList.add(grupe);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return grupeList;
    }  
    
    public static void insertGrupe(String grupes_kodas, String studiju_programa, int metai){
        try {
            Connection conn = db.getConnection();
            String SQL = "INSERT INTO grupe VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1, grupes_kodas);
            stmt.setString(2, studiju_programa);
            stmt.setInt(3, metai);
            stmt.executeUpdate(); 
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }
}
