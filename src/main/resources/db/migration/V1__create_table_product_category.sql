CREATE TABLE product_category (
    Id SERIAL PRIMARY KEY,
    Name varchar(255) NOT NULL UNIQUE
);

INSERT INTO product_category (Name)
VALUES ('Men''s Wear');

INSERT INTO product_category (Name)
VALUES ('Women''s Apparel');

INSERT INTO product_category (Name)
VALUES ('Watches');
