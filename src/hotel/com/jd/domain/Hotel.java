package hotel.com.jd.domain;

import org.springframework.stereotype.Component;

@Component
public class Hotel {
    private int hotel_id;//酒店ID
    private String hotel_loc;//#酒店位置
    private double hotel_totalincome;//酒店总收入
    private double hotel_roomincome;//酒店住房收入
    private double hotel_mealincome;//酒店餐饮收入

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setHotel_loc(String hotel_loc) {
        this.hotel_loc = hotel_loc;
    }

    public void setHotel_mealincome(double hotel_mealincome) {
        this.hotel_mealincome = hotel_mealincome;
    }

    public void setHotel_roomincome(double hotel_roomincome) {
        this.hotel_roomincome = hotel_roomincome;
    }

    public void setHotel_totalincome(double hotel_totalincome) {
        this.hotel_totalincome = hotel_totalincome;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public double getHotel_mealincome() {
        return hotel_mealincome;
    }

    public double getHotel_roomincome() {
        return hotel_roomincome;
    }

    public double getHotel_totalincome() {
        return hotel_totalincome;
    }

    public String getHotel_loc() {
        return hotel_loc;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", hotel_loc='" + hotel_loc + '\'' +
                ", hotel_totalincome=" + hotel_totalincome +
                ", hotel_roomincome=" + hotel_roomincome +
                ", hotel_mealincome=" + hotel_mealincome +
                '}';
    }
}
