package model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class Test {

    private static CustomerDAO dao = new CustomerDAO();
    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("id : ");
        String userId = scanner.next();
        System.out.print("name : ");
        String name = scanner.next();
        System.out.print("userPw : ");
        String userPw = scanner.next();
        System.out.print("phoneNumber : ");
        String phoneNumber = scanner.next();
        System.out.print("email : ");
        String email = scanner.next();
        System.out.print("birthDate : ");
        String birthDate = scanner.next();
        try {
        Date date = transformDate(birthDate);
        
        Customer cust = new Customer(name, userId, userPw, phoneNumber, email, date);
        System.out.println(cust.toString());
        int num = dao.create(cust);
        System.out.println(num);
        
        
        List<Customer> list = dao.findCustomerList();  
        System.out.println("create예제");
       System.out.println("-------------------------------------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Customer c = list.get(i);
                String n = c.getUserId();
                System.out.printf("%s \n", n);
            }
        }
        System.out.println();
        
        System.out.print("id : ");
        userId = scanner.next();
        System.out.print("name : ");
        name = scanner.next();
        System.out.print("userPw : ");
        userPw = scanner.next();
        System.out.print("phoneNumber : ");
        phoneNumber = scanner.next();
        System.out.print("email : ");
        email = scanner.next();
        System.out.print("birthDate : ");
        birthDate = scanner.next();
        date = transformDate(birthDate);
        
        cust = new Customer(name, userId, userPw, phoneNumber, email, date);
        num = dao.update(cust);
        
        System.out.println(num);
        
        System.out.println("update예제");
        list = dao.findCustomerList();  
        
       System.out.println("-------------------------------------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Customer c = list.get(i);
                String n = c.getName();
                System.out.printf("%s \n", n);
            }
        }
        
        System.out.print("id : ");
        userId = scanner.next();
        num = dao.remove(userId);
        
        System.out.println(num);
        
        
        list = dao.findCustomerList();  
        System.out.println("remove예제");
       System.out.println("-------------------------------------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Customer c = list.get(i);
                String n = c.getUserId();
                System.out.printf("%s \n", n);
            }
        }
        System.out.println("findCustomer예제");
        System.out.print("id : ");
        userId = scanner.next();
        cust = dao.findCustomer(userId);
        System.out.println(cust.toString());
        
        System.out.println("existingCustomer예제");
        System.out.print("id : ");
        userId = scanner.next();
        Boolean n = dao.existingCustomer(userId);
        System.out.println(n);
        
        
        } catch(Exception e) {
            System.out.println("오류");
        } finally {
            scanner.close();
        }
    }
    
    public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        
        // Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // 현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
        String transDate = afterFormat.format(tempDate);
        
        // 반환된 String 값을 Date로 변경한다.
        Date d = Date.valueOf(transDate);
        
        return d;
    }
}

