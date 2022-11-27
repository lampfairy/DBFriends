package controller.prod;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ProdManager;
import model.service.UserManager;
import model.Product;
import model.User;

public class DetailProdController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DetailProdController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String id = UserSessionUtils.getLoginUserId(request.getSession());
		UserManager manager = UserManager.getInstance();

		int prodId = Integer.parseInt(request.getParameter("prodId"));

		request.setAttribute("prodId", prodId);
		return "/prod/detail.jsp";
	}
}