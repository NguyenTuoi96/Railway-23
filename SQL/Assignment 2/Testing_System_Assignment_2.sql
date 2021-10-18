-- tạo cơ sở dữ liệu 'testing_system'
DROP DATABASE IF EXISTS testing_system; -- nếu tồn tại database tên là testing_system thì xóa đi
CREATE DATABASE testing_system; -- khởi tạo database
-- sử dụng database testing_system
USE testing_system;

ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; -- sửa DB khi không sử dụng được NVARCHAR

-- Table 1:Department
--  DepartmentID: định danh của phòng ban (auto increment)
--  DepartmentName: tên đầy đủ của phòng ban (VD: sale, marketing, ...)
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 		TINYINT AUTO_INCREMENT PRIMARY KEY,
    department_name 	VARCHAR(30) CHAR SET utf8mb4 NOT NULL
);
-- Table 2: Position
--  PositionID: định danh của chức vụ (auto increment)
--  PositionName: tên chức vụ (Dev, Test, Scrum Master, PM)
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
	position_id 	TINYINT AUTO_INCREMENT PRIMARY KEY,
    position_name 	ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
-- Table 3: Account
--  AccountID: định danh của User (auto increment)
--  Email:
--  Username:
--  FullName:
--  DepartmentID: phòng ban của user trong hệ thống
--  PositionID: chức vụ của User
--  CreateDate: ngày tạo tài khoản
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id 		INT AUTO_INCREMENT PRIMARY KEY,
    email 			VARCHAR(50) UNIQUE NOT NULL,
    username 		VARCHAR(50) UNIQUE NOT NULL,
    fullname 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    department_id 	TINYINT NOT NULL,
    position_id 	TINYINT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);
-- Table 4: Group
--  GroupID: định danh của nhóm (auto increment)
--  GroupName: tên nhóm
--  CreatorID: id của người tạo group
--  CreateDate: ngày tạo group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id 		TINYINT AUTO_INCREMENT PRIMARY KEY,
    group_name 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
-- Table 5: GroupAccount
--  GroupID: định danh của nhóm
--  AccountID: định danh của User
--  JoinDate: Ngày user tham gia vào nhóm
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id 		TINYINT NOT NULL,
    account_id 		INT NOT NULL,
    join_date 		DATE,
    FOREIGN KEY (group_id) REFERENCES `group`(group_id),
    FOREIGN KEY (account_id) REFERENCES `account`(account_id)
);
-- Table 6: TypeQuestion
--  TypeID: định danh của loại câu hỏi (auto increment)
--  TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
	type_id 	TINYINT AUTO_INCREMENT PRIMARY KEY,
    type_name 	ENUM('Essay', 'Multiple-Choice')
);
-- Table 7: CategoryQuestion
--  CategoryID: định danh của chủ đề câu hỏi (auto increment)
--  CategoryName: tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby,
-- ...)
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
	category_id 	TINYINT AUTO_INCREMENT PRIMARY KEY,
    category_name 	VARCHAR(50) CHAR SET utf8mb4 NOT NULL
);
-- Table 8: Question
--  QuestionID: định danh của câu hỏi (auto increment)
--  Content: nội dung của câu hỏi
--  CategoryID: định danh của chủ đề câu hỏi
--  TypeID: định danh của loại câu hỏi
--  CreatorID: id của người tạo câu hỏi
--  CreateDate: ngày tạo câu hỏi
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id 	TINYINT AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(2000) CHAR SET utf8mb4,
    category_id 	TINYINT NOT NULL,
    type_id 		TINYINT NOT NULL,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
-- Table 9: Answer
--  AnswerID: định danh của câu trả lời (auto increment)
--  Content: nội dung của câu trả lời
--  QuestionID: định danh của câu hỏi
--  isCorrect: câu trả lời này đúng hay sai
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	answer_id 		TINYINT AUTO_INCREMENT PRIMARY KEY,
    content 		VARCHAR(5000) CHAR SET utf8mb4,
    question_id 	TINYINT NOT NULL,
    is_correct 		BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);
-- Table 10: Exam
--  ExamID: định danh của đề thi (auto increment)
--  Code: mã đề thi
--  Title: tiêu đề của đề thi
--  CategoryID: định danh của chủ đề thi
--  Duration: thời gian thi
--  CreatorID: id của người tạo đề thi
--  CreateDate: ngày tạo đề thi
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
	exam_id 		TINYINT AUTO_INCREMENT PRIMARY KEY,
    `code` 			CHAR(10),
    title 			VARCHAR(50) CHAR SET utf8mb4,
    category_id 	TINYINT NOT NULL,
    duration 		INT,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);
-- Table 11: ExamQuestion
--  ExamID: định danh của đề thi
--  QuestionID: định danh của câu hỏi
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
	exam_id 		TINYINT NOT NULL,
    question_id 	TINYINT NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)    
);

-- Thêm dữ liệu vào các table
-- Table 1: department
INSERT INTO department(department_id, department_name) 
VALUES 
	(1, 'Marketing'),
	(2, 'Sale'),
    (3, N'Phát triển'),
    (4, N'Nhân sự'),
    (5, N'Kỹ thuật'),
    (6, N'Tài chính'),
    (7, N'Phó giám đốc'),
    (8, N'Giám đốc'),
    (9, N'Thư kí'),
    (10, N'Bảo vệ');
