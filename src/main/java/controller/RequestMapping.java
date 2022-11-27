package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.main.GotoMyPageController;
import controller.prod.findProdController;
import controller.user.ListUserController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.RegisterUserController;
import controller.user.UpdateUserController;
import controller.user.UpdateUserFormController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        //    	 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("/main/index.jsp"));
        mappings.put("/user/loginForm", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/main/myPage", new GotoMyPageController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/prod/list", new findProdController());
        //        mappings.put("/user/view", new ViewUserController());
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());
//        mappings.put("/user/update/form", new UpdateUserFormController());
        mappings.put("/user/update", new UpdateUserController());
        //        mappings.put("/user/delete", new DeleteUserController());

        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
        // 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
