CREATE TABLE userdata.profile
(
    profile_id         VARCHAR PRIMARY KEY,
    display_name       VARCHAR(256) NOT NULL UNIQUE,
    name              VARCHAR(256) NOT NULL,
    profile_picture_uri VARCHAR(100),
    birthday          DATE         NOT NULL,
    gender            VARCHAR(10)  NOT NULL,
    ethnicity         VARCHAR(25),
    religion          VARCHAR(25),
    height            NUMERIC(5, 2),
    figure            VARCHAR(25),
    marital_status     VARCHAR(25)  NOT NULL,
    occupation        VARCHAR(256),
    location          JSONB         NOT NULL,
    about_me           VARCHAR(5000)
);
