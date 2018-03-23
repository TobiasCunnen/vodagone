use vodagoneDB;

drop table AbonnementenVanAbonnees;
drop table Abonnementen;
drop table Abonnees;

create table Abonnementen
(
id int primary key auto_increment,
aanbieder varchar(255) not null,
dienst varchar(255) not null
);

create table Abonnees
(
id int primary key auto_increment,
name varchar(255) unique key not null,
email varchar(255) not null,
wachtwoord varchar(255) not null
);

create table AbonnementenVanAbonnees
(
abonneesId int,
abonnementId int,
aanbieder varchar(255) not null,
dienst varchar(255) not null,
prijs decimal(9,2),
startDatum date,
verdubbeling varchar(255),
deelbaar boolean,
status varchar(255),

primary key(abonneesId,abonnementId),
FOREIGN KEY (abonneesId) REFERENCES Abonnees(id),
FOREIGN KEY (abonnementId) REFERENCES Abonnementen(id)
);

