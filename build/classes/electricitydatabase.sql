create database electricity;
use electricity;

CREATE TABLE adminlogin(
USERNAME VARCHAR(20),
NAME VARCHAR(50),
PASSWORD VARCHAR(10)
);

CREATE TABLE newcustomer(
METERNO VARCHAR(10) PRIMARY KEY,
CUSTOMERNAME VARCHAR(50),
ADDRESS VARCHAR(50),
CITY VARCHAR(20),
STATE VARCHAR(20),
EMAIL VARCHAR(20),
MOBILE VARCHAR(15),
USERNAME VARCHAR(50),
PASSWORD VARCHAR(10));

CREATE TABLE meterinfo(
METERNO VARCHAR(10) PRIMARY KEY,
METERLOCATION VARCHAR(50),
METERTYPE VARCHAR(50),
PHASECODE VARCHAR(20),
BILLTYPE VARCHAR(20));

create table tax(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), swacch_bharat_cess varchar(20), fixed_tax varchar(20));
insert into tax values('9','47','22','57','6','18');

create table bill(
METERNO varchar(10),
MONTH varchar(30),
UNITS varchar(15),
TOTALBILL varchar(20),
STATUS varchar(15));

