package sxy.dx.controller;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.main.server.ResultHandler;
import sxy.dx.mapper.ItemMapper;
import sxy.dx.pojo.many2many.Item;

import java.sql.ResultSet;

/**
 * @auther 丁溪贵
 * @date 2019/9/28
 */
@RestController
public class ItemController {

    @Autowired
    private ItemMapper itemMapper ;

     @RequestMapping("/item/{id}")
    public Item getItemById(@PathVariable int id){
        Item item = itemMapper.getItemById(id);
        return item ;
    }

}
