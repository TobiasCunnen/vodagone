use vodagoneDB;

delete from abonnementenVanAbonnees;
delete from abonnees;
delete from abonnementen;

insert into abonnees (name, email, wachtwoord)
values
('Tobias Cunnenn','tobiascunnen@gmail.com','wachtwoord'),
('Meron Brouwer','Meron.Brouwer@han.nl','wachtwoord'),
('Dennis Breuker','Dennis.Breuker@han.nl','wachtwoord'),
('Michel Portier','Michel.Portier@han.nl','wachtwoord');

insert into abonnementen (aanbieder,dienst)
values
('vodafone', 'Mobiele telefonie 100'),
('vodafone', 'Mobiele telefonie 250'),
('ziggo', 'Kabel-internet (download 300 Mpbs)'),
('ziggo', 'Glasvezel-internet (download 500 Mbps)');

insert into abonnementenVanAbonnees (abonneesId, abonnementId,aanbieder,dienst,prijs,startDatum,verdubbeling,deelbaar,status)
values
(1,1,'vodafone', 'Mobiele telefonie 100', 5.00, '2017-01-01', 'standaard', 1, 'actief'),
(1,2,'vodafone', 'Mobiele telefonie 250', 5.00, '2017-01-01' , 'standaard', 1, 'actief'),
(1,3,'ziggo', 'Kabel-internet (download 300 Mpbs)', 5.00, '2017-01-01', 'standaard', 1, 'actief');

