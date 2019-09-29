package sxy.dx.pojo.many2many;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/28
 *
 *     1.特意将数据表和实体类字段不全部对应
 *    2.多对多，一件商品可以对应多个订单
 */
public class Item {

    private Integer id ;
    private String itemName;
    private List<Order> orders ;
    //这是一个与数据库当中不一样的字段,数据库当中字段为itemdDesc
    private String desc ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
