package controller.user;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ExistingException;
import model.service.UserManager;
import model.User;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        
    	Date date = transformDate(request.getParameter("birthDate"));
        User updateUser = new User(
                request.getParameter("name"),
                id,
                request.getParameter("userPw"),
                request.getParameter("phoneNumber"),
                request.getParameter("emailAddress"),
                date,
                request.getParameter("bankName"),
                request.getParameter("nameOnAccount"),
                request.getParameter("accountNumber")
        );
        
        try {
            UserManager manager = UserManager.getInstance();
            manager.update(updateUser);
            return "redirect:/main/myPage";
        } catch (Exception e) {
            request.setAttribute("updateFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("user", updateUser);
            return "/main/myPage.jsp";
        }
        
    	//log.debug("Update User : {}", updateUser);
    }
    
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