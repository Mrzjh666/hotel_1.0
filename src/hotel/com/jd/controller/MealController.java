package hotel.com.jd.controller;

import hotel.com.jd.domain.Meal;
import hotel.com.jd.service.MealService;
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
public class MealController {
    @Autowired
    @Qualifier("mealService")
    private MealService mealService;
    @RequestMapping(value = "/meal/searchByMealName")
    public ModelAndView searchByName(@RequestParam("mealName") String mealName, @RequestParam(required = false)int currentPage, @RequestParam(required = false) String delResult){
        PageParms parms = new PageParms();
        ModelAndView mv= new ModelAndView();
        System.out.println(mealName+"controller");
        mv.addObject("allMeal",mealService.findMealByName(mealName,currentPage,parms));
        mv.addObject("currentPage",parms.getCurrentPage());
        mv.addObject("allCount",parms.getAllCount());
        mv.addObject("allPageCount",parms.getAllPageCount());
        mv.addObject("searchMeal_type",mealName);
        mv.setViewName("/jsp/meal//mealtable");
        return mv;
    }
    @RequestMapping("/meal/openAdd")
    public String openAdd(){
        return "/jsp/meal/meal_add";
    }
    @RequestMapping("/meal/save")
    public ModelAndView save(Meal meal, ModelAndView mv){
        try {
            mealService.insert(meal);
            mv.addObject("result","meal添加成功");
        }catch (Exception e){
            mv.addObject("result","meal添加失败");
        }
        finally {
            mv.setViewName("/jsp/meal/mealtable");
            return mv;
        }
    }
    @RequestMapping(value = "/meal/openUpdate")
    public ModelAndView openUpdate(int meal_id,ModelAndView mv){
        Meal meal = mealService.findMealById(meal_id);
        mv.addObject("meal",meal);
        mv.setViewName("/jsp/meal/meal_update");
        return mv;
    }
    @RequestMapping(value = "/meal/update")
    public ModelAndView update( Meal meal, ModelAndView mv){
        try{
            System.out.println(meal.toString()+"controller");
            mealService.update(meal);
            mv.addObject("result","meal更新成功");
        }catch (Exception e){
            mv.addObject("result","meal更新失败");
        }
        finally {
            mv.addObject("meal",meal);
            mv.setViewName("/jsp/meal/mealtable");
            return mv;
        }
    }
    @RequestMapping(value = "/meal/delete")
    public ModelAndView delete(int meal_id){
        ModelAndView mv = new ModelAndView();
        try{
            System.out.println("new in meal_delete_controller");
            mealService.delete(meal_id);
            mv.addObject("result","meal删除成功");
        }
        catch (Exception e){
            mv.addObject("result","meal删除失败");
            e.printStackTrace();
        }
        finally {
            mv.setViewName("/jsp/meal//mealtable");
            return mv;
        }
    }
}
