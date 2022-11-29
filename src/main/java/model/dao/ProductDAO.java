package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
//import util.JDBCUtil;

public class ProductDAO {
	private JDBCUtil jdbcUtil = null;

	public ProductDAO() {          
		jdbcUtil = new JDBCUtil();
	}

	//怨좉컼 �벑濡�
	public int create(Product Product) throws SQLException {
		String sql = "INSERT INTO Product (productId, location, price, description, "
				+ "status, image, name, type1, type2, type3) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";     
		Object[] param = new Object[] {Product.getProductId(), Product.getLocation(), Product.getPrice(), Product.getDescription(),
				Product.getStatus(), Product.getImage(), Product.getName(), Product.getType1(), Product.getType2(), Product.getType3()};              
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
				+ "SET location=?, price=?, description=?, image=?, name=?, type1=?,type2=?, type3=? "
				+ "WHERE productId=? ";
		Object[] param = new Object[] {Product.getLocation(), Product.getPrice(), Product.getDescription(),
				Product.getImage(), Product.getName(), Product.getType1(), Product.getType2(), Product.getType3(), Product.getProductId()};                
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
		String sql = "SELECT location, price, description, status, image, name, type1, type2, type3 "
				+ "FROM Product "
				+ "WHERE productId=?";              
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
						rs.getInt("type1"),
						rs.getInt("type2"),
						rs.getInt("type3"));
				return Product;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); 
		}
		return null;
	}

	public List<Product> findProductList() throws SQLException {
		String sql = "SELECT productId, location, price, description, status, image, name, type1, type2, type3 "
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
						rs.getInt("type1"),
						rs.getInt("type2"),
						rs.getInt("type3"));
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

	public List<Product> findProductList(int type1, int type2, int type3) throws SQLException {
		int[] type_1;
		int[] type_2;
		int[] type_3;

		if(type1 == 0)
			type_1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		else
			type_1 = new int[] {type1, type1, type1, type1, type1, type1, type1};
		if(type2 == 0)
			type_2 = new int[] {1, 2, 3, 4};
		else
			type_2 = new int[] {type2, type2, type2, type2};
		if(type3 == 0)
			type_3 = new int[] {1, 2, 3, 4};
		else
			type_3 = new int[] {type3, type3, type3, type3};

		String sql = "SELECT productId, location, price, description, status, image, name, type1, type2, type3 "
				+ "FROM Product "
				+ "WHERE type1=any(?, ?, ?, ?, ?, ?, ?) AND type2=any(?, ?, ?, ?) AND type3=any(?, ?, ?, ?) "
				+ "ORDER BY productId";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {type_1[0], type_1[1], type_1[2], type_1[3], type_1[4], type_1[5], type_1[6], type_2[0], type_2[1], type_2[2], type_2[3], type_3[0], type_3[1], type_3[2], type_3[3]});  

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
						rs.getInt("type1"),
						rs.getInt("type2"),
						rs.getInt("type3"));
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

	public List<Product> findProductListWithKey(int type1, int type2, int type3, String keySearch) throws SQLException {
		int[] type_1;
		int[] type_2;
		int[] type_3;

		if(type1 == 0)
			type_1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		else
			type_1 = new int[] {type1, type1, type1, type1, type1, type1, type1};
		if(type2 == 0)
			type_2 = new int[] {1, 2, 3, 4};
		else
			type_2 = new int[] {type2, type2, type2, type2};
		if(type3 == 0)
			type_3 = new int[] {1, 2, 3, 4};
		else
			type_3 = new int[] {type3, type3, type3, type3};
		
		String key = "%" + keySearch + "%";

		String sql = "SELECT productId, location, price, description, status, image, name, type1, type2, type3 "
				+ "FROM Product "
				+ "WHERE type1=any(?, ?, ?, ?, ?, ?, ?) AND type2=any(?, ?, ?, ?) AND type3=any(?, ?, ?, ?) AND name LIKE ?"
				+ "ORDER BY productId";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {type_1[0], type_1[1], type_1[2], type_1[3], type_1[4], type_1[5], type_1[6], type_2[0], type_2[1], type_2[2], type_2[3], type_3[0], type_3[1], type_3[2], type_3[3], key});  

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
						rs.getInt("type1"),
						rs.getInt("type2"),
						rs.getInt("type3"));
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

	public int countingProduct(int type2) throws SQLException {
		String sql = "SELECT count(*) FROM Product WHERE type2=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {type2});  
		int count = 0;
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();     
		}
		return count;
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