package hotel.com.jd.domain;

public class Manager {
    private int manager_id;
    private String manager_name;
    private String manager_account;
    private String manager_password;
    private String manager_phone;
    private int hotel_id;

    public int getHotel_id() {
        return hotel_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public String getManager_account() {
        return manager_account;
    }

    public String getManager_name() {
        return manager_name;
    }

    public String getManager_password() {
        return manager_password;
    }

    public String getManager_phone() {
        return manager_phone;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setManager_account(String manager_account) {
        this.manager_account = manager_account;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public void setManager_phone(String manager_phone) {
        this.manager_phone = manager_phone;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", manager_name='" + manager_name + '\'' +
                ", manager_account='" + manager_account + '\'' +
                ", manager_password='" + manager_password + '\'' +
                ", manager_phone='" + manager_phone + '\'' +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
