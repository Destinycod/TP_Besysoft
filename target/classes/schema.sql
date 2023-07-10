create table clients (
        id bigint not null auto_increment,
        city varchar(255),
        code_zip varchar(255),
        department varchar(255),
        floor varchar(255),
        number varchar(255),
        street varchar(255),
        email varchar(255) not null,
        landline_phone varchar(255),
        cellphone varchar(255),
        last_name varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
);
alter table clients add constraint UK_srv16ica2c1csub334bxjjb59 unique (email);

create table employees (
        id bigint not null auto_increment,
        city varchar(255),
        code_zip varchar(255),
        department varchar(255),
        floor varchar(255),
        number varchar(255),
        street varchar(255),
        employee_type varchar(255),
        cellphone varchar(255),
        last_name varchar(255),
        name varchar(255),
        primary key (id)
);

create table manpowers (
	id bigint not null auto_increment,
    detail varchar(255),
    hours_duration varchar(255),
    mechanic_id bigint,
    work_order_id bigint,
    primary key (id)
);
alter table manpowers
       add constraint FKjjd2lrlqbr04wlpm202i3f0ll
       foreign key (mechanic_id)
       references mechanics (id);
alter table manpowers
       add constraint FKi50j8w3k9jed6y8do30racl6j
       foreign key (work_order_id)
       references work_orders (id);

create table mechanics (
       id bigint not null auto_increment,
        active varchar(255),
        city varchar(255),
        code_zip varchar(255),
        department varchar(255),
        floor varchar(255),
        number varchar(255),
        street varchar(255),
        cellphone varchar(255),
        last_name varchar(255),
        name varchar(255),
        specialization varchar(255),
        primary key (id)
);

create table vehicles (
       id bigint not null auto_increment,
        brand varchar(255),
        color varchar(255),
        model varchar(255),
        patent varchar(255) not null,
        year integer,
        primary key (id)
);
alter table vehicles add constraint UK_lnau42bxng0y5sj22d83pomqj unique (patent);

create table spare_parts (
       id bigint not null auto_increment,
        brand varchar(255),
        model varchar(255),
        spare_part varchar(255),
        value double precision,
        primary key (id)
);

create table work_orders (
       id bigint not null auto_increment,
        card_type varchar(255),
        end_date_of_repair date,
        entry_date date,
        failure_detail varchar(255),
        fuel_level varchar(255),
        mileage integer,
        number_of_installments integer,
        payment_date date,
        payment_method varchar(255),
        status varchar(255),
        total_value double precision,
        employee_id bigint,
        vehicle_id bigint,
        primary key (id)
);
alter table work_orders
       add constraint FKr1v7lpbqwxsxxg4nwevysi8ru
       foreign key (employee_id)
       references employees (id);
alter table work_orders
       add constraint FKq9nxf367ol3tyrwnfyv9jscam
       foreign key (vehicle_id)
       references vehicles (id);

create table work_order_details (
       id bigint not null auto_increment,
        amount integer,
        total_value double precision,
        spare_part_id bigint,
        work_order_id bigint,
        primary key (id)
);
alter table work_order_details
       add constraint FKeua34xq8nji18wa2kaqw5qv6k
       foreign key (spare_part_id)
       references spare_parts (id);
alter table work_order_details
       add constraint FK8g45kde1cgbxuvjt3yen0qiso
       foreign key (work_order_id)
       references work_orders (id);

create table rel_clients_vehicles (
       client_id bigint not null,
        vehicle_id bigint not null
);
alter table rel_clients_vehicles
       add constraint FKk45ofsqr7p811rfs902hf6xm3
       foreign key (vehicle_id)
       references vehicles (id);
alter table rel_clients_vehicles
       add constraint FKpdo8s4g2fs63y4ekix6s1gp47
       foreign key (client_id)
       references clients (id);