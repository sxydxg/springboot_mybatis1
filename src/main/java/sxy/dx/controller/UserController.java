package sxy.dx.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import sxy.dx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sxy.dx.pojo.User;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/8/14
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper ;

    @ResponseBody
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        System.out.println("***************************************");
        User user = userMapper.selectUserbyId(id);
        System.out.println(user);
        System.out.println("*******************************");
        return user ;
    }

    @ResponseBody
    @RequestMapping("/users")
    public List<User> getUsers(){
        System.out.println("***************************************");
        List<User> users = userMapper.getUsersByPageQuery();
        System.out.println(users);

        System.out.println("*******************************");
        return users ;
    }
}
