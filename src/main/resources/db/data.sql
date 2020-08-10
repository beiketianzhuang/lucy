
INSERT INTO `company_data`(data_order,`desc`,business_type,active) VALUES
(1,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司','geti',1);
INSERT INTO `company_data`(data_order,`desc`,business_type,active) VALUES
(2,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司','geti',1);
INSERT INTO `company_data`(data_order,`desc`,business_type,active) VALUES
(3,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司','geti',1);
INSERT INTO `company_data`(data_order,`desc`,business_type,active) VALUES
(4,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司','geti',1);
INSERT INTO `company_data`(data_order,`desc`,business_type,active) VALUES
(5,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司','geti',1);


INSERT INTO `company_step`(step,`desc`,active) VALUES
(1,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司1',1);
INSERT INTO `company_step`(step,`desc`,active) VALUES
(2,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司2',1);
INSERT INTO `company_step`(step,`desc`,active) VALUES
(3,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司3',1);
INSERT INTO `company_step`(step,`desc`,active) VALUES
(4,'公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司4',1);

INSERT INTO `company_question`(step,`question`,answer,active) VALUES
(4,'公司注册流程','公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司',1);

INSERT INTO `business_type`(`name`,`value`,price,active) VALUES
('个体','geti',1000,1);
INSERT INTO `business_type`(`name`,`value`,price,active) VALUES
('有限责任公司','youxianzeren',1000,1);
INSERT INTO `business_type`(`name`,`value`,price,active) VALUES
('股份有限公司','股份有限公司',1000,1);
INSERT INTO `business_type`(`name`,`value`,price,active) VALUES
('分公司','分公司',1000,1);

INSERT INTO `industry`(`name`,`value`,parent_id,active) VALUES
('商贸贸易','shangmaomaoyi',0,1);
INSERT INTO `industry`(`name`,`value`,parent_id,active) VALUES
('科技','科技类',0,1);
INSERT INTO `industry`(`name`,`value`,parent_id,active) VALUES
('文化传媒','wenhuachuanmei',0,1);
INSERT INTO `industry`(`name`,`value`,parent_id,active) VALUES
('咨询管理','zixunguanli',0,1);
INSERT INTO `industry`(`name`,`value`,parent_id,active) VALUES
('经济金融','jinjijinrong',0,1);
