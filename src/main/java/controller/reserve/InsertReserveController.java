package controller.reserve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Reservation;
import model.service.ExistingException;
import model.service.ReserveManager;

public class InsertReserveController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	
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
	        return "redirect:/main/reserve"; /// 수정
	        
		} catch (ExistingException e) {	// 예외 발생 시
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("reservation", reserv);
			return "/reserve/insert.jsp"; /// 수정
		}
    }
	
	public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        
        // Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // 현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
        String transDate = afterFormat.format(tempDate);
        
        // 반환된 String 값을 Date로 변경한다.
        Date d = Date.valueOf(transDate);
        
        return d;
    }
}
