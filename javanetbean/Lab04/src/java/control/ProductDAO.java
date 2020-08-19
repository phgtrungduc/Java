/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.KetNoi.getConnect;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duc.pt173030
 */
public class ProductDAO {

    private int numberOfRecords;

    public List<Product> viewAllProducts(int offset, int numberOfRecords) throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "select  * from Product" ;
        try {
            KetNoi conn = new KetNoi(); // cái này là hàm kết nối
//            Statement st = connect.createStatement();// tạo ra đối tượng truy xuất vào database
            ResultSet rs = conn.selectData(sql);//truy cập vào database
            while (rs.next()) {
                Product pr = new Product();
                pr.setProductID(rs.getInt("product_id"));
                pr.setName(rs.getString("name"));
                pr.setQuantity(rs.getInt("quantity"));
                pr.setPrice(rs.getInt("price"));
                pr.setCategory_id(rs.getInt("category_id"));
                list.add(pr);
            }
            rs.close();
            Connection connect = getConnect();
            Statement st = connect.createStatement();
            rs = st.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                this.numberOfRecords = rs.getInt(1);
            }
            int i=0;
            System.out.println("Đến đấy");
            while(list.isEmpty()==false){
                System.out.println(list.get(i).getName());
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

}
