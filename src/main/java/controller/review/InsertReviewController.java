package controller.review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Reservation;
import model.Review;
import model.User;
import model.service.ExistingException;
import model.service.ReserveManager;
import model.service.ReviewManager;
import model.service.UserManager;

public class InsertReviewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
        
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        ReserveManager reserveMa = ReserveManager.getInstance();
        Reservation r = reserveMa.findReservation(reservationId);
        
//        LocalDateTime now = LocalDateTime.now();
//        Date nowDate = transformDate(now.format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
        
        Review review = new Review(
                request.getParameter("title"),
                reservationId,
                user.getUserId(),
                Integer.parseInt(request.getParameter("productId")),
                request.getParameter("productName"),
//                nowDate,
                r.getStartDate(),
                r.getStartDate(),
                r.getEndDate(),
                Float.parseFloat(request.getParameter("rating")),
                "ss"
        );

        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.create(review);
            request.setAttribute("reviewList", null);
            return "/main/review.jsp"; /// 수정
        } catch (ExistingException e) { // 예외 발생 시
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("review", review);
            return "/review/review"; /// 수정
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
