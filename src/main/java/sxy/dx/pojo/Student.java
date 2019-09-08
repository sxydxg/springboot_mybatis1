package sxy.dx.pojo;

/**
 * @auther 丁溪贵
 * @date 2019/9/8
 */
public class Student {

    private Integer id ;  //主键自增长，批量插入能返回主键吗
    private String sname ;
    private String address ;

    public Student() {
    }

    public Student( String sname, String address) {

        this.sname = sname;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
