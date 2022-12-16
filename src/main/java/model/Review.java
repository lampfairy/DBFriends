package model;

import java.util.Date;
//
public class Review {
    private int reservationId;
    private String userId;
    private Date writeDate;
    private float rating;

    public Review(int reservationId, String userId, Date writeDate, float rating) {
        super();
        this.reservationId = reservationId;
        this.userId = userId;
        this.writeDate = writeDate;
        this.rating = rating;
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
    public Date getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return "Review [reservationId=" + reservationId + ", userId=" + userId + ", writeDate=" + writeDate
                + ", rating=" + rating + "]";
    }
}
