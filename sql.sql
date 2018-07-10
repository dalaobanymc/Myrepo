drop table logistics;
drop table goods;
drop table User;
drop table Merchants;
drop table courier;
drop table logi_comp;

create table User(
	user_id int not null auto_increment,
	user_name varchar(20) not null,
	user_account varchar(20) not null unique,
	user_passwd varchar(20) not null,
	user_email varchar(20) not null,
	user_tel char(11) not null,
	user_addr varchar(50) not null,
	constraint User_pk primary key(user_id)
);
insert into User(user_name,user_account,user_passwd,user_email,user_tel,user_addr) values('yumaochuan','dalaoban','502001','171099819@qq.com','17394943211','电子科技大学');

create table Merchants(
	Merchants_id int not null auto_increment,
	Merchants_name varchar(20) not null,
	Merchants_account varchar(20) not null unique,
	Merchants_passwd varchar(20) not null,
	Merchants_email varchar(20) not null,
	Merchants_tel char(11) not null,
	Merchants_addr varchar(50) not null,
	constraint Merchants_PK primary key(Merchants_id)
);
insert into Merchants(Merchants_name,Merchants_account,Merchants_passwd,Merchants_email,Merchants_tel,Merchants_addr)values('无良商家','hhh','502001','171099819@qq.com','17394943211','电子科技大学');

create table goods(
	goods_id int not null auto_increment,
	goods_name varchar(20) not null,
	goods_type varchar(20) not null,
	goods_num int not null,
	Merchants_id int not null,
	constraint goods_pk primary key(goods_id),
	constraint goods_Merchants_fk foreign key(Merchants_id) references Merchants(Merchants_id) 
	on update cascade
	on delete cascade
);
insert into goods(goods_name,goods_type,goods_num,Merchants_id) values('充气娃娃','玩具',10,1);

create table courier(
	courier_id int not null auto_increment,
	courier_name varchar(20) not null,
	courier_tel char(11) not null,
	courier_area char(20) not null,
	courier_goods_num int default 0 not null,
	constraint courier_pk primary key(courier_id)
);
insert into courier(courier_name,courier_tel,courier_area,courier_goods_num) values('王冠宇','买不起手机','厕所',12);

create table logi_comp(
    logi_comp_id  int  not null auto_increment,
    logi_comp_account  char(20)  not null unique,
    logi_comp_passwd  char(20)  not null,
    constraint  logi_comp_pk  primary key(logi_comp_id)
);
insert into logi_comp(logi_comp_account,logi_comp_passwd) values('system','password');

create table logistics(
	logistics_id int not null auto_increment,
	goods_id int not null,
	user_id int not null,
	Merchants_id int not null,
	courier_id int default 0 not null, 
	place_now varchar(50) default '商家发货地' not null,
	logistics_state varchar(15) default 'unsended' not null,
	constraint logistics_pk primary key(logistics_id),
	constraint logistics_goods_fk foreign key(goods_id) references goods(goods_id)
	on update cascade
	on delete cascade,
	constraint logistics_user_fk foreign key(user_id) references User(user_id)
	on update cascade
	on delete cascade,
	constraint logistics_Merchants_fk foreign key(Merchants_id) references Merchants(Merchants_id)
	on update cascade
	on delete cascade,
	constraint logistics_courier_fk foreign key(courier_id) references courier(courier_id)
	on update cascade
	on delete cascade
);
insert into logistics(goods_id,user_id,Merchants_id,courier_id,place_now,logistics_state) values(1,1,1,1,'成都','未发货');

