package controller.bookmark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.service.BookmarkManager;
import model.service.UserManager;

public class DeleteBookmarkController implements Controller{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        try {
        BookmarkManager manager = BookmarkManager.getInstance();
        manager.remove(user.getUserId(), productId);
        return "/main/myPage";
        }
        catch(Exception e){
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            return "/"; /// 수정
        }
    }
}
