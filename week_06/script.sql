--------------
create table "user"
(
    id serial not null
        constraint user_pk
            primary key,
    name varchar(64) not null,
    image varchar(256)
);

comment on table "user" is '用户表';

comment on column "user".id is '主键';

comment on column "user".name is '用户名';

comment on column "user".image is '用户头像';

create table product
(
    id serial not null
        constraint product_pk
            primary key,
    name varchar(256),
    image_url varchar(256),
    qty int
);

comment on table product is '商品表';

comment on column product.name is '商品名称';

comment on column product.image_url is '商品图片';

comment on column product.qty is '库存量';

create table "order"
(
    id int not null,
    order_id varchar(128),
    buy_time timestamp,
    user_id int
);

comment on table "order" is '订单表';

comment on column "order".order_id is '订单号';

comment on column "order".buy_time is '购买时间';

comment on column "order".user_id is '用户表主键；下单的用户';

create unique index order_id_uindex
    on "order" (id);

alter table "order"
    add constraint order_pk
        primary key (id);

create table order_product
(
    order_id int,
    product_id int,
    num int
);

comment on table order_product is '订单下购买商品表';

comment on column order_product.order_id is '订单表id';

comment on column order_product.product_id is '商品id';

comment on column order_product.num is '该商品购买数量';



