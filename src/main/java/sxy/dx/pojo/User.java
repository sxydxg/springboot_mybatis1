package sxy.dx.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @auther 丁溪贵
 * @date 2019/8/14
 */
//@Alias("user") 加不加这个注解都可以
public class User {
    private int uid ;
    private String username ;
    private String password ;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
