DROP DATABASE IF EXISTS testing_exam;
CREATE DATABASE testing_exam;
USE testing_exam;
DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER(
	CustomerID 	INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
	`Name` 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL ,
	Phone 		VARCHAR(20),
	Email 		VARCHAR(50) UNIQUE,
	Address 	VARCHAR(100) CHAR SET utf8mb4,
	Note 		TEXT
);
INSERT INTO CUSTOMER(`Name`, Phone, Email, Address, Note)
VALUES 
	('Nguyễn Văn An','0123456789','annguyen1@gmail.com','Hà Nội','Note cus 1'),
	('Nguyễn Văn Anh','0123456782','annguyen2@gmail.com','Hà Nội','Note cus 2'),
	('Nguyễn Văn ÂN','0123456783','annguyen3@gmail.com','Hà Nội','Note cus 3'),
	('Phạm Thị Hoa','0123456784','annguyen4@gmail.com','Hà Nội','Note cus 4'),
	('Phí Thanh Thanh','0123456785','annguyen5@gmail.com','Hà Nội','Note cus 5'),
	('Trần Thu Thảo','0123456786','annguyen6@gmail.com','Hà Nội','Note cus 6'),
	('Nguyễn Ngọc Minh','0123456787','annguyen7@gmail.com','Hà Nội','Note cus 7'),
	('Hoàng minh CHâu','0123456788','annguyen8@gmail.com','Hà Nội','Note cus 8');
DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR(
	CarID 		INT PRIMARY KEY NOT NULL ,
	Maker 		ENUM('HONDA', 'TOYOTA', 'NISSAN') ,
	Model 		VARCHAR(30),
	`Year` 		VARCHAR(5),
	Color 		VARCHAR(20) CHAR SET utf8mb4,
	Note 		TEXT
);
INSERT INTO CAR(CarID, Maker, Model, `Year`, Color, Note)
VALUES 
	(1, 'HONDA', 'model 1', '2017', 'Đỏ', 'Note car 1'),
	(2, 'TOYOTA', 'model 2', '2016', 'Đen', 'Note car 2'),
	(3, 'NISSAN', 'model 3', '2015', 'Trắng', 'Note car 3'),
	(4, 'TOYOTA', 'model 4', '2013', 'Xám', 'Note car 4'),
	(5, 'NISSAN', 'model 5', '2014', 'Đỏ', 'Note car 5'),
	(6, 'HONDA', 'model 6', '2018', 'Đỏ', 'Note car 6');
DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE CAR_ORDER(
	OrderID 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
	CustomerID 			INT,
	CarID 				INT,
	Amount 				INT DEFAULT 1,
	SalePrice 			VARCHAR(20),
	OrderDate 			DATE,
    DeliveryDate 		DATE,
    DeliveryAddress 	VARCHAR(100),
    Staus 				ENUM('0', '1', '2') DEFAULT '0',
    Note 				TEXT,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID) ON UPDATE SET NULL ON DELETE SET NULL,
    FOREIGN KEY (CarID) REFERENCES CAR(CarID) ON UPDATE SET NULL ON DELETE SET NULL
);
INSERT INTO CAR_ORDER(CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note)
VALUES 
	(1, 1, 2, '1000000000', '2019-01-01', '2019-01-18', 'Thanh Xuân - Hà Nội', '1', 'Note 1'),
	(2, 2, 2, '2000000000', '2020-01-01', null, 'Thanh Xuân - Hà Nội', '2', 'Note 1'),
	(3, 3, 2, '2000000000', '2021-01-01', null, 'Thanh Xuân - Hà Nội', '2', 'Note 1'),
	(4, 4, 2, '2000000000', '2019-01-01', '2019-01-19', 'Thanh Xuân - Hà Nội', '1', 'Note 1'),
	(5, 5, 2, '2000000000', '2020-01-01', null, 'Thanh Xuân - Hà Nội', '2', 'Note 1'),
	(6, 6, 2, '3000000000', '2021-01-01', '2021-01-20', 'Thanh Xuân - Hà Nội', '1', 'Note 1'),
	(7, 2, 2, '2000000000', '2018-01-01', '2018-01-16', 'Thanh Xuân - Hà Nội', '1', 'Note 1'),
	(8, 3, 2, '3000000000', '2021-01-01', '2021-01-18', 'Thanh Xuân - Hà Nội', '1', 'Note 1'),
	(8, 1, 2, '2000000000', '2020-01-01', '2020-01-17', 'Thanh Xuân - Hà Nội', '1', 'Note 1'),
	(8, 1, 2, '4000000000', '2019-01-01', '2019-01-22', 'Thanh Xuân - Hà Nội', null, 'Note 1');

