DROP DATABASE IF EXISTS salary_management;
CREATE DATABASE salary_management;
USE salary_management;
-- users 
DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id 				INT(10) PRIMARY KEY NOT NULL,
    first_name 		VARCHAR(30) CHAR SET utf8mb4 NOT NULL,
    last_name 		VARCHAR(30) CHAR SET utf8mb4 NOT NULL,
    email 			VARCHAR(100) UNIQUE,
    phone 			VARCHAR(20) UNIQUE,
    employee_id 	VARCHAR(10),
    avatar 			TEXT CHAR SET utf8mb4,
    gender 			TINYINT(10),
    age 			INT(3),
    create_at 		DATETIME,
    update_at 		DATETIME
);
INSERT INTO users
VALUES 
	(1, 	'Anh', 		'Nguyễn Ngọc', 		'nguyenanh@gmail.com', 		'08012354672', '1000000001', 	'avatar1', 	1, 35, NOW(), NOW()),
	(2, 	'An', 		'Nguyễn Thanh', 	'nguyenan@gmail.com', 		'08012352678', '1000000002', 	'avatar2', 	1, 26, NOW(), NOW()),
	(3, 	'Hoa', 		'Nguyễn Ngọc', 		'nguyenhoa@gmail.com', 		'08022354678', '1000000003', 	'avatar3', 	1, 36, NOW(), NOW()),
	(4, 	'Huệ', 		'Phạm Thanh', 		'phamhue@gmail.com', 		'08012354178', '1000000004', 	'avatar4', 	1, 26, NOW(), NOW()),
	(5, 	'Mai', 		'Nguyễn Ngọc', 		'ngocmai@gmail.com', 		'08022334678', '1000000005', 	'avatar5', 	1, 35, NOW(), NOW()),
	(6, 	'Thanh', 	'Nguyễn Phương', 	'phuongthanh@gmail.com', 	'08212354678', '1000000006', 	'avatar6', 	1, 25, NOW(), NOW()),
	(7, 	'Phương', 	'Nguyễn Ngọc', 		'phuongngoc@gmail.com', 	'08012324672', '1000000007', 	'avatar7', 	1, 29, NOW(), NOW()),
	(8, 	'Hùng', 	'Nguyễn Anh', 		'anhhung@gmail.com', 		'08019354673', '1000000008', 	'avatar8', 	1, 28, NOW(), NOW()),
	(9, 	'Quang', 	'Nguyễn Văn', 		'quangnguyen@gmail.com', 	'08012394673', '1000000009', 	'avatar9', 	1, 30, NOW(), NOW()),
	(10, 	'Trúc', 	'Nguyễn Thu', 		'thutruc@gmail.com', 		'08092353478', '1000000010', 	'avatar10', 1, 28, NOW(), NOW()),
	(11, 	'Đông', 	'Nguyễn Duy', 		'duydong@gmail.com', 		'09012354674', '1000000011', 	'avatar11', 1, 30, NOW(), NOW()),
	(12, 	'Phong', 	'Nguyễn Nam', 		'namphong@gmail.com', 		'08912354675', '1000000012', 	'avatar12', 1, 39, NOW(), NOW()),
	(13, 	'Phi', 		'Nguyễn Văn', 		'phinguyen@gmail.com', 		'07012354578', '1000000013', 	'avatar13', 1, 31, NOW(), NOW()),
	(14, 	'Huy', 		'Nguyễn Văn', 		'huynguyen@gmail.com', 		'08012954658', '1000000014', 	'avatar14', 1, 35, NOW(), NOW()),
	(15, 	'Dũng', 	'Nguyễn Văn', 		'dungnguyen@gmail.com', 	'08055354978', '1000000015', 	'avatar15', 1, 38, NOW(), NOW());

