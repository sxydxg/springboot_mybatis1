package sxy.dx.mapper;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import sxy.dx.pojo.User;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/8/14
 *
 *  该接口相关是测试 mybatis插件的（Interceptor）
 */

@Mapper
public interface UserMapper {


    User selectUserbyId(int id);
    List<User> getUsersByPageQuery();
    //使用rowBounds进行内存分页，mybatis会识别mybatis特定的参数
    // （自动用该rowBounds替换mybatis默认的RowBounds）
    List<User> getUsersByPageQuery2(RowBounds rowBounds);
}