-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT c.`Name`, COUNT(co.CarID) 'số lượng ô tô đã mua'
FROM CUSTOMER c
LEFT JOIN CAR_ORDER co ON c.CustomerID = co.CustomerID
GROUP BY co.CustomerID
ORDER BY COUNT(co.CarID);

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
-- oto nhất trong năm nay.
-- SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS f_return_maker;
DELIMITER $$
CREATE FUNCTION f_return_maker() RETURNS ENUM('HONDA', 'TOYOTA', 'NISSAN')
	BEGIN
		DECLARE returnValue ENUM('HONDA', 'TOYOTA', 'NISSAN');	-- biến chứa hãng bán được nhiều nhất trong năm nay
        SELECT c.Maker INTO returnValue 	-- add dữ liệu vào biến
		FROM CAR c
		LEFT JOIN CAR_ORDER co ON c.CarID = co.CarID
		WHERE YEAR(OrderDate) = YEAR(CURDATE())
		GROUP BY c.Maker
		HAVING COUNT(co.CarID) = (SELECT MAX(cntCar) FROM (
			SELECT COUNT(co.CarID) cntCar
			FROM CAR c
			LEFT JOIN CAR_ORDER co ON c.CarID = co.CarID
			WHERE YEAR(OrderDate) = YEAR(CURDATE())
			GROUP BY c.Maker
		) tmp);
        
        RETURN returnValue;
    END $$
DELIMITER ;
SELECT f_return_maker();

-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
-- những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS sp_delete_order_canceled;
DELIMITER $$
	CREATE PROCEDURE sp_delete_order_canceled()
    BEGIN
		DECLARE cntDelete INT;	-- biến chứa số đơn hàng bị xóa
        -- đếm số đơn hàng bị xóa, đưa vào biến
        SELECT COUNT(*) INTO cntDelete 
        FROM CAR_ORDER 
        WHERE Staus = '2' AND YEAR(OrderDate) < YEAR(CURDATE());
        
        -- xóa các đơn hàng đã bị hủy những năm trước
        DELETE FROM CAR_ORDER 
        WHERE Staus = '2' AND YEAR(OrderDate) < YEAR(CURDATE());
        
        -- in số lượng đơn hàng bị xóa
        SELECT cntDelete 'số lượng đơn hàng bị xóa';
    END $$
DELIMITER ;
CALL sp_delete_order_canceled();

-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
-- và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS sp_get_thong_tin_don_hang;
DELIMITER $$
	CREATE PROCEDURE sp_get_thong_tin_don_hang(in customer_id INT)
    BEGIN
		SELECT cu.`Name`, co.OrderID, count(ca.CarID) 'số lượng ô tô', ca.Maker
		FROM CUSTOMER cu
		LEFT JOIN CAR_ORDER co ON cu.CustomerID = co.CustomerID
		LEFT JOIN CAR ca ON co.CarID = ca.CarID
		WHERE cu.CustomerID = customer_id
		GROUP BY cu.CustomerID, ca.Maker;
    END $$
DELIMITER ;
CALL sp_get_thong_tin_don_hang(8);

-- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
-- vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS trigger_check_date;
DELIMITER $$
	CREATE TRIGGER trigger_check_date
    BEFORE INSERT ON CAR_ORDER
    FOR EACH ROW
    BEGIN
		IF NEW.DeliveryDate < DATE_ADD(NEW.OrderDate, INTERVAL 15 DAY) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'thông tin không hợp lệ';
        END IF;
    END $$
DELIMITER ;
INSERT INTO CAR_ORDER(CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note)
VALUES 
	(1, 1, 2, '1000000000', '2021-01-01', '2021-01-16', 'Thanh Xuân - Hà Nội', '1', 'Note 1');













































