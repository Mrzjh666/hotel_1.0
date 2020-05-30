package hotel.com.jd.service.Impl;

import hotel.com.jd.domain.Manager;
import hotel.com.jd.mapper.ManagerMapper;
import hotel.com.jd.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;
    @Override
    public Manager login(String loginName, String password) {
        System.out.println("service");
        Manager manager = managerMapper.findManager(loginName,password);
        return manager;

    }
}
