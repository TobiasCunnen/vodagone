use vodagoneDB;

delete from abonnementenVanAbonnees;
delete from abonnees;
delete from abonnementen;

insert into abonnees (name, email, wachtwoord)
values
('Tobias Cunnen','tobiascunnen@gmail.com','wachtwoord'),
('Meron Brouwer','Meron.Brouwer@han.nl','wachtwoord'),
('Dennis Breuker','Dennis.Breuker@han.nl','wachtwoord'),
('Michel Portier','Michel.Portier@han.nl','wachtwoord');

insert into abonnementen (aanbieder,dienst,prijs,verdubbeling,deelbaar)
values

('vodafone', 'Mobiele telefonie 100', 5, 'Nee', 0),
('vodafone', 'Mobiele telefonie 250',10, 'standaard',0),
('vodafone', 'Glasvezel-internet (download 500 Mbps)',40, 'standaard',0),
('ziggo', 'Kabel-internet (download 300 Mbps)',30, 'Nee', 0),
('ziggo', 'Eredivisie Live 1 t/m 5', 10, 'Nee',1),
('ziggo', 'HBO Plus',15,'Nee',1);

insert into abonnementenVanAbonnees (abonneesId, abonnementId, startDatum,verdubbeling,prijs,status)
values
(1,1,'2017-01-01','Nee',5, 'actief'),
(1,2,'2017-01-01','standaard',10,'actief'),
(1,4,'2017-01-01','Nee',30, 'actief');