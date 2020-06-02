package hotel.com.jd.mapper;

import hotel.com.jd.domain.Manager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface ManagerMapper {
    /**
     * 姓名密码查询管理员，找到返回manager,失败返回null
     * @param loginName
     * @param password
     * @return
     */
    @Select("select * from hotel.manager where manager_account = #{loginName} and manager_password = #{password}")
    Manager findManager(@Param("loginName") String loginName,@Param("password") String password);
    @Select("select count(manager_name) as AllRecord from hotel.manager where manager_name like concat('%',#{manager_name},'%')")
    int getRecordNum(@Param("manager_name") String manager_name);
    @Select("select * from hotel.manager where manager_name like concat('%',#{manager_name},'%') limit #{start_place},#{size}")
    ArrayList<Manager> findManagerByName(@Param("manager_name") String manager_name,@Param("start_place") int start_place,@Param("size") int size);
    @Insert("insert in hotel.manager (manager_name,manager_account,manager_password,manager_phone,hotel_id) values(#{manager_name},#{manager_account},#{manager_password},#{manager_phone},#{hotel_id}) where manager_id=#{manager_id}")
    void insert(Manager manager);
    @Select("select * from hotel.manager where manager_id=#{manager_id}")
    Manager findManagerById(int manager_id);
    @Update("update hotel.manager set manager_name=#{manager_name},manager_account=#{manager_account},manager_password=#{manager_password},manager_phone=#{manager_phone},hotel_id=#{hotel_id} where manager_id=#{manager_id}")
    void update(Manager manager);
    @Delete("delete from hotel.manager where manager_id=#{manager_id}")
    void delete(int manager_id);
}
