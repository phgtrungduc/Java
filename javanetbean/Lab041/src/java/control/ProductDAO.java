/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "select top "+offset+"(*) from Product where (product_id)>;
        try {
            int count =0;
            KetNoi conn = new KetNoi();
            ResultSet rs = conn.selectData(sql);//truy cập vào database
            while (rs.next()) {
                count ++;
                Product pr = new Product();
                pr.setProductID(rs.getInt("product_id"));
                pr.setName(rs.getString("name"));
                pr.setQuantity(rs.getInt("quantity"));
                pr.setPrice(rs.getInt("price"));
                pr.setCategory_id(rs.getInt("category_id"));
                list.add(pr);
            }
            rs.close();
            this.numberOfRecords = count;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }
}
