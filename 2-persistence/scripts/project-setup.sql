-- JDBC DB Setup
DROP TYPE IF EXISTS user_role CASCADE;
CREATE TYPE user_role AS ENUM ('Admin', 'Customer', 'Employee');


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (

	id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	pwd VARCHAR(50) NOT NULL,
	-- user_role_name 'Admin' 'Employee', 'Customer'
	user_role_name user_role NOT NULL
);

DROP TABLE IF EXISTS accounts CASCADE;
CREATE TABLE accounts (

	id SERIAL PRIMARY KEY,
	-- NUMERIC allow for decimals
	balance NUMERIC(50, 2) DEFAULT 0, -- 10,978,321.05 IS allowed
    acc_owner INTEGER REFERENCES users(id) NOT NULL,
    active BOOLEAN DEFAULT FALSE -- must be approved BY ADMIN 
);


