package controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Reservation;
import model.User;
import model.Review;
import model.service.ProdManager;
import model.service.ReserveManager;
import model.service.ReviewManager;
import model.service.UserManager;

public class FindReviewListController implements Controller{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ReviewManager reviewManager = ReviewManager.getInstance();
        String key = request.getParameter("key");
        
        List<Review> reviewList;
        reviewList = reviewManager.findReviewListByKey(key);
            request.setAttribute("reviewList", reviewList); 
            return "/main/review";
    }
}