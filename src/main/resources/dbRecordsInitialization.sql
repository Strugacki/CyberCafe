
INSERT INTO Role(role) VALUES('ROLE_ADMIN');

INSERT INTO Role(role) VALUES('ROLE_USER');

INSERT INTO Role(role) VALUES('ROLE_EMPLOYEE');

INSERT INTO "PUBLIC"."ADDRESS"
("CITY", "POSTALCODE", "STREET", "LOCALNUMBER" )
VALUES ('Czarna Woda', '83-262', 'Okrężna','14');

INSERT INTO "PUBLIC"."ADDRESS"
("CITY", "POSTALCODE", "STREET", "LOCALNUMBER" )
VALUES ('Warszawa', '10-294', 'Powstańców','1');

INSERT INTO "PUBLIC"."ADDRESS"
("CITY", "POSTALCODE", "STREET", "LOCALNUMBER" )
VALUES ('Gdańsk', '45-820', 'Zacna','11/4');

INSERT INTO "PUBLIC"."USER"
( "FIRSTNAME", "LASTNAME", "EMAIL", "ACTIVE", "DATEOFBIRTH", "NICKNAME", "LOGIN", "PASSWORD", "AVATAR", "ROLE_IDROLE","ADDRESS_IDADDRESS" )
VALUES ('Marcin', 'Hallman', 'mhallman94@gmail.com',true, '1994-10-06', 'Strugacki', 'admin', 'admin123',null,0,0);

INSERT INTO "PUBLIC"."USER"
( "FIRSTNAME", "LASTNAME", "EMAIL", "ACTIVE", "DATEOFBIRTH", "NICKNAME", "LOGIN", "PASSWORD", "AVATAR", "ROLE_IDROLE","ADDRESS_IDADDRESS" )
VALUES ('Adam', 'Kowalski', 'kowalski@gmail.com',true, '1980-07-03', 'Kowalski', 'kowalski1', 'fikumiku45',null,1,1);

INSERT INTO "PUBLIC"."USER"
( "FIRSTNAME", "LASTNAME", "EMAIL", "ACTIVE", "DATEOFBIRTH", "NICKNAME", "LOGIN", "PASSWORD", "AVATAR", "ROLE_IDROLE","ADDRESS_IDADDRESS" )
VALUES ('Ferdynand', 'Magelan', 'fikumiku@gmail.com',true, '1956-06-06', 'MagikXXX', 'magelan', '123123123',null,2,1);

INSERT INTO "PUBLIC"."TERMINAL"
( "TYPE", "AVAILABLE", "DESCRIPTION" )
VALUES ('PS4', true, 'test test test test');

INSERT INTO "PUBLIC"."RENT"
( "TERMINAL_IDTERMINAL", "USER_IDCUSTOMER", "USER_IDEMPLOYEE", "PRICE", "DATE", "TIMESTART", "HOURS" )
VALUES (0 ,1 ,2 ,100 , '2016-03-18', '15', '2');

INSERT INTO News(title,body,uploadDate) VALUES('Turniej League of Legends','W najbliższy weekend w CyberCafe odbędzie się turniej League of Legends dla graczy z całej Polski. Na uczestników czekają upominki a na zwycięzców wspaniałe nagrody ufundowane przez Intela. Zapraszamy!!','2016-02-12');

INSERT INTO News(title,body,uploadDate) VALUES('Turniej CS:GO','W najbliższy weekend w CyberCafe odbędzie się turniej CS:GO dla graczy z całej Polski. Na uczestników czekają upominki a na zwycięzców wspaniałe nagrody ufundowane przez Intela. Zapraszamy!!','2016-02-12');

INSERT INTO News(title,body,uploadDate) VALUES('Rozpoczęcie działalności','CyberCafe, miejsce, w którym możesz się zrelaksować grając na konsoli i PC ze znajomymi właśnie rozpoczęło działalność. Zapraszamy!!','2016-02-12');


