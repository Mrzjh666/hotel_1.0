package hotel.com.jd.domain;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 14:58
 */

public class Employee {
    private int emp_id;   //员工ID
    private String emp_name;//员工姓名
    private String emp_phone;//员工电话
    private String emp_no;//员工工号
    private String emp_pos;//员工职位
    private double emp_salary;//员工薪资
    private int hotel_id;//所属酒店

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_pos() {
        return emp_pos;
    }

    public void setEmp_pos(String emp_pos) {
        this.emp_pos = emp_pos;
    }

    public double getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", emp_pos='" + emp_pos + '\'' +
                ", emp_salary=" + emp_salary +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
