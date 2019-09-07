package sxy.dx;

import java.lang.reflect.Field;
import java.security.ProtectionDomain;

/**
 * @auther 丁溪贵
 * @date 2019/9/7
 */
public class TestReflection {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        student.setName("ddd");

        Field name = student.getClass().getSuperclass().getDeclaredField("name");
        name.setAccessible(true);
        Object o = name.get(student);
        System.out.println(o);
    }
}
