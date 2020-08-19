/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author duc.pt173030
 */
public class Connect {
    public Connect(){
		
	}
        // có thể gộp vào
        // nhưng thôi để nguyên đi hoặc tự viết 1 file mới đi nguyên tắc truy cập đơn giản vậy thôi
	public static Connection getConnect(){
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customer;user=sa;password=duc123456");
			System.out.println("Đã kết nối");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error when you connect to database!Error is: "+e.getMessage());
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(getConnect());
	}
	
        //hàm lấy dữ liệu từ database qua đối tượng st
	public ResultSet selectData(String sql) throws Exception{
		Connection connect =getConnect(); // cái này là hàm kết nối
		Statement stmt =  connect.createStatement();// tạo ra đối tượng truy xuất vào database
		ResultSet rs=	stmt.executeQuery(sql);//truy cập vào database
		return rs;
	}
}
