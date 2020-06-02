package hotel.com.jd.service.Impl;

import hotel.com.jd.domain.Manager;
import hotel.com.jd.mapper.ManagerMapper;
import hotel.com.jd.service.ManagerService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
    @Transactional(readOnly = true)
    @Override
    public ArrayList<Manager> findManagerByName(String manager_name, int currentPage, PageParms parms) {
        if(manager_name==null)
            manager_name="";
        parms.setAllCount(managerMapper.getRecordNum(manager_name));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
        if(currentPage <= 1)
            parms.setCurrentPage(1);
        else
            parms.setCurrentPage(currentPage);
        int start_place = (parms.getAllPageCount()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<Manager> list = managerMapper.findManagerByName(manager_name,start_place,size);
        return list;
    }
    @Transactional(readOnly = false)
    @Override
    public void insert(Manager manager) {
        managerMapper.insert(manager);
    }

    @Transactional(readOnly = true)
    @Override
    public Manager findManagerById(int manager_id) {
        return managerMapper.findManagerById(manager_id);
    }
    @Transactional(readOnly = false)
    @Override
    public void update(Manager manager) {
        managerMapper.update(manager);
    }
    @Transactional(readOnly = false)
    @Override
    public void delete(int manager_id) {
        managerMapper.delete(manager_id);
    }
}
