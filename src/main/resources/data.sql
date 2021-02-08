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
('alex', '$2b$10$tdLLG4aCpxoi9rBRejs.MuhF0UYgQ5C3JAj2TQqFTPhZId7Skrr9W', 1), /* password - 1234 */
('mary', '$2b$10$VEkfw.FZtXAhafw7sZ1gzuEpRkUHEPXwf9/5fEUcdF2jcgKe0nJJu', 1); /* password - 2345 */