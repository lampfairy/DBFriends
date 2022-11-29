package controller.prod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Product;
import model.service.ProdManager;

public class FindListProdController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProdManager prodManager = ProdManager.getInstance();
		int type1 = Integer.parseInt(request.getParameter("place"));
		int type2 = Integer.parseInt(request.getParameter("type"));
		int type3 = Integer.parseInt(request.getParameter("detail"));
		String keySearch = request.getParameter("keySearch");
		List<Product> prodList;
		if(keySearch == null) {
			prodList = prodManager.findProductList(type1, type2, type3);
			request.setAttribute("prodList", prodList);
			return "/";
		}
		else {
			prodList = prodManager.findProductListWithKey(type1, type2, type3, keySearch);
			request.setAttribute("prodList", prodList); 
			return "/main/reserve";
			
		}
}
	}