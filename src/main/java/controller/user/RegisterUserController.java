package controller.user;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.ExistingException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       

        // POST request (회원정보가 parameter로 전송됨)
//        SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = transformDate(request.getParameter("birthDate"));
        User user = new User(
                request.getParameter("name"),
                request.getParameter("userId"),
                request.getParameter("userPw"),
                request.getParameter("phoneNumber"),
                request.getParameter("emailAddress"),
                date,
                request.getParameter("bankName"),
                request.getParameter("nameOnAccount"),
                request.getParameter("accountNumber")
                );

//        AccountDetails ad = new AccountDetails(
//                request.getParameter("userId"),
//                request.getParameter("bankName"),
//                request.getParameter("name"),
//                request.getParameter("accountNumber")
//                );

        try {
            UserManager manager = UserManager.getInstance();
            manager.create(user);
            return "redirect:/user/loginForm";   // 성공 시 사용자 리스트 화면으로 redirect

        } catch (ExistingException e) {   // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("user", user);
            return "/user/registerForm.jsp";
        }
    }
//    
    public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyy-mm-dd");
        
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