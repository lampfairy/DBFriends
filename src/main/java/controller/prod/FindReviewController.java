package controller.prod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Product;
import model.Review;
import model.User;
import model.service.ProdManager;
import model.service.ReviewManager;
import model.service.UserManager;

public class FindReviewController implements Controller{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager manager = UserManager.getInstance();
        User user = manager.findUser(id);
        request.setAttribute("user", user);
        
        ReviewManager reviewManager = ReviewManager.getInstance();
        int prodId = Integer.parseInt(request.getParameter("productId"));
        List<Review> reviewList = reviewManager.findReviewListByProd(prodId);
        request.setAttribute("reviewList", reviewList); 
        return "/review/prodReviewList.jsp";
    }
}
