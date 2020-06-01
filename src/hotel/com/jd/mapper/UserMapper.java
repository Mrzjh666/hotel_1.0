package hotel.com.jd.mapper;

import hotel.com.jd.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * RoomMapper接口
 * @author zhu
 */
@Component
public interface UserMapper {
    /**
     * @info String
     *      user_id
     * @return User对象，没找到返回null
     */
    @Select("select * from hotel.user where user_id=#{user_id}")
    User findUserById(@Param("user_id") int user_id);

    @Select("select count(user_name) as AllRecord from hotel.user where user_name like concat('%',#{user_name},'%')")
    int getRecordNum(@Param("user_name") String user_name);

    @Select("select * from hotel.user where user_name like concat('%',#{user_name}),'%' limit #{start_place},#{size}")
    ArrayList<User> findUserByName(@Param("user_name") String user_name,@Param("start_place") int start_place,@Param("size")int size);
    @Update("update hotel.room set room_name=#{user_name},user_phone=#{user_phone},user_liveday=#{user_liveday},room_id=#{room_id} where user_id={user_id}")
    boolean update(User user);
    @Delete("delete from hotel.user where user_id=#{user_id}")
    boolean delete(@Param("user_id") int user_id);
    @Insert("insert into User(user_name,user_phone,user_liveday,room_id) values(#{user_name},#{user_phone},#{user_liveday},#{room_id})")
    boolean insert(User user);
}