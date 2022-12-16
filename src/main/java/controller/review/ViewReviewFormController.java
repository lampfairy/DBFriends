package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Product;
import model.Reservation;
import model.User;
import model.service.ProdManager;
import model.service.ReserveManager;
import model.service.UserManager;

public class ViewReviewFormController implements Controller{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/loginForm";     // login form 요청으로 redirect
        }
        
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager manager = UserManager.getInstance();
        User user = manager.findUser(id);
        request.setAttribute("user", user);
        
        int reserveId = Integer.parseInt(request.getParameter("reservationId"));
        ReserveManager reMa = ReserveManager.getInstance();
        Reservation reserve = reMa.findReservation(reserveId);
        request.setAttribute("reserve", reserve);
        
        ProdManager prodManager = ProdManager.getInstance();
        Product product = prodManager.findProduct(reserve.getProductId());

        return "/review/review.jsp";
    }
}
