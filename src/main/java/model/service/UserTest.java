package model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.User;
import model.dao.UserDAO;

import java.sql.Date;
import java.sql.SQLException;

public class UserTest {

    private static UserDAO dao = new UserDAO();
    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        
      
        System.out.println("create예제");  
        System.out.print("create id : ");
        String userId = scanner.next();
        try {
            while(dao.existingUser(userId)) {
                System.out.println(userId + " 는 이미 존재하는 아이디 입니다");
                System.out.print("create id : ");
                userId = scanner.next();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
        
        User user = new User(name, userId, userPw, phoneNumber, email, date);
        System.out.println(user.toString());
        int num = dao.create(user);
        System.out.println(num);
        
        List<User> list = dao.findUserList();  
        
        System.out.println("--------------------User id 목록--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                User c = list.get(i);
                String n = c.getUserId();
                System.out.printf("%s \n", n);
            }
        }
        System.out.println();
        
        System.out.println("findUser예제");
        System.out.print("id : ");
        userId = scanner.next();
        try {
            while(!dao.existingUser(userId)) {
                System.out.println(userId + " 는 존재하지 않는 아이디 입니다");
                System.out.print("remove id : ");
                userId = scanner.next();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        user = dao.findUser(userId);
        System.out.println(user.toString());
        
        
        
        System.out.println("update예제");
        System.out.print("update id : ");
        userId = scanner.next();
        try {
            while(!dao.existingUser(userId)) {
                System.out.println(userId + " 는 존재하지 않는 아이디 입니다");
                System.out.print("update id : ");
                userId = scanner.next();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
        
        user = new User(name, userId, userPw, phoneNumber, email, date);
        num = dao.update(user);
        
        System.out.println(num);
        
        list = dao.findUserList();  
        
       System.out.println("--------------------User id 목록--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                User c = list.get(i);
                String n = c.getUserId();
                System.out.printf("%s \n", n);
            }
        }
        
        System.out.println("remove예제");
        System.out.print("remove id : ");
        userId = scanner.next();
        try {
            while(!dao.existingUser(userId)) {
                System.out.println(userId + " 는 존재하지 않는 아이디 입니다");
                System.out.print("remove id : ");
                userId = scanner.next();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        num = dao.remove(userId);
        
        System.out.println(num);
        
        list = dao.findUserList();  
        
        System.out.println("--------------------User id 목록--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                User c = list.get(i);
                String n = c.getUserId();
                System.out.printf("%s \n", n);
            }
        }
        System.out.println("findUser예제");
        System.out.print("id : ");
        userId = scanner.next();
        try {
            while(!dao.existingUser(userId)) {
                System.out.println(userId + " 는 존재하지 않는 아이디 입니다");
                System.out.print("remove id : ");
                userId = scanner.next();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        user = dao.findUser(userId);
        System.out.println(user.toString());
        
//        System.out.println("existingUser예제");
//        System.out.print("id : ");
//        userId = scanner.next();
//        Boolean n = dao.existingUser(userId);
//        System.out.println(n);
        
        
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
