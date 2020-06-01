package hotel.com.jd.domain;

public class User {
    private int user_id;
    private String user_name;
    private String user_phone;
    private int user_liveday;
    private int room_id;

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public int getUser_liveday() {
        return user_liveday;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_liveday(int user_liveday) {
        this.user_liveday = user_liveday;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_liveday=" + user_liveday +
                ", room_id=" + room_id +
                '}';
    }
}

