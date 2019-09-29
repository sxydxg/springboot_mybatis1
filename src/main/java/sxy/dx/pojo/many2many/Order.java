package sxy.dx.pojo.many2many;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/28
 *
 *    1.特意将数据表和实体类字段不全部对应
 *    2.多对多，一个订单可以有多个商品
 *
 */
public class Order {

    private Integer id ;
    private String orderName;
    private List<Item> items ;
    //这是一个与数据库中不一样的字段，数据库当中字段orderDesc
    private String desc ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
