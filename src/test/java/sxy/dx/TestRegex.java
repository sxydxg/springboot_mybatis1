package sxy.dx;

/**
 * @auther 丁溪贵
 * @date 2019/9/7
 */
public class TestRegex {

    public static void main(String[] args) {
        String s = "ssfsfByPageQuery";
        System.out.println(s.matches(".*ByPageQuery$"));
    }
}
