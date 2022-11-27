package model.service;
///
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.Product;
import model.User;
import model.dao.ProductDAO;

import java.sql.Date;
import java.sql.SQLException;

public class ProductTest {

	private static ProductDAO dao = new ProductDAO();

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		List<Product> list = dao.findProductList();  

		
		System.out.println("--------------------Product id 목록--------------------");
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				Product p = list.get(i);
				int n = p.getProductId();
				String name = p.getName();
				System.out.printf("%d  %s \n", n, name);
			}
		}
		System.out.println("end");

		System.out.println("create product");  

		System.out.print("create productId : ");
		int productId = scanner.nextInt();

		try {
            while(dao.existingProduct(productId)) {
                System.out.println(productId + " can't be used ");
                System.out.print("create productId : ");
                productId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
        
        
        System.out.print("location : ");
        String location = scanner.next();
        System.out.print("price : ");
        int price = scanner.nextInt();
        System.out.print("description : ");
        String description = scanner.next();
        System.out.print("status : ");
        int status = scanner.nextInt();
        System.out.print("image : ");
        String image = scanner.next();
        System.out.print("name : ");
        String name = scanner.next();
        System.out.print("type : ");
        int type = scanner.nextInt();
        
        try {
        
        Product p = new Product(productId, location, price, description, status, image, name, type);
        System.out.println(p.toString());
        int num = dao.create(p);
        System.out.println(num);
        
        list = dao.findProductList();  
        
        System.out.println("--------------------Product id --------------------");
        System.out.println("1127추가 --> " + dao.countingProduct(type));
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Product c = list.get(i);
                int n = c.getProductId();
                System.out.printf("%d \n", n);
            }
        }
        System.out.println();
        
        System.out.println("update");
        System.out.print("update productId : ");
        productId = scanner.nextInt();
        try {
            while(!dao.existingProduct(productId)) {
                System.out.println(productId + " isn't found ");
                System.out.print("update productId : ");
                productId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        System.out.print("location : ");
        location = scanner.next();
        System.out.print("price : ");
        price = scanner.nextInt();
        System.out.print("description : ");
        description = scanner.next();
        System.out.print("status : ");
        status = scanner.nextInt();
        System.out.print("image : ");
        image = scanner.next();
        System.out.print("name : ");
        name = scanner.next();
        System.out.print("type : ");
        type = scanner.nextInt();
        
        
        p = new Product(productId, location, price, description, status, image, name, type);
        num = dao.update(p);
        
        System.out.println(num);
        
        list = dao.findProductList();  
        
       System.out.println("--------------------Product id--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Product c = list.get(i);
                int n = c.getProductId();
                System.out.printf("%d \n", n);
            }
        }
        
        System.out.println("remove");
        System.out.print("remove productId : ");
        productId = scanner.nextInt();
        try {
            while(!dao.existingProduct(productId)) {
                System.out.println(productId + " isn't found");
                System.out.print("remove productId : ");
                productId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        num = dao.remove(productId);
        
        System.out.println(num);
        
        list = dao.findProductList();  
        
        System.out.println("--------------------Product id--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Product c = list.get(i);
                int n = c.getProductId();
                System.out.printf("%d \n", n);
            }
        }
        System.out.println("findProduct");
        System.out.print("find productId : ");
        productId = scanner.nextInt();
        try {
            while(!dao.existingProduct(productId)) {
                System.out.println(productId + " isn't found ");
                System.out.print("find productId : ");
                productId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        p = dao.findProduct(productId);
        System.out.println(p.toString());
        
//        System.out.println("existingProduct");
//        System.out.print("id : ");
//        productId = scanner.next();
//        Boolean n = dao.existingProduct(productId);
//        System.out.println(n);
        
        
        } catch(Exception e) {
            System.out.println("");
        } finally {
            scanner.close();
        }
    }
    
   
}
