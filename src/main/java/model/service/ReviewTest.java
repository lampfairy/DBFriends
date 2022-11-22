package model.service;
///
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.Review;
import model.dao.ReviewDAO;

import java.sql.Date;
import java.sql.SQLException;

public class ReviewTest {

    private static ReviewDAO dao = new ReviewDAO();
    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("create Review");  
        
        System.out.print("create reviewId : ");
        int reviewId = scanner.nextInt();
        
        try {
            while(dao.existingReview(reviewId)) {
                System.out.println(reviewId + " can't be used ");
                System.out.print("create reviewId : ");
                reviewId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
        
        
        System.out.print("userId : ");
        String userId = scanner.next();
        System.out.print("title : ");
        String title = scanner.next();
        System.out.print("writeDate : ");
        String writeDate = scanner.next();
        System.out.print("rating : ");
        float rating = scanner.nextFloat();
        System.out.print("content : ");
        String content = scanner.next();
        System.out.print("image : ");
        String image = scanner.next();
        
        
        try {
        
            Date wdate = transformDate(writeDate);
            
            Review r = new Review(reviewId, userId, title, wdate, rating, content, image);
            System.out.println(r.toString());
            int num = dao.create(r);
            System.out.println(num);
            
            List<Review> list = dao.findReviewList();  
            
            System.out.println("--------------------Review id--------------------");
            if(list != null) {
                for(int i = 0; i < list.size(); i++) {
                    Review rv = list.get(i);
                    int n = rv.getReviewId();
                    System.out.printf("%d \n", n);
             }
        }
        System.out.println();
        
        System.out.println("update");
        System.out.print("update reviewId : ");
        reviewId = scanner.nextInt();
        try {
            while(!dao.existingReview(reviewId)) {
                System.out.println(reviewId + " isn't found ");
                System.out.print("update reviewId : ");
                reviewId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        System.out.print("userId : ");
        userId = scanner.next();
        System.out.print("title : ");
        title = scanner.next();
        System.out.print("writeDate : ");
        writeDate = scanner.next();
        wdate = transformDate(writeDate);
        System.out.print("rating : ");
        rating = scanner.nextFloat();
        System.out.print("content : ");
        content = scanner.next();
        System.out.print("image : ");
        image = scanner.next();   
        
      
        
        r = new Review(reviewId, userId, title, wdate, rating, content, image);
        num = dao.update(r);
        
        System.out.println(num);
        
        list = dao.findReviewList();  
        
       System.out.println("--------------------Review id--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Review rv = list.get(i);
                int n = rv.getReviewId();
                System.out.printf("%d \n", n);
            }
        }
        
        System.out.println("remove");
        System.out.print("remove reviewId : ");
        reviewId = scanner.nextInt();
        try {
            while(!dao.existingReview(reviewId)) {
                System.out.println(reviewId + " isn't found ");
                System.out.print("remove reviewId : ");
                reviewId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        num = dao.remove(reviewId);
        
        System.out.println(num);
        
        list = dao.findReviewList();  
        
        System.out.println("--------------------Review id--------------------");
        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                Review rv = list.get(i);
                int n = rv.getReviewId();
                System.out.printf("%d \n", n);
            }
        }
        System.out.println("findReview");
        System.out.print("find reviewId : ");
        reviewId = scanner.nextInt();
        try {
            while(!dao.existingReview(reviewId)) {
                System.out.println(reviewId + " isn't found ");
                System.out.print("find reviewId : ");
                reviewId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        r = dao.findReview(reviewId);
        System.out.println(r.toString());
        
//        System.out.println("existingReview�삁�젣");
//        System.out.print("id : ");
//        reviewId = scanner.next();
//        Boolean n = dao.existingReview(reviewId);
//        System.out.println(n);
        
        
        } catch(Exception e) {
            System.out.println("�삤瑜�");
        } finally {
            scanner.close();
        }
    }
    
    public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        
        // Date濡? 蹂?寃쏀븯湲? ?쐞?빐?꽌?뒗 ?궇吏? ?삎?떇?쓣 yyyy-mm-dd濡? 蹂?寃쏀빐?빞 ?븳?떎.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // ?쁽?옱 yyyymmdd濡쒕맂 ?궇吏? ?삎?떇?쑝濡? java.util.Date媛앹껜瑜? 留뚮뱺?떎.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date瑜? yyyy-mm-dd ?삎?떇?쑝濡? 蹂?寃쏀븯?뿬 String濡? 諛섑솚?븳?떎.
        String transDate = afterFormat.format(tempDate);
        
        // 諛섑솚?맂 String 媛믪쓣 Date濡? 蹂?寃쏀븳?떎.
        Date d = Date.valueOf(transDate);
        
        return d;
    }

   
}
