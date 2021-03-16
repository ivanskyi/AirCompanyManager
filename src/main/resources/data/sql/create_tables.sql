create database air_manager;

create table air_company (
    id int auto_increment primary key,
    name varchar(100) null,
    company_type varchar(100) null,
    founded_at varchar(100) null
);

create table airplane (
    id int auto_increment primary key,
    name varchar(100) null,
    factory_serial_number int null,
    air_company_id int null,
    number_of_flights int null,
    flight_distance int null,
    fuel_capacity int null,
    type varchar(100) null,
    created_at varchar(100) null
);

create table flight (
    id int auto_increment primary key,
    flight_status varchar(100) null,
    air_company_id int null,
    airplane_id int null,
    departure_country varchar(100) null,
    destination_country varchar(100) null,
    distance int null,
    estimated_flight_time int null,
    ended_at varchar(100) null,
    delay_started_at varchar(100) null,
    created_at varchar(100) null
);