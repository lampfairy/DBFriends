package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Product;
import model.dao.ProductDAO;

public class ProdManager {
	private static ProdManager prodMan = new ProdManager();
	private ProductDAO prodDAO;
	
	private ProdManager() {
		try {
			prodDAO = new ProductDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProdManager getInstance() {
		return prodMan;
	}
	
	public int create(Product product) throws SQLException, ExistingException {
		if(prodDAO.existingProduct(product.getProductId()) == true) {
			throw new ExistingException(product.getProductId() + "exists");
		}
		return prodDAO.create(product);
	}
	
	public int update(Product product) throws SQLException {
		return prodDAO.update(product);
	}
	
	public int remove(int productId) throws SQLException {
        return prodDAO.remove(productId);
    }

    public Product findProduct(int productId) throws SQLException, ExistingException {
        Product prod = prodDAO.findProduct(productId);
        
        if (prod == null) {
            throw new ExistingException(productId + "doesn't exist");
        }       
        return prod;
    }

    public List<Product> findProductList() throws SQLException {
            return prodDAO.findProductList();
    }
    
    public List<Product> findProductList(int type1, int type2, int type3) throws SQLException {
        return prodDAO.findProductList(type1, type2, type3);
    }
    
    public List<Product> findProductListWithKey(int type1, int type2, int type3, String keySearch) throws SQLException {
    	  return prodDAO.findProductListWithKey(type1, type2, type3, keySearch);
    }
    
    public int countingProduct(int type2) throws SQLException {
    	return prodDAO.countingProduct(type2);
    }
    
    public ProductDAO getProdDAO() {
		return this.prodDAO;
	}
    
    public List<Product> findNewProdList() throws SQLException {
        return prodDAO.findNewProdList();
    }
}
