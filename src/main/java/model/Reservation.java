package model;

import java.util.Date;
//
public class Reservation {
    private int reservationId;
    private int productId;
    private Date startDate;
    private Date endDate;
    private int headCount;
    private int price;
    private String userId;
    private String name;
    
    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getHeadCount() {
        return headCount;
    }
    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //Constructor
    
    public Reservation(int reservationId, int productId, Date startDate, Date endDate, int headCount, int price,
            String userId, String name) {
        super();
        this.reservationId = reservationId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.headCount = headCount;
        this.price = price;
        this.userId = userId;
        this.name = name;
    }
    
    //toString
    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", productId=" + productId + ", startDate=" + startDate
                + ", endDate=" + endDate + ", headCount=" + headCount + ", price=" + price +
                 ", userId=" + userId + "]";
    }
    
    
    
    

}
