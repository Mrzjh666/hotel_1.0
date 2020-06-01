package hotel.com.jd.service;

import hotel.com.jd.domain.User;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface UserService {
    User findUserById(int user_id);
    ArrayList<User> findUserByName(String user_name, int currentPage,PageParms parms);
    void insert(User user);
    void update(User user);
    void delete(int user_id);
}

