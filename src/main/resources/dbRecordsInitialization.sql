
INSERT INTO Role(role) VALUES('ROLE_ADMIN');

INSERT INTO Role(role) VALUES('ROLE_USER');

INSERT INTO Role(role) VALUES('ROLE_EMPLOYEE');

INSERT INTO "PUBLIC"."ADDRESS"
("CITY", "POSTALCODE", "STREET", "LOCALNUMBER" )
VALUES ('Czarna Woda', '83-262', 'Okrężna','14');

INSERT INTO "PUBLIC"."USER"
( "FIRSTNAME", "LASTNAME", "EMAIL", "ACTIVE", "DATEOFBIRTH", "NICKNAME", "LOGIN", "PASSWORD", "AVATAR", "ROLE_IDROLE","ADDRESS_IDADDRESS" )
VALUES ('Marcin', 'Hallman', 'mhallman94@gmail.com',true, '1994-10-06', 'Strugacki', 'admin', 'admin123',null,0,0);

INSERT INTO News(title,body,uploadDate) VALUES('Turniej League of Legends','W najbliższy weekend w CyberCafe odbędzie się turniej League of Legends dla graczy z całej Polski. Na uczestników czekają upominki a na zwycięzców wspaniałe nagrody ufundowane przez Intela. Zapraszamy!!','2016-02-12');

INSERT INTO News(title,body,uploadDate) VALUES('Turniej CS:GO','W najbliższy weekend w CyberCafe odbędzie się turniej CS:GO dla graczy z całej Polski. Na uczestników czekają upominki a na zwycięzców wspaniałe nagrody ufundowane przez Intela. Zapraszamy!!','2016-02-12');

INSERT INTO News(title,body,uploadDate) VALUES('Rozpoczęcie działalności','CyberCafe, miejsce, w którym możesz się zrelaksować grając na konsoli i PC ze znajomymi właśnie rozpoczęło działalność. Zapraszamy!!','2016-02-12');

