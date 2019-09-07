package sxy.dx;

/**
 * @auther 丁溪贵
 * @date 2019/9/7
 */
public class TestDeletefenhao {

    public static void main(String[] args) {
        String s = "select xxx ; from user ;" ;
        s = s.replaceAll(";","");
        System.out.println(s);

    }
}
