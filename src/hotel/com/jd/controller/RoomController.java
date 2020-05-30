package hotel.com.jd.controller;

import hotel.com.jd.domain.Room;
import hotel.com.jd.service.RoomService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;

@Controller
@RequestMapping("/jsp")
public class RoomController {
    @Autowired
    @Qualifier("roomService")
    private RoomService roomService;
    @RequestMapping(value = "/room/searchByType")
    public ModelAndView searchByType(@RequestParam(value = "roomType",required = false) String room_type, int currentPage, ModelAndView mv, @RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();

        mv.addObject("allRoom",roomService.findRoomByType(room_type,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchRoom_type",room_type);
        mv.setViewName("/roomtable");
        return mv;
    }
    @RequestMapping("/room/openAdd")
    public String openAdd(){
        return "/jsp/room/room_add";
    }
    @RequestMapping("/room/save")
    public ModelAndView save(Room room,ModelAndView mv){
        try {
            roomService.insert(room);
            mv.addObject("result","room添加成功");
        }catch (Exception e){
            mv.addObject("result","room添加失败");
        }
        finally {
            mv.setViewName("/room/room_add");
            return mv;
        }
    }
    @RequestMapping(value = "/room/openUpdade")
    public ModelAndView openUpdate(int room_id,ModelAndView mv){
        Room room = roomService.findRoomById(room_id);
        mv.addObject("room",room);
        mv.setViewName("/jsp/room/room_update");
        return mv;
    }
    @RequestMapping(value = "/room/update")
    public ModelAndView update(Room room,ModelAndView mv){
        try{
            roomService.update(room);
            mv.addObject("result","room更新成功");
        }catch (Exception e){
            mv.addObject("result","room更新失败");
        }
        finally {
            mv.addObject("room",room);
            mv.setViewName("room_update");
            return mv;
        }
    }
    @RequestMapping(value = "/room/delete")
    public ModelAndView delete(int room_id,String room_type,int currentPage,ModelAndView mv){
        String delResult ="";
        try{
            roomService.delete(room_id);
            delResult= URLEncoder.encode("删除成功","utf-8");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            String url="./room/searchByType?room_type="+room_type+
                    "&currentPage="+currentPage+"&delResult="+delResult;
            mv.setView(new RedirectView(url));
            return mv;
        }
    }
}
