ALTER TABLE BOOKS ADD BESTSELLER BOOLEAN;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
	DECLARE BOOK_RENT_COUNT, DAYS, CURSOR_BOOK_ID INT;
    DECLARE AVERAGE_RENTS_PER_MONTH DECIMAL(5,2);
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE CURSOR_ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;
    
    OPEN CURSOR_ALL_BOOKS;
    WHILE (FINISHED = 0) DO
		FETCH CURSOR_ALL_BOOKS INTO CURSOR_BOOK_ID;
        IF (FINISHED = 0) THEN
			SELECT COUNT(*) FROM RENTS
				WHERE BOOK_ID = CURSOR_BOOK_ID
					INTO BOOK_RENT_COUNT;
			SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS
				WHERE BOOK_ID = CURSOR_BOOK_ID
					INTO DAYS;
			SET AVERAGE_RENTS_PER_MONTH = BOOK_RENT_COUNT / DAYS * 30;
            IF AVERAGE_RENTS_PER_MONTH > 2 THEN
				UPDATE BOOKS SET BESTSELLER = TRUE
					WHERE BOOK_ID = CURSOR_BOOK_ID;
			ELSE
				UPDATE BOOKS SET BESTSELLER = FALSE
					WHERE BOOK_ID = CURSOR_BOOK_ID;
			END IF;
			COMMIT;
		END IF;
        
	END WHILE;
    CLOSE CURSOR_ALL_BOOKS;
END $$

DELIMITER ;

Call UpdateBestsellers();
SELECT * FROM BOOKS;