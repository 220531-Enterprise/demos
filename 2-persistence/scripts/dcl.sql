-- DCL: Data Control Language
-- Granting users permission and setting up permissions/roles for 
-- those users

-- DDL: Data Defintion Language
-- DML: Data Manipulation Language
-- DQL: Data Query Language
-- TCL: Transaction  Control Language
-- DCL*: Data Control Language

CREATE USER gandolf WITH PASSWORD 'ring';

-- role is a set of permissions 
CREATE ROLE special_priv WITH
	LOGIN
	CREATEDB
	CREATEROLE;

GRANT special_priv TO gandolf;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA sophiag TO gandolf;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA sophiag TO gandolf;


