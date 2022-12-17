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
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager manager = UserManager.getInstance();
        User user = manager.findUser(id);
        request.setAttribute("user", user);
        
        ReviewManager reviewManager = ReviewManager.getInstance();
        String key = request.getParameter("key");
        List<Review> freviewList;
        if(key != null) {
            freviewList = reviewManager.findReviewListByKey(key);
            request.setAttribute("reviewList", freviewList); 
        }
        else {
            freviewList = reviewManager.findReviewList();
            request.setAttribute("reviewList", freviewList);
        }
        return "/main/review.jsp";
    }
}
