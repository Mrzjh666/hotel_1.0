package hotel.com.jd.service.Impl;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 15:22
 */

import hotel.com.jd.domain.Employee;
import hotel.com.jd.mapper.EmployeeMapper;
import hotel.com.jd.service.EmployeeService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional(readOnly = true)
    @Override
    public Employee findEmployeeById(int  emp_id) {
        return employeeMapper.findEmployeeById(emp_id);
    }

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Employee> findEmployeeByName(String employee_name, int currentPage, PageParms parms) {
        if(employee_name == null)
            employee_name="";
        System.out.println(employee_name+"service");
        parms.setAllCount(employeeMapper.getRecordNum(employee_name));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
        if(currentPage < 1)
            parms.setCurrentPage(1);
        else
            parms.setCurrentPage(currentPage);
        int start_place = (parms.getCurrentPage()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<Employee> list = employeeMapper.findEmployeeByName(employee_name,start_place,size);

        return list;
    }
    @Transactional(readOnly=false)
    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }
    @Transactional(readOnly=false)
    @Override
    public void update(Employee employee) {
        System.out.println(employee.toString()+"service");
        employeeMapper.update(employee);
    }
    @Transactional(readOnly=false)
    @Override
    public void delete(int employeeId) {


        employeeMapper.delete(employeeId);
    }
}


