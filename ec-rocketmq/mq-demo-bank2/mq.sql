CREATE TABLE de_duplication (
   tx_no VARCHAR(64) NOT NULL COMMENT '事务id',
   create_time DATETIME,
   PRIMARY KEY (`tx_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;