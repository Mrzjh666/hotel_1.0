package hotel.com.jd.mapper;
import hotel.com.jd.domain.Room;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * RoomMapper接口
 * @author zhu
 */
@Component
public interface RoomMapper {
    /**
     * @info String
     *      room_no
     * @return Room对象，没找到返回null
     */
    @Select("select * from hotel.room where room_no=#{room_no}")
    Room findRoomByNo(@Param("room_no") String room_no);
    /**获取总类型房间记录数，如果房间为空，访问所有记录数
     * @info room_type
     * @return 该类型房间个数
     */
    @Select("select count(room_type) as AllRecord from hotel.room where room_type like concat('%',#{room_type},'%')")
    int getRecordNum(@Param("room_tyoe") String room_type);
    /**
     * @param room_id
     * @return Room对象，无就返回null
     */
    @Select("select * from hotel.room where room_id=#{room_id}")
    Room findRoomById(@Param("room_id") int room_id);

    /**
     * @info room_type  start_place size
     * @return Room集合，其中全部该类型的房子
     */
    @Select("select * from hotel.room where room_type like concat('%',#{room_type}),'%' limit #{start_place},#{size}")
    ArrayList<Room> findRoomByType(@Param("room_type") String room_type,@Param("start_place") int start_place,@Param("size")int size);
    /**
     * @info room_type room_flag start_place size
     * @return Room集合 该类型未入住房间
     */
    @Select("select * from hotel.room where room_type like concat('%',#{room_type}),'%' having room_flag like concat('%',room_flag,'%') limit #{start_place},#{size}")
    ArrayList<Room> findRoomByTypeAndFlag(@Param("room_type") String room_type,@Param("room_flag") String room_flag,@Param("start_place") int start_place,@Param("size")int size);
    @Update("update hotel.room set room_type=#{room_type},room_area=#{room_area},room_price=#{room_price},room_no=#{room_no},room_flag=#{room_flag},hotel_id={hotel_id} where room_id={room_id}")
    boolean update(Room room);
    @Delete("delete from hotel.room where room_id=#{room_id}")
    boolean delete(@Param("room_id") int room_id);
    @Insert("insert into Room(room_type,room_area,room_price,room_no,room_flag,hotel_id) values(#{room_type},#{room_area},#{room_price},#{room_no},#{room_flag},#{hotel_id})")
    boolean insert(Room room);
}
