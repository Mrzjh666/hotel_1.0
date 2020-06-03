package hotel.com.jd.mapper;

import hotel.com.jd.domain.Meal;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
/**
 * MealMapper接口
 * @Author cyb
 * @Date 2020/5/31 21:29
 */

@Component
public interface MealMapper {
//    @Select("select * from hotel.meal where meal_no=#{meal_no}")
//    Meal findMealByName(@Param("meal_no") String meal_no);
//    /**获取总类型房间记录数，如果房间为空，访问所有记录数
//     * @info meal_type
//     * @return 该类型房间个数
//     */
    @Select("select count(meal_name) as AllRecord from hotel.meal where meal_name like concat('%',#{meal_name},'%')")
    int getRecordNum(@Param("meal_name") String meal_name);
    /**
     * @param meal_id
     * @return Meal对象，无就返回null
     */
    @Select("select * from hotel.meal where meal_id=#{meal_id}")
    Meal findMealById(@Param("meal_id") int meal_id);

    /**
     * @info meal_name  start_place size
     * @return Meal集合，其中全部该类型的房子
     */
    @Select("select * from hotel.meal where meal_name like concat('%',#{meal_name},'%') limit #{start_place},#{size}")
    ArrayList<Meal> findMealByName(@Param("meal_name") String meal_name,@Param("start_place") int start_place,@Param("size")int size);
    @Update("update hotel.meal set meal_type=#{meal_type},meal_name=#{meal_name},meal_price=#{meal_price},meal_explain=#{meal_explain},meal_picpath=#{meal_picpath}hotel_id=#{hotel_id} where meal_id=#{meal_id}")
    boolean update(Meal meal);
    @Delete("delete from hotel.meal where meal_id=#{meal_id}")
    boolean delete(@Param("meal_id") int meal_id);
    @Insert("insert into Meal(meal_type,meal_name,meal_price,meal_explain,emp_id,meal_picpath,hotel_id) values(#{meal_type},#{meal_name},#{meal_price},#{meal_explain},#{emp_id},#{meal_picpath},#{hotel_id})")
    boolean insert(Meal meal);
}
