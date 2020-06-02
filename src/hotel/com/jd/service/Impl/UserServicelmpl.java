package hotel.com.jd.service.Impl;

import hotel.com.jd.domain.User;
import hotel.com.jd.mapper.UserMapper;
import hotel.com.jd.service.UserService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServicelmpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public User findUserById(int  user_id) {
        return userMapper.findUserById(user_id);
    }
    @Transactional(readOnly = true)
    @Override
    public ArrayList<User> findUserByName(String user_name, int currentPage, PageParms parms) {
        if(user_name == null)
            user_name="";
        parms.setAllCount(userMapper.getRecordNum(user_name));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
        if(currentPage < 1)
            parms.setCurrentPage(1);
        else
            parms.setCurrentPage(currentPage);
        int start_place = (parms.getAllPageCount()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<User> list = userMapper.findUserByName(user_name,start_place,size);
        return list;
    }
    @Transactional(readOnly=false)
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
    @Transactional(readOnly=false)
    @Override
    public void update(User user) {
        userMapper.update(user);
    }
    @Transactional(readOnly=false)
    @Override
    public void delete(int userId) {
        userMapper.delete(userId);
    }
}

