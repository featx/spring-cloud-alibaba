create table if not exists `t_domain_feature_module`
(
    `id`          bigint unsigned                                                    not null auto_increment comment '',
    `code`        varchar(32)  default ''                                            not null comment '业务编码',
    `name`        varchar(32)  default ''                                            not null comment '名称',
    `type`        int          default '0'                                           not null comment '类型',
    `status`      int unsigned default 0                                             not null comment '模块 状态',
    `sort`        int unsigned default 0                                             not null comment '模块 排序位 默认为0',
    `image_url`   varchar(128) default ''                                            not null comment '模块 图示 url',
    `description` varchar(255) default ''                                            not null comment '描述',
    `deleted`     tinyint      default 0                                             not null comment '软删除标记',
    `created_at`  datetime     default current_timestamp                             not null comment '创建时间',
    `updated_at`  datetime     default current_timestamp on update current_timestamp not null comment '最新修改的时间',
    primary key (id),
    unique key `uk_domain_feature_module_code` (`code`)
) Engine = INNODB, comment '';