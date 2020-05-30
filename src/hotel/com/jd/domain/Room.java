package hotel.com.jd.domain;

public class Room {
    private int room_id;//房间id
    private String room_type;//房间类型
    private Double room_area;//房间面积
    private Double room_price;//房间价格
    private String room_no;//房间号
    private String room_flag;//房间入住状态
    private int hotel_id;//所属酒店号码

    public Double getRoom_area() {
        return room_area;
    }

    public Double getRoom_price() {
        return room_price;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getRoom_flag() {
        return room_flag;
    }

    public String getRoom_no() {
        return room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setRoom_area(Double room_area) {
        this.room_area = room_area;
    }

    public void setRoom_flag(String room_flag) {
        this.room_flag = room_flag;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public void setRoom_price(Double room_price) {
        this.room_price = room_price;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", room_type='" + room_type + '\'' +
                ", room_area=" + room_area +
                ", room_price=" + room_price +
                ", room_no='" + room_no + '\'' +
                ", room_flag='" + room_flag + '\'' +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
