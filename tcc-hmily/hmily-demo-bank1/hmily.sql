CREATE TABLE local_try_log (
   tx_no VARCHAR(64) NOT NULL COMMENT '事务id',
   create_time DATETIME,
   PRIMARY KEY (`tx_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE local_confirm_log (
   tx_no VARCHAR(64) NOT NULL COMMENT '事务id',
   create_time DATETIME,
   PRIMARY KEY (`tx_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE local_cancel_log (
   tx_no VARCHAR(64) NOT NULL COMMENT '事务id',
   create_time DATETIME,
   PRIMARY KEY (`tx_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;