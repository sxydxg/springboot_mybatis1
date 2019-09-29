package sxy.dx.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sxy.dx.mapper.IDCardMapper;
import sxy.dx.pojo.one2one.IDCard;

/**
 * @auther 丁溪贵
 * @date 2019/9/29
 */
@RestController
public class IDCardController {

    @Autowired
    private IDCardMapper idCardMapper ;
    @RequestMapping("/idCard/{id}")
    public IDCard getIDCardById(@PathVariable int id){
        return idCardMapper.getIDCardById(id);
    }
}
