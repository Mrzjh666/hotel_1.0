package hotel.com.jd.mapper;

import hotel.com.jd.domain.Hotel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface HotelMapper {
    @Delete("delete from hotel.hotel where hotel_id=#{hotel_id}")
    public void delete(@Param("hotel_id")int hotel_id) ;
    @Update("update hotel.hotel set hotel_loc=#{hotel_loc},hotel_totalincome=#{hotel_totalincome},hotel_roomincome=#{hotel_roomincome},hotel_mealincome=#{hotel_mealincome} where hotel_id=#{hotel_id}")
    public void update(Hotel hotel) ;
    @Insert("insert into hotel_hotel(hotel_loc,hotel_totalincome,hotel_roomincome,hotel_mealincome) values(#{hotel_loc},#{hotel_totalincome},#{hotel_roomincome},#{hotel_mealincome})")
    public void insert(Hotel hotel) ;
    @Select("select * from hotel.hotel where hotel_id=#{hotel_id}")
    public Hotel findHotelById(@Param("hotel_id")int hotel_id) ;
    @Select("select count(*) as AllRecord from hotel.hotel")
    int getRecordNum();
    @Select("select * from hotel.hotel limit #{start_place},#{size}")
    ArrayList<Hotel> findHotelAll(@Param("start_place") int start_place,@Param("size") int size);
    @Update("update hotel.hotel set(hotel_totalincome,hotel_mealincome)values(hotel_totalincome+#{money},hotel_mealincome+#{money}where hotel_id=#{hotel_id}")
    void setHotelMealincome(@Param("hotel_id") int hotel_id, @Param("money") double money);
    @Update("update hotel.hotel set(hotel_totalincome,hotel_roomincome)values(hotel_totalincome+#{money},hotel_roomincome+#{money}where hotel_id=#{hotel_id}")
    void setHotelRoomincome(@Param("hotel_id") int hotel_id, @Param("money") double money);
}
