package rrr;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

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
//        System.out.print("birthDate : ");
//        String birthDate = scanner.next();
        try {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = formatter.parse(birthDate);
        
        Customer cust = new Customer(name, userId, userPw, phoneNumber, email);
        cust.toString();
//        int num = dao.create(cust);
//        System.out.println(num);
        
        
        List<Customer> list = dao.findCustomerList();  
        
       System.out.println("-------------------------------------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Customer c = list.get(i);
                String n = c.getName();
                System.out.printf("%s \n", n);
            }
        }
        System.out.println();
        
//        System.out.print("새 관리자 사번과 관리자 보직수당을 입력하시오: ");
//        int managerNo  = scanner.nextInt();
//        double commission = scanner.nextDouble();
//        
//        dao.replaceManagerOfDept(dept.getDeptNo(), managerNo, commission); 
//        
//        Employee manager = dao.findEmpInfo(managerNo);   
//        
//        // manager 객체의 필드 값 출력 ...
//        System.out.println(manager);
        
        
        } catch(Exception e) {
            System.out.println("오류");
        } finally {
            scanner.close();
        }
    }
    
}
