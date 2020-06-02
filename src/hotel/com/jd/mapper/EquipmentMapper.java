package hotel.com.jd.mapper;

import hotel.com.jd.domain.Equipment;
import hotel.com.jd.domain.Room;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * RoomMapper接口
 * @author zhu
 */
@Component
public interface EquipmentMapper {
    @Select("select count(equ_type) as AllRecord from hotel.equipment where equ_type like concat('%',#{equ_type},'%')")
    int getRecordNum(@Param("equ_type") String equ_type);
    /**
     * @param equ_id
     * @return Room对象，无就返回null
     */
    @Select("select * from hotel.equipment where equ_id=#{equ_id}")
    Equipment findEquipmentById(@Param("equ_id") int equ_id);

    /**
     * @info room_type  start_place size
     * @return Room集合，其中全部该类型的房子
     */
    @Select("select * from hotel.equipment where equ_type like concat('%',#{equ_type},'%') limit #{start_place},#{size}")
    ArrayList<Equipment> findEquipmentByType(@Param("equ_type") String equ_type, @Param("start_place") int start_place, @Param("size")int size);
    @Update("update hotel.equipment set equ_type=#{equ_type},equ_name=#{equ_name},equ_num=#{equ_num},equ_explain=#{equ_explain},equ_mark=#{equ_mark},emp_id=#{emp_id} where equ_id=#{equ_id}")
    boolean update(Equipment equipment);
    @Delete("delete from hotel.equipment where equ_id=#{equ_id}")
    boolean delete(@Param("equ_id") int equ_id);
    @Insert("insert into hotel.equipment (equ_type,equ_name,equ_num,equ_explain,equ_mark,equ_picpath,emp_id) values(#{equ_type},#{equ_name},#{equ_num},#{equ_explain},#{equ_mark},#{equ_picpath},#{emp_id})")
    boolean insert(Equipment equipment);
}

