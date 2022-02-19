-- create database
DROP DATABASE IF EXISTS testing_system_2;
CREATE DATABASE testing_system_2;
USE testing_system_2;

-- create table : address
DROP TABLE IF EXISTS address;
CREATE TABLE address(
	address_id 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    address_name 			NVARCHAR(100) NOT NULL UNIQUE KEY
);

-- create table: Department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table : Detail Department
DROP TABLE IF EXISTS detail_department;
CREATE TABLE detail_department(
	department_id 			TINYINT UNSIGNED PRIMARY KEY,
    address_id 				TINYINT UNSIGNED, -- UNIQUE KEY,  -- NOT NULL ,
    emulation_point 		TINYINT UNSIGNED,
    FOREIGN KEY(department_id) REFERENCES department(department_id),
	FOREIGN KEY(address_id) REFERENCES address(address_id)
);

-- create table: Posittion
DROP TABLE IF EXISTS position;
CREATE TABLE position (
	position_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    position_name			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY
);

-- create table: Salary
DROP TABLE IF EXISTS salary;
CREATE TABLE salary (
	salary_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    salary_name			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
);

-- create table: Account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    first_name				NVARCHAR(50) NOT NULL,
    last_name				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    department_id 			TINYINT UNSIGNED NOT NULL,	-- Set default waiting
    position_id				TINYINT UNSIGNED NOT NULL,	-- Set default Dev
    salary_id				TINYINT UNSIGNED NOT NULL, -- Set default 600
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(department_id) REFERENCES department(department_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id),
    FOREIGN KEY(salary_id) REFERENCES `salary`(salary_id)
);

-- create table: Employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`(
	account_id				TINYINT UNSIGNED PRIMARY KEY,
	working_number_of_year		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(account_id) REFERENCES `account` (account_id)
);

-- create table: Manager
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`(
	account_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    management_number_of_year 		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(account_id) REFERENCES `Account` (account_id)
);

-- create table: Group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    group_name				NVARCHAR(50) NOT NULL UNIQUE KEY,
    creator_id				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
	FOREIGN KEY(creator_id) REFERENCES `account` (account_id)
);

-- create table: GroupAccount
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id					TINYINT UNSIGNED NOT NULL,
    account_id				TINYINT UNSIGNED NOT NULL,
    join_date				DATETIME DEFAULT NOW(),
    PRIMARY KEY (group_id,account_id),
    FOREIGN KEY(account_id) REFERENCES `account` (account_id),
    FOREIGN KEY(group_id) REFERENCES `group` (group_id)
);

-- create table: type_question
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
    type_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name	 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Esay, 1: Multiple-Choice
);

-- create table: CategoryQuestion
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    category_name			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table: Question
DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					NVARCHAR(100) NOT NULL,
    category_id				TINYINT UNSIGNED NOT NULL,
    type_id					TINYINT UNSIGNED NOT NULL,
    creator_id				TINYINT UNSIGNED NOT NULL UNIQUE KEY, -- Cannot update this field
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(category_id) 	REFERENCES category_question(category_id),
    FOREIGN KEY(type_id) 		REFERENCES type_question(type_id),
    FOREIGN KEY(creator_id) 		REFERENCES `account`(account_id)
);

-- create table: Answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answers					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					NVARCHAR(100) NOT NULL,
    question_id				TINYINT UNSIGNED NOT NULL,
    is_correct				BIT DEFAULT 1,
    FOREIGN KEY(question_id) REFERENCES question(question_id)
);

-- create table: Exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
    exam_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    title					NVARCHAR(50) NOT NULL,
    category_id				TINYINT UNSIGNED NOT NULL,
    duration				TINYINT UNSIGNED NOT NULL DEFAULT 45,
    creator_id				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
    create_date				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(category_id) REFERENCES category_question(category_id),
    FOREIGN KEY(creator_id) 	REFERENCES `account`(account_id)
);

-- create table: exam_question
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id				TINYINT UNSIGNED NOT NULL,
	question_id			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(question_id) REFERENCES question(question_id),
    FOREIGN KEY(exam_id) REFERENCES exam(exam_id),
    PRIMARY KEY (exam_id,question_id)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Address
INSERT INTO address(address_name) 
VALUES
				(N'P501'),
				(N'P502'),
				(N'P503'),
				(N'P504'),
				(N'P505'),
				(N'P401'),
				(N'P402'),
				(N'P403'),
				(N'P404'),
				(N'P405');

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

