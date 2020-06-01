package hotel.com.jd.service;

import hotel.com.jd.domain.Hotel;
import hotel.com.jd.domain.Room;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface HotelService {
    void insert(Hotel hotel);
    void update(Hotel hotel);
    void delete(int hotel_id);
    Hotel findHotelById(int hotel_id);
    /**
     * 修改酒店收入金额  用户入住调用Hotelservice
     * @param hotel_id
     * @return result=成功或者失败
     */
    void setHotelMealincome(int hotel_id,double money);
    /**
     * 修改酒店收入金额 菜品点餐成功Hotelservice
     * @param hotel_id
     * @return result=成功或者失败
     */
    void setHotelRoomincome(int hotel_id,double money);

    /**
     * 查找所有酒店，返回一页的酒店
     * @param currentPage
     * @param parms
     * @return
     */
    ArrayList<Hotel> findHotelAll(int currentPage, PageParms parms);
}
