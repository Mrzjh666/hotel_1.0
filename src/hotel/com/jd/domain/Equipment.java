package hotel.com.jd.domain;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 18:05
 */

public class Equipment {
    private int equ_id;//器材ID
    private String equ_name;//器材名称
    private String equ_type;//器材类型
    private int equ_num;//器材数量
    private String equ_explain;//器材作用解释
    private String equ_mark;//器材备注
    private String equ_picpath;//器材图片路径
    private int emp_id;//维修员工ID
    public Equipment(){}
    public Equipment(String equ_name,String equ_type,int equ_num,
                     String equ_explain,String equ_mark,int emp_id,String equ_picpath){
        this.emp_id=emp_id;
        this.equ_explain=equ_explain;
        this.equ_mark=equ_mark;
        this.equ_name=equ_name;
        this.equ_num=equ_num;
        this.equ_picpath=equ_picpath;
        this.equ_type =equ_type;
    }
    public int getEqu_id() {
        return equ_id;
    }

    public void setEqu_id(int equ_id) {
        this.equ_id = equ_id;
    }

    public String getEqu_name() {
        return equ_name;
    }

    public void setEqu_name(String equ_name) {
        this.equ_name = equ_name;
    }

    public String getEqu_type() {
        return equ_type;
    }

    public void setEqu_type(String equ_type) {
        this.equ_type = equ_type;
    }

    public int getEqu_num() {
        return equ_num;
    }

    public void setEqu_num(int equ_num) {
        this.equ_num = equ_num;
    }

    public String getEqu_explain() {
        return equ_explain;
    }

    public void setEqu_explain(String equ_explain) {
        this.equ_explain = equ_explain;
    }

    public String getEqu_mark() {
        return equ_mark;
    }

    public void setEqu_mark(String equ_mark) {
        this.equ_mark = equ_mark;
    }

    public String getEqu_picpath() {
        return equ_picpath;
    }

    public void setEqu_picpath(String equ_picpath) {
        this.equ_picpath = equ_picpath;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equ_id=" + equ_id +
                ", equ_name='" + equ_name + '\'' +
                ", equ_type='" + equ_type + '\'' +
                ", equ_num=" + equ_num +
                ", equ_explain='" + equ_explain + '\'' +
                ", equ_mark='" + equ_mark + '\'' +
                ", equ_picpath='" + equ_picpath + '\'' +
                ", emp_id=" + emp_id +
                '}';
    }
}
