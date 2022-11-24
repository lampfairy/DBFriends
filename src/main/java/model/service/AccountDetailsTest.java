package model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.AccountDetails;
import model.User;
import model.dao.AccountDetailsDAO;
import model.dao.UserDAO;

public class AccountDetailsTest {
	    private static AccountDetailsDAO dao = new AccountDetailsDAO();
	    private static UserDAO dao_u = new UserDAO();
	    
	    public static void main(String[] args) throws SQLException {
	    
	        Scanner scanner = new Scanner(System.in);
	      
	        System.out.println("create AccountDetails");  
	        
	        
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
	        System.out.print("input bankName : ");
	        String bankName = scanner.next();
	        System.out.print("input nameOnAccount : ");
	        String nameOnAccount = scanner.next();
	        System.out.print("input useraccountNumberId : ");
	        String accountNumber = scanner.next();


	        AccountDetails accountDatails = new AccountDetails(userId, bankName, nameOnAccount, accountNumber);
	        System.out.println(accountDatails.toString());
	        int num = dao.create(accountDatails);
	        System.out.println(num);
	        System.out.println();
	        

	        System.out.println("update");
	        System.out.print("input userId : ");
	        userId = scanner.next();
	        try {
	            while(!dao_u.existingUser(userId)) {
	                System.out.println(userId + "  isn't exist");
	                System.out.print("update id : ");
	                userId = scanner.next();
	            }
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        System.out.print("input bankName : ");
	        bankName = scanner.next();
	        System.out.print("input nameOnAccount : ");
	        nameOnAccount = scanner.next();
	        System.out.print("input useraccountNumberId : ");
	        accountNumber = scanner.next();

	        
	        accountDatails = new AccountDetails(userId, bankName, nameOnAccount, accountNumber);
	        num = dao.update(accountDatails);
	        
	        System.out.println(num);
	        
	        List<AccountDetails> list = dao.findAccountDetailsList();  
	        
	       System.out.println("--------------------AccountDetails 목록--------------------");
	        if(list != null) {
	            for(int i = 0; i < list.size(); i++) {
	            	AccountDetails c = list.get(i);
	                String id = c.getUserId();
	                String bn = c.getBankName();
	                String noa = c.getNameOnAccount();
	                String an = c.getAccountNumber();
	                System.out.printf("%s 's account detail: %s %s %s \n", id, bn, noa, an);
	            }
	        }
	        
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
	        
	        num = dao.remove(userId);
	        System.out.println(num);
	        
	        list = dao.findAccountDetailsList();  
	        
	        System.out.println("--------------------AccountDetails 목록--------------------");
	        if(list != null) {
	            for(int i = 0; i < list.size(); i++) {
	            	AccountDetails c = list.get(i);
	                String id = c.getUserId();
	                String bn = c.getBankName();
	                String noa = c.getNameOnAccount();
	                String an = c.getAccountNumber();
	                System.out.printf("%s 's account detail: %s %s %s \n", id, bn, noa, an);
	            }
	        }
	        
	        System.out.println("findUserfindAccountDetailsList");
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
	        
	        accountDatails = dao.findAccountDetails(userId);
	        System.out.println("-----------------" + userId + " 's account Datails-----------------");
	        String id = accountDatails.getUserId();
            String bn = accountDatails.getBankName();
            String noa = accountDatails.getNameOnAccount();
            String an = accountDatails.getAccountNumber();
            System.out.printf("%s 's account detail: %s %s %s \n", id, bn, noa, an);
	    }
}
