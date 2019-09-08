package sxy.dx.mapper;

import org.apache.ibatis.annotations.Mapper;
import sxy.dx.pojo.Student;

import java.util.List;

/**
 *  该接口是测试批量插入，且返回批量插入主键的例子
 */
@Mapper
public interface StudentMapper {

    void insertOneStudent(Student student);
    void insertStudentList(List<Student> studentList);
    // 该方法ok 采用 insert into table values （xx）,（xx）,（xx）;
    void insertStudentList2(List<Student> studentList);
}
