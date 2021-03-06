package hotel.com.jd.controller;

import hotel.com.jd.domain.Hotel;
import hotel.com.jd.service.HotelService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp")
public class HotelController {

    @Autowired
        @Qualifier("hotelService")
        private HotelService hotelService;
        @RequestMapping(value = "/hotel/searchHotelAll")
        public ModelAndView searchHotelAll( @RequestParam(required = false)int currentPage, @RequestParam(required = false) String delResult){
            PageParms parms = new PageParms();
            ModelAndView mv= new ModelAndView();
            mv.addObject("allHotel",hotelService.findHotelAll(currentPage,parms));
            mv.addObject("currentPage",parms.getCurrentPage());
            mv.addObject("allCount",parms.getAllCount());
            mv.addObject("allPageCount",parms.getAllPageCount());
            mv.setViewName("/jsp/hotel/hoteltable");
            return mv;
        }
        @RequestMapping("/hotel/openAdd")
        public String openAdd(){
            return "/jsp/hotel/hotel_add";
        }
        @RequestMapping("/hotel/save")
        public ModelAndView save(Hotel hotel, ModelAndView mv){
            try {
                System.out.println(hotel.toString()+"C");
                hotelService.insert(hotel);
                mv.addObject("result","hotel添加成功");
            }catch (Exception e){
                mv.addObject("result","hotel添加失败");
            }
            finally {
                mv.addObject("hotel_id",hotel.getHotel_id());
                mv.setViewName("/jsp/manager/manager_add");
                return mv;
            }
        }

        @RequestMapping(value = "/hotel/delete")
        public ModelAndView delete(@RequestParam("hotel_id") int hotel_id,@RequestParam("currentPage") int currentPage){
            ModelAndView mv = new ModelAndView();
            try{
                System.out.println("new in hotel_delete_controller");
                hotelService.delete(hotel_id);

                mv.addObject("result","hotel删除成功");
            }
            catch (Exception e){
                mv.addObject("result","hotel删除失败");
                e.printStackTrace();
            }
            finally {
                mv.setViewName("/jsp/hotel/hoteltable");
                return mv;
            }
        }
    }