-- department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	id 				INT(10) PRIMARY KEY NOT NULL,
    `name` 			VARCHAR(30) CHAR SET utf8mb4 NOT NULL,
    `description` 	TEXT CHAR SET utf8mb4,
    create_at 		DATETIME,
    update_at 		DATETIME
);
INSERT INTO department
VALUES 
	(1, 'Admin', 'description Admin', NOW(), NOW()),
	(2, 'HR', 'description HR', NOW(), NOW()),
	(3, 'IT', 'description IT', NOW(), NOW()),
	(4, 'Delivery', 'description Delivery', NOW(), NOW());

-- user_department
DROP TABLE IF EXISTS user_department;
CREATE TABLE user_department(
	id 				INT(10) PRIMARY KEY NOT NULL,
    user_id 		INT(10) NOT NULL,
    department_id 	INT(10) NOT NULL,
    start_date 		DATE,
    end_date 		DATE,
    create_at 		DATETIME,
    update_at 		DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES department(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO user_department
VALUES 
	(1, 1, 1, '2010-01-01', '2013-11-01', NOW(), NOW()),
	(2, 1, 2, '2013-11-02', '2025-11-01', NOW(), NOW()),
	(3, 2, 2, '2010-01-01', '2012-11-01', NOW(), NOW()),
	(4, 2, 3, '2012-11-02', '2014-11-01', NOW(), NOW()),
	(5, 3, 3, '2012-01-01', '2013-11-01', NOW(), NOW()),
	(6, 3, 4, '2013-11-02', '2015-11-01', NOW(), NOW()),
	(7, 4, 1, '2012-01-01', '2012-11-01', NOW(), NOW()),
	(8, 4, 3, '2012-11-02', '2016-11-01', NOW(), NOW()),
	(9, 5, 2, '2010-01-01', '2011-11-01', NOW(), NOW()),
	(10, 5, 3, '2011-01-02', '2012-11-01', NOW(), NOW()),
	(11, 6, 1, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(12, 7, 2, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(13, 8, 3, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(14, 9, 4, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(15, 10, 2, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(16, 11, 3, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(17, 12, 2, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(18, 13, 3, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(19, 14, 2, '2010-01-01', '2021-11-01', NOW(), NOW()),
	(20, 15, 1, '2010-01-01', '2021-11-01', NOW(), NOW());
-- roles
DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
	id 			INT(10) PRIMARY KEY NOT NULL,
    `name` 		VARCHAR(30) CHAR SET utf8mb4 NOT NULL,
    create_at 	DATETIME,
    update_at 	DATETIME
);
INSERT INTO roles
VALUES 
	(1, 'Giám đốc', NOW(), NOW()),
	(2, 'Trưởng phòng', NOW(), NOW()),
	(3, 'Phó phòng', NOW(), NOW()),
	(4, 'Nhân viên', NOW(), NOW()),
	(5, 'Cộng tác viên', NOW(), NOW());
    
-- user_role
DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role(
	id 						INT(10) PRIMARY KEY NOT NULL,
    user_department_id 		INT(10) NOT NULL,
    role_id 				INT(10) NOT NULL,
    start_date 				DATE,
    end_date				DATE,
    create_at 				DATETIME,
    update_at 				DATETIME,
    FOREIGN KEY (user_department_id) REFERENCES user_department(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO user_role
VALUES 
	(1, 13, 4, '2010-01-01', '2015-01-01', NOW(), NOW()),
	(2, 16, 4, '2010-01-01', '2015-01-01', NOW(), NOW()),
	(3, 18, 4, '2010-01-01', '2015-01-01', NOW(), NOW()),
	(4, 13, 3, '2015-01-02', '2021-01-01', NOW(), NOW()),
	(5, 16, 3, '2015-01-02', '2021-01-01', NOW(), NOW()),
	(6, 18, 3, '2015-01-02', '2021-01-01', NOW(), NOW()),
	(7, 2, 2, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(8, 4, 2, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(9, 6, 3, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(10, 8, 4, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(11, 10, 5, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(12, 11, 4, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(13, 12, 3, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(14, 14, 2, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(15, 15, 1, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(16, 17, 4, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(17, 19, 4, '2010-01-01', '2021-01-01', NOW(), NOW()),
	(18, 20, 2, '2010-01-01', '2021-01-01', NOW(), NOW());
    
-- salary_detail_type
DROP TABLE IF EXISTS salary_detail_type;
CREATE TABLE salary_detail_type(
	id 			INT(10) PRIMARY KEY NOT NULL,
    `name` 		VARCHAR(10) CHAR SET utf8mb4 NOT NULL,
    create_at 	DATETIME,
    update_at 	DATETIME
);
INSERT INTO salary_detail_type
VALUES 
	(1, 'Lương cứng', NOW(), NOW()),
	(2, 'Phụ cấp', NOW(), NOW()),
	(3, 'Thưởng', NOW(), NOW()),
	(4, 'Thuế TNCN', NOW(), NOW()),
	(5, 'BHXH', NOW(), NOW());

-- salary
DROP TABLE IF EXISTS salary;
CREATE TABLE salary(
	id 				INT(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_role_id 	INT(10),
    total_salary 	DOUBLE(12, 2),
    `month`			VARCHAR(2),
    `year`			VARCHAR(4),
    create_at 		DATETIME,
    update_at 		DATETIME,
    FOREIGN KEY (user_role_id) REFERENCES user_role(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO salary (user_role_id,total_salary,`month`,`year`,create_at,update_at)
VALUES 
	(4, 	10000000, '04', '2021', NOW(), NOW()),
	(5, 	11000000, '04', '2021', NOW(), NOW()),
	(6, 	12000000, '04', '2021', NOW(), NOW()),
	(7, 	10000000, '04', '2021', NOW(), NOW()),
	(8, 	11000000, '04', '2021', NOW(), NOW()),
	(9, 	12000000, '04', '2021', NOW(), NOW()),
	(10, 	12000000, '04', '2021', NOW(), NOW()),
	(11, 	13000000, '04', '2021', NOW(), NOW()),
	(12,	11000000, '04', '2021', NOW(), NOW()),
	(13,	11000000, '04', '2021', NOW(), NOW()),
	(14,	13000000, '04', '2021', NOW(), NOW()),
	(15,	14000000, '04', '2021', NOW(), NOW()),
	(16,	12000000, '04', '2021', NOW(), NOW()),
	(17,	10000000, '04', '2021', NOW(), NOW()),
	(18,	90000000, '04', '2021', NOW(), NOW()),
	(4,		10000000, '05', '2021', NOW(), NOW()),
	(5,		11000000, '05', '2021', NOW(), NOW()),
	(6,		12000000, '05', '2021', NOW(), NOW()),
	(7,		10000000, '05', '2021', NOW(), NOW()),
	(8,		11000000, '05', '2021', NOW(), NOW()),
	(9,		12000000, '05', '2021', NOW(), NOW()),
	(10,	12000000, '05', '2021', NOW(), NOW()),
	(11,	13000000, '05', '2021', NOW(), NOW()),
	(12,	11000000, '05', '2021', NOW(), NOW()),
	(13,	11000000, '05', '2021', NOW(), NOW()),
	(14,	13000000, '05', '2021', NOW(), NOW()),
	(15,	14000000, '05', '2021', NOW(), NOW()),
	(16,	12000000, '05', '2021', NOW(), NOW()),
	(17,	10000000, '05', '2021', NOW(), NOW()),
	(18,	90000000, '05', '2021', NOW(), NOW()),
	(4,		10000000, '06', '2021', NOW(), NOW()),
	(5,		11000000, '06', '2021', NOW(), NOW()),
	(6,		12000000, '06', '2021', NOW(), NOW()),
	(7,		10000000, '06', '2021', NOW(), NOW()),
	(8,		11000000, '06', '2021', NOW(), NOW()),
	(9,		12000000, '06', '2021', NOW(), NOW()),
	(10,	12000000, '06', '2021', NOW(), NOW()),
	(11,	13000000, '06', '2021', NOW(), NOW()),
	(12,	11000000, '06', '2021', NOW(), NOW()),
	(13,	11000000, '06', '2021', NOW(), NOW()),
	(14,	13000000, '06', '2021', NOW(), NOW()),
	(15,	14000000, '06', '2021', NOW(), NOW()),
	(16,	12000000, '06', '2021', NOW(), NOW()),
	(17,	10000000, '06', '2021', NOW(), NOW()),
	(18,	90000000, '06', '2021', NOW(), NOW());

-- salary_detail
DROP TABLE IF EXISTS salary_detail;
CREATE TABLE salary_detail(
	id 						INT(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    amonth 					DOUBLE(12, 2),
    salary_id 				INT(10),
    salary_detail_type_id 	INT(10),
    operation 				TINYINT(3),
    FOREIGN KEY (salary_id) REFERENCES salary(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO salary_detail (amonth,salary_id,salary_detail_type_id,operation)
VALUES 
	(10000000, 	1, 1, 1),
	(10000000, 	2, 1, 1),
	(1000000, 	2, 4, 2),
	(10000000, 	3, 1, 1),
	(10000000, 	4, 1, 1),
	(10000000, 	5, 1, 1),
	(1000000, 	5, 1, 1),
	(10000000, 	6, 1, 1),
	(10000000, 	7, 1, 1),
	(10000000, 	8, 1, 1),
	(10000000, 	9, 1, 1),
	(10000000, 	10, 1, 1),
	(10000000, 	11, 1, 1),
	(10000000, 	12, 1, 1),
	(10000000, 	13, 1, 1),
	(10000000, 	14, 1, 1),
	(10000000, 	15, 1, 1),
	(10000000, 	16, 1, 1),
	(10000000, 	16, 2, 1),
	(100000, 	16, 3, 2),
	(500000, 	16, 4, 2),
	(2, 	16, 4, 3),
	(3, 	16, 4, 4),
	(10000000, 	17, 1, 1),
	(2000000, 	17, 3, 2),
	(10000000, 	18, 1, 1),
	(10000000, 	19, 1, 1),
	(10000000, 	20, 1, 1),
	(10000000, 	21, 1, 1),
	(10000000, 	22, 1, 1),
	(10000000, 	23, 1, 1),
	(10000000, 	24, 1, 1),
	(10000000, 	25, 1, 1),
	(10000000, 	26, 1, 1),
	(10000000, 	27, 1, 1),
	(10000000, 	28, 1, 1),
	(10000000, 	29, 1, 1),
	(10000000, 	30, 1, 1),
	(10000000, 	31, 1, 1),
	(10000000, 	32, 1, 1),
	(10000000, 	33, 1, 1),
	(10000000, 	34, 1, 1),
	(10000000, 	35, 1, 1),
	(10000000, 	36, 1, 1),
	(10000000, 	37, 1, 1),
	(10000000, 	38, 1, 1),
	(10000000, 	39, 1, 1),
	(10000000, 	40, 1, 1),
	(10000000, 	41, 1, 1),
	(10000000, 	42, 1, 1),
	(10000000, 	43, 1, 1),
	(10000000, 	44, 1, 1),
	(10000000, 	45, 1, 1);

-- 2. Viết câu lệnh query
-- a) Get lương tháng 5 của 1 user bất kì.
SELECT max(id) FROM users;
SELECT min(id) FROM users;
SELECT (SELECT max(id) FROM users) - (SELECT min(id) FROM users);
SELECT floor(rand() * ((SELECT max(id) FROM users) - (SELECT min(id) FROM users)) + (SELECT min(id) FROM users));

SELECT u.id, concat(u.last_name, ' ', u.first_name) user_name , s.total_salary
FROM users u
LEFT JOIN user_department ud ON u.id = ud.user_id
LEFT JOIN user_role ur ON ud.id = ur.user_department_id
LEFT JOIN salary s ON ur.id = s.user_role_id
WHERE s.`month` = '05' 
	AND u.id = (
		SELECT id 
		FROM (
			SELECT floor(rand() * ((SELECT max(id) FROM users) - (SELECT min(id) FROM users)) + (SELECT min(id) FROM users)) id) tmp);

-- b) Get danh sách lương tháng 5 của 1 phòng bất kì sắp xếp theo tổng
-- lương giảm dần
SELECT d.`name` department_name, concat(u.last_name, ' ', u.first_name) user_name, s.total_salary
FROM department d
LEFT JOIN user_department ud ON d.id = ud.department_id
LEFT JOIN user_role ur ON ud.id = ur.user_department_id
LEFT JOIN salary s ON ur.id = s.user_role_id
LEFT JOIN users u ON ud.user_id = u.id
WHERE s.`month` = '05' 
	AND d.id = (
		SELECT id 
		FROM (
			SELECT floor(rand() * ((SELECT max(id) FROM department) - (SELECT min(id) FROM department)) + (SELECT min(id) FROM department)) id) tmp)
ORDER BY s.total_salary DESC;

-- c) Get nhưng user bị tính lương sai(total_salary != total detail salary)
-- trong tháng 5/2020
WITH 
		salary_05 AS (
			SELECT u.id user_id, concat(u.last_name, ' ', u.first_name) user_name , s.id salary_id, s.total_salary
			FROM users u
			LEFT JOIN user_department ud ON u.id = ud.user_id
			LEFT JOIN user_role ur ON ud.id = ur.user_department_id
			LEFT JOIN salary s ON ur.id = s.user_role_id
			WHERE s.`month` = '05'),
		salary_detail_tmp AS (
			SELECT *,
            CASE WHEN operation = 1 THEN '+'
				WHEN operation = 2 THEN '-'
				WHEN operation = 3 THEN '*'
				WHEN operation = 4 THEN '/'
			END op
            FROM salary_detail
        ),        
		salary_detail_05 AS (
			SELECT s05.*, SUM(CONCAT(sd.op, sd.amonth)) total_slr_detail 	-- SUM(CONCAT)) : chỉ đúng với + -, nhân và chia thì không sdung được, khi đó cần sử dụng procerdure với vòng lăp cursor 
			FROM salary_05 s05			
            LEFT JOIN salary_detail_tmp sd ON s05.salary_id = sd.salary_id
            GROUP BY s05.salary_id)
	SELECT * 
    FROM salary_detail_05 WHERE total_salary <> total_slr_detail;
-- d) Get tổng chi phí của các phòng trong tháng 5/2020
SELECT d.`name` department_name, concat(u.last_name, ' ', u.first_name) user_name, SUM(s.total_salary) 'tổng chi phí (tổng lương)'
FROM department d
LEFT JOIN user_department ud ON d.id = ud.department_id
LEFT JOIN user_role ur ON ud.id = ur.user_department_id
LEFT JOIN salary s ON ur.id = s.user_role_id
LEFT JOIN users u ON ud.user_id = u.id
WHERE s.`month` = '05'
GROUP BY d.id;

-- 3. Viết thủ tục cho phép get chi tiết lương tháng của 1 user bất kì
-- hiển thị thông tin sau: Type, Amount, Operation; sao cho hàng
-- cuối cùng sẽ là cột tổng
DROP PROCEDURE IF EXISTS sp_lay_luong_thang_chi_tiet;
DELIMITER $$
CREATE PROCEDURE sp_lay_luong_thang_chi_tiet(IN inputId INT(10))
	BEGIN
		DECLARE targetMonth VARCHAR(2);
		DECLARE targetYear VARCHAR(4);
		DECLARE tongVal DOUBLE(12, 2);
		DECLARE i INT;
		-- biến để xem cursor đã đến dòng cuối chưa
		DECLARE doneMonth BOOLEAN DEFAULT FALSE;
		-- tạo cursor các tháng lương của user nhập vào
		DECLARE cur_month cursor for
			SELECT s.month, s.year FROM users u
			JOIN user_department ud ON u.id = ud.user_id
			JOIN user_role ur ON ud.id = ur.user_department_id
			JOIN salary s ON ur.id = s.user_role_id
			WHERE u.id = inputId	-- user_id nhập vào
			ORDER BY s.year, s.month; 
		
		-- điều khiển hoạt động của cursor khi đến dòng cuối(set là true)
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneMonth = TRUE;
		
		-- tạo bảng tạm để in kết quả (Type, Amount, Operation)
		DROP TEMPORARY TABLE IF EXISTS resultTmp;
		CREATE TEMPORARY TABLE resultTmp(
			type_name VARCHAR(50) CHAR SET utf8mb4,
			amonth DOUBLE(12,2) DEFAULT 0,
			operation VARCHAR(3) DEFAULT ''
		);
		-- mở cur_month
		OPEN cur_month;
			-- lặp từng dòng
			read_loop_month: LOOP
				-- đọc từng dòng của cur_month
				FETCH cur_month INTO targetMonth, targetYear;
				-- đến dòng cuối thì thoát đọc loop
				IF doneMonth THEN
				  LEAVE read_loop_month;
				END IF;
				-- insert tháng lương vào bảng tạm (tháng lương nào. vd 2021/04)
				INSERT INTO resultTmp (type_name) VALUES (CONCAT(targetYear, '/', targetMonth));
				
				BLOCK2: BEGIN
					DECLARE amonthVal DOUBLE(12, 2); -- biến chứa gtri cột amonth
					DECLARE operationVal TINYINT(3); -- biến chứa gtri cột operation
					
					-- biến để xem cursor Luong đã đến dòng cuối chưa
					DECLARE done_luong BOOLEAN DEFAULT FALSE;
					-- tạo cursor lương từng tháng của user nhập vào
					DECLARE cur_luong cursor for
						SELECT sd.amonth, sd.operation
						FROM users u
						JOIN user_department ud ON u.id = ud.user_id
						JOIN user_role ur ON ud.id = ur.user_department_id
						JOIN salary s ON ur.id = s.user_role_id
						JOIN salary_detail sd ON s.id = sd.salary_id
						LEFT JOIN salary_detail_type sdt ON sd.salary_detail_type_id = sdt.id
						WHERE u.id = inputId -- user_id nhập vào
						AND s.`month` = targetMonth
						AND s.`year` = targetYear
						ORDER BY sdt.id;
					
					-- điều khiển hoạt động của cursor khi đến dòng cuối(set là true)
					DECLARE CONTINUE HANDLER FOR NOT FOUND SET done_luong = TRUE;
					SET tongVal = 0;   
					SET i = 0;
					-- mở cur_luong
					OPEN cur_luong;
						-- lặp từng dòng
						read_loop_luong: LOOP
							-- đọc từng dòng của cursor luong
							FETCH cur_luong INTO amonthVal, operationVal;
							-- đến dòng cuối thì thoát đọc loop_luong
							IF done_luong THEN
							  LEAVE read_loop_luong;
							END IF;
							
							-- tính tổng lương
							-- trường hợp này sẽ tính tổng lương từ trên xuống theo id của bảng salary_detail_type. 
							-- --> phép tính sẽ tính từ trái sang phải (không quan tâm cộng trừ nhân chia)
							-- --> nếu bắt buộc phải nhân chia trước công trừ sau đúng toán học --> nghĩ là sẽ không thể làm được
							IF i = 0 THEN 
								SET tongVal = amonthVal;
							ELSE 
								IF operationVal = 1 THEN
								  SET tongVal = tongVal + amonthVal;
								ELSEIF operationVal = 2 THEN
								  SET tongVal = tongVal - amonthVal;
								ELSEIF operationVal = 3 THEN
								  SET tongVal = tongVal * amonthVal;
								ELSEIF operationVal = 4 THEN
								  SET tongVal = tongVal / amonthVal;
								END IF;
							END IF;
							SET i = i + 1;
							
						END LOOP read_loop_luong;	  
					-- đóng cur_luong
					CLOSE cur_luong;
				END BLOCK2;
				
				-- insert detail lương vào bảng tạm
				INSERT INTO resultTmp (
					SELECT sdt.`name`, sd.amonth, sd.operation
						FROM users u
						JOIN user_department ud ON u.id = ud.user_id
						JOIN user_role ur ON ud.id = ur.user_department_id
						JOIN salary s ON ur.id = s.user_role_id
						JOIN salary_detail sd ON s.id = sd.salary_id
						LEFT JOIN salary_detail_type sdt ON sd.salary_detail_type_id = sdt.id
						WHERE u.id = inputId -- user_id nhập vào
						AND s.`month` = targetMonth
						AND s.`year` = targetYear
						ORDER BY sdt.id
				);
				-- insert tổng vào bảng tạm
				INSERT INTO resultTmp(type_name, amonth)
				VALUES ('tổng', tongVal);            
			END LOOP read_loop_month;	  
		-- đóng cur_month
		CLOSE cur_month;	
		-- in ra kết quả
		SELECT * FROM resultTmp;
		-- dùng xong thì xóa bảng tạm
		DROP TEMPORARY TABLE IF EXISTS resultTmp;
	END$$
DELIMITER ;
CALL sp_lay_luong_thang_chi_tiet(8);

-- 4. Viết thủ tục cho phép get lương tháng của 1 user bất kì hiển thị thông tin
-- sau: fullname (first_name + last_name), department, role, salary
DROP PROCEDURE IF EXISTS sp_get_luong_nhan_vien;
DELIMITER $$
CREATE PROCEDURE sp_get_luong_nhan_vien(IN userId INT(10))
	BEGIN
		DECLARE targetMonth VARCHAR(2);
		DECLARE targetYear VARCHAR(4);
		-- biến để xem cursor đã đến dòng cuối chưa
		DECLARE doneMonth BOOLEAN DEFAULT FALSE;
		-- tạo cursor các tháng lương của user nhập vào
		DECLARE cur_month cursor for
			SELECT s.month, s.year FROM users u
			JOIN user_department ud ON u.id = ud.user_id
			JOIN user_role ur ON ud.id = ur.user_department_id
			JOIN salary s ON ur.id = s.user_role_id
			WHERE u.id = userId
			ORDER BY s.year, s.month;
    
		-- điều khiển hoạt động của cursor khi đến dòng cuối(set là true)
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneMonth = TRUE;
    
		-- tạo bảng tạm để in kết quả (fullname (first_name + last_name), department, role, salary)
		DROP TEMPORARY TABLE IF EXISTS resultTmp;
		CREATE TEMPORARY TABLE resultTmp(
			fullname VARCHAR(60) CHAR SET utf8mb4,
			department VARCHAR(30) CHAR SET utf8mb4 DEFAULT '',
            `role` VARCHAR(30) CHAR SET utf8mb4 DEFAULT '',
            salary DOUBLE(12, 2) DEFAULT 0
		);
	-- mở cur_month
	OPEN cur_month;
		-- lặp từng dòng (từng tháng)
		read_loop_month: LOOP
			-- đọc từng dòng của cur_month
			FETCH cur_month INTO targetMonth, targetYear;
            -- đến dòng cuối thì thoát đọc loop
			IF doneMonth THEN
			  LEAVE read_loop_month;
			END IF;
            -- insert tháng lương vào bảng tạm (tháng lương nào. vd 2021/04)
            INSERT INTO resultTmp (fullname) VALUES (CONCAT(targetYear, '/', targetMonth));          
            
			-- insert detail lương vào bảng tạm
            INSERT INTO resultTmp (
				SELECT CONCAT(u.last_name, ' ', u.first_name) user_name, d.`name` department_name, r.`name` role_name, s.total_salary
				FROM users u
				JOIN user_department ud ON u.id = ud.user_id
				JOIN department d ON ud.department_id = d.id
				JOIN user_role ur ON ud.id = ur.user_department_id
				JOIN roles r ON ur.role_id = r.id
				JOIN salary s ON ur.id = s.user_role_id
				WHERE u.id = userId -- user_id nhập vào
				AND s.`month` = targetMonth
				AND s.`year` = targetYear
            );
            
		END LOOP read_loop_month;	  
	-- đóng cur_month
	CLOSE cur_month;	
    -- in ra kết quả
    SELECT * FROM resultTmp;
    -- dùng xong thì xóa bảng tạm
    DROP TEMPORARY TABLE IF EXISTS resultTmp;
	END$$
DELIMITER ;

CALL sp_get_luong_nhan_vien(8);
                    
-- 5. Viết trigger cho phép khi insert data role của 1 user trong phòng thì
-- khoảng thời gian các role phải khác nhau và nằm trong khoảng thời gian
-- của user nằm trong phòng đó.
-- Ví dụ: user A nằm thuộc phòng Admin từ 1/4/2020 đến 1/8/2020, user A
-- có role Nhân viên từ 1/4/2020-1/6/2020 thì khi user đó lên trưởng phòng
-- Admin thì phải nằm trong khoảng 1/4/2020-1/8/2020 và khác khoảng
-- 1/4/2020 và 1/6/2020.
DROP TRIGGER IF EXISTS trigger_check_insert_role_use;
DELIMITER $$
CREATE TRIGGER trigger_check_insert_role_use
BEFORE INSERT ON user_role
FOR EACH ROW
BEGIN
	DECLARE startDepartment DATE; -- ngày bắt đầu vào phòng
	DECLARE endDepartment DATE; -- ngày out phòng
	DECLARE minStartRole DATE; -- ngày bắt đầu role sớm nhất
	DECLARE maxEndRole DATE; -- ngày kết thúc role muộn nhất
    
    -- set ngày bắt đầu và ngày out phòng
    SELECT start_date, end_date INTO startDepartment, endDepartment FROM user_department WHERE id = NEW.user_department_id;    
    -- set ngày sớm nhất bắt đầu role và muộn nhất kết thúc role
    SELECT MIN(start_date), MAX(end_date) INTO minStartRole, maxEndRole FROM user_role WHERE user_department_id = NEW.user_department_id;
    
    -- check khoảng thời gian các role phải khác nhau
    IF (minStartRole <= NEW.start_date AND NEW.start_date <= maxEndRole)
		OR (minStartRole <= NEW.end_date AND NEW.end_date <= maxEndRole)
		OR (NEW.start_date <= minStartRole AND NEW.end_date >= maxEndRole) THEN
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'khoảng thời gian các role phải khác nhau';
    END IF;
    
    -- check nằm trong khoảng thời gian của user nằm trong phòng    
    IF NOT((startDepartment <= NEW.start_date AND NEW.start_date <= endDepartment)
		AND (startDepartment <= NEW.end_date AND NEW.end_date <= endDepartment)) THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'khoảng thời gian phải nằm trong khoảng thời gian của user nằm trong phòng';
	END IF;
END$$
DELIMITER ;

INSERT INTO user_role
VALUES 
	(19, 2, 4, '2009-01-02', '2026-11-02', NOW(), NOW());
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    