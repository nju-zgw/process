use managesys;
create database if not exists managesys character set utf8;
create table users (
  user_id int not null auto_increment,
  user_name varchar(32) not null,
  user_pwd varchar(32) not null default '1234',
  primary key (user_id)
);

create table roles (
  role_id int not null auto_increment,
  role_name varchar(20) not null,
  primary key(role_id)
);

create table rights (
  right_id int not null auto_increment,
  right_name varchar(20) not null,
  primary key(right_id)
);

create table user_role_rel(
  rel_id int not null auto_increment,
  user_id int not null,
  role_id int not null,
  primary key(rel_id),
  CONSTRAINT UC_UR UNIQUE (user_id,role_id),
  CONSTRAINT `FK_UR_REF_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_UR_REF_ROLE` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
);

create table role_right_rel(
  rel_id int not null auto_increment,
  role_id int not null,
  right_id int not null,
  primary key(rel_id),
  CONSTRAINT UC_RR UNIQUE (role_id,right_id),
  CONSTRAINT `FK_RR_REF_ROLE` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `FK_RR_REF_RIGHT` FOREIGN KEY (`right_id`) REFERENCES `rights` (`right_id`)
);


create table risk_items (
  risk_item_id int not null auto_increment,
  project_id int not null,
  creater_id int not null,
  risk_type_id int not null,
  risk_descript_id int ,
  risk_prob tinyint(1) not null default 0,
  risk_affest tinyint(1) not null default 0,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  primary key(risk_item_id)
);

create table risk_types (
  type_id int not null primary key,
  type_name varchar(128) not null,
  parent_type int default NULL
);

create table risk_descripts (
  risk_descript_id int not null auto_increment,
  risk_descript text,
  primary key(risk_descript_id)
);

create table risk_status (
  status_id int not null auto_increment,
  risk_item_id int not null,
  tracer_id int not null,
  risk_status_descript_id int not null,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  primary key(status_id)
);
create table risk_status_descripts (
  status_descript_id int not null auto_increment,
  status_descript text,
  primary key(status_descript_id)
);

create table projects (
  project_id int not null auto_increment,
  project_name varchar(64) not null,
  project_descript varchar(64) not null default '暂无',
  project_period int not null,
  manager_id int not null,
  start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  project_status tinyint(1) not null default 0,
  primary key(project_id)
);

create table user_project_rel (
  rel_id int not null auto_increment,
  user_id int not null,
  project_id int not null,
  join_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  primary key(rel_id),
  CONSTRAINT UP_RR UNIQUE (user_id,project_id),
  CONSTRAINT `FK_UP_REF_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_UP_REF_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
);

#用户角色关联
INSERT INTO user_role_rel (user_id, role_id) VALUES
  (1,1), (2,2), (3,3), (4,4);

#角色权限关联
INSERT INTO role_right_rel (role_id, right_id) VALUES (1,1), (1,2), (1,4),
  (1,8), (1,9),
  (2,1), (2,2), (2,3), (2,4), (2,8), (2,9),
  (3,5), (3,6), (3,7), (3,8), (3,9);


#Users表和Spring-security的信息要一致

select risk_item_id,p.project_id,creater_id,risk_type_id,risk_descript_id,risk_prob,risk_affect,create_time,
  p.project_name as pname
from risk_items ri
  join projects p on p.project_id = ri.project_id
where ri.project_id in (select upr.project_id from user_project_rel upr where user_id = 1 );


#插入Project数据
insert into projects
(project_name, project_descript,project_period, manager_id, project_status )
values
  ('企业信息管理项目', '为南京大学软件学院开发的项目，投资巨大，功能复杂',30, 2, 1),
  ('数据收集和分析软件', '1.适用行业场景：产品连锁店面 2.周期要求：长期 3.详细功能描述：数据采集和数据分析等 4.终端要求：电脑和手机',90, 2, 1),
  ('考核试卷自动生成PC端软件', '软件功能：类似于驾考科目一那种类型的试题生成软件，员工考核完成后自动输出成绩。',50, 2, 1),
  ('二手车置换交易管理系统', '梳理了二手车置换交易中，二手车经营公司、汽车厂商、汽车4S店与经纪公司信息流通的过程，解决了二手车置换流程的信息化管理。',30, 2, 1),
  ('合同执行管理系统', '该系统分为合同管理、合同分拆、合同评审、生成计划、生产管理、发货管理、物流管理、售后服务八个主要部分贯穿整个系统',30, 2, 1);

#插入user project relation
INSERT INTO user_project_rel (user_id, project_id)
    VALUES
      (1,1),(1,2),(1,3),(1,4),(1,5);