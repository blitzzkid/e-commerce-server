CREATE TABLE shop (
    Id SERIAL PRIMARY KEY,
    Name varchar(100) NOT NULL UNIQUE
);

INSERT INTO shop (Name)
VALUES ('Adidas');

INSERT INTO shop (Name)
VALUES ('Triumph');

INSERT INTO shop (Name)
VALUES ('Tissot');
