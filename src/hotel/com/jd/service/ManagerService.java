package hotel.com.jd.service;

import hotel.com.jd.domain.Manager;

public interface ManagerService {

    Manager login(String loginName, String password);
}
