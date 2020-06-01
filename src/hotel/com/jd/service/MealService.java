package hotel.com.jd.service;

import hotel.com.jd.domain.Meal;
import hotel.com.jd.util.PageParms;
import java.util.ArrayList;

public interface MealService {
//    Meal findMealByName(String meal_name);
    Meal findMealById(int meal_id);
    ArrayList<Meal> findMealByName(String meal_name,
                                   int currentPage,PageParms parms);
    void insert(Meal meal);
    void update(Meal meal);
    void delete(int mealId);
}
