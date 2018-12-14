# --- First database schema

# --- !Ups

set ignorecase true;

create table members (
  id                        bigint not null,
  city                      bigint not null,
  bd                        bigint not null,
  gender                    varchar(255) not null,
  registered_via            bigint not null,
  registration_init_time    bigint not null,
  payment_method_id         bigint not null,
  payment_plan_days         bigint not null,
  plan_list_price           bigint not null,
  actual_amount_paid        bigint not null,
  is_auto_renew             bigint not null,
  transaction_date          bigint not null,
  membership_expire_date    bigint not null,
  is_cancel                 bigint not null,
  constraint pk_members primary key (id))
;
