package controller.bookmark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Bookmark;
import model.Product;
import model.User;
import model.service.BookmarkManager;
import model.service.ExistingException;
import model.service.ProdManager;
import model.service.UserManager;

public class InsertBookmarkController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = UserSessionUtils.getLoginUserId(request.getSession());
        UserManager umanager = UserManager.getInstance();
        User user = umanager.findUser(id);
        request.setAttribute("user", user);
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProdManager prma = ProdManager.getInstance();
        Product product = prma.findProduct(productId);
        
        Bookmark bookmark = new Bookmark(
                user.getUserId(),
                productId,
                product.getName()
        );
        
        try {
            BookmarkManager manager = BookmarkManager.getInstance();
            manager.create(bookmark);
            return "redirect:/prod/detail?productId=" + productId;
        } catch (ExistingException e) { // 예외 발생 시
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("bookmark", bookmark);
            return "redirect:/prod/detail?productId=" + productId; /// 수정
        }
    }
}
