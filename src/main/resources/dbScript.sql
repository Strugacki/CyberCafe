CREATE TABLE Role(
  idRole bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  role varchar(20)
);

CREATE TABLE Terminal(
  idTerminal bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  type varchar(20),
  available boolean,
  description varchar(100)
);

CREATE TABLE Address(
  idAddress bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  city varchar(20),
  postalCode varchar(6),
  street varchar(30)
);

CREATE TABLE User(
  idUser bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  firstname varchar(20),
  lastname varchar(20),
  email varchar(20),
  active boolean,
  dateOfBirth varchar(20),
  nickname varchar(20),
  login varchar(20),
  password varchar(20),
  avatar blob,
  role_IDROLE bigint, FOREIGN KEY (role_IDROLE) REFERENCES Role(IDROLE),
  address_IDADDRESS bigint, FOREIGN KEY (address_IDADDRESS) REFERENCES Address(IDADDRESS)
);

CREATE TABLE News(
  idNews bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  title varchar(50),
  body varchar(300),
  uploadDate date,
  user_IDUSER bigint, FOREIGN KEY (user_IDUSER) REFERENCES User(IDUSER)
);

CREATE TABLE Rent(
  idRent bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  terminal_IDTERMINAL bigint, FOREIGN KEY (terminal_IDTERMINAL) REFERENCES Terminal(IDTERMINAL),
  user_IDCUSTOMER bigint, FOREIGN KEY (user_IDCUSTOMER) REFERENCES User(IDUSER),
  user_IDEMPLOYEE bigint, FOREIGN KEY (user_IDEMPLOYEE) REFERENCES User(IDUSER),
  price double,
  timeStart varchar(11),
  timeEnd varchar(11),
);