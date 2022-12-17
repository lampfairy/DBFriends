package controller;

import java.util.List;

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
		ProdManager prodManager = ProdManager.getInstance();
		int restaurant = prodManager.countingProduct(1);
		int activity = prodManager.countingProduct(2);
		int accommodation = prodManager.countingProduct(3);
		req.setAttribute("restaurant", restaurant);
		req.setAttribute("activity", activity);
		req.setAttribute("accommodation", accommodation);
		
		List<Product> prodList = prodManager.findNewProdList();
		List<Product> prodTOP10List = prodManager.findTOP10List();
		
		req.setAttribute("prodTOP1", prodTOP10List.get(0));
        req.setAttribute("prodTOP2", prodTOP10List.get(1));
        req.setAttribute("prodTOP3", prodTOP10List.get(2));
		
		req.setAttribute("product1", prodList.get(0));
		req.setAttribute("product2", prodList.get(1));
		req.setAttribute("product3", prodList.get(2));
		
        return forwardUrl;
    }
}
