package hotel.com.jd.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import hotel.com.jd.domain.Manager;
import hotel.com.jd.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpSession;
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping(value="/manager/login")
    public String login(@Param("manager_account") String manager_account,@Param("manager_password")String  manager_password,
                              ModelAndView mv, HttpSession session){
        System.out.println("now login"+manager_account+"////\\\\\\\\\\"+manager_password);
        Manager manager = managerService.login(manager_account,manager_password);
        if(manager != null)
        {
            // 登录成功，将user对象设置到HttpSession作用范围域
            session.setAttribute("manager", manager);
//            mv.setViewName("/index2");
            return "/index2";
        }
        else
        {
            // 登录失败，设置失败提示信息，并跳转到登录页面
//            mv.setView(new RedirectView("/login.html"));
            return "/login.html";
        }
//        return mv;
    }
    @RequestMapping("/manager/link")
    public String link(){
        return "index2";
    }

}
