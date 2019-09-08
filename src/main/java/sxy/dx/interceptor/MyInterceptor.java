package sxy.dx.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
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

        MappedStatement ms =(MappedStatement)args[0];
//        System.out.println("ms的sqlsource ："+ms.getSqlSource().getBoundSql());
        Statement st = null;
        //第二个方法参数 Object就是你传入的参数，如果方法没参数，则为null
        System.out.println("args[1] : "+args[1]);
        //获取绑定sql（需要传入参数）
        BoundSql boundSql = ms.getBoundSql(args[1]);
        //在这里也是可以修改sql，通过反射，设置sql的值
        System.out.println("sql : "+boundSql.getSql());
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
