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
		try {
		ProdManager prodManager = ProdManager.getInstance();
        int type = Integer.parseInt(request.getParameter("type"));
        List<Product> prodList = prodManager.findProductList(type);
        //List<Product> prodList = prodManager.findProductList(currentPage, countPerPage);

        // userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
        request.setAttribute("prodList", prodList);  

        // 사용자 리스트 화면으로 이동(forwarding)
        return "/prod/list.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			return "/main/index.jsp";
		}
	}
}