-- Add data DetailDepartment
INSERT INTO detail_department	(  department_id		, address_id, 	emulation_point)
VALUES 							(		1,				1,					1	),
								(		2,				1,					4	),
								(		3,				3,					6	),
								(		4,				4,					7	),
								(		5,				5,					2	),
								(		6,				6,					1	),
								(		7,				7,					5	),
								(		8,				8,					6	),
								(		9,				9,					8	),
								(		10,				10,					9	);
                    
-- Add data position
INSERT INTO position	(`position_name`	) 
VALUES 					('Dev'			),
						('Test'			),
						('ScrumMaster'	);
                        
-- Add data salary                 
INSERT INTO salary		(salary_name	) 
VALUES 					('600'		),
						('700'		),
						('1500'		);


-- Add data Account
INSERT INTO `account`(email								, username			, first_name,	last_name,		 department_id	, position_id, salary_id, 	create_date)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,   '5'			,   '1',		'1'		,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,   '1'			,   '2',		'2'		,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,   '2'			,   '3',		'3'		,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,   '3'			,   '3',		'3'		,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,   '4'			,   '3',		'3'		,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,   '6'			,   '3',		'3'		,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,   '7'			,   '2',		'2'		,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,   '8'			,   '1',		'1'		,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,   '9'			,   '2',		'2'		,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,   '10'		,   '1',		'1'		,	'2020-04-09');

-- Add data Employee                 
INSERT INTO employee	(account_id,		working_number_of_year) 
VALUES 					(	1,					1			),
						(	2,					2			),
						(	3,					1			),
						(	4,					3			),
						(	5,					4			),
 						(	6,					2			),
						(	7,					3			),
						(	8,					1			),
						(	9,					5			),   
                        (	10,					6			);

-- Add data Manager                 
INSERT INTO manager		(account_id,		management_number_of_year) 
VALUES 					(	1,					1			),
						(	2,					2			),
						(	3,					1			),
						(	4,					3			),
						(	5,					4			),
 						(	6,					2			),
						(	7,					3			),
						(	8,					1			),
						(	9,					5			),   
                        (	10,					6			);
                        
-- Add data Group        
INSERT INTO `group`	(  group_name			, creator_id		, create_date)
VALUES 				(N'Testing System'		,   5			,'2019-03-05'),
					(N'Developement'		,   1			,'2020-03-07'),
                    (N'VTI Sale 01'			,   2			,'2020-03-09'),
                    (N'VTI Sale 02'			,   3			,'2020-03-10'),
                    (N'VTI Sale 03'			,   4			,'2020-03-28'),
                    (N'VTI Creator'			,   6			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   7			,'2020-04-07'),
                    (N'Management'			,   8			,'2020-04-08'),
                    (N'Chat with love'		,   9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   10			,'2020-04-10');

-- Add data GroupAccount
INSERT INTO `group_account`	(  group_id	, account_id	, join_date	 )
VALUES 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');

-- Add data TypeQuestion
INSERT INTO type_question	(type_name	) 
VALUES 						('0'), 
							('1'); 


-- Add data CategoryQuestion
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
													
-- Add data Question
INSERT INTO question	(content			, category_id, type_id		, creator_id	, create_date )
VALUES 					(N'Câu hỏi về Java'	,	1		,   '1'			,   '1'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'			,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	9		,   '2'			,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'			,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	5		,   '1'			,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'			,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'			,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'			,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'			,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'			,   '10'	,'2020-04-07');

-- Add data Answers
INSERT INTO answer	(  content		, question_id	, is_correct	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   1			,	1		),
                    (N'Trả lời 03'	,   1			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);
	
-- Add data Exam
INSERT INTO exam	(`code`			, title					, category_id	, duration	, creator_id		, create_date )
VALUES 				('S-1'			, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('S-2'			, N'Đề thi PHP'			,	10			,	60		,   '1'			,'2019-04-05'),
                    ('M-1'			, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('S-3'			, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('M-2'			, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('S-4'			, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('S-5'			, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('S-6'			, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('L-1'			, N'Đề thi ADO.NET'		,	4			,	180		,   '9'			,'2020-04-07'),
                    ('L-2'			, N'Đề thi ASP.NET'		,	7			,	180		,   '10'		,'2020-04-08');
                    
-- Add data ExamQuestion
INSERT INTO exam_question(exam_id	, question_id	) 
VALUES 					(	1	,		5		),
						(	2	,		10		), 
						(	3	,		4		), 
						(	4	,		3		), 
						(	5	,		7		), 
						(	6	,		10		), 
						(	7	,		2		), 
						(	8	,		10		), 
						(	9	,		9		), 
						(	10	,		8		); 