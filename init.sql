CREATE TABLE userData (
    id INT PRIMARY KEY,
    name VARCHAR(256),
    city VARCHAR(256),
    pinCode INT
);

CREATE TABLE cityDetails(
    pinCode INT PRIMARY KEY,
    city VARCHAR(256)
);