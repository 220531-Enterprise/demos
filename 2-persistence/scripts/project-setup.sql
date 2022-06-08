-- JDBC DB Setup
DROP TYPE IF EXISTS user_role CASCADE;
CREATE TYPE user_role AS ENUM ('Admin', 'Customer', 'Employee');

SELECT * FROM users;
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (

	id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	pwd VARCHAR(50) NOT NULL,
	-- user_role_name 'Admin' 'Employee', 'Customer'
	user_role_name user_role NOT NULL
);

select * FROM accounts;

DROP TABLE IF EXISTS accounts CASCADE;
CREATE TABLE accounts (

	id SERIAL PRIMARY KEY,
	-- NUMERIC allow for decimals
	balance NUMERIC(50, 2) DEFAULT 0, -- 10,978,321.05 IS allowed
    acc_owner INTEGER REFERENCES users(id) NOT NULL,
    active BOOLEAN DEFAULT FALSE -- must be approved BY ADMIN 
);

DROP TABLE IF EXISTS users_accounts_jt CASCADE;
CREATE TABLE users_accounts_jt (

	acc_owner INTEGER NOT NULL REFERENCES users(id),
	account INTEGER NOT NULL REFERENCES accounts(id)

);



-- insert 2 bank accounts for tony stark
INSERT INTO accounts (balance, acc_owner, active) 
	VALUES (1000, 1, FALSE),
			(80000000, 1, TRUE);

-- Create some type of function that will automatically be triggered to add that data into the
-- users_accounts_jt....

CREATE OR REPLACE FUNCTION auto_insert_into_jt() 
RETURNS TRIGGER 
AS $$

	BEGIN 
		-- this function is triggered by an insert on the accounts table
		-- in which the acc_owner ID and the account id is  automatically
		-- added to users_accounts_jt table
		INSERT INTO users_accounts_jt (acc_owner, account)
			VALUES (NEW.acc_owner, NEW.id);
		
		RETURN NEW;
	
	END

$$ 
LANGUAGE plpgsql;
		
CREATE TRIGGER upon_account_persistence
	AFTER INSERT ON accounts 
	FOR EACH ROW
	EXECUTE FUNCTION auto_insert_into_jt();


select * FROM accounts;
SELECT * FROM users;
SELECT * FROM users_accounts_jt;
		
INSERT INTO accounts(balance, acc_owner, active)
	VALUES (600, 2, FALSE),
			(1000, 2, TRUE);
		
-- to find all of Pepper Potts account ID's		
SELECT account FROM users_accounts_jt WHERE acc_owner = 2;
		
		
-- PL/SQL 
-- Postgres is plpgsql
-- Oracle's is Oracle pl/sql
		
		
		
		
		
		
		
