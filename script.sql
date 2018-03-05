
CREATE TABLE passenger
(
  id       VARCHAR(255) NOT NULL
    PRIMARY KEY,
  birthday DATE         NOT NULL,
  name     VARCHAR(255) NOT NULL,
  surname  VARCHAR(255) NOT NULL
)
  ENGINE = MyISAM;

CREATE TABLE route
(
  id     VARCHAR(255) NOT NULL
    PRIMARY KEY,
  status INT          NOT NULL
)
  ENGINE = MyISAM;

CREATE TABLE routeentry
(
  id                 VARCHAR(255) NOT NULL
    PRIMARY KEY,
  route_id           VARCHAR(255) NULL,
  schedule_id        VARCHAR(255) NULL,
  station_id         VARCHAR(255) NOT NULL,
  routeEntries_ORDER INT          NULL
)
  ENGINE = MyISAM;

CREATE INDEX FKbmojjac3eusgajkv14vmxchox
  ON routeentry (route_id);

CREATE INDEX FK7c6fhivi41uwdu1btgfie38hr
  ON routeentry (schedule_id);

CREATE INDEX FKjq9t2v9ejgyx1n3ym93l5w6v2
  ON routeentry (station_id);

CREATE TABLE schedule
(
  id        VARCHAR(255) NOT NULL
    PRIMARY KEY,
  arrival   DATETIME     NULL,
  departure DATETIME     NULL
)
  ENGINE = MyISAM;

CREATE TABLE station
(
  id     VARCHAR(255) NOT NULL
    PRIMARY KEY,
  name   VARCHAR(255) NULL,
  status INT          NOT NULL,
  CONSTRAINT UKovvr5506rucq3pwpt2if867pd
  UNIQUE (name)
)
  ENGINE = MyISAM;

CREATE TABLE stationstatus
(
  id         VARCHAR(255) NOT NULL
    PRIMARY KEY,
  delay      INT          NULL,
  status     VARCHAR(255) NOT NULL,
  station_id VARCHAR(255) NOT NULL,
  train_id   VARCHAR(255) NOT NULL
)
  ENGINE = MyISAM;

CREATE INDEX FK8tmrknbl8rvfr5ns5hk1i8a29
  ON stationstatus (station_id);

CREATE INDEX FKjverige13c7gndl8bjxq3lejq
  ON stationstatus (train_id);

CREATE TABLE ticket
(
  number       VARCHAR(255) NOT NULL
    PRIMARY KEY,
  passenger_id VARCHAR(255) NOT NULL,
  train_id     VARCHAR(255) NOT NULL
)
  ENGINE = MyISAM;

CREATE INDEX FK7xdva6e0sknsfbit0xop9y050
  ON ticket (passenger_id);

CREATE INDEX FKs1ds9191bgjraigeag60ttepm
  ON ticket (train_id);

CREATE TABLE train
(
  id       VARCHAR(255) NOT NULL
    PRIMARY KEY,
  number   VARCHAR(255) NULL,
  places   INT          NULL,
  status   INT          NOT NULL,
  route_id VARCHAR(255) NULL,
  CONSTRAINT UK4meepr5d4uks4lq5wa7kvsb5q
  UNIQUE (number)
)
  ENGINE = MyISAM;

CREATE INDEX FKasan18pkdvwoi59a7yr5t9uoy
  ON train (route_id);

CREATE TABLE user
(
  uuid     VARCHAR(255) NOT NULL
    PRIMARY KEY,
  name     VARCHAR(255) NULL,
  password VARCHAR(255) NULL,
  role     VARCHAR(255) NOT NULL,
  CONSTRAINT UK_syftr7gx86fwf7ox7bgvnnta7
  UNIQUE (name)
)
  ENGINE = MyISAM;


