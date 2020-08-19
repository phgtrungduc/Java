/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.module.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duc.pt173030
 */
public class KetNoi2 {

    private Connection conn = null;
    public KetNoi2()

    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=productDB;user=duc;password=duc123456");
            System.out.println("Đã kết nối");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error when you connect to database!Error is: " + e.getMessage());
        }
        String sql = "SELECT * FROM Product";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String name = rs.getString("name");
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new KetNoi2();
    }
}
