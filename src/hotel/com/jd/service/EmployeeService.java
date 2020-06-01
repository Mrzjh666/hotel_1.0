package hotel.com.jd.service;

import hotel.com.jd.domain.Employee;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface EmployeeService {
    //    Employee findEmployeeByName(String employee_name);
    Employee findEmployeeById(int emp_id);
    ArrayList<Employee> findEmployeeByName(String employee_name,
                                   int currentPage, PageParms parms);
    void insert(Employee employee);
    void update(Employee employee);
    void delete(int employeeId);
}