package controller.prod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Product;
import model.service.ProdManager;

public class findProdController implements Controller {
//	private static final int countPerPage = 10; // 한 화면에 출력할 사용자 수

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String currentPageStr = request.getParameter("currentPage");    
//		int currentPage = 1;
//		if (currentPageStr != null && !currentPageStr.equals("")) {
//			currentPage = Integer.parseInt(currentPageStr);
//		}       

		ProdManager prodManager = ProdManager.getInstance();
		List<Product> prodList = prodManager.findProductList();
		//         List<Product> prodList = prodManager.findProductList(currentPage, countPerPage);

		// userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("prodList", prodList);  

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/prod/list.jsp";        
	}
}