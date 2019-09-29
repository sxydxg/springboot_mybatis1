CREATE TABLE tb_item(

 id INT PRIMARY KEY AUTO_INCREMENT,
 itemName VARCHAR(20),
 itemDesc VARCHAR(20)

);

CREATE TABLE tb_order(

 id INT PRIMARY KEY AUTO_INCREMENT,
 orderName VARCHAR(20),
 orderDesc VARCHAR(20)

);
# 多对多关系表(省略商品的数量)
CREATE TABLE tb_item_order(

	tid INT ,
	oid INT

);


# 插入数据
INSERT INTO tb_item (itemName,itemDesc)VALUES('华硕笔记本','笔记本很好用啊，大家快来买')
INSERT INTO tb_item (itemName,itemDesc)VALUES('至尊版充气娃娃','耐玩，男士必需品')
INSERT INTO tb_item (itemName,itemDesc)VALUES('方便面','料多，好吃')
INSERT INTO tb_order (orderName,orderDesc)VALUES('订单1','第一笔订单')
INSERT INTO tb_order (orderName,orderDesc)VALUES('订单2','第二笔订单')
# 订单1 有 3个商品（id=1,2,3）
# 订单2 有 2个商品（id=2,3）
INSERT INTO tb_item_order VALUES(1,1);
INSERT INTO tb_item_order VALUES(2,1);
INSERT INTO tb_item_order VALUES(3,1);
INSERT INTO tb_item_order VALUES(2,2);
INSERT INTO tb_item_order VALUES(3,2);
SELECT * FROM tb_item_order ;
SELECT * FROM tb_order ;
SELECT * FROM tb_item ;
 SELECT item.id AS tid ,item.itemName,item.itemDesc,o.id AS oid ,o.orderName,o.orderDesc
   FROM tb_item item
   JOIN tb_item_order tio ON tio.tid=item.id
   JOIN tb_order o ON tio.oid=o.id
   WHERE item.id = 1;