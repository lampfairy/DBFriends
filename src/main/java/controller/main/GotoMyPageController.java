package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.service.UserManager;
import model.Reservation;
import model.Review;
import model.service.BookmarkManager;
import model.service.ProdManager;
import model.Bookmark;
import model.Product;
import model.service.ReserveManager;
import model.service.ReviewManager;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GotoMyPageController implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/loginForm";     // login form 요청으로 redirect
        }

        /*
        String currentPageStr = request.getParameter("currentPage");    
        int currentPage = 1;
        if (currentPageStr != null && !currentPageStr.equals("")) {
            currentPage = Integer.parseInt(currentPageStr);
        }       
         */

        // List<User> userList = manager.findUserList(currentPage, countPerPage);

        // userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달 
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager manager = UserManager.getInstance();
        User user = manager.findUser(id);

        BookmarkManager boma = BookmarkManager.getInstance();
        List<Bookmark> bookmarkList = boma.findUserBookmarkList(id);
        request.setAttribute("bookmarkList", bookmarkList); 

        ReserveManager reservema = ReserveManager.getInstance();
        List<Reservation> reservationList = reservema.findReservationList(id);
        request.setAttribute("user", user);

        List<Reservation> reserveList = new ArrayList<Reservation>();
        List<Reservation> visitedList = new ArrayList<Reservation>();
        
        ReviewManager reviewma = ReviewManager.getInstance();

        if(reservationList != null) {
            LocalDateTime now = LocalDateTime.now();
            String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date nowDate = transformDate(formatedNow);

            for(int i = 0; i < reservationList.size(); i++) {
                Reservation reservation = reservema.findReservation(reservationList.get(i).getReservationId());
                if(reservation.getEndDate().compareTo(nowDate) < 0 && !reviewma.existingReview(reservation.getReservationId())) {
                    visitedList.add(reservation);
                }
                else if(reservation.getEndDate().compareTo(nowDate) >= 0){  
                    reserveList.add(reservation);
                }
            }
        }

        request.setAttribute("reserveList", reserveList); 
        request.setAttribute("visitedList", visitedList); 

        // 사용자 리스트 화면으로 이동(forwarding)
        return "/main/myPage.jsp";
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
