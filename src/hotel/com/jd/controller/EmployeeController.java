package hotel.com.jd.controller;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 15:34
 */
import hotel.com.jd.domain.Employee;
import hotel.com.jd.service.EmployeeService;
import hotel.com.jd.util.PageParms;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 8:41
 */

@Controller
@RequestMapping("/jsp")
public class EmployeeController {
    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;
    @RequestMapping(value = "/employee/searchByEmployeeName")
    public ModelAndView searchByName(@RequestParam("employeeName") String employeeName, @RequestParam(required = false)int currentPage, @RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();
        ModelAndView mv= new ModelAndView();
        System.out.println(employeeName+"controller");
        mv.addObject("allEmployee",employeeService.findEmployeeByName(employeeName,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchEmployee_name",employeeName);
        mv.setViewName("/jsp/employee//employeetable");
        return mv;
    }
    @RequestMapping("/employee/openAdd")
    public String openAdd(){
        return "/jsp/employee/employee_add";
    }
    @RequestMapping("/employee/save")
    public ModelAndView save(Employee employee, ModelAndView mv){
        try {
            employeeService.insert(employee);
            mv.addObject("result","employee添加成功");
        }catch (Exception e){
            mv.addObject("result","employee添加失败");
        }
        finally {
            mv.setViewName("/jsp/employee/employeetable");
            return mv;
        }
    }
    @RequestMapping(value = "/employee/openUpdate")
    public ModelAndView openUpdate(int emp_id,ModelAndView mv){
        Employee employee = employeeService.findEmployeeById(emp_id);
        mv.addObject("employee",employee);
        mv.setViewName("/jsp/employee/employee_update");
        return mv;
    }
    @RequestMapping(value = "/employee/update")
    public ModelAndView update( Employee employee, ModelAndView mv){
        try{
            System.out.println(employee.toString()+"controller");
            employeeService.update(employee);
            mv.addObject("result","employee更新成功");
        }catch (Exception e){
            mv.addObject("result","employee更新失败");
        }
        finally {
            mv.addObject("employee",employee);
            mv.setViewName("/jsp/employee/employeetable");
            return mv;
        }
    }
    @RequestMapping(value = "/employee/delete")
    public ModelAndView delete(int emp_id){
        ModelAndView mv = new ModelAndView();
        try{
            System.out.println("new in employee_delete_controller");
            employeeService.delete(emp_id);
            mv.addObject("result","employee删除成功");
        }
        catch (Exception e){
            mv.addObject("result","employee删除失败");
            e.printStackTrace();
        }
        finally {
            mv.setViewName("/jsp/employee//employeetable");
            return mv;
        }
    }
}

