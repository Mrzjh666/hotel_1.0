package hotel.com.jd.controller;

import hotel.com.jd.domain.Room;
import hotel.com.jd.service.RoomService;
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

@Controller
@RequestMapping("/jsp")
public class RoomController {
    @Autowired
    @Qualifier("roomService")
    private RoomService roomService;
    @RequestMapping(value = "/room/searchByRoomType")
    public ModelAndView searchByType(@RequestParam("roomType") String roomType,  @RequestParam(required = false)int currentPage,  @RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();
        ModelAndView mv= new ModelAndView();
        System.out.println(roomType+"controller");
        mv.addObject("allRoom",roomService.findRoomByType(roomType,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchRoom_type",roomType);
        mv.setViewName("/jsp/room//roomtable");
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
            mv.setViewName("/jsp/room/roomtable");
            return mv;
        }
    }
    @RequestMapping(value = "/room/openUpdate")
    public ModelAndView openUpdate(int room_id,ModelAndView mv){
        Room room = roomService.findRoomById(room_id);
        mv.addObject("room",room);
        mv.setViewName("/jsp/room/room_update");
        return mv;
    }
    @RequestMapping(value = "/room/update")
    public ModelAndView update( Room room, ModelAndView mv){
        try{
            System.out.println(room.toString()+"controller");
            roomService.update(room);
            mv.addObject("result","room更新成功");
        }catch (Exception e){
            mv.addObject("result","room更新失败");
        }
        finally {
            mv.addObject("room",room);
            mv.setViewName("/jsp/room/roomtable");
            return mv;
        }
    }
    @RequestMapping(value = "/room/delete")
    public ModelAndView delete(int room_id){
        ModelAndView mv = new ModelAndView();
        try{
            System.out.println("new in room_delete_controller");
            roomService.delete(room_id);
            mv.addObject("result","room删除成功");
        }
        catch (Exception e){
            mv.addObject("result","room删除失败");
            e.printStackTrace();
        }
        finally {
            mv.setViewName("/jsp/room//roomtable");
            return mv;
        }
    }
}
