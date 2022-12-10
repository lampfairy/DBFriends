package controller.reserve;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Reservation;
import model.User;
import model.service.ReserveManager;
import model.service.UserManager;

public class DetailReserveController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
        
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        
        ReserveManager rema = ReserveManager.getInstance();
        Reservation reserve = rema.findReservation(reservationId);
        request.setAttribute("user", user);    
        request.setAttribute("reserve", reserve); 
        
        return "/reserve/detail.jsp";
    }
}
