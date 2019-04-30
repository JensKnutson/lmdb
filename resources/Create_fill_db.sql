create table if not exists movie
(id serial, Title text, year integer, format text);
insert into movie
(title, year, format)
values 
('Johan Falk - Gruppen för särskilda insatser ', 2009, null),
('Johan Falk: Kodnamn: Lisa ', 2012, null),
('Johan Falk: National Target ', 2009, 'Video'),
('Johan Falk: Spelets regler ', 2012, 'Video'),
('Johan Falk: Blodsdiamanter ', 2015, 'Video'),
('Johan Falk: Slutet ', 2015, 'Video'),
('Johan Falk: Vapenbröder ', 2009, 'Video'),
('Johan Falk: Barninfiltratören ', 2012, 'Video'),
('Johan Falk: Organizatsija Karayan ', 2012, 'Video'),
('Johan Falk: Leo Gaut ', 2009, 'Video'),
('Johan Falk: Lockdown ', 2015, 'Video'),
('Johan Falk: De fredlösa ', 2009, 'Video'),
('Johan Falk: Tyst diplomati ', 2015, 'Video'),
('Johan Falk: Operation Näktergal ', 2009, 'Video'),
('Johan Falk: De 107 patrioterna ', 2012, 'Video'),
('Johan Falk: Ur askan i elden ', 2015, 'Video'),
('Johan Falk: Alla råns moder ', 2012, 'Video');

