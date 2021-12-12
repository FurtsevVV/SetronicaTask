CREATE TABLE languagemap (
	language_id bigserial primary key,
    currency varchar(50),
    languages varchar(50)
	);

CREATE TABLE products (
	product_id bigserial primary key,
    product_name varchar(50) NOT NULL,
    description varchar(250),
	price numeric(10,2),
	date_of_creation varchar(50),
	date_of_modification varchar(50),
	language_id int,
	CONSTRAINT language_fk
	FOREIGN KEY (language_id)
	REFERENCES languagemap (language_id)
);

insert into languagemap values(1, 'RUB', 'RU');
insert into languagemap values(2, 'USD', 'EN');
insert into languagemap values(3, 'CHF', 'CH');

INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (1, 'Lodka', 'Descr', 120.11, '2021-01-01', '2021-01-02', 1);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (2, 'Palatka', 'Descr1', 50.00, '2021-01-01', '2021-01-02', 1);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (3, 'Chainik', 'Descr2', 20.00, '2021-01-01', '2021-01-02', 1);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (4, 'Stol1', 'Descr3', 10.00, '2021-05-12', '2021-06-31', 3);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (5, 'Stol2', 'Descr4', 15.00, '2021-01-10', '2021-02-15', 2);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (6, 'Stol2', 'Descr4', 15.00, '2021-01-10', '2021-02-15', 2);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (7, 'Tovar', 'Descr5', 25.50, '2021-02-10', '2021-02-15', 3);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (8, 'Tovar1', 'Descr6', 30.00, '2021-02-09', '2021-02-15', 3);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (9, 'Tovar1', 'Descr6', 30.00, '2021-02-09', '2021-02-15', null);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (10, 'Tovar', 'Descr7', 30.00, '2021-02-09', '2021-02-15', null);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (11, 'Tovar3', 'Descr8', 50.00, '2021-02-09', '2021-02-15', null);
INSERT INTO public.products(
	product_id, product_name, description, price, date_of_creation, date_of_modification, language_id)
	VALUES (12, 'Tovar4', 'Descr7', 70.00, '2021-02-09', '2021-02-15', null);
