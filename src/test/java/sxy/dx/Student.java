package sxy.dx;

/**
 * @auther 丁溪贵
 * @date 2019/8/14
 */
public class Student extends People{

    private String country ;

    public Student() {
    }

    public Student(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
