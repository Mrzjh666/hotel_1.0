package hotel.com.jd.controller;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 19:55
 */

import hotel.com.jd.domain.Equipment;
import hotel.com.jd.service.EquipmentService;
import hotel.com.jd.util.PageParms;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
public class EquipmentController {
    @Autowired
    @Qualifier("equipmentService")
    private EquipmentService equipmentService;
    @RequestMapping(value = "/equipment/searchByEquipmentType")
    public ModelAndView searchByType(@RequestParam("equipmentType") String equipmentType, @RequestParam(required = false)int currentPage, @RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();
        ModelAndView mv= new ModelAndView();
        System.out.println(equipmentType+"controller");
        mv.addObject("allEquipment",equipmentService.findEquipmentByTpye(equipmentType,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchEquipment_type",equipmentType);
        mv.setViewName("/jsp/equipment//equipmenttable");
        return mv;
    }
    @RequestMapping("/equipment/openAdd")
    public String openAdd(){
        return "/jsp/equipment/equipment_add";
    }
    @RequestMapping("/equipment/save")
    public ModelAndView save(@RequestParam("equ_type") String equ_type,@RequestParam("equ_name") String equ_name, @RequestParam("equ_num") int equ_num,@RequestParam("equ_explain") String equ_explain,
                             @RequestParam("equ_mark") String equ_mark,@RequestParam("file") MultipartFile file,@RequestParam("emp_id") int emp_id, ModelAndView mv){
        System.out.println("now in controller");
        try {
            String file_name = file.getOriginalFilename();
            System.out.println("file_name--->>>"+file_name);
            String equ_picpath ="F://new/hotel/web/images/"+file_name;
            Equipment equipment = new Equipment(equ_name,equ_type,equ_num,equ_explain,equ_mark,emp_id,equ_picpath);
            System.out.println("Controller"+equipment.toString());
            equipmentService.insert(equipment);
            mv.addObject("result","equipment添加成功");
        }catch (Exception e){
            mv.addObject("result","equipment添加失败");
        }
        finally {
            mv.setViewName("/jsp/equipment/equipmenttable");
            return mv;
        }
    }
    @RequestMapping(value = "/equipment/openUpdate")
    public ModelAndView openUpdate(int equ_id,ModelAndView mv){
        Equipment equipment = equipmentService.findEquipmentById(equ_id);
        mv.addObject("equipment",equipment);
        mv.setViewName("/jsp/equipment/equipment_update");
        return mv;
    }
    @RequestMapping(value = "/equipment/update")
    public ModelAndView update(@RequestParam("equ_type") String equ_type,@RequestParam("equ_id")int equ_id,@RequestParam("equ_name") String equ_name,@RequestParam("equ_num") int equ_num,
                              @RequestParam("equ_explain") String equ_explain,@RequestParam("equ_picpath")String equ_picpath,@RequestParam("file1") MultipartFile file1,@RequestParam("equ_mark") String equ_mark,@RequestParam("emp_id") int emp_id ,ModelAndView mv){
        Equipment equipment = null;
        try{
            if(file1==null){
                equipment = new Equipment(equ_name,equ_type,equ_num,equ_explain,equ_mark,emp_id,equ_picpath);
                equipment.setEqu_id(equ_id);
                System.out.println(equipment.toString()+"c");
                equipmentService.update(equipment);
            }else {
                String filename=file1.getOriginalFilename();
                String picpath="F://new/hotel/web/images/"+filename;
                System.out.println(filename);
                equipment = new Equipment(equ_name,equ_type,equ_num,equ_explain,equ_mark,emp_id,picpath);
                equipment.setEqu_id(equ_id);
                System.out.println(equipment.toString()+"cc");
                equipmentService.update(equipment);
            }
            mv.addObject("result","equipment更新成功");
        }catch (Exception e){
            mv.addObject("result","equipment更新失败");
        }
        finally {
            mv.addObject("equipment",equipment);
            mv.setViewName("/jsp/equipment/equipmenttable");
            return mv;
        }
    }
    @RequestMapping(value = "/equipment/delete")
    public ModelAndView delete(int equ_id){
        ModelAndView mv = new ModelAndView();
        try{
            System.out.println("new in equipment_delete_controller");
            equipmentService.delete(equ_id);
            mv.addObject("result","equipment删除成功");
        }
        catch (Exception e){
            mv.addObject("result","equipment删除失败");
            e.printStackTrace();
        }
        finally {
            mv.setViewName("/jsp/equipment//equipmenttable");
            return mv;
        }
    }
}



