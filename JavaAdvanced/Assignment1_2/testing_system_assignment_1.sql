 -- create database
DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
USE testing_system;
SELECT * from exam;
-- create table Ex1: group_ex1
DROP TABLE IF EXISTS 	group_ex1;
CREATE TABLE IF NOT EXISTS group_ex1 (
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 			NVARCHAR(50) NOT NULL UNIQUE KEY,
    create_date 	DATE
);

INSERT INTO `group_ex1` (`name`, create_date )

VALUE				('Java Fresher', '2022-01-01'),			
					('Java Web', '2022-01-02'),			
					('C# Fresher', '2022-01-03');

-- Ex3
-- create table 1: department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 		NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- Add data Department
INSERT INTO department(department_name) 
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);

-- create table 2: posittion
DROP TABLE IF EXISTS position;
CREATE TABLE position (
	position_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    position_name			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY -- mapping trên Java là String
);

-- Add data position
INSERT INTO position	(position_name	) 
VALUES 					('Dev'			),
						('Test'			),
						('ScrumMaster'	);

-- create table 3: salary
DROP TABLE IF EXISTS salary;
CREATE TABLE `salary` (
	salary_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    salary_name			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
);

-- Add data salary                 
INSERT INTO `salary`	(salary_name	) 
VALUES 					('600'		),
						('700'		),
						('1500'		);

-- create table 4: account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    first_name				NVARCHAR(50) NOT NULL,
    last_name				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);
-- Add data account
INSERT INTO `account`(email								, username			, first_name	, last_name 		, create_date)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'			, 'Nguyen Hai'		, '2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'			, 'Tong Quang'		, '2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien'		, 'Nguyen Van'		, '2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'			, 'Duong'			, '2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang'		, 'Nguyen Chien'  	, '2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'			, 'Ngo Ba'			, NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'			, 'Bui Xuan'		, NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'			, 'Nguyen Thanh'	, '2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'			, 'Duong Van'		, '2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'			, 'Vi Ti'			, '2020-04-09');

-- create table 5: group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    group_name				NVARCHAR(50) NOT NULL UNIQUE KEY,
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);
-- Add data Group
INSERT INTO `group`	(  group_name			, create_date)
VALUES 				(N'Testing System'		,'2019-03-05'),
					(N'Developement'		,'2020-03-07'),
                    (N'VTI Sale 01'			,'2020-03-09'),
                    (N'VTI Sale 02'			,'2020-03-10'),
                    (N'VTI Sale 03'			,'2020-03-28'),
                    (N'VTI Creator'			,'2020-04-06'),
                    (N'VTI Marketing 01'	,'2020-04-07'),
                    (N'Management'			,'2020-04-08'),
                    (N'Chat with love'		,'2020-04-09'),
                    (N'Vi Ti Ai'			,'2020-04-10');

-- create table 6: type_question
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
    type_id 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Essay, 1: Multiple-Choice
);

-- Add data TypeQuestion
INSERT INTO type_question	(type_name	) 
VALUES 						('0'); 

-- create table 7: category_question
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    category_name			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- Add data category_question
INSERT INTO category_question		(category_name	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);

-- create table 8: question
DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					NVARCHAR(100) NOT NULL,
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- Add data question
INSERT INTO question	(content			, create_date )
VALUES 					(N'Câu hỏi về Java'	,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,'2020-04-05'),
						(N'Hỏi về C#'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,'2020-04-06'),
						(N'Hỏi về Postman'	,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,'2020-04-06'),
						(N'Hỏi về C++'		,'2020-04-07'),
						(N'Hỏi về SQL'		,'2020-04-07'),
						(N'Hỏi về Python'	,'2020-04-07');

-- create table 9: answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					NVARCHAR(100) NOT NULL,
    is_correct				BIT DEFAULT 1
);

-- Add data answer
INSERT INTO answer	(  content		, is_correct	)
VALUES 				(N'Trả lời 01'	, 0),
					(N'Trả lời 02'	, 1),
                    (N'Trả lời 03'	, 0),
                    (N'Trả lời 04'	, 1),
                    (N'Trả lời 05'	, 1),
                    (N'Trả lời 06'	, 1),
                    (N'Trả lời 07'	, 0),
                    (N'Trả lời 08'	, 0),
                    (N'Trả lời 09'	, 1),
                    (N'Trả lời 10'	, 1);

-- create table 10: exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam (
    exam_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code1`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    `code2`					CHAR(10), -- NOT NUL-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    title					NVARCHAR(50) NOT NULL,
    duration				integer default 25 NOT NULL,
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);	
SELECT * FROM exam;
INSERT INTO exam	(`code1`			, title				, create_date )
VALUES 				('S-5'			, N'Đề thi C#3'			, '2019-04-05')


-- Add data exam
INSERT INTO exam	(`code1`			, title				, duration	,  create_date )
VALUES 				('S-1'			, N'Đề thi C#'			,	60		, '2019-04-05'),
					('S-2'			, N'Đề thi PHP'			,	60		, '2019-04-05'),
                    ('M-1'			, N'Đề thi C++'			,	120		, '2019-04-07'),
                    ('S-3'			, N'Đề thi Java'		,	60		, '2020-04-08'),
                    ('M-2'			, N'Đề thi Ruby'		,	120		, '2020-04-10'),
                    ('S-4'			, N'Đề thi Postman'		,	60		, '2020-04-05'),
                    ('S-5'			, N'Đề thi SQL'			,	60		, '2020-04-05'),
                    ('S-6'			, N'Đề thi Python'		,	60		, '2020-04-07'),
                    ('L-1'			, N'Đề thi ADO.NET'		,	180		, '2020-04-07'),
                    ('L-2'			, N'Đề thi ASP.NET'		,	180		, '2020-04-08');