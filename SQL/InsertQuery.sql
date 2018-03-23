use vodagoneDB;

insert into abonnees (name, email, wachtwoord)
values
('Tobias Cunnenn','tobiascunnen@gmail.com','wachtwoord'),
('Meron Brouwer','Meron.Brouwer@han.nl','wachtwoord'),
('Dennis Breuker','Dennis.Breuker@han.nl','wachtwoord'),
('Michel Portier','Michel.Portier@han.nl','wachtwoord');

insert into abonnementen (aanbieder,dienst,prijs,startDatum,verdubbeling,deelbaar,status)
values
('vodafone', 'Mobiele telefonie 100', 5.00, '2017-01-01', 'standaard', true, 'actief'),
('vodafone', 'Mobiele telefonie 250', 5.00, '2017-01-01' , 'standaard', true, 'actief'),
('ziggo', 'Kabel-internet (download 300 Mpbs)', 5.00, '2017-01-01', 'standaard', true, 'actief');
