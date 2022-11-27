package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class GoTop10PageController implements Controller {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

		return "/main/top10.jsp";
    }
}
