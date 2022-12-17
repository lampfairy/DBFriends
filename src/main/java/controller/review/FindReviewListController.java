package controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.Review;
import model.service.ReviewManager;
import model.service.UserManager;

public class FindReviewListController implements Controller{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
//        String id = UserSessionUtils.getLoginUserId(request.getSession());
//        UserManager manager = UserManager.getInstance();
//        User user = manager.findUser(id);
//        request.setAttribute("user", user);
        
        ReviewManager reviewManager = ReviewManager.getInstance();
        String keySearch = request.getParameter("keySearch");
        
        if(keySearch != null) {
            List<Review> reviewList = reviewManager.findReviewListByKey(keySearch);
            request.setAttribute("reviewList", reviewList); 
        }
        else {
            request.setAttribute("reviewList", null);
        }
        
        return "/";

    }
}
