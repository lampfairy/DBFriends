package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Reservation;
import model.Review;
import model.User;
import model.service.ReserveManager;
import model.service.ReviewManager;
import model.service.UserManager;

public class DetailReviewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
        
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        
        ReserveManager resevema = ReserveManager.getInstance();
        Reservation reserve = resevema.findReservation(reservationId);
        
        ReviewManager reviewma = ReviewManager.getInstance();
        Review review = reviewma.findReview(reservationId);
        
        request.setAttribute("reserve", reserve); 
        request.setAttribute("review", review); 
        
        return "/review/detail.jsp";
    }
}
