/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.47-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `undo_log` (
	`id` bigint (20),
	`branch_id` bigint (20),
	`xid` varchar (300),
	`context` varchar (384),
	`rollback_info` blob ,
	`log_status` int (11),
	`log_created` datetime ,
	`log_modified` datetime ,
	`ext` varchar (300)
); 
