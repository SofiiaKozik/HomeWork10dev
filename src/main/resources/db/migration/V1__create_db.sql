DROP TABLE IF EXISTS client, planet, ticket;

CREATE TABLE client(
        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        NAME VARCHAR(300) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 300)
);

CREATE TABLE planet(
        ID VARCHAR(500) NOT NULL,
        NAME VARCHAR(500) NOT NULL CHECK (LENGTH(NAME) BETWEEN 1 AND 500)
);

CREATE TABLE ticket(
        ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        CLIENT_ID INT,
        created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
        FROM_PLANET_ID VARCHAR(500) NOT NULL,
        TO_PLANET_ID VARCHAR(500) NOT NULL
);