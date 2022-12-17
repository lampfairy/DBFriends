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
import model.Product;
import model.Reservation;
import model.Review;
import model.User;
import model.service.ExistingException;
import model.service.ProdManager;
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
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        Review review = new Review(
                request.getParameter("title"),
                reservationId,
                user.getUserId(),
                productId,
                request.getParameter("productName"),
                null,
                r.getStartDate(),
                r.getEndDate(),
                Float.parseFloat(request.getParameter("rating")),
                request.getParameter("content")
        );

        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.create(review);
            
            float rating = Float.parseFloat(manager.findRating(productId));
            ProdManager pMa = ProdManager.getInstance();
            Product p = pMa.findProduct(review.getProductId());
            p.setRating(rating);
            pMa.update(p);
            
            return "/main/review"; /// 수정
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

