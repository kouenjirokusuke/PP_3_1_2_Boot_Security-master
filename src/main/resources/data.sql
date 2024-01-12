INSERT INTO roles (name) VALUES ('ADMIN'), ('USER');
INSERT INTO users (email, name, password) VALUES ('admin@gmail.com', 'Alex', 'pass'),
                                                 ('user@gmail.com', 'Matthew', 'pass');
INSERT INTO users_roles (user_id, roles_id) VALUES ((SELECT users.id FROM users WHERE id=1),(SELECT roles.id FROM roles WHERE id=1)),
                                                   ((SELECT users.id FROM users WHERE id=1),(SELECT roles.id FROM roles WHERE id=2)),
                                                   ((SELECT users.id FROM users WHERE id=2),(SELECT roles.id FROM roles WHERE id=2));