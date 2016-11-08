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

//创建风险表
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