package hotel.com.jd.mapper;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 15:25
 */
import hotel.com.jd.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
/**
 * EmployeeMapper接口
 * @Author cyb
 * @Date 2020/5/31 21:29
 */

@Component
public interface EmployeeMapper {
    //    @Select("select * from hotel.employee where employee_no=#{employee_no}")
//    Employee findEmployeeByName(@Param("employee_no") String employee_no);
//    /**获取总类型房间记录数，如果房间为空，访问所有记录数
//     * @info employee_type
//     * @return 该类型房间个数
//     */
    @Select("select count(emp_name) as AllRecord from hotel.employee where emp_name like concat('%',#{emp_name},'%')")
    int getRecordNum(@Param("emp_name") String employee_name);
    /**
     * @param emp_id
     * @return Employee对象，无就返回null
     */
    @Select("select * from hotel.employee where emp_id=#{emp_id}")
    Employee findEmployeeById(@Param("emp_id") int emp_id);

    /**
     * @info employee_name  start_place size
     * @return Employee集合，其中全部该类型的房子
     */
    @Select("select * from hotel.employee where emp_name like concat('%',#{emp_name},'%') limit #{start_place},#{size}")
    ArrayList<Employee> findEmployeeByName(@Param("emp_name") String employee_type,@Param("start_place") int start_place,@Param("size")int size);
    @Update("update hotel.employee set emp_name=#{emp_name},emp_phone=#{emp_phone},emp_no=#{emp_no},emp_pos=#{emp_pos},emp_salary=#{emp_salary},hotel_id=#{hotel_id} where emp_id=#{emp_id}")
    boolean update(Employee employee);
    @Delete("delete from hotel.employee where emp_id=#{emp_id}")
    boolean delete(@Param("emp_id") int emp_id);
    @Insert("insert into Employee(emp_name,emp_phone,emp_no,emp_pos,emp_salary,hotel_id) values(#{emp_name},#{emp_phone},#{emp_no},#{emp_pos},#{emp_salary},#{hotel_id})")
    boolean insert(Employee employee);
}

