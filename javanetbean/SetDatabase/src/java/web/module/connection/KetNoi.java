package web.module.connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoi {
	public KetNoi(){
		
	}
        // có thể gộp vào
        // nhưng thôi để nguyên đi hoặc tự viết 1 file mới đi nguyên tắc truy cập đơn giản vậy thôi
	public static Connection getConnect(){
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=productDB;user=duc;password=duc123456");
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