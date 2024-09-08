-- Create accounts table
CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    beneficiary_id INTEGER
);

-- Import accounts data
COPY accounts (id, beneficiary_id)
FROM 'C:/Users/Android/Desktop/Nejava/accounts.csv'
DELIMITER ','
CSV HEADER;

-- Create beneficiaries table
CREATE TABLE beneficiaries (
     id BIGINT PRIMARY KEY,
     first_name VARCHAR(255),
     last_name VARCHAR(255)
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

-- Import beneficiaries data
COPY beneficiaries (id, account_id, beneficiary_name)
FROM 'C:/Users/Android/Desktop/Nejava/beneficiaries.csv'
DELIMITER ','
CSV HEADER;

-- Create transactions table
CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_id INTEGER,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

-- Import transactions data
COPY transactions (id, account_id, amount, date)
FROM 'C:/Users/Android/Desktop/Nejava/transactions.csv'
DELIMITER ','
CSV HEADER;