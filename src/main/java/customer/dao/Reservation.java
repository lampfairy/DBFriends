package customer.dao;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int productId;
    private Date startDate;
    private Date endDate;
    private int headCount;
    private int price;
    private int reservationList;
    private int customerId;
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
    public int getReservationList() {
        return reservationList;
    }
    public void setReservationList(int reservationList) {
        this.reservationList = reservationList;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    //Constructor
    
    public Reservation(int reservationId, int productId, Date startDate, Date endDate, int headCount, int price,
            int reservationList, int customerId) {
        super();
        this.reservationId = reservationId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.headCount = headCount;
        this.price = price;
        this.reservationList = reservationList;
        this.customerId = customerId;
    }
    
    //toString
    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", productId=" + productId + ", startDate=" + startDate
                + ", endDate=" + endDate + ", headCount=" + headCount + ", price=" + price + ", reservationList="
                + reservationList + ", customerId=" + customerId + "]";
    }
    
    
    
    

}
