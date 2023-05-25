create or replace PROCEDURE InsertBook(
  myBookID IN NUMBER,
  myBookName IN VARCHAR2,
  myPublisher IN VARCHAR2,
  myPrice IN NUMBER)
AS
BEGIN
 INSERT INTO Book(bookid, bookname, publisher, price)
  VALUES(myBookID, myBookName, myPublisher, myPrice);
END;

CREATE OR REPLACE PROCEDURE BookInsertOrUpdate(
  myBookID NUMBER,
  myBookName VARCHAR2,
  myPublisher VARCHAR2,
  myPrice INT)
AS
  mycount NUMBER;
BEGIN
  SELECT count(*) INTO mycount FROM Book
  WHERE bookname LIKE myBookName;
  
  IF mycount !=0 THEN
  UPDATE Book SET price=myPrice
  WHERE bookname LIKE myBookName;
  
  ELSE
    INSERT INTO Book(bookid, bookname, publisher, price)
    Values(myBookID, myBookName, myPublisher, myPrice);
  END IF;
END;

CREATE OR REPLACE PROCEDURE AveragePrice(
  AverageVal OUT NUMBER)
AS
BEGIN
  SELECT AVG(price) INTO AverageVal FROM Book WHERE price IS NOT NULL;
END;

CREATE OR REPLACE PROCEDURE Interest
AS
  myInterest NUMERIC;
  Price NUMERIC;
  CURSOR InterestCursor IS SELECT saleprice FROM Orders;
BEGIN
  myInterest :=0.0;
  OPEN InterestCursor;
  LOOP
    FETCH InterestCursor INTO Price;
    EXIT WHEN InterestCursor%NOTFOUND;
    IF Price >=30000 THEN
      myInterest :=myInterest + Price*0.1;
    ELSE
      myInterest :=myInterest + Price*0.05;
    END IF;
  END LOOP;
  CLOSE InterestCursor;
  DBMS_OUTPUT.PUT_LINE('전체이익금액=' ||myInterest);
END;
