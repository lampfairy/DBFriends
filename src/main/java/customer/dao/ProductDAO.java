package customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class ProductDAO {
    private JDBCUtil jdbcUtil = null;
    
    public ProductDAO() {          
        jdbcUtil = new JDBCUtil();
    }
    
    //怨좉컼 �벑濡�
    public int create(Product Product) throws SQLException {
        String sql = "INSERT INTO Product (productId, location, price, description, "
                    + "status, image, name, type) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";     
        Object[] param = new Object[] {Product.getProductId(), Product.getLocation(), Product.getPrice(), Product.getDescription(),
                Product.getStatus(), Product.getImage(), Product.getName(), Product.getType()};              
        jdbcUtil.setSqlAndParameters(sql, param);
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close(); 
        }       
        return 0;           
    }

    //怨좉컼 �닔�젙
    public int update(Product Product) throws SQLException {
        String sql = "UPDATE Product "
                    + "SET location=?, price=?, description=?, image=?, name=?, type=? "
                    + "WHERE productId=?";
        Object[] param = new Object[] {Product.getLocation(), Product.getPrice(), Product.getDescription(),
                 Product.getImage(), Product.getName(), Product.getType(), Product.getProductId()};                
        jdbcUtil.setSqlAndParameters(sql, param);   
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }       
        return 0;
    }

   //�쉶�썝 �궘�젣
    public int remove(int productId) throws SQLException {
        String sql = "DELETE FROM Product WHERE productId=?";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {productId});   

        try {               
            int result = jdbcUtil.executeUpdate(); 
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close(); 
        }       
        return 0;
    }

   //�쉶�썝 �젙蹂� 蹂닿린
    public Product findProduct(int productId) throws SQLException {
        String sql = "SELECT location, price, description, status, image, name, type "
                    + "FROM Product "
                    + "WHERE productId=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {productId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                Product Product = new Product(
                    productId,
                    rs.getString("location"),
                    rs.getInt("price"),
                    rs.getString("description"),
                    rs.getInt("status"),
                    rs.getString("image"),
                    rs.getString("name"),
                    rs.getInt("type"));
                return Product;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }

    //�쉶�썝�젙蹂� 由ъ뒪�듃蹂닿린
    public List<Product> findProductList() throws SQLException {
        String sql = "SELECT productId, location, price, description, status, image, name, type "
                    + "FROM Product "
                    + "ORDER BY productId";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<Product> ProductList = new ArrayList<Product>();   
            while (rs.next()) {
                Product Product = new Product(
                        rs.getInt("productId"),
                        rs.getString("location"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("status"),
                        rs.getString("image"),
                        rs.getString("name"),
                        rs.getInt("type"));
                ProductList.add(Product);   
            }       
            return ProductList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }

  //아이디 중복 확인
    public boolean existingProduct(int productId) throws SQLException {
        String sql = "SELECT count(*) FROM Product WHERE productId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {productId});  
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();     
        }
        return false;
    }
}