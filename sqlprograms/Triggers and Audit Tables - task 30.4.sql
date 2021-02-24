-- Audit table on Books table :
CREATE TABLE BOOKS_AUD (
	EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
    EVENT_DATE DATETIME NOT NULL,
    EVENT_TYPE VARCHAR (10) DEFAULT NULL,
    BOOK_ID INT(11) NOT NULL,
    OLD_TITLE VARCHAR(255),
    NEW_TITLE VARCHAR(255),
    OLD_PUBYEAR INT(4),
    NEW_PUBYEAR INT(4),
    OLD_BESTSELLER BOOLEAN,
    NEW_BESTSELLER BOOLEAN,
    PRIMARY KEY (`EVENT_ID`)
);

-- Insert event on Books table :
DELIMITER $$
CREATE TRIGGER BOOKS_INSERT AFTER INSERT ON BOOKS
FOR EACH ROW
BEGIN
	INSERT INTO BOOKS_AUD (
			EVENT_DATE, EVENT_TYPE, 
            BOOK_ID, 
            NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER)
			VALUES (
            CURTIME(), "INSERT", 
            NEW.BOOK_ID, 
            NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER);
END $$
DELIMITER ;

-- Doublecheck :
INSERT INTO BOOKS(TITLE, PUBYEAR, BESTSELLER)
     VALUES ("For Whom the Bell Tolls", 2021, 1);

-- Delete event on Books table :
DELIMITER $$
CREATE TRIGGER BOOKS_DELETE AFTER DELETE ON BOOKS
FOR EACH ROW
BEGIN
	INSERT INTO BOOKS_AUD (
		EVENT_DATE, EVENT_TYPE, 
        BOOK_ID, 
        OLD_TITLE, OLD_PUBYEAR, OLD_BESTSELLER)
		VALUES (
        CURTIME(), "DELETE", 
        OLD.BOOK_ID, 
        OLD.TITLE, OLD.PUBYEAR, OLD.BESTSELLER);
END $$
DELIMITER ;

-- Doublecheck :
DELETE FROM BOOKS 
	WHERE BOOK_ID = 6;
COMMIT;

-- Update event on Books table :
DELIMITER $$
CREATE TRIGGER BOOKS_UPDATE AFTER UPDATE ON BOOKS
FOR EACH ROW
BEGIN
	INSERT INTO BOOKS_AUD (
		EVENT_DATE, EVENT_TYPE, 
		BOOK_ID, 
        NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER, 
        OLD_TITLE, OLD_PUBYEAR, OLD_BESTSELLER)
		VALUES (
        CURTIME(), "UDPATE", 
        OLD.BOOK_ID, 
        NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER, 
        OLD.TITLE, OLD.PUBYEAR, OLD.BESTSELLER);
END $$
DELIMITER ;

-- Doublecheck :
UPDATE BOOKS SET TITLE = "8888888888888" 
	WHERE BOOK_ID = 7; 
COMMIT;
    
    
-- Audit table on Readers table :
    CREATE TABLE READERS_AUD (
	EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
    EVENT_DATE DATETIME NOT NULL,
    EVENT_TYPE VARCHAR (10) DEFAULT NULL,
    READER_ID INT(11) NOT NULL,
    OLD_FIRSTNAME VARCHAR(255),
    NEW_FIRSTNAME VARCHAR(255),
    OLD_LASTNAME VARCHAR(255),
    NEW_LASTNAME VARCHAR(255),
    OLD_PESELID VARCHAR(11),
    NEW_PESELID VARCHAR(11),
    OLD_VIP_LEVEL VARCHAR(20),
    NEW_VIP_LEVEL VARCHAR(20),
    PRIMARY KEY (`EVENT_ID`)
);

-- Insert event on Readers table :
DELIMITER $$
CREATE TRIGGER READERS_INSERT AFTER INSERT ON READERS
FOR EACH ROW
BEGIN
	INSERT INTO READERS_AUD (
		EVENT_DATE, EVENT_TYPE, 
		READER_ID,  
        NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID, NEW_VIP_LEVEL)
		VALUES (
        CURTIME(), "INSERT", 
        NEW.READER_ID, 
        NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID, NEW.VIP_LEVEL);
END $$
DELIMITER ;

-- Doublecheck :
INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID, VIP_LEVEL)
     VALUES ("W. Axl", "Rose", "666", "nobody knows");
     
-- Delete event on Readers table :
DELIMITER $$
CREATE TRIGGER READERS_DELETE AFTER DELETE ON READERS
FOR EACH ROW
BEGIN
	INSERT INTO READERS_AUD (
		EVENT_DATE, EVENT_TYPE, 
        READER_ID,  
		OLD_FIRSTNAME, OLD_LASTNAME, OLD_PESELID, OLD_VIP_LEVEL)
		VALUES (
        CURTIME(), "DELETE", 
        OLD.READER_ID, 
		OLD.FIRSTNAME, OLD.LASTNAME, OLD.PESELID, OLD.VIP_LEVEL);
END $$
DELIMITER ;

-- Doublecheck :
DELETE FROM READERS 
	WHERE READER_ID = 7;
    
-- Update event on Readers table :
DELIMITER $$
CREATE TRIGGER READERS_UPDATE AFTER UPDATE ON READERS
FOR EACH ROW
BEGIN
	INSERT INTO READERS_AUD (
		EVENT_DATE, EVENT_TYPE, 
		READER_ID,  
        NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID, NEW_VIP_LEVEL, 
        OLD_FIRSTNAME, OLD_LASTNAME, OLD_PESELID, OLD_VIP_LEVEL)
		VALUES (
        CURTIME(), "UDPATE", 
        OLD.READER_ID, 
        NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID, NEW.VIP_LEVEL, 
        OLD.FIRSTNAME, OLD.LASTNAME, OLD.PESELID, OLD.VIP_LEVEL);
END $$
DELIMITER ;

-- Doublecheck :
UPDATE READERS SET VIP_LEVEL = 'Exceptional !!!' 
	WHERE READER_ID = 5;