-- Table 2: position
INSERT INTO `position`(position_id, position_name) 
VALUES 
	(1, 'Dev'),
	(2, 'Test'),
    (3, 'Scrum Master'),
    (4, 'PM');
-- Table 3: account
INSERT INTO `account`(account_id, email, username, fullname, department_id, position_id, create_date) 
VALUES 
	(1, 'nguyenhong@gmail.com', 'NguyenHong', 'Nguyễn Thị Hồng', 3, 2, '2021-10-18'),
    (2, 'nguyenhoa@gmail.com', 'NguyenHoa', 'Nguyễn Thị Hoa', 1, 3, '2020-10-15'),
    (3, 'phamhue@gmail.com', 'PhamHue', 'Phạm Thị Huệ', 1, 2, '2019-11-13'),
    (4, 'hoangnha@gmail.com', 'HoangNha', 'Hoàng Phong Nhã', 6, 4, '2020-09-20'),
    (5, 'nguyendong@gmail.com', 'NguyenDong', 'Nguyễn Văn Đông', 8, 4, '2018-05-03'),
    (6, 'tranthanhphong@gmail.com', 'ThanhPhong', 'Trần Thanh Phong', 4, 2, '2021-09-11'),
    (7, 'tranminhnguyet@gmail.com', 'MinhNguyet', 'Trần Minh Nguyệt', 7, 3, '2021-01-30'),
    (8, 'nguyenan@gmail.com', 'NguyenAn', 'Nguyễn Văn An', 9, 2, '2020-02-11'),
    (9, 'tranthithu@gmail.com', 'ThiThu', 'Trần Thị Thu', 5, 3, '2019-05-20'),
    (10, 'thungan@gmail.com', 'ThuNgan', 'Phạm Thu Ngân', 2, 4, '2020-08-15');
-- Table 4: group
INSERT INTO `group`(group_id, group_name, creator_id, create_date) 
VALUES 
	(1, N'Nhóm A', 1, '2021-10-18'),
	(2, N'Nhóm B', 5, '2021-10-19'),
	(3, N'Nhóm C', 3, '2021-09-10'),
	(4, N'Nhóm D', 4, '2021-08-21'),
	(5, N'Nhóm E', 7, '2021-10-01');
-- Table 5: group_account
INSERT INTO group_account(group_id, account_id, join_date) 
VALUES 
	(1, 1, '2021-10-18'),
	(1, 2, '2021-10-18'),
	(2, 5, '2021-10-19'),
	(2, 9, '2021-10-19'),
	(3, 3, '2021-09-10'),
	(3, 6, '2021-09-10'),
	(4, 4, '2021-08-21'),
	(4, 8, '2021-08-21'),
	(5, 7, '2021-10-01'),
	(5, 10, '2021-10-01');
-- Table 6: type_question
INSERT INTO type_question(type_id, type_name) 
VALUES 
	(1, 'Essay'),
	(2, 'Multiple-Choice');
-- Table 7: category_question
INSERT INTO category_question(category_id, category_name) 
VALUES 
	(1, 'Java'),
	(2, '.NET'),
	(3, 'SQL'),
	(4, 'Postman'),
	(5, 'Ruby'),
	(6, 'VBA'),
	(7, 'C#'),
	(8, 'js');
-- Table 8: question
INSERT INTO question(question_id, content, category_id, type_id, creator_id, create_date) 
VALUES 
	(1, 'content test 1', 2, 1, 1, '2021-10-11'),
	(2, 'content test 2', 4, 2, 3, '2021-10-11'),
	(3, 'content test 3', 3, 1, 2, '2021-10-11'),
	(4, 'content test 4', 5, 2, 6, '2021-10-11'),
	(5, 'content test 5', 8, 2, 8, '2021-10-11'),
	(6, 'content test 6', 7, 1, 7, '2021-10-11'),
	(7, 'content test 7', 6, 1, 4, '2021-10-11');
-- Table 9: answer
INSERT INTO answer(answer_id, content, question_id, is_correct) 
VALUES 
	(1, 'content answer test 1', 2, 1),
	(2, 'content answer test 2', 4, 0),
	(3, 'content answer test 3', 3, 1),
	(4, 'content answer test 4', 5, 0),
	(5, 'content answer test 5', 1, 1),
	(6, 'content answer test 6', 7, 1),
	(7, 'content answer test 7', 6, 1);
-- Table 10: exam
INSERT INTO exam(exam_id, `code`, title, category_id, duration, creator_id, create_date) 
VALUES 
	(1, 'RB', 'title ruby', 5, 50, 1, '2021-05-05'),
	(2, 'VB', 'title vb 1', 6, 100, 3, '2021-06-15'),
	(3, 'JS', 'title exam js', 8, 60, 2, '2021-06-25'),
	(4, 'PM', 'title postman', 4, 120, 6, '2021-09-05'),
	(5, 'SQ', 'title sql exam', 3, 40, 3, '2021-10-11'),
	(6, 'C#', 'title exam C#', 7, 180, 5, '2021-10-15');
-- Table 11: exam_question
INSERT INTO exam_question(exam_id, question_id) 
VALUES 
	(1, 4),
	(2, 7),
	(3, 5),
	(4, 2),
	(5, 3),
	(6, 6);