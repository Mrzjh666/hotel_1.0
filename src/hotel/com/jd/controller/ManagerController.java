package hotel.com.jd.controller;

import hotel.com.jd.util.PageParms;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import hotel.com.jd.domain.Manager;
import hotel.com.jd.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
@Controller("/jsp")
public class ManagerController {
    @Autowired
    @Qualifier("managerService")
    private ManagerService managerService;
    @RequestMapping(value="/manager/login")
    public String login(@Param("manager_account") String manager_account,@Param("manager_password")String  manager_password,
                              ModelAndView mv, HttpSession session){
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
    @RequestMapping(value = "/manager/link")
    public String link(){
        return "index2";
    }
    @RequestMapping(value = "/manager/findManager")
    public ModelAndView findManagerByName(@RequestParam("managerName") String manager_name,@RequestParam(required=false ) int currentPage){
        ModelAndView mv = new ModelAndView();
        PageParms parms = new PageParms();
        mv.addObject("allManager",managerService.findManagerByName(manager_name,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchManager_name",manager_name);
        mv.setViewName("/jsp/manager/managertable");
        return mv;
    }
    @RequestMapping(value = "/manager/save")
    public ModelAndView save(Manager manager, ModelAndView mv){
        try {
            managerService.insert(manager);
            mv.addObject("result","manager添加成功");
        }catch (Exception e){
            mv.addObject("result","manager添加失败");
        }
        finally {
            mv.setViewName("/jsp/manager/managertable");
            return mv;
        }
    }
    @RequestMapping(value = "/manager/openAdd")
    public String openAdd(){
        return "/jsp/manager/manager_add";
    }
    @RequestMapping(value = "/manager/openUpdate")
    public ModelAndView openUpdate(int manager_id,ModelAndView mv){
        Manager manager = managerService.findManagerById(manager_id);
        mv.addObject("manager",manager);
        mv.setViewName("/jsp/manager/manager_update");
        return mv;
    }
    @RequestMapping(value = "/manager/update")
    public ModelAndView update( Manager manager, ModelAndView mv){
        try{

            managerService.update(manager);
            mv.addObject("result","manager更新成功");
        }catch (Exception e){
            mv.addObject("result","manager更新失败");
        }
        finally {
            mv.addObject("manager",manager);
            mv.setViewName("/jsp/manager/managertable");
            return mv;
        }
    }
    @RequestMapping("/manager/delete")
    public ModelAndView delete(int manager_id, HttpSession session){
        ModelAndView mv = new ModelAndView();
        Manager manager = (Manager) session.getAttribute("manager");
        try{
            if(manager.getHotel_id()==manager_id){
                mv.addObject("result","manager是本人，删除失败");
            }
            else {
                managerService.delete(manager_id);
                mv.addObject("result", "manager删除成功");
            }
        }
        catch (Exception e){
            mv.addObject("result","manager删除失败");
            e.printStackTrace();
        }
        finally {
            mv.setViewName("/jsp/manager//managertable");
            return mv;
        }
    }

}
