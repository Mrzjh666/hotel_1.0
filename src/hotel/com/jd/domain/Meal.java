package hotel.com.jd.domain;

/**
 * Meal实体类
 * @Author cyb
 * @Date 2020/5/31 21:29
 */

public class Meal{
    private int meal_id;//餐品ID
    private String meal_type;//餐品类型
    private String meal_name;//餐品名称
    private double meal_price;//餐品价格
    private String meal_explain;//餐品注释
    private int emp_id;//厨师ID
    private String meal_picpath;//餐品图片路径
    private int hotel_id;//酒店ID

    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public double getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(double meal_price) {
        this.meal_price = meal_price;
    }

    public String getMeal_explain() {
        return meal_explain;
    }

    public void setMeal_explain(String meal_explain) {
        this.meal_explain = meal_explain;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getMeal_picpath() {
        return meal_picpath;
    }

    public void setMeal_picpath(String meal_picpath) {
        this.meal_picpath = meal_picpath;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "meal_id=" + meal_id +
                ", meal_type='" + meal_type + '\'' +
                ", meal_name='" + meal_name + '\'' +
                ", meal_price='" + meal_price + '\'' +
                ", meal_explain='" + meal_explain + '\'' +
                ", emp_id=" + emp_id +
                ", meal_picpath='" + meal_picpath + '\'' +
                ", hotel_id=" + hotel_id +
                '}';
    }
}