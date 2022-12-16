package model;

import java.util.Date;
//
public class Review {
    private String title;
    private int reservationId;
    private String userId;
    private int productId;
    private String productName;
    private Date writeDate;
    private Date startDate;
    private Date endDate;
    private float rating;
    private String content;
    
    public Review(String title, int reservationId, String userId, int productId, String productName, Date writeDate, Date startDate,
            Date endDate, float rating, String content) {
        super();
        this.title = title;
        this.reservationId = reservationId;
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.writeDate = writeDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.content = content;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Date getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
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
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "Review [title=" + title + ", reservationId=" + reservationId + ", userId=" + userId + ", productId=" + productId
                + ", productName=" + productName + ", writeDate=" + writeDate + ", startDate=" + startDate
                + ", endDate=" + endDate + ", rating=" + rating + ", content=" + content + "]";
    }
}
