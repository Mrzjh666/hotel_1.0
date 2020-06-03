package hotel.com.jd.mapper;

import hotel.com.jd.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
/**
 * UserMapper接口
 * @Author cyb
 * @Date 2020/5/31 21:29
 */

@Component
public interface UserMapper {
    //    @Select("select * from hotel.user where user_no=#{user_no}")
//    User findUserByName(@Param("user_no") String user_no);
//    /**获取总类型房间记录数，如果房间为空，访问所有记录数
//     * @info user_type
//     * @return 该类型房间个数
//     */
    @Select("select count(user_name) as AllRecord from hotel.user where user_name like concat('%',#{user_name},'%')")
    int getRecordNum(@Param("user_name") String user_name);
    /**
     * @param user_id
     * @return User对象，无就返回null
     */
    @Select("select * from hotel.user where user_id=#{user_id}")
    User findUserById(@Param("user_id") int user_id);

    /**
     * @info user_name  start_place size
     * @return User集合，其中全部该类型的房子
     */
    @Select("select * from hotel.user where user_name like concat('%',#{user_name},'%') limit #{start_place},#{size}")
    ArrayList<User> findUserByName(@Param("user_name") String user_name,@Param("start_place") int start_place,@Param("size")int size);
    @Update("update hotel.user set user_name=#{user_name},user_liveday=#{user_liveday},room_id=#{room_id} where user_id=#{user_id}")
    boolean update(User user);
    @Delete("delete from hotel.user where user_id=#{user_id}")
    boolean delete(@Param("user_id") int user_id);
    @Insert("insert into User(user_name,user_phone,user_liveday,room_id) values(#{user_name},#{user_phone},#{user_liveday},#{room_id})")
    boolean insert(User user);
    @Select("select user_id from hotel.user where user_phone=#{user_phone}")
    int getUserIdByPhone(@Param("user_phone") String user_phone);
}
