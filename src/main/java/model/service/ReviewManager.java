package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Review;
import model.dao.ReviewDAO;

public class ReviewManager {
	private static ReviewManager reviewMan = new ReviewManager();
	private ReviewDAO reviewDAO;
	
	private ReviewManager() {
		try {
			reviewDAO = new ReviewDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ReviewManager getInstance() {
		return reviewMan;
	}
	
	public int create(Review Review) throws SQLException, ExistingException {
		if(reviewDAO.existingReview(Review.getReservationId()) == true) {
			throw new ExistingException(Review.getReservationId() + "exists");
		}
		return reviewDAO.create(Review);
	}
	
	public int update(Review Review) throws SQLException {
		return reviewDAO.update(Review);
	}
	
	public int remove(int reservationId) throws SQLException {
        return reviewDAO.remove(reservationId);
    }

    public Review findReview(int reservationId)
        throws SQLException, ExistingException {
        Review prod = reviewDAO.findReview(reservationId);
        
        if (prod == null) {
            throw new ExistingException(reservationId + "doesn't exist");
        }       
        return prod;
    }
    
    public String findRating(int productId) throws SQLException {
        return reviewDAO.findRating(productId);
    }

    public List<Review> findReviewList() throws SQLException {
            return reviewDAO.findReviewList();
    }
    
    public List<Review> findReviewListByKey(String key) throws SQLException {
        return reviewDAO.findReviewListByKey(key);
    }
    
    public ReviewDAO getreviewDAO() {
		return this.reviewDAO;
	}
    
    public boolean existingReview(int reservationId) throws SQLException {
        return reviewDAO.existingReview(reservationId);
    }
    
}
