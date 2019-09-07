package sxy.dx.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

/**
 * @auther 丁溪贵
 * @date 2019/9/6
 *
 *  Executor
 */
@Intercepts(
       value={
               @Signature(
                     type = Executor.class,
                     method = "query",
                     args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}
               )
       }

)
//@Component
public class MyInterceptor implements Interceptor {


    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        Method method = invocation.getMethod();
        Object[] args = invocation.getArgs();
        System.out.println(target.getClass());
        System.out.println(method.getName());
        System.out.println(Arrays.toString(args));
        MappedStatement ms =(MappedStatement)args[0];
//        System.out.println("ms的sqlsource ："+ms.getSqlSource().getBoundSql());
        Statement st = null;


        System.out.println("########################");
//        放行
        return invocation.proceed();
    }


    public Object plugin(Object target) {

        if (target instanceof Executor){
            return Plugin.wrap(target,this);
        }

        return target;
    }

    public void setProperties(Properties properties) {

    }
}
