INSERT INTO company (name)
VALUES
('Lightning inc.'),
('Thunderbolt inc.');

INSERT INTO gas_data (timestamp, value, company_id)
VALUES
('2021-02-09 00:00:00', 35, 1),
('2021-02-09 00:01:00', 54, 1);

INSERT INTO employee (username, password, company_id)
VALUES
('alex', '1234', 1),
('mary', '2345', 1);