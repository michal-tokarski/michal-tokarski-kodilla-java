DROP FUNCTION IF EXISTS GetReaderById_v1;

DELIMITER $$

CREATE FUNCTION GetReaderById_v1(readerId INT) RETURNS VARCHAR (255) DETERMINISTIC
BEGIN
	DECLARE result VARCHAR(20) ;
    DECLARE resultFirstname VARCHAR(20) ;
    DECLARE resultLastname VARCHAR(20) ;
    IF readerId <= 0 THEN
		SET result = 'Wrong ID';
	ELSE
		SELECT FIRSTNAME INTO resultFirstname FROM readers WHERE READER_ID = readerId;
        SELECT LASTNAME INTO resultLastname FROM readers WHERE READER_ID = readerId;
        SET result = concat (resultFirstname , " " , resultLastname); 
	END IF;
	RETURN result;
END $$

DELIMITER ;

SELECT getReaderById_v1(2);