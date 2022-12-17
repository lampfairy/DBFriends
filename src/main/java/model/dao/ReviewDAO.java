package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Review;
//import util.JDBCUtil;

public class ReviewDAO {
    private JDBCUtil jdbcUtil = null;
    
    public ReviewDAO() {          
        jdbcUtil = new JDBCUtil();
    }
   
    //create Review
    public int create(Review Review) throws SQLException {
        String sql = "INSERT INTO Review (title, reservationId, userId, writeDate, rating, productId, content) "
                    + "VALUES (?, ?, ?, SYSDATE, ?, ?, ?)";     
        Object[] param = new Object[] {Review.getTitle(), Review.getReservationId(), Review.getUserId(), 
                Review.getRating(), Review.getProductId(), Review.getContent()};              
        jdbcUtil.setSqlAndParameters(sql, param);
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close(); 
        }       
        return 0;           
    }

    //update Review
    public int update(Review Review) throws SQLException {
        String sql = "UPDATE Review "
                    + "SET title=?, userId=?, writeDate=?, rating=?, productId=?, content=? "
                    + "WHERE reservationId=?";
        Object[] param = new Object[] {Review.getTitle(), Review.getUserId(), Review.getWriteDate(),
                Review.getRating(), Review.getProductId(), Review.getContent(), Review.getReservationId()};                
        jdbcUtil.setSqlAndParameters(sql, param);   
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }       
        return 0;
    }

   //remove Review

    public int remove(int reservationId) throws SQLException {
        String sql = "DELETE FROM Review WHERE reservationId=?";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});   
        try {               
            int result = jdbcUtil.executeUpdate(); 
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close(); 
        }       
        return 0;
    }

   //find Review
    public Review findReview(int reservationId) throws SQLException {
        String sql = "SELECT r.title AS title, r.userId AS userId, r.productId AS productId, p.productName AS productName, "
                    + "r.writeDate AS writeDate, p.startDate AS startDate, p.endDate AS endDate, r.rating AS rating, r.content AS content "
                    + "FROM Review r JOIN Product p ON r.productId = p.productId "
                    + "WHERE reservationId=?";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                Review Review = new Review(
                        rs.getString("title"),
                        reservationId,
                        rs.getString("userId"),
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getDate("writeDate"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getFloat("rating"),
                        rs.getString("content")
                   );
                return Review;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }
 
    //find Review List
    public List<Review> findReviewList() throws SQLException {
        String sql = "SELECT r.title AS title, r.reservationId AS reservationId, r.userId AS userId, r.productId AS productId, p.productName AS productName, "
                    + "r.writeDate AS writeDate, p.startDate AS startDate, p.endDate AS endDate, r.rating AS rating, r.content AS content "
                    + "FROM Review r JOIN Product p ON r.productId = p.productId "
                    + "ORDER BY writeDate";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<Review> ReviewList = new ArrayList<Review>();   
            while (rs.next()) {
                Review Review = new Review(
                        rs.getString("title"),
                        rs.getInt("reservationId"),
                        rs.getString("userId"),
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getDate("writeDate"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getFloat("rating"),
                        rs.getString("content")
                        );
                ReviewList.add(Review);   
            }       
            return ReviewList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }
    
    public List<Review> findReviewListByKey(String key) throws SQLException {
        String sql = "SELECT r.title AS title, r.reservationId AS reservationId, r.userId AS userId, r.productId AS productId, p.productName AS productName, "
                    + "r.writeDate AS writeDate, p.startDate AS startDate, p.endDate AS endDate, r.rating AS rating, r.content AS content "
                    + "FROM Review r JOIN Product p ON r.productId = p.productId "
                    + "WHERE title LIKE ? OR content LIKE ? "
                    + "ORDER BY writeDate";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {key, key});  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<Review> ReviewList = new ArrayList<Review>();   
            while (rs.next()) {
                Review Review = new Review(
                        rs.getString("title"),
                        rs.getInt("reservationId"),
                        rs.getString("userId"),
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getDate("writeDate"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getFloat("rating"),
                        rs.getString("content")
                        );
                ReviewList.add(Review);   
            }       
            return ReviewList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }
    

  //find Review
    public String findRating(int productId) throws SQLException {
        String sql = "SELECT rating "
                    + "FROM Review "
                    + "WHERE productId=?";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {productId});   
        
        float rating = 0;
        int count = 0;
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            while (rs.next()) {                      
                rating += rs.getFloat("rating");
                count++;
            }
            rating /= count;
            return String.format("%.1f", rating);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }

  //Review 아이디 중복 확인
    public boolean existingReview(int reservationId) throws SQLException {
        String sql = "SELECT count(*) FROM Review WHERE reservationId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});  
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();     
        }
        return false;
    }
}
