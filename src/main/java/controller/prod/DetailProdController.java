package controller.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Product;
import model.User;
import model.service.ProdManager;
import model.service.UserManager;
public class DetailProdController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DetailProdController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		String id = UserSessionUtils.getLoginUserId(request.getSession());
		if(id != null) {
			UserManager manager = UserManager.getInstance();
			User user = manager.findUser(id);
			request.setAttribute("user", user); 
		}

		int prodId = Integer.parseInt(request.getParameter("productId"));
		ProdManager prodManager = ProdManager.getInstance();
		Product product = prodManager.findProduct(prodId);
		request.setAttribute("product", product);

		return "/prod/detail.jsp";
	}
}