package hotel.com.jd.service.Impl;

/**
 * @Description
 * @Author cyb
 * @Date 2020/5/31 22:40
 */
import hotel.com.jd.domain.Meal;
import hotel.com.jd.mapper.MealMapper;
import hotel.com.jd.service.MealService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("mealService")
public class MealServiceImpl implements MealService {
    @Autowired
    private MealMapper mealMapper;

    @Transactional(readOnly = true)
    @Override
    public Meal findMealById(int  meal_id) {
        return mealMapper.findMealById(meal_id);
    }

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Meal> findMealByName(String meal_name, int currentPage, PageParms parms) {
        if(meal_name == null)
            meal_name="";
        System.out.println(meal_name+"service");
        parms.setAllCount(mealMapper.getRecordNum(meal_name));
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
        ArrayList<Meal> list = mealMapper.findMealByName(meal_name,start_place,size);

        return list;
    }
    @Transactional(readOnly=false)
    @Override
    public void insert(Meal meal) {
        mealMapper.insert(meal);
    }
    @Transactional(readOnly=false)
    @Override
    public void update(Meal meal) {
        System.out.println(meal.toString()+"service");
        mealMapper.update(meal);
    }
    @Transactional(readOnly=false)
    @Override
    public void delete(int mealId) {


        mealMapper.delete(mealId);
    }
}

