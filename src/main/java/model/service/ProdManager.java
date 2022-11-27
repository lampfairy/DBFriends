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
	
	public int create(Product product) throws SQLException, ExistingProdException {
		if(prodDAO.existingProduct(product.getProductId()) == true) {
			throw new ExistingProdException(product.getProductId() + "exists");
		}
		return prodDAO.create(product);
	}
	
	public int update(Product product) throws SQLException {
		return prodDAO.update(product);
	}
	
	public int remove(int productId) throws SQLException {
        return prodDAO.remove(productId);
    }

    public Product findProduct(int productId)
        throws SQLException, ProdNotFoundException {
        Product prod = prodDAO.findProduct(productId);
        
        if (prod == null) {
            throw new ProdNotFoundException(productId + "doesn't exist");
        }       
        return prod;
    }

    public List<Product> findProductList() throws SQLException {
            return prodDAO.findProductList();
    }
    
    public ProductDAO getProdDAO() {
		return this.prodDAO;
	}
}