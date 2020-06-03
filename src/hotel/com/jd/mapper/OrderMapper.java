package hotel.com.jd.mapper;

import hotel.com.jd.domain.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface OrderMapper {
    @Insert("insert into hotel.orders (order_type,order_price,date,user_id)values(#{order_type},#{order_price},#{date},#{user_id})")
    void insert(Orders order);
    @Select("select * from hotel.orders where order_id=#{order_id}")
    Orders findOrderById(@Param("order_id") int order_id);
    @Delete("delete from hotel.orders where order_id = #{order_id}")
    void delete(@Param("order_id") int order_id);
    @Select("select count(order_type) as AllRecord from hotel.orders where order_type like contat('%', #{order_type},'%')")
    int getRecordNum(@Param("order_type") String order_type);
    @Select("select * from hotel.orders where order_type like concat('%',#{order_type},'%') limit #{start_place},#{size}")
    ArrayList<Orders> findRoomByType(@Param("order_type") String order_type,@Param("start_place") int start_place,@Param("size") int size);
}
