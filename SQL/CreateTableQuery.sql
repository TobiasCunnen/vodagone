use vodagoneDB;

create table Abonnementen
(
id int primary key auto_increment,
aanbieder varchar(255) not null,
dienst varchar(255) not null,
prijs decimal(9,2),
startDatum date,
verdubbeling varchar(255),
deelbaar boolean,
status varchar(255)
);

create table Abonnees
(
id int primary key auto_increment,
name varchar(255) unique key not null,
email varchar(255) not null,
wachtwoord varchar(255) not null
);
