drop table t_b_sys_org;
create table t_b_sys_org (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '组织管理',
  `org_no` bigint(20) NOT NULL,
  `org_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent_org_no` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `create_by` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_by` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1-生效，0-失效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_org_no` (`org_no`),
  KEY `idx_org_name` (`org_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
