package hotel.com.jd.service;

import hotel.com.jd.domain.Manager;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface ManagerService {

    Manager login(String loginName, String password);

    ArrayList<Manager> findManagerByName(String manager_name, int currentPage, PageParms parms);

    void insert(Manager manager);

    Manager findManagerById(int manager_id);

    void update(Manager manager);

    void delete(int manager_id);
}
