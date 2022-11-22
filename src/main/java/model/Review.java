package model;

import java.util.Date;

public class Review {
    
    private int reviewId;
    private String userId;
    private String title;
    private Date writeDate;
    private float rating;
    private String content;
    private String image;
    
    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Review(int reviewId, String userId, String title, Date writeDate, float rating, String content,
            String image) {
        super();
        this.reviewId = reviewId;
        this.userId = userId;
        this.title = title;
        this.writeDate = writeDate;
        this.rating = rating;
        this.content = content;
        this.image = image;
    }
    
   
//    public Review(int reviewId, String title, Date writeDate, float rating, String content, String image) {
//        super();
//        this.title = title; 
//        this.writeDate = writeDate;
//        this.rating = rating;
//        this.content = content;
//        this.image = image;
//        this.reviewId = reviewId;
//    }
    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", userId=" + userId + ", title=" + title + ", writeDate="
                + writeDate + ", rating=" + rating + ", content=" + content + ", image=" + image + "]";
    }
    
    
    
}
