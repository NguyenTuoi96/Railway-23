-- create database
DROP DATABASE IF EXISTS testing_system_5;
CREATE DATABASE testing_system_5;
USE testing_system_5;

-- create table: Department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 			VARCHAR(30) CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE KEY
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO department(department_name) 
VALUES
						(N'Waiting'	),
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Nhân viên bán hàng'	);
                        
-- create table: Account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_id 			INT UNSIGNED NOT NULL,
    full_name				VARCHAR(100) CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, 
    `password`				NVARCHAR(30) NOT NULL,
    `confirm_password`		NVARCHAR(30) NOT NULL,
    phone					VARCHAR(15) NOT NULL UNIQUE KEY,
    FOREIGN KEY(department_id) REFERENCES department(department_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `account`( department_id	,email					, full_name	 		, `password`, `confirm_password`, phone)
VALUES 				(  '5'				,'nguyenvana@gmail.com' , 'nguyen van a' 	, 'nguyenA' , 'nguyenA'         , '08039062410'),
					(  '1'				,'nguyenvanb@gmail.com' , 'nguyen van b' 	, 'nguyenB' , 'nguyenB'         , '08039062411'),
                    (  '2'				,'nguyenvanc@gmail.com' , 'nguyen van c' 	, 'nguyenC' , 'nguyenC'         , '08039062412'),
                    (  '3'				,'nguyenvand@gmail.com' , 'nguyen van d' 	, 'nguyenD' , 'nguyenD'         , '08039062413'),
                    (  '4'				,'nguyenvane@gmail.com' , 'nguyen van e' 	, 'nguyenE' , 'nguyenE'         , '08039062414'),
                    (  '6'				,'nguyenvanf@gmail.com' , 'nguyen van f' 	, 'nguyenF' , 'nguyenF'         , '08039062415'),
                    (  '7'				,'nguyenvang@gmail.com' , 'nguyen van g' 	, 'nguyenG' , 'nguyenG'         , '08039062416'),
                    (  '8'				,'nguyenvanh@gmail.com' , 'nguyen van h' 	, 'nguyenH' , 'nguyenH'         , '08039062417'),
                    (  '9'				,'nguyenvani@gmail.com' , 'nguyen van i' 	, 'nguyenI' , 'nguyenI'         , '08039062418'),
                    (  '10'				,'nguyenvanj@gmail.com' , 'nguyen van j' 	, 'nguyenJ' , 'nguyenJ'         , '08039062419');