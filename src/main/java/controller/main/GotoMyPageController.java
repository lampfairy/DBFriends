package controller.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.service.UserManager;
import model.Reservation;
import model.service.ProdManager;
import model.Product;
import model.service.ReserveManager;

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
        
        ReserveManager rema = ReserveManager.getInstance();
        List<Reservation> reserveList = rema.findReservationList(id);
        request.setAttribute("user", user);    
        request.setAttribute("reserveList", reserveList); 

        // 사용자 리스트 화면으로 이동(forwarding)
        return "/main/myPage.jsp";
    }
}
