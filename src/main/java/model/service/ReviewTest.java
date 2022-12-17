package model.service;
///
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.Reservation;
import model.Review;
import model.dao.ReservationDAO;
import model.dao.ReviewDAO;

import java.sql.Date;
import java.sql.SQLException;

public class ReviewTest {
//
    private static ReservationDAO dao_r = new ReservationDAO();
    private static ReviewDAO dao = new ReviewDAO();
    
    public static void main(String[] args) throws SQLException {
    
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("create Review");  
        
        int string = scanner.nextInt();
        
        List<Review> list_r = dao.findReviewListByProd(string);

        System.out.println("-----------a list of products available for reservation-----------");
        if(list_r != null) {
            for(int i = 0; i < list_r.size(); i++) {
                Review c = list_r.get(i);
                int n = c.getReservationId();
                System.out.printf("%d \t", n);
                if(i != 0 && i % 10 == 0)
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println();
//
//        System.out.print("input reservationId : ");
//        int reservationId = scanner.nextInt();
//
//        try {
//            while(!dao_r.existingReservation(reservationId) || dao.existingReview(reservationId)) {
//                if(!dao_r.existingReservation(reservationId)) {
//                    System.out.println(reservationId + " isn't exist");
//                    System.out.print("create reservationId : ");
//                    reservationId = scanner.nextInt();
//                }
//                if(dao.existingReview(reservationId)) {
//                    System.out.println(reservationId + " already writed");
//                    System.out.print("create reservationId : ");
//                    reservationId = scanner.nextInt();
//                }
//            }
//        } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } 
//        
//        System.out.print("title : ");
//        String title = scanner.next();
//        LocalDate now = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        System.out.print("writeDate : ");
//        String writeDate = now.format(formatter);
//        System.out.println(writeDate);
//        System.out.print("rating : ");
//        float rating = scanner.nextFloat();
//        System.out.print("content : ");
//        String content = scanner.next();
//        System.out.print("image : ");
//        String image = scanner.next();
//        
//        
//        try {
//            Date wdate = transformDate(writeDate);
//            
//            Review r = new Review(reservationId, title, wdate, rating, content, image);
//            System.out.println(r.toString());
//            int num = dao.create(r);
//            System.out.println(num);
//            
//            List<Review> list = dao.findReviewList();  
//            
//            System.out.println("--------------------Reservation id--------------------");
//            if(list != null) {
//                for(int i = 0; i < list.size(); i++) {
//                    Review rv = list.get(i);
//                    int n = rv.getReservationId();
//                    System.out.printf("%d \n", n);
//             }
//        }
//        System.out.println();
//        
//        System.out.println("update");
//        System.out.print("input reservationId : ");
//        reservationId = scanner.nextInt();
//        try {
//            while(!dao.existingReview(reservationId)) {
//                System.out.println(reservationId + " can't be used ");
//                System.out.print("input reservationId : ");
//                reservationId = scanner.nextInt();
//            }
//        } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } 
//        
//        System.out.print("title : ");
//        title = scanner.next();
//        System.out.print("writeDate : ");
//        now = LocalDate.now();
//        writeDate = now.format(formatter);
//        System.out.println(writeDate);
//        wdate = transformDate(writeDate);
//        System.out.print("rating : ");
//        rating = scanner.nextFloat();
//        System.out.print("content : ");
//        content = scanner.next();
//        System.out.print("image : ");
//        image = scanner.next();   
//        
//        r = new Review(reservationId, title, wdate, rating, content, image);
//        num = dao.update(r);
//        
//        System.out.println(num);
//        
//        list = dao.findReviewList();  
//        
//       System.out.println("--------------------Reservation id--------------------");
//        if(list != null) {
//            for(int i = 0; i < list.size(); i++) {
//                Review rv = list.get(i);
//                int n = rv.getReservationId();
//                System.out.printf("%d \n", n);
//            }
//        }
//        
//        System.out.println("remove");
//        System.out.print("input reservationId : ");
//        reservationId = scanner.nextInt();
//        try {
//            while(!dao.existingReview(reservationId)) {
//                System.out.println(reservationId + " can't be used ");
//                System.out.print("input reservationId : ");
//                reservationId = scanner.nextInt();
//            }
//        } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } 
//        num = dao.remove(reservationId);
//        
//        System.out.println(num);
//        
//        list = dao.findReviewList();  
//        
//        System.out.println("--------------------Reservation id--------------------");
//        if(list != null) {
//            for(int i = 0; i < list.size(); i++) {
//                Review rv = list.get(i);
//                int n = rv.getReservationId();
//                System.out.printf("%d \n", n);
//            }
//        }
//        System.out.println("findReview");
//        System.out.print("input reservationId : ");
//        reservationId = scanner.nextInt();
//        try {
//            while(!dao.existingReview(reservationId)) {
//                System.out.println(reservationId + " can't be used ");
//                System.out.print("input reservationId : ");
//                reservationId = scanner.nextInt();
//                System.out.print("input userId : ");
//                reservationId = scanner.nextInt();
//            }
//        } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } 
//        r = dao.findReview(reservationId);
//        System.out.println(r.toString());
//        } catch(Exception e) {
//            System.out.println("error");
//        } finally {
//            scanner.close();
//        }
    }
    
    public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String transDate = afterFormat.format(tempDate);
        Date d = Date.valueOf(transDate);
        
        return d;
    }
}
