package hotel.com.jd.service.Impl;

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
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("mealService")
public class MealServiceImpl implements MealService {

    @Autowired
    private MealMapper mealMapper;

    @Transactional(readOnly=false)
    @Override
    public boolean addMeal(Meal m) {
        return mealMapper.insert(m);
    }

    @Transactional(readOnly=false)
    @Override
    public boolean deleteMeal(int meal_id) {
        return mealMapper.delete(meal_id);
    }

    @Transactional(readOnly=false)
    @Override
    public boolean updateMeal(Meal m) {
        return mealMapper.update(m);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Meal> getMealByid(int meal_id) {
        return mealMapper.getMealByid(meal_id);
    }

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Meal> getMealByType(String meal_Type, int currentPage, PageParms parms) {
        if(meal_Type == null)
            meal_Type="";
        parms.setAllCount(mealMapper.getRecordNum(meal_Type));
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
        ArrayList<Meal> list = mealMapper.findMealByType(meal_Type,start_place,size);
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Meal> getmealByHotel_id(int hotel_id, int currentPage, PageParms parms) {
        parms.setAllCount(mealMapper.getRecordNumByid(hotel_id));
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
        ArrayList<Meal> list = mealMapper.findMealByHotel_id(hotel_id,start_place,size);
        return list;
    }

    @Override
    public boolean createOrder() {
        return false;
    }

}
