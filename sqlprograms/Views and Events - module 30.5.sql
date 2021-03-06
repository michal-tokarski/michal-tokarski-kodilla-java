-- View books and readers :
CREATE VIEW BOOKS_AND_READERS AS
	SELECT RD.READER_ID, RD. FIRSTNAME, RD.LASTNAME, BK.TITLE, RT.RENT_DATE, RT.RETURN_DATE
	FROM READERS RD, BOOKS BK, RENTS RT
	WHERE RT.BOOK_ID = BK.BOOK_ID
	AND RT.READER_ID = RD.READER_ID
	ORDER BY RT.RENT_DATE;

-- View books and readers, where rentals took place in last x days :
SELECT * FROM BOOKS_AND_READERS
	WHERE RENT_DATE >= CURDATE() - 10
	ORDER BY LASTNAME;

-- Process list :
SHOW PROCESSLIST;
SET GLOBAL EVENT_SCHEDULER = ON;

-- Create event Update Vips :
USE KODILLA_COURSE;
CREATE EVENT UPDATE_VIPS
	ON SCHEDULE EVERY 1 MINUTE 
    DO CALL UpdateVipLevels();
    
-- Update Vip-level in readers :
UPDATE READERS
	SET VIP_LEVEL = "Not set"
	WHERE READER_ID IN (1,2,3,4,5);

-- Remove event Update Vips :
DROP EVENT UPDATE_VIPS;
COMMIT;

-- Doublecheck :
SELECT * FROM READERS;