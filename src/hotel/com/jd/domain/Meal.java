package hotel.com.jd.domain;

public class Meal {
    private  int meal_id;
    private String meal_type;
    private String meal_name;
    private double meal_price;
    private String meal_explain;
    private int emp_id;
    private String meal_picpath;
    private int hotel_id;

    public Meal(int meal_id, String meal_type, String meal_name, double meal_price, String meal_explain, int emp_id, String meal_picpath, int inhotel_id) {
        this.meal_id = meal_id;
        this.meal_type = meal_type;
        this.meal_name = meal_name;
        this.meal_price = meal_price;
        this.meal_explain = meal_explain;
        this.emp_id = emp_id;
        this.meal_picpath = meal_picpath;
        this.hotel_id = inhotel_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public void setMeal_price(double meal_price) {
        this.meal_price = meal_price;
    }

    public void setMeal_explain(String meal_explain) {
        this.meal_explain = meal_explain;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setMeal_picpath(String meal_picpath) {
        this.meal_picpath = meal_picpath;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getMeal_id() {
        return meal_id;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public double getMeal_price() {
        return meal_price;
    }

    public String getMeal_explain() {
        return meal_explain;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getMeal_picpath() {
        return meal_picpath;
    }

    public int getHotel_id() {
        return hotel_id;
    }
}
