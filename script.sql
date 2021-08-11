CREATE TABLE main (
	id serial PRIMARY KEY NOT NULL,
	name varchar(100) NOT NULL,
	desctiption text NOT NULL,
	date_ins_upd date,
	department varchar(100) NOT NULL,
	status varchar(100) NOT NULL,
	deadline date,
	priority varchar(100) NOT NULL,
	var int,
	assignee jsonb,
	commentary jsonb	
);

CREATE TABLE dep(
	id int NOT NULL,
	name varchar(100) PRIMARY KEY NOT NULL,
	descript text NOT NULL
);


CREATE TABLE statuses(
	id int NOT NULL,
	name varchar(100) PRIMARY KEY NOT NULL,
	descript text NOT NULL,
	dep varchar(100) NOT NULL
);

CREATE TABLE priorities(
	id int NOT NULL,
	name varchar(100) PRIMARY KEY NOT NULL,
	ordr int NOT NULL
);

CREATE TABLE users(
	id int PRIMARY KEY NOT NULL,
	name varchar(100) NOT NULL,
	role varchar(100) NOT NULL
);

--FOREIGN KEYS:

--1. 
ALTER TABLE statuses
ADD FOREIGN KEY (dep) REFERENCES dep(name);

--2.
ALTER TABLE main
ADD FOREIGN KEY (department) REFERENCES dep(name);

--3. 
ALTER TABLE main
ADD FOREIGN KEY (status) REFERENCES statuses(name);

--4.
ALTER TABLE main
ADD FOREIGN KEY (priority) REFERENCES priorities(name);

--INDEXES:

CREATE INDEX idx_main_id
ON main (id);

CREATE INDEX idx_dep_name
ON dep (name);

CREATE INDEX idx_status_name
ON statuses (name);

CREATE INDEX idx_prior_name
ON priorities (name);

CREATE INDEX idx_users_id
ON users (id);





