package sxy.dx.mapper;

import org.apache.ibatis.annotations.Mapper;
import sxy.dx.pojo.many2many.Item;

/**
 * @auther 丁溪贵
 * @date 2019/9/28
 */
@Mapper
public interface ItemMapper {

    Item getItemById(int id);
}
