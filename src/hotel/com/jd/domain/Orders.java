package hotel.com.jd.domain;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Orders {
    private int order_id;
    private String order_type;
    private int user_id;
    private double order_price;
    private String date;

    public String getDate() {
        return date;
    }

    public double getOrder_price() {
        return order_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getOrder_type() {
        return order_type;
    }
    public void set_date(String date){
        this.date=date;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", order_type='" + order_type + '\'' +
                ", user_id=" + user_id +
                ", order_price=" + order_price +
                ", date=" + date +
                '}';
    }
}
