-- Create beneficiaries table
CREATE TABLE beneficiary (
     id BIGINT PRIMARY KEY,
     first_name VARCHAR(255),
     last_name VARCHAR(255)
);

-- Create accounts table
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    beneficiary_id INTEGER,
    FOREIGN KEY (beneficiary_id) REFERENCES beneficiary(id)
);

-- Create transactions table
CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    account_id INTEGER,
    amount DECIMAL(10, 2) NOT NULL,
    type VARCHAR(255),
    date DATE NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(id)
);


-- WILL NOT WORK AS IT TRIES TO LOAD THE DATA FROM INSIDE THE DOCKER CONTAINER
-- Import beneficiaries data
-- COPY beneficiary (id,first_name,last_name)
-- FROM './src/main/resources/db/migrations/beneficiaries.csv'
-- DELIMITER ','
-- CSV HEADER;

-- Import accounts data
-- COPY account (id, first_name, last_name)
-- FROM './src/main/resources/accounts.csv'
-- DELIMITER ','
-- CSV HEADER;


-- WILL NOT WORK AS IT TRIES TO LOAD THE DATA FROM INSIDE THE DOCKER CONTAINER
-- -- Import transactions data
-- COPY transaction (id, account_id, amount, date)
-- FROM './src/main/resources/transactions.csv'
-- DELIMITER ','
-- CSV HEADER;
