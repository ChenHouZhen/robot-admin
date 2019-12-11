/*
 Navicat Premium Data Transfer

 Source Server         : localhost - 本地
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : robot

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 11/12/2019 09:08:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '菜单图标',
  `order_num` int(11) DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 258 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', 'systemManage', '', 0, NULL, 0);
INSERT INTO `sys_menu` VALUES (2, 0, '首页', 'home', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (3, 0, '学科管理', 'subjectManage', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (4, 0, '学科知识点', 'subjectLore', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (5, 0, '课程管理', 'courseManage', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (6, 0, '课程知识点', 'courseLore', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (7, 0, '审批管理（架构师）', 'approvalArchitect', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (8, 0, '审批管理（录入员）', 'approvalDES', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (9, 0, '个人中心', 'userCenter', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (10, 0, '帮助中心', 'helpCenter', '', 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (11, 3, '建立学科', 'subjectManageFound', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (12, 3, '学科知识图谱', 'subjectManageAtlas', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (13, 4, '学科知识点-知识管理-版本管理', 'subjectLoreVersion', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (14, 4, '学科知识点-知识管理-图文管理', 'subjectLoreImageText', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (15, 4, '学科知识点-知识管理-音视频管理', 'subjectLoreAudioVideo', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (16, 4, '学科知识点-知识管理-题目管理', 'subjectLoreProblems', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (17, 4, '学科知识点-知识点详情', 'subjectLoreDetail', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (18, 4, '学科知识点-图文详情', 'subjectLoreImageTextDetail', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (19, 4, '学科知识点-知识关系', 'subjectLoreNexus', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (20, 4, '学科知识点-学科图谱', 'subjectLoreAtlas', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (21, 5, '课程管理-课程管理', 'courseManageManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (22, 5, '课程管理-课程大纲', 'courseManageSyllabus', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (23, 5, '课程管理-课程介绍', 'courseManageIntroduce', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (24, 6, '课程知识点-课程知识点属性', 'courseLoreAttribute', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (25, 6, '课程知识点-课程知识点内容', 'courseLoreContent', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (26, 7, '审批管理（架构师）-学科知识点版本', 'subjectVersionArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (27, 7, '审批管理（架构师）-学科知识点图文', 'subjectImageTextArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (28, 7, '审批管理（架构师）-学科知识点音视频', 'subjectAudioVideoArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (29, 7, '审批管理（架构师）-课程知识点属性', 'courseAttrbuteArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (30, 7, '审批管理（架构师）-课程知识点版本', 'courseVersionArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (31, 7, '审批管理（架构师）-课程知识点图文', 'courseImageTextArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (32, 7, '审批管理（架构师）-课程知识点音视频', 'courseAudioVideoArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (33, 7, '审批管理（架构师）-课程知识点题目', 'courseProblemsArchitect', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (34, 8, '审批管理（录入员）-学科知识点版本', 'subjectVersionDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (35, 8, '审批管理（录入员）-学科知识点图文', 'subjectImageTextDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (36, 8, '审批管理（录入员）-学科知识点音视频', 'subjectAudioVideoDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (37, 8, '审批管理（录入员）-课程知识点属性', 'courseAttrbuteDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (38, 8, '审批管理（录入员）-课程知识点版本', 'courseVersionDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (39, 8, '审批管理（录入员）-课程知识点图文', 'courseImageTextDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (40, 8, '审批管理（录入员）-课程知识点音视频', 'courseAudioVideoDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (41, 8, '审批管理（录入员）-课程知识点题目', 'courseProblemsDES', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (42, 1, '系统管理-用户管理', 'userManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (43, 1, '系统管理-角色管理', 'roleManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (44, 1, '系统管理-权限管理', 'authorityManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (45, 1, '系统管理-菜单管理', 'menuManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (46, 1, '系统管理-部门管理', 'sectionManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (47, 1, '系统管理-统计管理', 'statisticsManage', 'sys:count', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (48, 1, '系统管理-字典管理', 'wordbookManage', '', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (51, 46, '添加', NULL, 'sys:dept:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (52, 46, '修改', NULL, 'sys:dept:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (53, 46, '删除', NULL, 'sys:dept:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (56, 48, '添加', NULL, 'sys:dict:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (57, 48, '修改', NULL, 'sys:dict:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (58, 48, '删除', NULL, 'sys:dict:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (60, 48, '刷新缓存', NULL, 'sys:dict:redis', 2, '', 0);
INSERT INTO `sys_menu` VALUES (61, 45, '添加', NULL, 'sys:menu:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (62, 45, '修改', NULL, 'sys:menu:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (63, 45, '删除', NULL, 'sys:menu:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (66, 43, '添加', NULL, 'sys:role:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (67, 43, '修改', NULL, 'sys:role:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (68, 43, '删除', NULL, 'sys:role:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (71, 44, '角色授权', NULL, 'sys:role:auth', 2, '', 0);
INSERT INTO `sys_menu` VALUES (72, 42, '添加', NULL, 'sys:user:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (73, 42, '修改', NULL, 'sys:user:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (74, 42, '删除', NULL, 'sys:user:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (77, 42, '重置密码', NULL, 'sys:user:resetPassword', 2, '', 0);
INSERT INTO `sys_menu` VALUES (85, 23, '添加', NULL, 'sys:course-introduce:insert', 2, '', 0);
INSERT INTO `sys_menu` VALUES (86, 23, '修改', NULL, 'sys:course-introduce:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (87, 23, '删除', NULL, 'sys:course-introduce:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (90, 23, '批量导入', NULL, 'sys:course-introduce:import', 2, '', 0);
INSERT INTO `sys_menu` VALUES (91, 23, '批量导出', NULL, 'sys:course-introduce:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (95, 29, '通过审批', NULL, 'sys:course-knowledge-check:pass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (96, 29, '驳回审批', NULL, 'sys:course-knowledge-check:unpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (98, 29, '删除', NULL, 'sys:course-knowledge-check:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (99, 29, '修改', NULL, 'sys:course-knowledge-check:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (100, 29, '批量导出', NULL, 'sys:course-knowledge-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (102, 21, '增加', NULL, 'sys:course:insert', 2, '', 0);
INSERT INTO `sys_menu` VALUES (103, 21, '修改', NULL, 'sys:course:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (104, 21, '删除', NULL, 'sys:course:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (105, 21, '导出', NULL, 'sys:course:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (106, 6, '课程知识点-课程知识点属性详情', 'courseLoreDetail', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (108, 22, '导入', NULL, 'sys:course-outline:import', 2, '', 0);
INSERT INTO `sys_menu` VALUES (109, 22, '导出', NULL, 'sys:course-outline:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (110, 22, '添加', NULL, 'sys:course-outline:insert', 2, '', 0);
INSERT INTO `sys_menu` VALUES (111, 12, '知识点树', '/sub/kg/tree', 'subject:kg:tree', 2, '', 0);
INSERT INTO `sys_menu` VALUES (112, 22, '修改', '', 'sys:course-outline:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (113, 22, '删除', '', 'sys:course-outline:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (114, 0, '公共权限', '/common', '', 0, '', 0);
INSERT INTO `sys_menu` VALUES (116, 33, '删除', NULL, 'check:course:exercise:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (117, 33, '通过审批', NULL, 'check:course:exercise:pass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (118, 33, '驳回审批', NULL, 'check:course:exercise:reject', 2, '', 0);
INSERT INTO `sys_menu` VALUES (119, 33, '导出', NULL, 'check:course:exercise:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (120, 114, '公共接口', '/common', '', 1, '', 0);
INSERT INTO `sys_menu` VALUES (122, 11, '添加', NULL, 'subject:save', 2, '', 0);
INSERT INTO `sys_menu` VALUES (123, 11, '修改', NULL, 'subject:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (124, 11, '删除', NULL, 'subject:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (128, 24, '添加', NULL, 'sys:course-knowledge:insert', 2, '', 0);
INSERT INTO `sys_menu` VALUES (130, 24, '修改', NULL, 'sys:course-knowledge:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (131, 24, '删除', NULL, 'sys:course-knowledge:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (132, 24, '导入', NULL, 'sys:course-knowledge:import', 2, '', 0);
INSERT INTO `sys_menu` VALUES (133, 24, '导出', NULL, 'sys:course-knowledge:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (135, 25, '绑定/解绑', '', 'sys:course-knowledge:insert', 2, '', 0);
INSERT INTO `sys_menu` VALUES (136, 12, '导入', '/sub/kg/import-xmind/{subjectId}', 'subject:kg:importXmind', 2, '', 0);
INSERT INTO `sys_menu` VALUES (137, 12, '导出', '/sub/kg/export-xmind/{subjectId}', 'subject:kg:exportXmind', 2, '', 0);
INSERT INTO `sys_menu` VALUES (139, 41, '删除', NULL, 'check:course:exercise:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (140, 41, '通过审批', NULL, 'check:course:exercise:pass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (141, 41, '驳回', NULL, 'check:course:exercise:reject', 2, '', 0);
INSERT INTO `sys_menu` VALUES (142, 41, '导出', NULL, 'check:course:exercise:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (143, 12, '添加', '/sub/kg/create', 'subject:kg:create', 2, '', 0);
INSERT INTO `sys_menu` VALUES (144, 12, '编辑', '/sub/kg/edit', 'subject:kg:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (145, 12, '删除', '/sub/kg/delete', 'subject:kg:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (153, 30, '通过', '', 'sys:version-relation-check:pass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (154, 30, '驳回', NULL, 'sys:version-relation-check:unpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (156, 30, '导出', NULL, 'sys:version-relation-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (159, 38, '删除', NULL, 'sys:version-relation-check:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (160, 38, '修改', NULL, 'sys:version-relation-check:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (161, 38, '导出', NULL, 'sys:version-relation-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (163, 32, '通过', NULL, 'sys:media-relation-check:pass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (164, 13, '模板下载', NULL, 'kg:content:templateExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (165, 13, '导入', NULL, 'kg:content:import', 2, '', 0);
INSERT INTO `sys_menu` VALUES (167, 13, '删除', NULL, 'kg:content:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (168, 13, '导出', NULL, 'kg:content:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (169, 13, '编辑', NULL, 'kg:content:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (173, 26, '通过', NULL, 'check:kg:content:batchPass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (174, 26, '驳回', NULL, 'check:kg:content:batchUnpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (177, 32, '驳回', '', 'sys:media-relation-check:unpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (179, 34, '删除', NULL, 'check:kg:content:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (181, 34, '修改', NULL, 'check:kg:content:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (182, 32, '导出', '', 'sys:media-relation-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (183, 26, '导出', NULL, 'check:kg:content:batchExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (188, 14, '导入', NULL, 'subject:doc:import', 2, '', 0);
INSERT INTO `sys_menu` VALUES (189, 14, '删除', NULL, 'subject:doc:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (190, 14, '导出', NULL, 'subject:doc:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (191, 14, '编辑', NULL, 'subject:doc:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (192, 14, '模板下载', NULL, 'subject:doc:templateExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (195, 27, '通过', NULL, 'check:kg:content:batchPass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (196, 27, '驳回', NULL, 'check:kg:content:batchUnpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (202, 35, '删除', NULL, 'check:kg:content:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (203, 40, '删除', '', 'sys:media-relation-check:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (204, 35, '修改', NULL, 'check:kg:content:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (205, 40, '修改', '', 'sys:media-relation-check:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (208, 40, '导出', '', 'sys:media-relation-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (210, 31, '通过', NULL, 'sys:doc-relation-check:pass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (211, 31, '驳回', NULL, 'sys:doc-relation-check:unpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (213, 31, '导出', NULL, 'sys:doc-relation-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (214, 15, '编辑', NULL, 'subject:media:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (217, 39, '删除', NULL, 'sys:doc-relation-check:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (218, 39, '修改', NULL, 'sys:doc-relation-check:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (220, 39, '导出', NULL, 'sys:doc-relation-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (222, 15, '删除', NULL, 'subject:media:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (223, 15, '导入', NULL, 'subject:media:import', 2, '', 0);
INSERT INTO `sys_menu` VALUES (224, 15, '导出', NULL, 'subject:media:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (225, 15, '模板下载', NULL, 'subject:media:template:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (226, 15, '预览', NULL, 'subject:media:preview', 2, '', 0);
INSERT INTO `sys_menu` VALUES (229, 28, '通过', NULL, 'check:kg:content:batchPass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (230, 28, '驳回', NULL, 'check:kg:content:batchUnpass', 2, '', 0);
INSERT INTO `sys_menu` VALUES (234, 36, '删除', NULL, 'check:kg:content:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (235, 36, '修改', NULL, 'check:kg:content:edit', 2, '', 0);
INSERT INTO `sys_menu` VALUES (236, 36, '导出', NULL, 'check:kg:content:batchExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (237, 36, '预览', NULL, 'subject:media:preview', 2, '', 0);
INSERT INTO `sys_menu` VALUES (240, 37, '删除', NULL, 'sys:course-knowledge-check:delete', 2, '', 0);
INSERT INTO `sys_menu` VALUES (241, 37, '修改', NULL, 'sys:course-knowledge-check:update', 2, '', 0);
INSERT INTO `sys_menu` VALUES (243, 37, '导出', NULL, 'sys:course-knowledge-check:export', 2, '', 0);
INSERT INTO `sys_menu` VALUES (244, 120, '公共-上传接口-上传图片', NULL, 'upload:image', 2, '', 0);
INSERT INTO `sys_menu` VALUES (245, 120, '公共-上传接口-上传文件', NULL, 'upload:file', 2, '', 0);
INSERT INTO `sys_menu` VALUES (246, 19, '建立关系', NULL, 'subject:kg:relation:build', 2, '', 0);
INSERT INTO `sys_menu` VALUES (250, 1, '1', '1', '1', 1, '', 0);
INSERT INTO `sys_menu` VALUES (251, 27, '导出', NULL, 'check:kg:content:batchExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (253, 28, '导出', NULL, 'check:kg:content:batchExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (255, 35, '导出', NULL, 'check:kg:content:batchExport', 2, '', 0);
INSERT INTO `sys_menu` VALUES (257, 34, '导出', NULL, 'check:kg:content:batchExport', 2, '', 0);

SET FOREIGN_KEY_CHECKS = 1;
