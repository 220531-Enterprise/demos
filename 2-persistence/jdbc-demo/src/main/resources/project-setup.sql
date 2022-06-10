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

		
		
-- PL/SQL 
-- Postgres is plpgsql
-- Oracle's is Oracle pl/sql
		
-- I want to retrieve all the accounts that belong to one owner
-- account ID, account Balance, isActive

-- USER ID, USERNAME, PWD, ROLE, ACCOUNT_ID, ACCOUNT BAL, ACTIVE

DROP VIEW users_account_data;

CREATE VIEW users_account_data AS
SELECT users.id, users.username, users.pwd, users.user_role_name, 
accounts.id AS account_id, accounts.balance, accounts.active
	FROM users
	LEFT JOIN users_accounts_jt ON users.id = users_accounts_jt.acc_owner 
	LEFT JOIN accounts ON accounts.id = users_accounts_jt.account;

-- views are NOT snapshots in time (so they dyanmically update)
SELECT * FROM users_account_data;

--INSERT INTO users (username, pwd, user_role_name)
--	VALUES ('antman', 'ants', 'Customer');
		
		
