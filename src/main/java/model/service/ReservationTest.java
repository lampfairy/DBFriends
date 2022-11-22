package model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.Reservation;
import model.dao.ReservationDAO;

import java.sql.Date;
import java.sql.SQLException;

public class ReservationTest {

    private static ReservationDAO dao = new ReservationDAO();
    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("create reservation");  
        
        System.out.print("create reservationId : ");
        int reservationId = scanner.nextInt();
        
        try {
            while(dao.existingReservation(reservationId)) {
                System.out.println(reservationId + " can't be used ");
                System.out.print("create reservationId : ");
                reservationId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
                                                                                
        System.out.print("productId : ");
        int productId = scanner.nextInt();
        System.out.print("startDate : ");
        String startDate = scanner.next();
        System.out.print("endDate : ");
        String endDate = scanner.next();
        System.out.print("headCount : ");
        int headCount = scanner.nextInt();
        System.out.print("price : ");
        int price = scanner.nextInt();
        System.out.print("reservationList : ");
        int reservationList = scanner.nextInt();
        System.out.print("userId : ");
        String userId = scanner.next();
        
        try {
        
            Date sdate = transformDate(startDate);
            Date edate = transformDate(endDate);
           
            
            Reservation res = new Reservation(reservationId, productId, sdate, edate, headCount, price, reservationList, userId);    
            
            System.out.println(res.toString());
            int num = dao.create(res);
            System.out.println(num);
            
            List<Reservation> list = dao.findReservationList();  
            
            System.out.println("--------------------Reservation id --------------------");
            if(list != null) {
                for(int i = 0; i < list.size(); i++) {
                    Reservation r = list.get(i);
                    int n = r.getReservationId();
                    System.out.printf("%d \n", n);
                }
            }
            System.out.println();
            
            System.out.println("update");
            System.out.print("update reservationId : ");
            reservationId = scanner.nextInt();
        try {
            while(!dao.existingReservation(reservationId)) {
                System.out.println(reservationId + " isn't found ");
                System.out.print("update reservationId : ");
                reservationId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
       
       
        
        System.out.print("productId : ");
        productId = scanner.nextInt();
        System.out.print("startDate : ");
        startDate = scanner.next();
        sdate = transformDate(startDate);
        System.out.print("endDate : ");
        endDate = scanner.next();
        edate = transformDate(endDate);
        System.out.print("headCount : ");
        headCount = scanner.nextInt();
        System.out.print("price : ");
        price = scanner.nextInt();
        System.out.print("reservationList : ");
        reservationList = scanner.nextInt();
        System.out.print("userId : ");
        userId = scanner.next();
        
        
        res = new Reservation(reservationId, productId, sdate, edate, headCount, price, reservationList, userId);
        num = dao.update(res);
        
        System.out.println(num);
        
        list = dao.findReservationList();  
        
       System.out.println("--------------------Reservation id --------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Reservation r = list.get(i);
                int n = r.getReservationId();
                System.out.printf("%d \n", n);
            }
        }
        
        System.out.println("remove");
        System.out.print("remove reservationId : ");
        productId = scanner.nextInt();
        try {
            while(!dao.existingReservation(reservationId)) {
                System.out.println(reservationId + " isn't found ");
                System.out.print("remove reservationId : ");
                reservationId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        num = dao.remove(reservationId);
        
        System.out.println(num);
        
        list = dao.findReservationList();  
        
        System.out.println("--------------------Reservation id--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Reservation r = list.get(i);
                int n = r.getReservationId();
                System.out.printf("%d \n", n);
            }
        }
        System.out.println("findReservation");
        System.out.print("find reservationId : ");
        reservationId = scanner.nextInt();
        try {
            while(!dao.existingReservation(reservationId)) {
                System.out.println(reservationId + " isn't found ");
                System.out.print("find reservationId : ");
                reservationId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        res = dao.findReservation(reservationId);
        System.out.println(res.toString());
        
//        System.out.println("existingProduct�삁�젣");
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
    
    public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        
        // Date濡� 蹂�寃쏀븯湲� �쐞�빐�꽌�뒗 �궇吏� �삎�떇�쓣 yyyy-mm-dd濡� 蹂�寃쏀빐�빞 �븳�떎.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // �쁽�옱 yyyymmdd濡쒕맂 �궇吏� �삎�떇�쑝濡� java.util.Date媛앹껜瑜� 留뚮뱺�떎.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date瑜� yyyy-mm-dd �삎�떇�쑝濡� 蹂�寃쏀븯�뿬 String濡� 諛섑솚�븳�떎.
        String transDate = afterFormat.format(tempDate);
        
        // 諛섑솚�맂 String 媛믪쓣 Date濡� 蹂�寃쏀븳�떎.
        Date d = Date.valueOf(transDate);
        
        return d;
    }
   
}
