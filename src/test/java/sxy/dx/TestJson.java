package sxy.dx;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @auther 丁溪贵
 * @date 2019/8/14
 */
public class TestJson {
    /**
     *  自动提示快捷键   ctrl+空格
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws IOException {
//        1.创建ObjectMapper对象
        ObjectMapper o = new ObjectMapper();
//       2. 创建一个student对象
        Student s = new Student("丁溪贵","中国");
//       3.将一个pojo对象序列换为json字符串
        String v = o.writeValueAsString(s);
//        4.将一个json字符串转换成student实例
        Student s2 = o.readValue(v,Student.class);

    }
}
