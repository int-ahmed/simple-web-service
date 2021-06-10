
INSERT INTO country (name, country_code, currency) values
('Big Land','BLD','CHK'),
('Mordor','MDR','GUL'),
('Numberland','NUM','DIG');

INSERT INTO state (name, state_code, population, country_id) values
('Left Province','LEF',10100, SELECT id FROM country WHERE country.country_code like 'BLD'),
('Right Province','RIG',778030, SELECT id FROM country WHERE country.country_code like 'BLD'),
('Topside','TSD',2200340, SELECT id FROM country WHERE country.country_code like 'BLD'),
('Center Province','CTR',1340922, SELECT id FROM country WHERE country.country_code like 'BLD'),
('Udun','UDN',2000110, SELECT id FROM country WHERE country.country_code like 'MDR'),
('Gorgoroth','GOR',3120900, SELECT id FROM country WHERE country.country_code like 'MDR'),
('Nurn','NRN',1100000, SELECT id FROM country WHERE country.country_code like 'MDR'),
('Kand','KND',2500000, SELECT id FROM country WHERE country.country_code like 'MDR'),
('One','KND',1150000, SELECT id FROM country WHERE country.country_code like 'NUM'),
('Two','KND',25320, SELECT id FROM country WHERE country.country_code like 'NUM'),
('Three','KND',310000, SELECT id FROM country WHERE country.country_code like 'NUM'),
('Four','KND',400000, SELECT id FROM country WHERE country.country_code like 'NUM');