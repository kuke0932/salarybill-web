/*
Navicat MySQL Data Transfer

Source Server         : 10.10.10.10
Source Server Version : 50718
Source Host           : 10.10.10.10:3306
Source Database       : webapp

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-11 17:05:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_department`
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父部门id',
  `department_name` varchar(255) NOT NULL COMMENT '部门名称',
  `department_desc` varchar(255) DEFAULT NULL COMMENT '部门描述',
  `department_tags` varchar(255) DEFAULT NULL COMMENT '部门标签',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('1', null, '总部一', null, null, '0', null, null, null, null, null, null);
INSERT INTO `sys_department` VALUES ('12', '1', 'aaa', 'aaa', null, '0', '1', 'admin', '2018-03-01 16:55:08', null, null, null);
INSERT INTO `sys_department` VALUES ('13', '12', 'bbb', 'aaa', null, '1', '1', 'admin', '2018-03-01 16:55:18', null, null, null);
INSERT INTO `sys_department` VALUES ('14', '12', 'bbb', '我是bbb', null, '1', '1', 'admin', '2018-04-11 08:42:53', null, null, null);

-- ----------------------------
-- Table structure for `sys_department_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_department_user`;
CREATE TABLE `sys_department_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_department_user
-- ----------------------------
INSERT INTO `sys_department_user` VALUES ('1', '1', '8', '0', '1', 'admin', '2018-03-01 09:27:07', null, null, null);

-- ----------------------------
-- Table structure for `sys_function`
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父ID',
  `function_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `function_code` varchar(255) DEFAULT NULL COMMENT '英文名',
  `function_url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `function_type` tinyint(4) DEFAULT NULL COMMENT '菜单类型1 菜单 2 按钮',
  `function_sort` int(11) DEFAULT NULL COMMENT '菜单顺序',
  `icon_style` varchar(45) DEFAULT NULL COMMENT '按钮或者菜单上图标样式',
  `is_visible` tinyint(4) DEFAULT '1' COMMENT '是否展示在页面上  1 展示 0  隐藏',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO `sys_function` VALUES ('1', null, '系统菜单', null, null, '1', '1', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('2', '1', '系统管理', null, '', '1', '1', 'systemManagement', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('4', '2', '用户管理', null, 'systemManagement/user/index', '1', '1', 'user', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('5', '4', '添加用户', 'add', '/system/admin/sysUser/addUser', '2', '1', '', '1', '0', null, null, null, '1', 'admin', '2018-03-01 16:45:31');
INSERT INTO `sys_function` VALUES ('6', '4', '修改用户', 'edit', '/system/admin/sysUser/updateUser', '2', '3', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('7', '4', '删除用户', 'del', '/system/admin/sysUser/deleteById', '2', '2', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('8', '2', '部门管理', null, 'systemManagement/department/index', '1', '2', 'department', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('9', '8', '添加部门', 'add', '/system/admin/sysDepartment/addDepartment', '2', '1', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('10', '8', '修改部门', 'edit', '/system/admin/sysDepartment/updateDepartment', '2', '2', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('11', '8', '删除部门', 'del', '/system/admin/sysDepartment/removeDepartment', '2', '3', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('12', '2', '角色管理', null, 'systemManagement/role/index', '1', '3', 'role', '1', '0', null, null, null, '1', 'admin', '2018-02-28 11:28:03');
INSERT INTO `sys_function` VALUES ('13', '12', '添加角色', 'add', '/system/admin/sysRole/addRole', '2', '1', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('14', '12', '修改角色', 'edit', '/system/admin/sysRole/updateRole', '2', '2', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('15', '12', '删除角色', 'del', '/system/admin/sysRole/removeRole', '2', '3', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('16', '2', '群组管理', null, 'systemManagement/group/index', '1', '4', 'group', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('17', '16', '添加群组', 'add', '/system/admin/sysGroup/addGroup', '2', '1', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('18', '16', '修改群组', 'edit', '/system/admin/sysGroup/updateGroup', '2', '2', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('19', '16', '删除群组', 'del', '/system/admin/sysGroup/removeGroup', '2', '3', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('20', '16', '查看用户', 'viewUser', 'systemManagement/group/checkUser', '2', '4', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('21', '20', '添加群组用户', 'add', '/system/admin/sysGroup/addUserToGroup', '2', '1', 'aa', '1', '0', null, null, null, '1', 'admin', '2018-03-01 16:11:11');
INSERT INTO `sys_function` VALUES ('22', '20', '删除群组用户', 'del', '/system/admin/sysGroup/removeUserFromGroup', '2', '2', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('23', '2', '菜单管理', null, 'systemManagement/menu/index', '1', '5', 'menu', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('24', '23', '添加菜单', 'add', '/system/admin/sysFunction/addFunction', '2', '1', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('25', '23', '修改菜单', 'edit', '/system/admin/sysFunction/updateFunction', '2', '2', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('26', '23', '删除菜单', 'del', '/system/admin/sysFunction/removeFunction', '2', '3', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('27', '2', '菜单授权管理', null, 'systemManagement/menuAuthor/index', '1', '6', 'menuAuthor', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('28', '27', '添加角色', 'add', '/system/admin/sysFunction/addRoleToFunction', '2', '1', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('29', '27', '删除角色', 'del', '/system/admin/sysFunction/removeRoleFromFunction', '2', '2', '', '1', '0', null, null, null, '1', 'admin', '2018-04-11 09:02:04');
INSERT INTO `sys_function` VALUES ('38', '1', '测试', null, '', '1', '3', 'aaa', '1', '1', '1', 'admin', '2018-02-27 11:49:29', '1', 'admin', '2018-02-27 11:56:07');
INSERT INTO `sys_function` VALUES ('39', '27', 'aaa', null, '', '2', '1', '', '1', '1', '1', 'admin', '2018-04-11 09:02:41', null, null, null);

-- ----------------------------
-- Table structure for `sys_group`
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) NOT NULL COMMENT '群组名称',
  `group_desc` varchar(255) DEFAULT NULL COMMENT '群组描述',
  `group_tags` varchar(255) DEFAULT NULL COMMENT '群组标签',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(11) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_group
-- ----------------------------
INSERT INTO `sys_group` VALUES ('1', '群组一', '群组一群组一群组一', null, '1', '1', 'admin', '2018-04-11 08:57:22', '1', 'admin', '2018-04-11 08:58:02');

-- ----------------------------
-- Table structure for `sys_group_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_group_user`;
CREATE TABLE `sys_group_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` int(11) DEFAULT NULL COMMENT '群组ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_group_user
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_value` varchar(50) DEFAULT NULL COMMENT '角色值',
  `role_desc` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `role_id_unique` (`id`) USING BTREE,
  KEY `role_name_unique` (`role_name`) USING BTREE,
  KEY `role_value_unique` (`role_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级后台管理员', 'admin', null, '0', null, null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('11', 'test', 'test', 'test', '1', '1', 'admin', '2018-03-01 09:33:49', '1', 'admin', '2018-03-01 17:47:42');
INSERT INTO `sys_role` VALUES ('12', 'test', 'test', 'test', '0', '1', 'admin', '2018-03-02 11:13:21', null, null, null);

-- ----------------------------
-- Table structure for `sys_role_function`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_function`;
CREATE TABLE `sys_role_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `function_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of sys_role_function
-- ----------------------------
INSERT INTO `sys_role_function` VALUES ('3', '1', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('31', '1', '2', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('32', '1', '3', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('33', '1', '4', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('34', '1', '5', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('35', '1', '6', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('36', '1', '7', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('37', '1', '8', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('38', '1', '9', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('39', '1', '10', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('40', '1', '11', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('41', '1', '12', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('42', '1', '13', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('43', '1', '14', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('44', '1', '15', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('45', '1', '16', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('46', '1', '17', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('47', '1', '18', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('48', '1', '19', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('49', '1', '20', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('50', '1', '21', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('51', '1', '22', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('52', '1', '23', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('53', '1', '24', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('54', '1', '25', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('55', '1', '26', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('56', '1', '27', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('57', '1', '28', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('58', '1', '29', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('59', '1', '30', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('60', '1', '31', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('61', '1', '32', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('62', '1', '33', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('72', '1', '36', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('73', '1', '37', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('80', '9', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('81', '9', '2', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('82', '9', '4', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('83', '9', '5', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('84', '10', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('85', '10', '2', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('86', '10', '4', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('87', '10', '5', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('88', '10', '7', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('91', '11', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('92', '11', '3', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('93', '11', '34', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('95', '12', '3', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('96', '12', '34', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_function` VALUES ('97', '12', '35', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色用户关联表';

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '1', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_user` VALUES ('7', '12', '8', '0', null, null, null, null, null, null);
INSERT INTO `sys_role_user` VALUES ('8', '12', '1', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `login_pwd` varchar(32) NOT NULL COMMENT '登录密码',
  `salt` varchar(6) DEFAULT NULL COMMENT '盐',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户真实姓名名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件地址',
  `mobile` varchar(12) NOT NULL DEFAULT '0' COMMENT '手机号码',
  `telephone` varchar(20) DEFAULT NULL COMMENT '座机号码',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态.1: 正常,0:冻结',
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `last_login_ip` varchar(20) DEFAULT NULL COMMENT '最后登录IP',
  `api_key` varchar(16) DEFAULT NULL COMMENT 'WEBAPI key',
  `api_secret` varchar(32) DEFAULT NULL COMMENT 'WEBAPI secret',
  `logical_del` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标志   1 删除 0 未删除',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建者名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者ID',
  `update_name` varchar(20) DEFAULT NULL COMMENT '更新者名字',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ak_mobile_unique` (`mobile`) USING BTREE,
  UNIQUE KEY `login_name_unique` (`login_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'c61551543c789d869b997517755dbb0e', 'f094uy', 'admin', null, '13663218177', '13663218177', '1', '2018-01-30 13:57:34', null, null, null, '0', null, null, null, '1', 'admin', '2018-01-30 13:57:41');
INSERT INTO `sys_user` VALUES ('8', 'test', '62c2eee13281c9217c17872b94890b4b', 'QkrExC', 'test', '123@qq.com', '15373961111', '12345678', '1', '2018-03-01 09:27:08', null, null, null, '0', '1', 'admin', '2018-03-01 09:27:07', null, null, null);
INSERT INTO `sys_user` VALUES ('9', '1111', 'f38167c5e34213de32f065df9196e481', 'VEDquY', '111111', '123@qq.com', '18132420711', '', '1', '2018-04-11 08:52:06', null, null, null, '1', '1', 'admin', '2018-04-10 17:52:53', '1', 'admin', '2018-04-11 08:52:12');
INSERT INTO `sys_user` VALUES ('11', 'aaaaaaa', '3e9ee9efbaa3bad24bc94608ef0d90c2', 'YVW8ry', 'aaaaaaaa', '111@qq.com', '18111111111', '', '1', '2018-04-11 10:02:22', null, null, null, '1', '1', 'admin', '2018-04-11 10:02:08', '1', 'admin', '2018-04-11 10:02:22');

-- ----------------------------
-- Table structure for `web_user`
-- ----------------------------
DROP TABLE IF EXISTS `web_user`;
CREATE TABLE `web_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '前台用户表主键',
  `login_name` varchar(20) NOT NULL COMMENT '账号',
  `login_pwd` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(6) NOT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_user
-- ----------------------------
