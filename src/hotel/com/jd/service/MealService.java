package hotel.com.jd.service;

import hotel.com.jd.domain.Meal;
import hotel.com.jd.util.PageParms;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface MealService {
    @Transactional(readOnly=false)
    boolean addMeal(Meal m);

    @Transactional(readOnly=false)
    boolean deleteMeal(int meal_id);

    @Transactional(readOnly=false)
    boolean updateMeal(Meal m);

    @Transactional(readOnly = true)
    List<Meal> getMealByid(int meal_id);

    @Transactional(readOnly = true)
    ArrayList<Meal> getMealByType(String meal_Type, int currentPage, PageParms parms);

    @Transactional(readOnly = true)
    ArrayList<Meal> getmealByHotel_id(int hotel_id, int currentPage, PageParms parms);

    boolean createOrder();
}
