package hotel.com.jd.mapper;

import hotel.com.jd.domain.Meal;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface MealMapper {

    @Insert("insert into meal(meal_type,meal_name,meal_explain,emp_id,meal_picpath,hotel_id,hotel_name,hotel_grade) value (#{meal_type},#{meal_name},#{meal_explain},#{emp_id},#{meal_picpath},#{hotel_id},#{hotel_name},#{hotel_grade})")
    boolean insert(Meal m);

    @Delete("DELETE FROM hotel.meal WHERE meal_id = #{meal_id}")
    boolean delete(@Param("meal_id")int meal_id);

    @Update("update hotel.meal set meal_type=#{meal_type},meal_name=#{meal_name},meal_explain=#{meal_explain},emp_id=#{emp_id},meal_picpath=#{meal_picpath},hotel_id=#{hotel_id},hotel_name=#{hotel_name},hotel_grade=#{hotel_grade} WHERE meal_id=#{meal_id}")
    boolean update(Meal m);

    @Select("select * from hotel.meal where meal_id=#{meal_id}")
    List<Meal> getMealByid(@Param("meal_id")int meal_id);

    @Select("select count(meal_type) as AllRecord from hotel.meal where meal_type like concat('%',#{meal_type},'%')")
    int getRecordNum(@Param("meal_type")String meal_type);

    @Select("select * from hotel.meal where meal_type like concat('%',#{meal_type},'%') limit #{start_place},#{size}")
    ArrayList<Meal> findMealByType(@Param("meal_type")String meal_type, @Param("start_place") int start_place, @Param("size")int size);

    @Select("select count(hotel_id) as AllRecord from hotel.meal where hotel_id=#{hotel_id}")
    int getRecordNumByid(@Param("hotel_id")int hotel_id);

    @Select("select * from hotel.meal where hotel_id=#{hotel_id} limit #{start_place},#{size}")
    ArrayList<Meal> findMealByHotel_id(int hotel_id, @Param("start_place") int start_place, @Param("size")int size);
}
