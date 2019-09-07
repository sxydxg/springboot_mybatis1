package sxy.dx.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
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
                     type = StatementHandler.class,
                     method = "prepare",
                     args = {Connection.class,Integer.class}
               )
       }

)
@Component
public class MyInterceptor2 implements Interceptor {



    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler target = (StatementHandler)invocation.getTarget();

        // 得到目标sql,没有去掉 尾部的 分号;
        String sql = target.getBoundSql().getSql();
        //去掉分号
        sql = sql.replaceAll(";","");
        // prepare里面有一个connection参数可以供我们使用
        Connection conn = (Connection) invocation.getArgs()[0];
        Statement statement = conn.createStatement();

        //count（*）目标sql
        ResultSet resultSet = statement.executeQuery("select count(*) from ( " + sql + " ) as  t_temp");
        if(resultSet!=null){
           resultSet.next(); //开始迭代
          //得到总记录数，你可以将记录数保存到一个你想要的地方
            int count = resultSet.getInt(1);//第一列
            // 操作总记录.....
        }

        //思路：利用反射得到sql的id，如果sql是以ByPageQuery结尾，那么进行分页
        //sql的id保存在MappedStatement对象中
        //StatementHandler的子类-----org.apache.ibatis.executor.statement.RoutingStatementHandler可以获得MappedStatement
        //RoutingStatementHandler会根据配置选项3个StatementHandler的子类,点击源码一目了然，为了节约篇幅，再次不一样赘述。
//      先得到RoutingStatementHandler的成员变量delegate
        Field f_delegate = target.getClass().getDeclaredField("delegate");
        f_delegate.setAccessible(true);
        Object delegate= f_delegate.get(target);
//      得到delegate的成员变量mappedStatement（3个子类都继承了org.apache.ibatis.executor.statement.BaseStatementHandler，所有一定有该成员变量）
        Field f_mappedStatement = delegate.getClass().getSuperclass().getDeclaredField("mappedStatement");
        f_mappedStatement.setAccessible(true);
        MappedStatement mappedStatement = (MappedStatement)f_mappedStatement.get(delegate);

        //判断sql的id是否以ByPageQuery结尾，如果是，则进行分页
        if(mappedStatement.getId().matches(".*ByPageQuery$")){

            sql = sql+" limit 0 , 10 ; " ; // 此处可以动态设置参数，我在这里就写死了

            //通过反射设置sql（为什么mybatis不提供相应的方法，导致我这么麻烦，他娘的）
            //target.getBoundSql().getSql()---没有提供setSql方法,只有getSql方法
            BoundSql boundSql = target.getBoundSql();
            Field f_sql = boundSql.getClass().getDeclaredField("sql");
            f_sql.setAccessible(true);
            //更新sql
            f_sql.set(boundSql,sql);

        }




        return invocation.proceed();
    }


    public Object plugin(Object target) {

        if (target instanceof StatementHandler){
            return Plugin.wrap(target,this);
        }

        return target;
    }

    public void setProperties(Properties properties) {

    }
}
