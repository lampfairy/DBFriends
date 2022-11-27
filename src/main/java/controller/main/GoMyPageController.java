package controller.main;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.service.UserManager;

public class GoMyPageController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		//login 사용자만 볼 수 있도록

		if (request.getMethod().equals("GET")) {
			String updateId = request.getParameter("userId");

			UserManager manager = UserManager.getInstance();
			User user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("user", user);

			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(updateId, session) ||
					UserSessionUtils.isLoginUser("admin", session)) {
				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능

				return "/main/myPage.jsp";   // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송     
			}    

			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "/user/view.jsp";
		}

		// POST request (회원정보가 parameter로 전송됨)
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		User updateUser = new User(
				request.getParameter("name"),
				request.getParameter("userId"),
				request.getParameter("userPW"),
				request.getParameter("phoneNumber"),
				request.getParameter("emailAddress"),
				transFormat.parse(request.getParameter("birthDate"))
				);

		UserManager manager = UserManager.getInstance();
		manager.update(updateUser);

		//찜, 예약, 다녀온 곳 불러오기

		return "redirect:/user/list";
	}
}
