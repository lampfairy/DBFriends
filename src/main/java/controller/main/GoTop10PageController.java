package controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Product;
import model.User;
import model.service.ProdManager;
import model.service.UserManager;

public class GoTop10PageController implements Controller {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 // 로그인 여부 확인
        if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/loginForm";     // login form 요청으로 redirect
        }
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager manager = UserManager.getInstance();
        User user = manager.findUser(id);
        request.setAttribute("user", user);  
        
        ProdManager prodManager = ProdManager.getInstance();
        List<Product> prodList = prodManager.findProductList();
        request.setAttribute("prodList", prodList);
	    
		return "/main/top10.jsp";
    }
}
