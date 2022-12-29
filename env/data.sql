drop database easydb;
CREATE DATABASE IF NOT EXISTS easydb  DEFAULT CHARACTER SET utf8;

USE easydb;

DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user (
  user_id char(36) NOT NULL COMMENT '用户id uuid 主键',
  user_name varchar(100) NOT NULL COMMENT '用户登陆名称',
  user_password varchar(32) NOT NULL DEFAULT '""' COMMENT '用户密码 md5',
  user_nickname varchar(50) DEFAULT '上帝' COMMENT '用户昵称',
  user_email varchar(30) DEFAULT '""' COMMENT '用户邮箱',
  user_type int(11) DEFAULT '0' COMMENT '用户状态 0(普通用户),1(管理员),2(超级管理员)',
  PRIMARY KEY (user_id),
  UNIQUE KEY UN_user_name (user_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Data for the table t_user */
insert  into t_user(user_id,user_name,user_password,user_nickname,user_email,user_type) 
values ('f577f9f9-159e-4aaf-9332-fd7b294bc208','aa',md5('123'),'李筱雯','aa@163.com',0);
insert  into t_user(user_id,user_name,user_password,user_nickname,user_email,user_type) 
values ('f577f9f9-159e-4aaf-9332-fd7b294bc209','bc',md5('123'),'白茶','bc@163.com',1);

select * from t_user;


DROP TABLE IF EXISTS t_product;
CREATE TABLE t_product (
  product_id char(36) NOT NULL DEFAULT '',
  product_name varchar(100) DEFAULT NULL,
  product_price double DEFAULT '0',
  product_category varchar(100) DEFAULT '',
  product_imgurl varchar(500) DEFAULT '',
  product_num int(11) DEFAULT '0',
  product_description varchar(255) DEFAULT '',
  PRIMARY KEY (product_id),
  UNIQUE KEY UN_product_name (product_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('05e20c1a-0401-4c0a-82ab-6fb0f37db397','荣耀Play5T','1199','手机数码','http://image.easymall.com/upload/5/e/d/5/4/5/e/b/5f0d34dc-157f-49ba-ad39-1b28927ba6ae_1005714.jpg',206,'22.5W超级快充 5000mAh大电池 6.5英寸护眼屏');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('09f47493-214d-44bc-927d-6ce0bf89a057','爱疯9S(0315-01)','1000','手机数码','http://image.easymall.com/upload/5/2/3/4/7/8/d/c/1838eaa6-6459-420f-b8e2-6ea9f43c4b5e_dfd259ab-bcc7-43f6-a9d5-62872ff5671e.jpg',185,'爱疯9S(0315-01)');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('103e5414-0da2-4fba-b92f-0ba876e08939','滑雪套装','2000','户外运动','http://image.easymall.com/upload/4/d/2/a/2/3/1/8/b3c3fc7a-222c-49be-9491-f466553d2284_386718.jpg',1000,'这种运动值得你拥有');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('17c3f20e-ef86-4857-9293-f29e52954a95','打印机','180','手机数码','http://image.easymall.com/upload/7/c/b/f/7/d/2/9/5e229aef-063f-4d0d-91df-2d4aa7167670_6f84843a-1d1e-49c7-b4ce-c035d7790171.jpg',100,'一个神奇的打印机?!');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('26128d47-423b-4220-8047-544ff899db50','1208_01iphone7','850','手机数码','http://image.easymall.com/upload/2/1/0/3/f/0/3/5/2fb0b43b-4dbe-440b-899b-13c02a9f5475_22d124c9-df52-4cd4-88b3-691005f1cafe.jpg',100,'1208_01iphone7');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('2ad0d041-8c5f-4b70-a0ef-1ca2fd476dba','战神主机','5888','手机数码','http://image.easymall.com/upload/b/4/1/b/d/9/8/8/e41cd642-2fc2-4cb2-b20a-f8a78405eee2_e9dd0d91-40c1-4db5-a888-244e825e9ce4.jpg',100,'');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('36b9407f-746a-4956-988e-557122bc74d0','床上用品','138','床上用品','http://image.easymall.com/upload/e/5/0/9/c/7/6/0/60746822-144c-4e98-8aaa-fca07e142a63.jpg',100,'绿色新中式仙鹤高端展厅样板房床上用品');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('38a4a0f0-7c33-4e78-aa9e-1a3f7f193683','打印机021701','3000','手机数码','http://image.easymall.com/upload/8/6/b/0/5/9/e/f/1d25320d-e1b2-42bc-b890-981d58391cf0_6f84843a-1d1e-49c7-b4ce-c035d7790171.jpg',100,'希望好用');


insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('3da04a08-a570-4945-91b5-cd0d63ace7b4','2017011002打印机','10000','手机数码','http://image.easymall.com/upload/9/f/f/a/1/6/d/0/49617712-4018-4c0e-9e7a-5ebc4ff79ad1_6f84843a-1d1e-49c7-b4ce-c035d7790171.jpg',1000,'打印机');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('3f36ac54-5da0-4cd8-9991-2ee86cc348c2','金士顿8G内存条','300','手机数码','http://image.easymall.com/upload/2/2/b/7/f/2/f/4/06402c91-aa25-45d5-b0c3-3ac276a7cd05_244c59c6-bf0a-451b-81e6-18f8bb257e5f.jpg',100,'3级内存条，拿货220，数量有限！');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('59622587-958e-43cb-b657-49619f60713e','意林合订本2021','26.2','图书杂志','http://image.easymall.com/upload/6/5/a/4/2/9/e/8/cb68faa0-0033-4517-bff0-5fb2f1f1019a_671434fae6cd7b89a26ce25e072442a7d8330efa.jpg',1000,'意林合订本2021年秋季卷13-18期总第70卷');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('6746c459-b284-4256-bbc6-1df60ba4a0a2',' 计算之魂','79.8','图书杂志','http://image.easymall.com/upload/2/6/4/a/a/5/2/3/ee6c796a-6333-4cd5-a06e-271d876aac8c_589577.jpg',1000,'计算之魂 《数学之美》《浪潮之巅》等畅销书作者吴军博士新作，1000册签名书签版随机掉落');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('6746c459-b284-4256-bbc6-1df60ba4a3a2',' 汽车轮胎防滑链','36.8','汽车用品','http://image.easymall.com/upload/2/6/4/a/a/5/2/3/2b4bd3f3ef6ea2d7.jpg',10000,'汽车轮胎防滑链应急通用型越野车小轿车面包车SUV牛筋加厚条雪地防滑条防滑链条绑带 20条装');


insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('6c28bc1a-9c9b-4be3-b1cf-0068565e64e4','格力空调','2699','家用电器','http://image.easymall.com/upload/1/f/b/5/3/4/e/4/61a8cdff-52f7-4fce-bdb5-570426022082_preview.jpg',889,'1.5匹 云佳 新能效 变频冷暖 自清洁 壁挂式卧室空调挂机');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('70ee3179-3e76-4a3d-bd30-55d740f022dc','美的空调','2599','家用电器','http://image.easymall.com/upload/e/6/f/d/3/f/6/1/d2370fcb-dc8f-4405-9bf2-76e798a91567_Jellyfish.jpg',999,'美的(Midea) 新一级 风酷 大1.5匹变频冷暖壁挂式空调挂机大风口');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('77feb539-a575-487b-8500-df38520f3239','读者合订本','25.6','图书杂志','http://image.easymall.com/upload/5/e/e/6/c/4/9/b/67c1a752-9020-4372-bcda-3375ef01c878_preview.jpg',555,'读者合订本杂志 2021年秋季卷 赠书2本');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('a0390f80-bed7-4a92-9954-5e22e64cbe17','护肤品','50','日用百货','http://image.easymall.com/upload/5/0/6/f/4/4/b/f/40ca42aa-8298-430a-9fa9-88d6156d7b18_c987f2c1-4123-4d87-83bd-fe2fb221e272.jpg',333,'好用');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('a08b13e9-c16a-4657-94ee-3b9bee2bd9c6','华为荣耀8','1100','手机数码','http://image.easymall.com/upload/4/a/d/8/8/c/4/0/236ac480-db3a-4e6b-bc7f-c379a30c2c2c_301fb535-938a-4103-a2f5-f3f9af9ba9c6.jpg',777,'挺好的');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('a7184417-5aa2-4de0-8237-a4c0f53972a1','华为手机8plus','1300','手机数码','http://image.easymall.com/upload/3/6/c/0/7/2/1/3/741c8c70-cdd1-43a9-8cde-aa6a787129ca_738f47e2-9605-46aa-b647-fc8dca814074.jpg',888,'还可以。。。。老司机推荐使用');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('b1f9c947-4f72-4245-b09d-8c5a8c311ae1','纯色长袖T恤','68','服装服饰','http://image.easymall.com/upload/6/5/5/c/5/4/1/9/d437c381-59af-49ee-80c6-2b01e0b06105_1017530.jpg',888,'男青年圆领加大码2021秋季新款打底衫双面绒t恤德绒秋衣男士卫衣潮流泽荃男装衣服');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description)  
values('bf45940e-ac72-454f-b67f-83dd288d11f9','木林森 夹克男外套','138','服装服饰','http://image.easymall.com/upload/1/4/2/e/7/3/6/4/09af74da-3829-45c5-9517-380d2cc74f6a_preview.jpg',766,'男士韩版潮流宽松青年商务立领棒球服加绒加厚冬季男士皮衣茄克上衣男装衣服 8802黑色');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('c0e7b4f3-e1ad-47d6-8c0d-f1c58b820ca8','大金表','1000','日用百货','http://image.easymall.com/upload/c/4/b/7/b/5/8/f/5adda796-66af-4c6e-a9e5-49a52a3c44a5_371cee6d-d81b-42b7-a11f-3ad36dc0e537.jpg',666,'大金表，好看哦');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('c2952779-e9e0-4eda-8e0a-41a61f1afc66','大金纯金表','10998','日用百货','http://image.easymall.com/upload/e/d/b/1/f/0/6/7/bcff4ee1-cc7f-4b30-a29c-017f76a21bf8_1.jpg',566,'大金纯金表');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('c2978733-5af8-473b-adbc-05073126164b','超值清洁套装','16','日用百货','http://image.easymall.com/upload/3/5/5/4/c/3/a/b/943de853-0e1b-4d51-9524-991607024d3b_IMG_0928.JPG',665,'40*60纯色海绵地垫+加绒加厚敞口或者束口手套1双');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('c766ec19-4645-4e6b-9ddf-73a0f4aa5f6c','肥皂盒架子','9.99','日用百货','http://image.easymall.com/upload/f/e/f/8/2/e/3/c/82c1698f-38a2-4340-9df7-83fadaefff4b_howardmouth.jpg',776,'限量款,全球唯一');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('d73ab7ed-9f78-4775-a93b-4d355b2d5fc0','可折叠洗衣服盆子','44','日用百货','http://image.easymall.com/upload/c/8/1/0/4/6/3/b/28139e28-7390-45a7-82c8-03e673486e60_Desert.jpg',887,'奢吧可折叠洗衣服盆子家用大号加大加深加厚洗衣盆特大号大塑料脸盆');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('d7f7cce4-b268-41a7-9429-21fa69b64159','TCL电视','2000','家用电器','http://image.easymall.com/upload/1/8/e/9/b/2/7/2/95e01470-8e6f-40dc-a76b-087d804bb0cf_bae0a60a-521d-48ef-bea6-0854b89d7be0.jpg',887,'好用啊');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('d8cb845e-37f6-4515-9fc1-dea07719ee06','大号镜子','15.6','日用百货','http://image.easymall.com/upload/6/b/8/3/a/4/9/8/3fb77001-cd6c-4e4f-94a1-21a9c0563778_Hydrangeas.jpg',886,'住校生活用品开学日用百货大学生宿舍好物女生住校生住宿生寝室神器用品 紫色小熊-大号镜子');

insert into t_product(product_id,product_name,product_price,product_category,product_imgurl,product_num,product_description) 
values('ff838641-feb5-42a1-b061-042b9113a95c','华为手机','5899','手机数码','http://image.easymall.com/upload/c/7/4/1/4/2/3/2/a99e691b-88d4-43a2-ac12-82ec54db123d_738f47e2-9605-46aa-b647-fc8dca814074.jpg',668,'充电会自动引爆');

select product_imgurl from t_product;
select count(*) from t_product;

use easydb;
DROP TABLE IF EXISTS t_cart;
CREATE TABLE t_cart(
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(100) DEFAULT NULL,
  product_id varchar(100) DEFAULT NULL,
  product_image varchar(500) DEFAULT NULL,
  product_name varchar(100) DEFAULT NULL,
  product_price double DEFAULT NULL,
  num int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table t_cart */
insert  into t_cart(id,user_id,product_id,product_image,product_name,product_price,num) values
 (29,'f577f9f9-159e-4aaf-9332-fd7b294bc208','a0390f80-bed7-4a92-9954-5e22e64cbe17','http://image.easymall.com/upload/5/0/6/f/4/4/b/f/40ca42aa-8298-430a-9fa9-88d6156d7b18_c987f2c1-4123-4d87-83bd-fe2fb221e272.jpg','护肤品',50,1),
(31,'f577f9f9-159e-4aaf-9332-fd7b294bc208','77feb539-a575-487b-8500-df38520f3239','http://image.easymall.com/upload/5/e/e/6/c/4/9/b/67c1a752-9020-4372-bcda-3375ef01c878_preview.jpg','读者合订本',25.6,5),
(33,'f577f9f9-159e-4aaf-9332-fd7b294bc208','ff838641-feb5-42a1-b061-042b9113a95c','http://image.easymall.com/upload/c/7/4/1/4/2/3/2/a99e691b-88d4-43a2-ac12-82ec54db123d_738f47e2-9605-46aa-b647-fc8dca814074.jpg','华为手机',5899,3);

use easydb;
DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order (
  order_id char(36) NOT NULL DEFAULT '',
  order_money double DEFAULT '0',
  order_receiverinfo varchar(255) DEFAULT '',
  order_paystate int(11) DEFAULT '0',
  order_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  user_id char(36) DEFAULT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table t_order */
insert  into t_order(order_id,order_money,order_receiverinfo,order_paystate,order_time,user_id) values 
('153b198e-228d-435b-91ab-58e6498c00f9',3764.6,'华南师范大学软件学院',0,'2022-06-15 10:00:58','f577f9f9-159e-4aaf-9332-fd7b294bc208');
insert  into t_order(order_id,order_money,order_receiverinfo,order_paystate,order_time,user_id) values
('3bca1c96-2a0f-4b0d-a684-106924823aa2',7283.8,'华南师范大学软件学院',0,'2022-06-15 10:00:18','f577f9f9-159e-4aaf-9332-fd7b294bc208');
insert  into t_order(order_id,order_money,order_receiverinfo,order_paystate,order_time,user_id) values
('da57776f-9fae-431d-9359-18492ae13858',3196.2,'华南师范大学软件学院',0,'2022-06-16 00:19:35','f577f9f9-159e-4aaf-9332-fd7b294bc208');
insert  into t_order(order_id,order_money,order_receiverinfo,order_paystate,order_time,user_id) values
('6f9378f3-c400-4a7a-9e96-5162bc25c842',3178,'华南师范大学软件学院',0,'2022-06-16 00:20:15','f577f9f9-159e-4aaf-9332-fd7b294bc208');
/*Table structure for table t_order_item */

DROP TABLE IF EXISTS t_order_item;

CREATE TABLE t_order_item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  order_id char(100) DEFAULT NULL,
  product_id char(36) DEFAULT NULL,
  num int(11) DEFAULT '0',
  product_image varchar(500) DEFAULT NULL,
  product_name varchar(100) DEFAULT NULL,
  product_price double DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

/*Data for the table t_order_item */

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'6f9378f3-c400-4a7a-9e96-5162bc25c842','a0390f80-bed7-4a92-9954-5e22e64cbe17',1,'http://image.easymall.com/upload/5/0/6/f/4/4/b/f/40ca42aa-8298-430a-9fa9-88d6156d7b18_c987f2c1-4123-4d87-83bd-fe2fb221e272.jpg','护肤品',50);
insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'6f9378f3-c400-4a7a-9e96-5162bc25c842','77feb539-a575-487b-8500-df38520f3239',5,'http://image.easymall.com/upload/5/e/e/6/c/4/9/b/67c1a752-9020-4372-bcda-3375ef01c878_preview.jpg','读者合订本',25.6);
insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'6f9378f3-c400-4a7a-9e96-5162bc25c842','c0e7b4f3-e1ad-47d6-8c0d-f1c58b820ca8',3,'http://image.easymall.com/upload/c/4/b/7/b/5/8/f/5adda796-66af-4c6e-a9e5-49a52a3c44a5_371cee6d-d81b-42b7-a11f-3ad36dc0e537.jpg','大金表',1000);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'da57776f-9fae-431d-9359-18492ae13858','6c28bc1a-9c9b-4be3-b1cf-0068565e64e4',1,'http://image.easymall.com/upload/1/f/b/5/3/4/e/4/61a8cdff-52f7-4fce-bdb5-570426022082_preview.jpg','格力空调',2699);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'da57776f-9fae-431d-9359-18492ae13858','a0390f80-bed7-4a92-9954-5e22e64cbe17',1,'http://image.easymall.com/upload/5/0/6/f/4/4/b/f/40ca42aa-8298-430a-9fa9-88d6156d7b18_c987f2c1-4123-4d87-83bd-fe2fb221e272.jpg','护肤品',50);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'da57776f-9fae-431d-9359-18492ae13858','77feb539-a575-487b-8500-df38520f3239',5,'http://image.easymall.com/upload/5/e/e/6/c/4/9/b/67c1a752-9020-4372-bcda-3375ef01c878_preview.jpg','读者合订本',25.6);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'da57776f-9fae-431d-9359-18492ae13858','6746c459-b284-4256-bbc6-1df60ba4a0a2',4,'http://image.easymall.com/upload/2/6/4/a/a/5/2/3/ee6c796a-6333-4cd5-a06e-271d876aac8c_589577.jpg',' 计算之魂',79.8);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'3bca1c96-2a0f-4b0d-a684-106924823aa2','6746c459-b284-4256-bbc6-1df60ba4a0a2',1,'http://image.easymall.com/upload/2/6/4/a/a/5/2/3/ee6c796a-6333-4cd5-a06e-271d876aac8c_589577.jpg',' 计算之魂',79.8);


insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'3bca1c96-2a0f-4b0d-a684-106924823aa2','26128d47-423b-4220-8047-544ff899db50',5,'http://image.easymall.com/upload/2/1/0/3/f/0/3/5/2fb0b43b-4dbe-440b-899b-13c02a9f5475_22d124c9-df52-4cd4-88b3-691005f1cafe.jpg','1208_01iphone7',850);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'3bca1c96-2a0f-4b0d-a684-106924823aa2','d8cb845e-37f6-4515-9fc1-dea07719ee06',1,'http://image.easymall.com/upload/6/b/8/3/a/4/9/8/3fb77001-cd6c-4e4f-94a1-21a9c0563778_Hydrangeas.jpg','大号镜子',15.6);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'3bca1c96-2a0f-4b0d-a684-106924823aa2','6c28bc1a-9c9b-4be3-b1cf-0068565e64e4',1,'http://image.easymall.com/upload/1/f/b/5/3/4/e/4/61a8cdff-52f7-4fce-bdb5-570426022082_preview.jpg','格力空调',2699);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'153b198e-228d-435b-91ab-58e6498c00f9','d8cb845e-37f6-4515-9fc1-dea07719ee06',1,'http://image.easymall.com/upload/6/b/8/3/a/4/9/8/3fb77001-cd6c-4e4f-94a1-21a9c0563778_Hydrangeas.jpg','大号镜子',15.6);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'153b198e-228d-435b-91ab-58e6498c00f9','6c28bc1a-9c9b-4be3-b1cf-0068565e64e4',1,'http://image.easymall.com/upload/1/f/b/5/3/4/e/4/61a8cdff-52f7-4fce-bdb5-570426022082_preview.jpg','格力空调',2699);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'153b198e-228d-435b-91ab-58e6498c00f9','a0390f80-bed7-4a92-9954-5e22e64cbe17',1,'http://image.easymall.com/upload/5/0/6/f/4/4/b/f/40ca42aa-8298-430a-9fa9-88d6156d7b18_c987f2c1-4123-4d87-83bd-fe2fb221e272.jpg','护肤品',50);

insert  into t_order_item(id,order_id,product_id,num,product_image,product_name,product_price) values 
(null,'153b198e-228d-435b-91ab-58e6498c00f9','09f47493-214d-44bc-927d-6ce0bf89a057',1,'http://image.easymall.com/upload/5/2/3/4/7/8/d/c/1838eaa6-6459-420f-b8e2-6ea9f43c4b5e_dfd259ab-bcc7-43f6-a9d5-62872ff5671e.jpg','爱疯9S(0315-01)',1000);

select t_order.order_id,order_money,num,product_id,product_name,product_price from t_order,t_order_item 
where t_order.order_id=t_order_item.order_id;


