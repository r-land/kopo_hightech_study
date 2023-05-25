CREATE OR REPLACE TRIGGER AfterInsertBook

AFTER INSERT ON Book FOR EACH ROW
DECLARE
  average NUMBER;
BEGIN
  INSERT INTO Book_log
    VALUES(:new.bookid, :new.bookname, :new.publisher, :new.price);
  DBMS_OUTPUT.PUT_LINE('삽입 투플을 Book_log 테이블에 백업..');
END;

--------------------------------------
CREATE OR REPLACE FUNCTION fnc_Interest(
 Price NUMBER) RETURN INT
IS
  myInterest NUMBER;
BEGIN

  IF Price >= 30000 THEN myInterest := Price*0.1;
  ELSE myInterest :=Price*0.05;
  END IF;
  RETURN myInterest;
END;