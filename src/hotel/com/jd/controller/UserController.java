package hotel.com.jd.controller;

import hotel.com.jd.domain.User;
import hotel.com.jd.service.UserService;
import hotel.com.jd.util.PageParms;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 8:41
 */

@Controller
@RequestMapping("/jsp")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(value = "/user/searchByUserName")
    public ModelAndView searchByName(@RequestParam("userName") String userName, @RequestParam(required = false)int currentPage, @RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();
        ModelAndView mv= new ModelAndView();
        System.out.println(userName+"controller");
        mv.addObject("allUser",userService.findUserByName(userName,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchUser_name",userName);
        mv.setViewName("/jsp/user//usertable");
        return mv;
    }
    @RequestMapping("/user/openAdd")
    public String openAdd(){
        return "/jsp/user/user_add";
    }
    @RequestMapping("/user/save")
    public ModelAndView save(User user, ModelAndView mv){
        try {
            userService.insert(user);
            mv.addObject("result","user添加成功");
        }catch (Exception e){
            mv.addObject("result","user添加失败");
        }
        finally {
            mv.setViewName("/jsp/user/usertable");
            return mv;
        }
    }
    @RequestMapping(value = "/user/openUpdate")
    public ModelAndView openUpdate(int user_id,ModelAndView mv){
        User user = userService.findUserById(user_id);
        mv.addObject("user",user);
        mv.setViewName("/jsp/user/user_update");
        return mv;
    }
    @RequestMapping(value = "/user/update")
    public ModelAndView update( User user, ModelAndView mv){
        try{
            System.out.println(user.toString()+"controller");
            userService.update(user);
            mv.addObject("result","user更新成功");
        }catch (Exception e){
            mv.addObject("result","user更新失败");
        }
        finally {
            mv.addObject("user",user);
            mv.setViewName("/jsp/user/usertable");
            return mv;
        }
    }
    @RequestMapping(value = "/user/delete")
    public ModelAndView delete(int user_id){
        ModelAndView mv = new ModelAndView();
        try{
            System.out.println("new in user_delete_controller");
            userService.delete(user_id);
            mv.addObject("result","user删除成功");
        }
        catch (Exception e){
            mv.addObject("result","user删除失败");
            e.printStackTrace();
        }
        finally {
            mv.setViewName("/jsp/user//usertable");
            return mv;
        }
    }
}


