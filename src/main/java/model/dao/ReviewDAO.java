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
        String sql = "INSERT INTO Review (reservationId, userId, writeDate, rating) "
                    + "VALUES (?, ?, ?, ?)";     
        Object[] param = new Object[] {Review.getReservationId(), Review.getUserId(), Review.getWriteDate(), Review.getRating()};              
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
                    + "SET userId=?, writeDate=?, rating=? "
                    + "WHERE reservationId=?";
        Object[] param = new Object[] {Review.getUserId(), Review.getWriteDate(),
                Review.getRating(), Review.getReservationId()};                
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
        String sql = "SELECT reservationId, title, writeDate, rating, content, image "
                    + "FROM Review "
                    + "WHERE reservationId=?";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                Review Review = new Review(
                        reservationId,
                        rs.getString("userId"),
                        rs.getDate("writeDate"),
                        rs.getFloat("rating")
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
        String sql = "SELECT reservationId, title, writeDate, rating, content, image "
                    + "FROM Review "
                    + "ORDER BY writeDate";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<Review> ReviewList = new ArrayList<Review>();   
            while (rs.next()) {
                Review Review = new Review(
                       rs.getInt("reservationId"),
                       rs.getString("userId"),
                       rs.getDate("writeDate"),
                       rs.getFloat("rating")
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
