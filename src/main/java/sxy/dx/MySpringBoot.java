package sxy.dx;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.security.krb5.Config;
import sxy.dx.interceptor.MyInterceptor;

@SpringBootApplication
@MapperScan(basePackages = "sxy.dx.mapper")
public class MySpringBoot {

//    @Bean
//    public Interceptor getInter(){
//
//        return new MyInterceptor();
//
//    }
////    添加拦截器
//    @Bean
//    public ConfigurationCustomizer configurationCustomizer(){
//        return new ConfigurationCustomizer(){
//
//            @Override
//            public void customize(Configuration configuration) {
//                configuration.setMapUnderscoreToCamelCase(true);//设置驼峰命名法
//                configuration.addInterceptor(getInter()); //添加mybatis拦截器
//            }
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBoot.class);
    }
}
