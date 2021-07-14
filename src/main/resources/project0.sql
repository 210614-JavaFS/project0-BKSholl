DROP TABLE accounts;
DROP TABLE users;


CREATE TABLE users (
	username varchar(50) PRIMARY key,
	firstName varchar(50),
	lastName varchar(50),
	last4SSN int
);

CREATE TABLE accounts (
	id serial PRIMARY KEY,
	username varchar(50) REFERENCES users(username) ON DELETE SET NULL,
	pass varchar(50),
	balance numeric(20,2) CHECK (balance>=0),
	accountlevel smallint,
	approved bool
);


INSERT INTO users VALUES 
('bsholl', 'brendan', 'sholl', 2341),
('knguyen', 'kevin', 'nguyen', 3421),
('asahota', 'amrit', 'sahota', 2143);


INSERT INTO accounts VALUES
(DEFAULT, 'bsholl', 'password', 25.11, 3, true),
(DEFAULT, 'knguyen', 'wordpass', 1000.99, 2, true),
(DEFAULT, 'asahota', 'passpass', 1.11, 1, false);

SELECT * FROM users WHERE USERNAME = 'bsholl';