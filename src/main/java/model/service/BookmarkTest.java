package model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.Bookmark;
import model.Product;
import model.User;
import model.dao.BookmarkDAO;
import model.dao.ProductDAO;
import model.dao.UserDAO;

public class BookmarkTest {
	    private static BookmarkDAO dao = new BookmarkDAO();
	    private static ProductDAO dao_p = new ProductDAO();
	    private static UserDAO dao_u = new UserDAO();
	    
	    public static void main(String[] args) throws SQLException {
	    
	        Scanner scanner = new Scanner(System.in);
	      
	        System.out.println("create bookmark");  
	        
	        
	        List<User> list_u = dao_u.findUserList();

	        System.out.println("-----------a list of users available for login-----------");
	        if(list_u != null) {
	            for(int i = 0; i < list_u.size(); i++) {
	            	User c = list_u.get(i);
	                String n = c.getUserId();
	                System.out.printf("%s \t", n);
	                if(i != 0 && i % 5 == 0)
	                    System.out.println();
	            }
	        }
	        System.out.println();
	        
	        List<Product> list_p = dao_p.findProductList();

	        System.out.println("-----------a list of products available for bookmark-----------");
	        if(list_p != null) {
	            for(int i = 0; i < list_p.size(); i++) {
	            	Product c = list_p.get(i);
	                int n = c.getProductId();
	                System.out.printf("%d \t", n);
	                if(i != 0 && i % 10 == 0)
	                    System.out.println();
	            }
	        }
	        System.out.println();
	        System.out.println();

	        System.out.print("input userId : ");
	        String userId = scanner.next();

	        try {
	        	while(!dao_u.existingUser(userId)) {
	        		System.out.println(userId + " isn't exist");
	        		System.out.print("input userId : ");
	        		userId = scanner.next();
	        	}
	        } catch (SQLException e1) {
	        	// TODO Auto-generated catch block
	        	e1.printStackTrace();
	        } 

	        System.out.print("input productId : ");
	        int productId = scanner.nextInt();
	        try {
	        	while(!dao_p.existingProduct(productId)) {
	        		System.out.println(productId + " isn't exist");
	        		System.out.print("input productId : ");
	        		productId = scanner.nextInt();
	        	}
	        	while(dao.existingBookmark(userId, productId)) {
	        		System.out.println(productId + " alraedy exist");
	        		System.out.print("input productId : ");
	        		productId = scanner.nextInt();
	        	}
	        } catch (SQLException e1) {
	        	// TODO Auto-generated catch block
	        	e1.printStackTrace();
	        } 

	        try {
	        	Bookmark b = new Bookmark(userId, productId);
	        	System.out.println(b.toString());
	            int num = dao.create(b);
	            System.out.println(num);
	            
	            List<Bookmark> list = dao.findUserBookmarkList(userId);  
	            
	            System.out.println("--------------------" + userId + " 's Bookmark List--------------------");
	            if(list != null) {
	                for(int i = 0; i < list.size(); i++) {
	                	Bookmark rb = list.get(i);
	                    int n = rb.getProductId();
	                    System.out.printf("%d \n", n);
	             }
	        }
	        System.out.println();
	        
	        System.out.println("remove");
	        System.out.print("input userId : ");
	        userId = scanner.next();
	        
	        try {
	        	while(!dao_u.existingUser(userId)) {
	        		System.out.println(userId + " isn't exist");
	        		System.out.print("input userId : ");
	    	        userId = scanner.next();
	        	}
	        } catch (SQLException e1) {
	        	// TODO Auto-generated catch block
	        	e1.printStackTrace();
	        } 
	        
	        System.out.print("input productId for remove: ");
    		productId = scanner.nextInt();
	        try {
	        	while(!dao_p.existingProduct(productId)) {
	        		System.out.println(productId + " isn't exist");
	        		System.out.print("input productId : ");
	        		productId = scanner.nextInt();
	        	}
	        } catch (SQLException e1) {
	        	// TODO Auto-generated catch block
	        	e1.printStackTrace();
	        } 
	        
	        num = dao.remove(userId, productId);
	        
	        System.out.println(num);
	        
	        list = dao.findBookmarkList();  
	        
	        System.out.println("-----------------All Bookmark List-----------------");
	        if(list != null) {
	            for(int i = 0; i < list.size(); i++) {
	                Bookmark rv = list.get(i);
	                String s = rv.getUserId();
	                int n = rv.getProductId();
	                System.out.printf("%s 's Bookmark List : %d \n", s, n);
	            }
	        }
	        System.out.println("findUserBookmark");
	        System.out.print("input userId : ");
	        userId = scanner.next();
	        try {
	        	while(!dao_u.existingUser(userId)) {
	        		System.out.println(userId + " isn't exist");
	        		System.out.print("input userId : ");
	    	        userId = scanner.next();
	        	}
	        } catch (SQLException e1) {
	        	// TODO Auto-generated catch block
	        	e1.printStackTrace();
	        } 
	        list = dao.findUserBookmarkList(userId);
	        System.out.println("-----------------" + userId + " 's Bookmark List-----------------");
	        if(list != null) {
	            for(int i = 0; i < list.size(); i++) {
	                Bookmark rv = list.get(i);
	                int n = rv.getProductId();
	                System.out.printf("%s 's Bookmark List : \n", userId);
	                System.out.printf("%d \n",n);
	            }
	        }
	        } catch(Exception e) {
	            System.out.println("error");
	        } finally {
	            scanner.close();
	        }
	    }
}
