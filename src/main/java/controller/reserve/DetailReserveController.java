package controller.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.service.ReserveManager;
import model.service.UserManager;

public class DetailReserveController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
        
        
        
        return "/reserve/detail.jsp";
    }
}
