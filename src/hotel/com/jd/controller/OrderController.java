package hotel.com.jd.controller;

import hotel.com.jd.domain.Orders;
import hotel.com.jd.domain.Room;
import hotel.com.jd.domain.User;
import hotel.com.jd.service.HotelService;
import hotel.com.jd.service.OrderService;
import hotel.com.jd.service.RoomService;
import hotel.com.jd.service.UserService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/jsp")
public class OrderController {
   @Autowired
   @Qualifier(value = "orderService")
   private OrderService orderService;
   @Autowired
   @Qualifier(value = "hotelService")
   private HotelService hotelService;
   @Autowired
   @Qualifier(value = "userService")
   private UserService userService;
   @Autowired
   private RoomService roomService;
   private final int OrderOk = 1;//生成成功
   private final int OrderDef = 2;//生成失败
   @RequestMapping("/order/newOrder")
   /**
    * 生成订单
    * @param user_id从session获取
    * @param order_type    people  order_price 订单人数信息 日期cortroller自己获取
    */
   public ModelAndView newOrder(@RequestParam(value = "order_type",required = false) String order_type, double order_price, int people, HttpSession session) {
      ModelAndView mv = new ModelAndView();
      int user_id = (int) session.getAttribute("user_id");
      try {
         Orders order = new Orders();
         Date date1 = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         String date = simpleDateFormat.format(date1);
         order.setOrder_price(order_price*people);
         order.setUser_id(user_id);
         order.setOrder_type(order_type);
         order.set_date(date);
         orderService.newOrder(order);
         mv.addObject("Orderresult", OrderOk);
      } catch (Exception e) {
         mv.addObject("Orderresult", OrderDef);
      }finally {
         return mv;
      }
   }
   @RequestMapping("/order/searchOrderByType")
   public ModelAndView searchOrderByType(@RequestParam("order_type") String order_type,@RequestParam(required = false)int currentPage){
      PageParms parms = new PageParms();
      ModelAndView mv= new ModelAndView();
      mv.addObject("allOrder",orderService.findOrderByType(order_type,currentPage,parms));
      mv.addObject("currentPage",parms.getCurrentPage());
      mv.addObject("allCount",parms.getAllCount());
      mv.addObject("allPageCount",parms.getAllPageCount());
      mv.addObject("searchOrder_type",order_type);
      mv.setViewName("/jsp/order//ordertable");
      return mv;
   }
   /**
    * @param order_id
    * 查找用户，房间，间接确定酒店
    * 删除订单，修改金额
    */
   @RequestMapping("/order/backOrderById")
   public ModelAndView backOrderById(@RequestParam("order_id") int order_id){
      ModelAndView mv = new ModelAndView();
      try {
         Orders order = orderService.findOrderById(order_id);
         User user = userService.findUserById(order.getUser_id());
         orderService.delete(order.getOrder_id());
         Room room = roomService.findRoomById(user.getRoom_id());
         if(order.getOrder_type().equals("room"))
         {
            hotelService.setHotelRoomincome(room.getHotel_id(),order.getOrder_price()*(-1));
         }else {
            hotelService.setHotelMealincome(room.getHotel_id(),order.getOrder_price()*(-1));
         }
         mv.addObject("result","退订成功");
      }catch (Exception e){
         mv.addObject("result","退订失败");
      }finally {
         mv.setViewName("/jsp/order/ordertable");
         return mv;
      }
   }
}
