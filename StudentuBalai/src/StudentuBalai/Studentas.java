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
public class Studentas {
    static DB db;
    private int nr;
    private String vardas;
    private String pavarde;
    private String grupe;

    public Studentas(int nr, String vardas, String pavarde, String grupe) {
        this.nr = nr;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.grupe = grupe;
    }

    public int getNr() {
        return nr;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getGrupe() {
        return grupe;
    }
    
    public static ArrayList<Studentas> studentasList(){
        ArrayList<Studentas> studentasList = new ArrayList<Studentas>();
        try{
        Connection connection = db.getConnection();
            Statement stmt = (Statement) connection.createStatement();
            String sql = "SELECT * FROM studentas";
            ResultSet rs = stmt.executeQuery(sql);   
            while( rs.next()){
                Studentas studentas = new Studentas(rs.getInt("studento_nr"), rs.getString("vardas"), rs.getString("pavarde"), rs.getString("grupe"));
                studentasList.add(studentas);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentasList;
    }
    
    public static void insertStudentas(int nr, String vardas, String pavarde, String grupe){
        try {
            Connection conn = db.getConnection();
            String SQL = "INSERT INTO studentas VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, nr);
            stmt.setString(2, vardas);
            stmt.setString(3, pavarde);
            stmt.setString(4, grupe);
            stmt.executeUpdate(); 
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
