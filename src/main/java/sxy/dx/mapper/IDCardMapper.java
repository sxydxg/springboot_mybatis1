package sxy.dx.mapper;

import org.apache.ibatis.annotations.Mapper;
import sxy.dx.pojo.one2one.IDCard;

@Mapper
public interface IDCardMapper {

    IDCard getIDCardById(int id);
}
