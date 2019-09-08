package sxy.dx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sxy.dx.mapper.StudentMapper;
import sxy.dx.pojo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/8
 */
@Controller
public class StudentController {

    @Autowired
    private StudentMapper studentMapper ;

    @ResponseBody
    @RequestMapping("/insertOneStudent")
    public Student insertOnStudent(){

        Student student = new Student("ding", "一个美丽的地方");
        studentMapper.insertOneStudent(student);
        return student ;
    }

    @ResponseBody
    @RequestMapping("/insertStudentList")
    public List<Student> insertStudentList(){

        Student s1 = new Student("大地之熊", "魔兽森林");
        Student s2 = new Student("海王鲸", "无尽之海");
        Student s3 = new Student("神圣黄金龙", "落日山脉");
        List<Student> list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        studentMapper.insertStudentList2(list);
        return list ;
    }
}
