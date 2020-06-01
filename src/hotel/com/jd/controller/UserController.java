package hotel.com.jd.controller;

import hotel.com.jd.domain.User;
import hotel.com.jd.service.UserService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController  {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping("/searchByName")
    public ModelAndView searchByName(String user_name, int currentPage, ModelAndView mv,@RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();
        mv.addObject("allUser",userService.findUserByName(user_name,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchUser_name",user_name);
        mv.setViewName("/user/usertable");
        return mv;
    }
    @RequestMapping("/openAdd")
    public String openAdd(){
        return "/user/user_add";
    }
    @RequestMapping("/save")
    public ModelAndView save(User user,ModelAndView mv){
        try {
            userService.insert(user);
            mv.addObject("result","user添加成功");
        }catch (Exception e){
            mv.addObject("result","user添加失败");
        }
        finally {
            mv.setViewName("/user/user_add");
            return mv;
        }
    }
    @RequestMapping(value = "/openUpdade")
    public ModelAndView openUpdate(int user_id,ModelAndView mv){
        User user = userService.findUserById(user_id);
        mv.addObject("user",user);
        mv.setViewName("/user/user_update");
        return mv;
    }
    @RequestMapping(value = "/update")
    public ModelAndView update(User user,ModelAndView mv){
        try{
            userService.update(user);
            mv.addObject("result","user更新成功");
        }catch (Exception e){
            mv.addObject("result","user更新失败");
        }
        finally {
            mv.addObject("user",user);
            mv.setViewName("user/user_update");
            return mv;
        }
    }
    @RequestMapping(value = "/delete")
    public ModelAndView delete(int user_id,String user_name,int currentPage,ModelAndView mv){
        String delResult ="";
        try{
            userService.delete(user_id);
            delResult= URLEncoder.encode("删除成功","utf-8");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            String url="../user/searchByName?user_name="+user_name+
                    "&currentPage="+currentPage+"&delResult="+delResult;
            mv.setView(new RedirectView(url));
            return mv;
        }
    }
}

