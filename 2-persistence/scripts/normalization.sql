CREATE TABLE employees_1nf (

	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER,
	dept VARCHAR(50)
);

SELECT * FROM employees_1nf;

-- let's transform it to 2NF below
CREATE TABLE employees_2nf (

	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER

);

CREATE TABLE employee_dept_2nf (
	emp_id INTEGER REFERENCES employees_2nf(emp_id),
	dept VARCHAR(50) NOT NULL	
);

-- LET'S NORMALIZE FURTHER INTO 3NF

CREATE TABLE dept_3nf (
	dept_id SERIAL PRIMARY KEY,
	dept_name VARCHAR(50)
);

CREATE TABLE employees_3nf (
	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER
);

CREATE TABLE emp_dept_3nf (
	-- define each relationship with a primary key
	emp_dept_relation SERIAL PRIMARY KEY,
	emp_id INTEGER REFERENCES employees_3nf(id),
	dept_id INTEGER REFERENCES dept_3nf(id)
);



