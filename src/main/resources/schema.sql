CREATE TABLE country (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         country_code VARCHAR(3) NOT NULL,
                         currency VARCHAR(3) NOT NULL,
                         PRIMARY KEY (id),
                         CONSTRAINT country_code_uq UNIQUE (country_code)
);

CREATE TABLE state (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         state_code VARCHAR(3) NOT NULL,
                         population INTEGER,
                         country_id INTEGER,
                         PRIMARY KEY (id),
                         CONSTRAINT state_country_fk FOREIGN KEY (country_id) REFERENCES country (id)
);