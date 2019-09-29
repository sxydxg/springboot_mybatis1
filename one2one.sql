CREATE TABLE tb_people(

	id INT PRIMARY KEY AUTO_INCREMENT,
	pName VARCHAR(20)

);
-- 外键我就放在了tb_idCard这张表中
CREATE TABLE tb_idCard(

	id INT PRIMARY KEY AUTO_INCREMENT,
	idCard VARCHAR(20),
	pid INT ,
	CONSTRAINT  idcard_people_fk  FOREIGN KEY (pid) REFERENCES tb_people(id)

);
INSERT INTO tb_people(pName) VALUES("阿贵");
INSERT INTO tb_idCard(idCard,pid) VALUES("12345678",1);
SELECT * FROM tb_people;
SELECT * FROM tb_idCard;
