-- We just create a database
DROP DATABASE IF EXISTS coffee_shop_db;
CREATE DATABASE coffee_shop_db;

\c transaction_service_db;
--jdbc:postgresql://localhost:5452/coffee_shop_db?user=root&password=root
