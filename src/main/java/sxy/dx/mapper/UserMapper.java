package sxy.dx.mapper;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sxy.dx.pojo.User;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/8/14
 */

@Mapper
public interface UserMapper {


    User selectUserbyId(int id);
    List<User> getUsersByPageQuery();
}
