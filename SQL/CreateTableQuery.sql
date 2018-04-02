use vodagoneDB;

drop table if exists AbonnementenVanAbonnees;
drop table if exists Abonnementen;
drop table if exists Abonnees;

create table Abonnementen
(
id int auto_increment primary key,
aanbieder varchar(255) not null,
dienst varchar(255) not null,
prijs decimal(9,2),
verdubbeling varchar(255),
deelbaar bit
);

create table Abonnees
(
id int auto_increment primary key,
name varchar(255) unique not null,
email varchar(255) not null,
wachtwoord varchar(255) not null
);

create table AbonnementenVanAbonnees
(
abonneesId int,
abonnementId int,
verdubbeling varchar(255),
startDatum date,
status varchar(255),

primary key(abonneesId,abonnementId),
FOREIGN KEY (abonneesId) REFERENCES Abonnees(id),
FOREIGN KEY (abonnementId) REFERENCES Abonnementen(id)
);

