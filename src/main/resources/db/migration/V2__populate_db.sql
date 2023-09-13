INSERT INTO client
(NAME)
VALUES
    ('Alina'),
    ('Kas'),
	('Terin'),
	('Kitai'),
	('Nina'),
    ('Riz'),
    ('Cassian'),
	('Castyl'),
	('Poppy'),
	('Nesta');

INSERT INTO Planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'MARS', 'VEN'),
    (2, 'EARTH', 'MARS'),
    (3, 'JUP', 'SAT'),
    (4, 'VEN', 'EARTH'),
    (5, 'MARS', 'EARTH'),
    (6, 'MARS', 'JUP'),
    (7, 'EARTH', 'SAT'),
    (8, 'JUP', 'VEN'),
    (9, 'SAT', 'MARS'),
    (10, 'VEN', 'JUP');

select * from client