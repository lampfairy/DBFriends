package controller.reserve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Reservation;
import model.User;
import model.service.ExistingException;
import model.service.ReserveManager;
import model.service.UserManager;

public class InsertReserveController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	
	    String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
	    
       	Date startDate = transformDate(request.getParameter("startDate"));
       	Date endDate = transformDate(request.getParameter("endDate"));
       	Reservation reserv = new Reservation(
       			Integer.parseInt(request.getParameter("reservationId")), 
       			Integer.parseInt(request.getParameter("productId")), 
       			startDate,
       			endDate,
       			Integer.parseInt(request.getParameter("headCount")),
       			Integer.parseInt(request.getParameter("price")),
       			Integer.parseInt(request.getParameter("reservationList")),
       			request.getParameter("userId")
       	);

		try {
			ReserveManager manager = ReserveManager.getInstance();
			manager.create(reserv);
	        return "/main/myPage.jsp";
	        
		} catch (ExistingException e) {	// 예외 발생 시
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("reservation", reserv);
			return "/reserve/insert.jsp";
		}
    }
	
	public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String transDate = afterFormat.format(tempDate);
        Date d = Date.valueOf(transDate);
        
        return d;
    }
}
