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
import model.service.UserManager;
import model.User;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
// 
//    	if (request.getMethod().equals("GET")) {	
//    		// GET request: 회원정보 수정 form 요청	
//    		// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
//    		String updateId = request.getParameter("userId");
//
//    		log.debug("UpdateForm Request : {}", updateId);
//    		
//    		UserManager manager = UserManager.getInstance();
//			User user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
//			request.setAttribute("user", user);			
//
//			HttpSession session = request.getSession();
//			if (UserSessionUtils.isLoginUser(updateId, session) ||
//				UserSessionUtils.isLoginUser("admin", session)) {
//				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
//				
//				return "/user/updateForm.jsp";   // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송     
//			}    
//			
//			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
//			request.setAttribute("updateFailed", true);
//			request.setAttribute("exception", 
//					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
//			return "/user/view.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
//	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
        
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager manager = UserManager.getInstance();
        
    	Date date = transformDate(request.getParameter("birthDate"));
        User updateUser = new User(
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

    	log.debug("Update User : {}", updateUser);
		manager.update(updateUser);
		request.setAttribute("user", updateUser);
        return "/main/myPage.jsp";
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