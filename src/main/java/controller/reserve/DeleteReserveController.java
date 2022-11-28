package controller.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.ReserveManager;

public class DeleteReserveController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int deleteId = Integer.parseInt(request.getParameter("reservationId"));

		ReserveManager manager = ReserveManager.getInstance();		
		HttpSession session = request.getSession();	
	
//		if ((UserSessionUtils.isLoginUser("admin", session) && 	// 로그인한 사용자가 관리자이고 	
//			 !deleteId.equals("admin"))							// 삭제 대상이 일반 사용자인 경우, 
//			   || 												// 또는 
//			(!UserSessionUtils.isLoginUser("admin", session) &&  // 로그인한 사용자가 관리자가 아니고 
//			  UserSessionUtils.isLoginUser(deleteId, session))) { // 로그인한 사용자가 삭제 대상인 경우 (자기 자신을 삭제)
				
			manager.remove(deleteId); // 예약 내역 삭제
			return "redirect:/user/list"; //수정
//		}
	}
}
