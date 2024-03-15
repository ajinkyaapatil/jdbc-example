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

INSERT INTO userData(id, name, city, pinCode)
VALUES
    (1, 'Vyankatesh', 'Nashik', 424203),
    (2, 'Ajinkya', 'Pune', 424201),
    (3, 'Soham', 'Pune', 424201),
    (4, 'Rajshree', 'Nagpur', 424202);

INSERT INTO cityDetails(pinCode, city)
VALUES
    (424203, 'Nashik'),
    (424201, 'Pune'),
    (424202, 'Nagpur');