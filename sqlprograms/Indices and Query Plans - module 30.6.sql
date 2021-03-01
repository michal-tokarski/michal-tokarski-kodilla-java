-- Create table Phones :
CREATE TABLE PHONES (
	PHONE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PHONENUM INT(9),
    FIRSTNAME VARCHAR(50),
    LASTNAME VARCHAR(50)
);

-- Populate table Phones with random data :
DELIMITER $$
CREATE PROCEDURE FillTestData()
BEGIN
	DECLARE K INT DEFAULT 0;
    WHILE (K < 100000) DO
		INSERT INTO PHONES (PHONENUM, FIRSTNAME, LASTNAME)
		VALUES (ROUND(RAND()*1000000000),
				CONCAT('Firstname number ', K),
                CONCAT('Lastname number ', k));
		IF (MOD(K, 5000) = 0) THEN
			COMMIT;
		END IF;
        SET K = K + 1;
	END WHILE;
	COMMIT;
END $$
DELIMITER ;

-- Run the populate procedure :
CALL FillTestData();

-- Help commands :
SELECT * FROM kodilla_course.phones;
SELECT COUNT(*) FROM kodilla_course.phones;

-- Create table Phone Stats :
CREATE TABLE PHONESTATS (
	ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    RANGE_FROM INT(11),
    RANGE_TO INT(11),
    QUANTITY INT(11)
);

-- Calculate histogram values of the table Phones :
DELIMITER $$
CREATE PROCEDURE CalcPhoneStats()
BEGIN
	DECLARE K INT(11) DEFAULT 0;
    DECLARE QTY INT(11);
    DELETE FROM PHONESTATS;
    COMMIT;
    WHILE (K < 100000000) DO
		SELECT COUNT(*) FROM PHONES
        WHERE PHONENUM BETWEEN K-99999 AND K
			INTO QTY;
		INSERT INTO PHONESTATS (RANGE_FROM, RANGE_TO, QUANTITY)
			VALUES (K-99999, K, QTY);
		COMMIT;
        SET K = K + 100000;
	END WHILE;
END $$
DELIMITER ;

-- Run the histogram procedure :
CALL CalcPhoneStats();

-- Help commands :
SELECT * FROM kodilla_course.phonestats;
SELECT COUNT(*) FROM kodilla_course.phonestats;

-- Inspect for indices :
EXPLAIN SELECT COUNT(*)
FROM PHONES
WHERE PHONENUM BETWEEN 1 AND 100000;

-- Create index :
CREATE INDEX PHONENO ON PHONES (PHONENUM);
