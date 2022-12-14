package customer.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
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
                System.out.println(reservationId + " ");
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
        System.out.print("customerId : ");
        int customerId = scanner.nextInt();
        
        try {
        
            Date sdate = transformDate(startDate);
            Date edate = transformDate(endDate);
           
            
            Reservation res = new Reservation(reservationId, productId, sdate, edate, headCount, price, reservationList, customerId);    
            
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
                System.out.println(reservationId + " ");
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
        System.out.print("endDate : ");
        endDate = scanner.next();
        System.out.print("headCount : ");
        headCount = scanner.nextInt();
        System.out.print("price : ");
        price = scanner.nextInt();
        System.out.print("reservationList : ");
        reservationList = scanner.nextInt();
        System.out.print("customerId : ");
        customerId = scanner.nextInt();
        
        
        res = new Reservation(reservationId, productId, sdate, edate, headCount, price, reservationList, customerId);
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
                System.out.println(reservationId + " ");
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
                System.out.println(reservationId + " ");
                System.out.print("find reservationId : ");
                reservationId = scanner.nextInt();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        res = dao.findReservation(reservationId);
        System.out.println(res.toString());
        
//        System.out.println("existingProduct????????????");
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
        
        // Date?????? ????????????????????? ???????????????????????? ???????????? ?????????????????? yyyy-mm-dd?????? ????????????????????? ????????????.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // ???????????? yyyymmdd????????? ???????????? ???????????????????????? java.util.Date??????????????? ???????????????.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date?????? yyyy-mm-dd ???????????????????????? ????????????????????? String?????? ?????????????????????.
        String transDate = afterFormat.format(tempDate);
        
        // ??????????????? String ????????? Date?????? ?????????????????????.
        Date d = Date.valueOf(transDate);
        
        return d;
    }
   
}
