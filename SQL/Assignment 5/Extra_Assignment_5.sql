-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'.
-- Kết quả sẽ như sau:
-- Name
-- -----------------------------
-- LL Mountain Seat/Saddle
-- ML Mountain Seat/Saddle
-- HL Mountain Seat/Saddle
-- LL Road Seat/Saddle
-- ML Road Seat/Saddle
-- HL Road Seat/Saddle
-- LL Touring Seat/Saddle
-- ML Touring Seat/Saddle
-- HL Touring Seat/Saddle
-- (9 row(s) affected)
SELECT p.`Name` 
FROM product p
WHERE p.ProductSubcategoryID = (
	SELECT tmp.ProductSubcategoryID 
	FROM (
		SELECT ps.ProductSubcategoryID
		FROM productsubcategory ps 
		WHERE ps.`Name` = 'Saddles'
	) tmp
);

-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.
-- Name
-- ----------------------------
-- Water Bottle - 30 oz.
-- Mountain Bottle Cage
-- Road Bottle Cage
-- LL Bottom Bracket
-- ML Bottom Bracket
-- HL Bottom Bracket
-- (6 row(s) affected)
SELECT p.`Name` 
FROM product p
WHERE p.ProductSubcategoryID IN (
	SELECT tmp.ProductSubcategoryID 
	FROM (
		SELECT ps.ProductSubcategoryID
		FROM productsubcategory ps 
		WHERE ps.`Name` LIKE 'Bo%'
	) tmp
)
ORDER BY p.ProductID;

-- Question 3:
-- Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bike (nghĩa là ProductSubcategoryID = 3)
-- Kết quả sẽ như sau:
-- Name
-- --------------------------
-- Touring-3000 Blue, 54
-- Touring-3000 Blue, 58
-- Touring-3000 Blue, 62
-- .........
-- Touring-3000 Yellow, 62
-- Touring-3000 Blue, 44
-- Touring-3000 Blue, 50
-- (10 row(s) affected)

SELECT p.`Name`
FROM product p 
WHERE p.ListPrice = (
	SELECT tmp.min_price 
	FROM (SELECT MIN(p.ListPrice) min_price
		FROM product p 
		WHERE 
		p.ProductSubcategoryID IN (
			SELECT ps.ProductSubcategoryID 
			FROM product p
			JOIN productsubcategory ps 
				ON p.ProductSubcategoryID = ps.ProductSubcategoryID
			WHERE ps.`Name` = 'Touring Bikes')
	) tmp
);

-- Exercise 2: JOIN nhiều bảng
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database.
SELECT c.`Name` Country, s.`Name` Province
FROM countryregion c
JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode;

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
SELECT c.`Name` Country, s.`Name` Province
FROM countryregion c
JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` IN ('Germany', 'Canada')
ORDER BY Country, Province;

-- Question 3:
-- Từ bảng SalesPerson, chúng ta lấy cột BusinessEntityID (là định danh của người
-- sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)
-- Từ bảng SalesOrderHeader, chúng ta lấy cột SalesOrderID OrderDate
SELECT * FROM SalesPerson;
SELECT * FROM SalesOrderHeader;
SELECT sh.SalesOrderID, sh.OrderDate, sh.SalesPersonID, s.SalesPersonID BusinessEntityID, s.Bonus, s.SalesYTD
FROM salesperson s
JOIN salesorderheader sh ON s.SalesPersonID = sh.SalesPersonID
WHERE sh.OnlineOrderFlag <> 1
AND s.SalesPersonID IS NOT NULL;

-- Question 4:
-- Sử dụng câu query ở question 3, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID.
SELECT sh.SalesOrderID, sh.OrderDate, e.title Jobtitle , s.Bonus, s.SalesYTD
FROM salesperson s
JOIN salesorderheader sh ON s.SalesPersonID = sh.SalesPersonID
LEFT JOIN employee e ON sh.ContactID = e.ContactID
WHERE sh.OnlineOrderFlag <> 1
AND s.SalesPersonID IS NOT NULL





















