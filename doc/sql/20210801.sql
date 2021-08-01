-- auto-generated definition
create table sys_user_extra
(
    suc_id        varchar(32)      not null
        primary key,
    user_id       bigint(32) null comment '用户id',
    biz_id        varchar(32)      null comment '业务id',
    status        char default 0   not null comment '状态：0启用,1禁用',
    is_admin      char default 0   null comment '是否是管理员：0不是 1是,默认0',
    biz_type      char default '0' null comment '业务类型：0metamask',
    default_state char default '0' null comment '默认状态：0非默认1默认'
)
comment '用户数据关联';


-- auto-generated definition
create table metamask_info
(
    id          varchar(60) not null,
    create_time datetime    null,
    update_time datetime    null,
    constraint metamask_info_id_uindex
        unique (id)
)
comment 'metamask钱包信息';

alter table metamask_info
    add primary key (id);

