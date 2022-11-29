package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.service.ProdManager;

public class ForwardController implements Controller {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
        this.forwardUrl = forwardUrl;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		ProdManager prodManager = ProdManager.getInstance();
//		int restaurant = prodManager.countingProduct(1);
//		int activity = prodManager.countingProduct(2);
//		int accommodation = prodManager.countingProduct(3);
//		req.setAttribute("restaurant", restaurant);
//		req.setAttribute("activity", activity);
//		req.setAttribute("accommodation", accommodation);
		
        return forwardUrl;
    }
}
