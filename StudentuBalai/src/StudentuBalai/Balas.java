/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentuBalai;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vaidos
 */
public class Balas {
    static DB db;
    private int id;
    private Date data;
    private int balai;
    private String paaiskinimas;
    private int studentas;

    public Balas(int id, Date data, int balai, String paaiskinimas, int studentas) {
        this.id = id;
        this.data = data;
        this.balai = balai;
        this.paaiskinimas = paaiskinimas;
        this.studentas = studentas;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public int getBalai() {
        return balai;
    }

    public String getPaaiskinimas() {
        return paaiskinimas;
    }

    public int getStudentas() {
        return studentas;
    }

    public static ArrayList<Balas> balasList(){
        ArrayList<Balas> balasList = new ArrayList<Balas>();
        try{
        Connection connection = db.getConnection();
            Statement stmt = (Statement) connection.createStatement();
            String sql = "SELECT * FROM balas";
            ResultSet rs = stmt.executeQuery(sql);   
            while( rs.next()){
                Balas balas = new Balas(rs.getInt("balo_id"), rs.getDate("irasymo_data"), rs.getInt("balai"), rs.getString("paaiskinimas"), rs.getInt("studentas"));
                balasList.add(balas);
            }    
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception ex) {
                        ex.printStackTrace();
        }
        return balasList;
    }       
 
    public static void insertBalas(String data, int balai, String paaiskinimas, int studentas){
        try {
            Connection conn = db.getConnection();
            String SQL = "INSERT INTO balas(irasymo_data, balai, paaiskinimas, studentas) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.getGeneratedKeys();
            stmt.setString(1, data);
            stmt.setInt(2, balai);
            stmt.setString(3, paaiskinimas);
            stmt.setInt(4, studentas);
            stmt.executeUpdate(); 
            ResultSet rs = stmt.getGeneratedKeys();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }
    
    public static void updateBalas(String data, int balas, String paaiskinimas, int studentas, int ID){
        try{
            Connection conn = db.getConnection();
            String sql = "UPDATE balas SET irasymo_data = ?, balai = ?, paaiskinimas = ?, studentas = ? WHERE balo_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setInt(2, balas);
            stmt.setString(3, paaiskinimas);
            stmt.setInt(4, studentas);
            stmt.setInt(5, ID);
            stmt.executeUpdate(); 
            stmt.close();
            conn.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    public static void deleteBalas(int ID){
        try{
            Connection conn = db.getConnection();
            String sql = "DELETE FROM balas WHERE balo_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID);
            stmt.executeUpdate();
            stmt.close();
            conn.close();  
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    
}
