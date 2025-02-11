
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author I Komang Abimanyu/1402022066
 */
public class dbConnect {
    public static Connection con;
    public static Statement stm;
    public static PreparedStatement pst;
    public static ResultSet rs = null;
    
    public static void koneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas6_1402022066", "root", "");
            stm = con.createStatement();
        } catch(ClassNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }
    }
}
