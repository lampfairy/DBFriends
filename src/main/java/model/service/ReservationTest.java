package model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.Product;
import model.Reservation;
import model.dao.ProductDAO;
import model.dao.ReservationDAO;

import java.sql.Date;
import java.sql.SQLException;

public class ReservationTest {
//
    private static ReservationDAO dao = new ReservationDAO();
    private static ProductDAO dao_p = new ProductDAO();

    public static void main(String[] args) throws SQLException {

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


        System.out.println();
        List<Product> list_p = dao_p.findProductList();

        System.out.println("-----------a list of products available for reservation-----------");
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

        System.out.print("productId : ");
        int productId = scanner.nextInt();

        Product p = new Product();
        p = dao_p.findProduct(productId);

        System.out.print("startDate : ");
        String startDate = scanner.next();
        System.out.print("endDate : ");
        String endDate = scanner.next();

        while(startDate.compareTo(endDate) > 0) {
            System.out.println("The end date cannot be earlier than the start date");
            System.out.print("startDate : ");
            startDate = scanner.next();
            System.out.print("endDate : ");
            endDate = scanner.next();
        }

        System.out.println("Number of people available for reservation: " + p.getStatus());
        System.out.print("headCount : ");
        int headCount = scanner.nextInt();

        while(headCount > p.getStatus()) {
            System.out.println("overstaffed");
            System.out.print("headCount : ");
            headCount = scanner.nextInt();
        }
        //Status not reduced by the number of people booked
        p.setStatus(p.getStatus() - headCount);
        p = new Product(p.getProductId(), p.getLocation(), p.getPrice(), p.getDescription(), p.getStatus(), p.getImage(), p.getName(), p.getType());
        int num = dao_p.update(p);
        //System.out.println(num);
        
        System.out.println("Number of people available for reservation: " + p.getStatus());

        int price = p.getPrice() * headCount;
        System.out.println("price(the amount to be paid): " + price);
        System.out.print("reservationList : ");
        int reservationList = scanner.nextInt();
        System.out.print("userId : ");
        String userId = scanner.next();

        try {
            Date sdate = transformDate(startDate);
            Date edate = transformDate(endDate);

            Reservation res = new Reservation(reservationId, productId, sdate, edate, headCount, price, reservationList, userId);    

            System.out.println(res.toString());
            num = dao.create(res);
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

            res = dao.findReservation(reservationId);
            
            System.out.println();
            list_p = dao_p.findProductList();

            System.out.println("-----------a list of products available for reservation-----------");
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

            System.out.print("productId : " + res.getProductId() + "→ ");
            productId = scanner.nextInt();
            
            System.out.print("startDate : " + res.getStartDate() + "→ ");
            startDate = scanner.next();
            System.out.print("endDate : " + res.getEndDate() + "→ ");
            endDate = scanner.next();
            while(startDate.compareTo(endDate) > 0) {
                System.out.println("The end date cannot be earlier than the start date");
                System.out.print("startDate : ");
                startDate = scanner.next();
                System.out.print("endDate : ");
                endDate = scanner.next();
            }
            sdate = transformDate(startDate);
            edate = transformDate(endDate);

            if(productId == p.getProductId()) {
                p.setStatus(p.getStatus() + res.getHeadCount());
                p = new Product(p.getProductId(), p.getLocation(), p.getPrice(), p.getDescription(), p.getStatus(), p.getImage(), p.getName(), p.getType());
            }
            else
                p = dao_p.findProduct(productId);
                
            
            System.out.println("Number of people available for reservation: " + p.getStatus());
            System.out.print("headCount : " + res.getHeadCount() + "→ ");
            headCount = scanner.nextInt();
            while(headCount > p.getStatus()) {
                System.out.println("overstaffed");
                System.out.print("headCount : ");
                headCount = scanner.nextInt();
            }
            p.setStatus(p.getStatus() - headCount);
            p = new Product(p.getProductId(), p.getLocation(), p.getPrice(), p.getDescription(), p.getStatus(), p.getImage(), p.getName(), p.getType());
            
            price = p.getPrice() * headCount;
            System.out.println("price(the amount to be paid): " + price);
            System.out.print("reservationList : " + res.getReservationList() + "→ ");
            reservationList = scanner.nextInt();
            System.out.print("userId : " + res.getUserId());
            userId = res.getUserId();
            System.out.println();

            res = new Reservation(reservationId, productId, sdate, edate, headCount, price, reservationList, userId);
            num = dao.update(res);

            System.out.println(res.toString());
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
            reservationId = scanner.nextInt();
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
