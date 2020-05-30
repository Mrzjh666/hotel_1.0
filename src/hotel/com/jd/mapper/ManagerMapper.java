package hotel.com.jd.mapper;

import hotel.com.jd.domain.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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
}
