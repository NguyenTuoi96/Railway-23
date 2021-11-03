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
	department_id 		TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    department_name 	VARCHAR(30) CHAR SET utf8mb4 NOT NULL UNIQUE
);
-- Thêm data vào bảng
INSERT INTO department(department_name) 
VALUES 
	('Marketing'),
	('Sale'),
    ('Phát triển'),
    ('Nhân sự'),
    ('Kỹ thuật'),
    ('Tài chính'),
    ('Phó giám đốc'),
    ('Giám đốc'),
    ('Thư kí'),
    ('Bảo vệ'),
	('Phòng A1'),
	('Phòng A2'),
    ('Phòng A3'),
    ('Phòng A4'),
    ('Phòng A5'),
    ('Phòng B1'),
    ('Phòng B2'),
    ('Phòng B3'),
    ('Phòng B4'),
    ('Phòng B5');
    
-- Table 2: Position
--  PositionID: định danh của chức vụ (auto increment)
--  PositionName: tên chức vụ (Dev, Test, Scrum Master, PM)
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
	position_id 	TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    position_name 	ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
-- Thêm data vào bảng
INSERT INTO `position`(position_name) 
VALUES 
	('Dev'),
	('Test'),
    ('Scrum Master'),
    ('PM');
    
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
	account_id 		INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    email 			VARCHAR(50) UNIQUE NOT NULL,
    username 		VARCHAR(20) UNIQUE NOT NULL,
    fullname 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    gender  		CHAR(20),
    department_id 	TINYINT NOT NULL,
    position_id 	TINYINT NOT NULL,
    create_date 	DATE,
FOREIGN KEY (department_id) REFERENCES department(department_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (position_id) REFERENCES `position`(position_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm data vào bảng
INSERT INTO `account`(email, username, fullname, gender, department_id, position_id, create_date) 
VALUES 
	('nguyenhong@gmail.com'		, 'NguyenHong'		, 'Nguyễn Thị Hồng'		, 'F', 3	, 2, '2010-10-18'),
    ('nguyenhoa@gmail.com'		, 'NguyenHoa'		, 'Nguyễn Thị Hoa'		, 'F', 1	, 3, '2020-10-15'),
    ('phamhue@gmail.com'		, 'PhamHue'			, 'Phạm Thị Huệ'		, 'F', 1	, 2, '2019-11-13'),
    ('hoangnha@gmail.com'		, 'HoangNha'		, 'Hoàng Phong Nhã'		, 'M', 6	, 4, '2020-09-20'),
    ('nguyendong@gmail.com'		, 'NguyenDong'		, 'Nguyễn Văn Đông'		, 'M', 8	, 1, '2018-05-03'),
    ('tranthanhphong@gmail.com'	, 'ThanhPhong'		, 'Trần Thanh Phong'	, 'M', 4	, 2, '2021-09-11'),
    ('tranminhnguyet@gmail.com'	, 'MinhNguyet'		, 'Trần Minh Nguyệt'	, 'F', 7	, 3, '2021-01-30'),
    ('nguyenan@gmail.com'		, 'NguyenAn'		, 'Nguyễn Văn An'		, 'M', 9	, 2, '2020-02-11'),
    ('tranthithu@gmail.com'		, 'ThiThu'			, 'Trần Thị Thu'		, 'F', 5	, 3, '2019-05-20'),
    ('thungan@gmail.com'		, 'ThuNgan'			, 'Phạm Thu Ngân'		, 'F', 2	, 4, '2020-08-15'),
	('ngocha96@gmail.com'		, 'NgocHa96'		, 'Nguyễn Ngọc Hà'		, 'F', 13	, 2, '2019-11-18'),
    ('nguyenhuong12@gmail.com'	, 'HuongNguyen'		, 'Nguyễn Thanh Hương'	, 'F', 2	, 2, '2019-12-15'),
    ('huongnhai@gmail.com'		, 'HuongNhai'		, 'Phạm Hương Nhài'		, 'F', 2	, 3, '2020-11-15'),
    ('nhadan@gmail.com'			, 'NhaDan'			, 'Hoàng Nhã Đan'		, 'F', 16	, 4, '2020-08-20'),
    ('ngocanh@gmail.com'		, 'AnhNgoc'			, 'Nguyễn Ngọc Ánh'		, 'F', 18	, 1, '2019-05-03'),
    ('hoathanh@gmail.com'		, 'HoaThanh'		, 'Trần Thanh Hòa'		, 'M', 14	, 2, '2020-07-01'),
    ('minhanhtran@gmail.com'	, 'MinhAn'			, 'Trần Minh An'		, 'F', 17	, 3, '2020-11-25'),
    ('thanhanhnguyen@gmail.com'	, 'ThanhAnh'		, 'Nguyễn Thanh Anh'	, 'F', 19	, 2, '2020-03-13'),
    ('nguyenhuong@gmail.com'	, 'NguyenHuong'		, 'Trần Thị Hường'		, 'F', 15	, 3, '2019-04-21'),
    ('thanhlong@gmail.com'		, 'ThanhLong'		, 'Phạm Thanh Long'		, 'M', 20	, 4, '2020-08-25'),
	('thaiha@gmail.com'			, 'ThaiHa'			, 'Nguyễn Thái Hà'		, 'F', 13	, 2, '2019-11-18'),
    ('thanhthao@gmail.com'		, 'ThanhThao'		, 'Nguyễn Thanh Thảo'	, 'F', 11	, 2, '2019-12-15'),
    ('thuhuongpham@gmail.com'	, 'ThuHuongPham'	, 'Phạm Thu Hương'		, 'F', 11	, 3, '2020-11-15'),
    ('anhvu@gmail.com'			, 'AnhVu'			, 'Hoàng Anh Vũ'		, 'M', 16	, 4, '2020-08-20'),
    ('anhthu@gmail.com'			, 'AnhThu'			, 'Nguyễn Anh Thư'		, 'F', 20	, 2, '2019-05-03'),
    ('thanhhoatran@gmail.com'	, 'HoaTran'			, 'Trần Thanh Hoa'		, 'F', 14	, 1, '2020-07-01'),
    ('tranthienan@gmail.com'	, 'ThienAnTran'		, 'Trần Thiên Ân'		, 'F', 17	, 3, '2020-11-25'),
    ('nguyenmocmien@gmail.com'	, 'MocMien'			, 'Nguyễn Mộc Miên'		, 'F', 20	, 2, '2020-03-13'),
    ('thuhuongtran@gmail.com'	, 'ThuHuong'		, 'Trần Thu Hường'		, 'F', 15	, 2, '2019-04-21'),
    ('thanhngoc@gmail.com'		, 'ThanhNgoc'		, 'Phạm Thanh Ngọc'		, 'F', 20	, 4, '2020-08-25'),
    ('thanhhuong01@gmail.com'	, 'ThanhHuong'		, 'Nguyễn Thanh Hương'	, 'F', 3	, 3, '2020-08-25'),
    ('dangdao@gmail.com'		, 'DaoDang'			, 'Đặng Thanh Đào'		, 'F', 2	, 1, '2019-01-01');
    
-- Table 4: Group
--  GroupID: định danh của nhóm (auto increment)
--  GroupName: tên nhóm
--  CreatorID: id của người tạo group
--  CreateDate: ngày tạo group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id 		TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    group_name 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL UNIQUE,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm data vào bảng
INSERT INTO `group`(group_name, creator_id, create_date) 
VALUES 
	('Nhóm A'	, 1	, '2021-10-18'),
	('Nhóm B'	, 5	, '2021-10-19'),
	('Nhóm C'	, 3	, '2021-09-10'),
	('Nhóm D'	, 4	, '2021-08-21'),
	('Nhóm E'	, 7	, '2021-10-01'),
	('Nhóm A1'	, 11, '2021-10-18'),
	('Nhóm B1'	, 15, '2021-10-19'),
	('Nhóm C1'	, 13, '2021-09-10'),
	('Nhóm D1'	, 14, '2021-08-21'),
	('Nhóm E1'	, 17, '2021-10-01'),
	('Nhóm A2'	, 18, '2021-10-01'),
	('Nhóm B2'	, 19, '2021-10-01'),
	('Nhóm C2'	, 20, '2021-10-01'),
	('Nhóm D2'	, 12, '2021-10-01'),
	('Nhóm E2'	, 16, '2019-10-01');
    
-- Table 5: GroupAccount
--  GroupID: định danh của nhóm
--  AccountID: định danh của User
--  JoinDate: Ngày user tham gia vào nhóm
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id 		TINYINT NOT NULL,
    account_id 		INT NOT NULL,
    join_date 		DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) REFERENCES `group`(group_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (account_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm data vào bảng
INSERT INTO group_account(group_id, account_id, join_date) 
VALUES 
	(1	, 1	, '2021-10-18'),
	(1	, 2	, '2021-10-18'),
	(2	, 5	, '2021-10-19'),
	(2	, 9	, '2021-10-19'),
	(2	, 1	, '2021-09-10'),
	(3	, 6	, '2021-09-10'),
	(2	, 4	, '2021-08-21'),
	(4	, 8	, '2021-08-21'),
	(5	, 7	, '2021-10-01'),
	(5	, 10, '2021-10-01'),
	(6	, 21, '2021-10-18'),
	(7	, 22, '2021-10-18'),
	(8	, 25, '2021-10-19'),
	(9	, 29, '2021-10-19'),
	(10	, 23, '2021-09-10'),
	(11	, 26, '2021-09-10'),
	(12	, 24, '2021-08-21'),
	(2	, 15, '2021-08-21'),
	(14	, 27, '2021-10-01'),
	(2	, 28, '2021-10-01');
    
-- Table 6: TypeQuestion
--  TypeID: định danh của loại câu hỏi (auto increment)
--  TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
	type_id 	TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    type_name 	ENUM('Essay', 'Multiple-Choice')
);
-- Thêm data vào bảng
INSERT INTO type_question(type_name) 
VALUES 
	('Essay'),
	('Multiple-Choice');
    
-- Table 7: CategoryQuestion
--  CategoryID: định danh của chủ đề câu hỏi (auto increment)
--  CategoryName: tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby,
-- ...)
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
	category_id 	TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    category_name 	VARCHAR(50) CHAR SET utf8mb4 NOT NULL UNIQUE
);
-- Thêm data vào bảng
INSERT INTO category_question(category_name) 
VALUES 
	('Java'),
	('.NET'),
	('SQL'),
	('Postman'),
	('Ruby'),
	('VBA'),
	('C#'),
	('js'),
	('PHP'),
	('Python'),
	('Jquery'),
	('React'),
	('Html'),
	('Css'),
	('C++'),
	('C'),
	('Bootstrap'),
	('Vue'),
	('NodeJs'),
	('Angular');
    
-- Table 8: Question
--  QuestionID: định danh của câu hỏi (auto increment)
--  Content: nội dung của câu hỏi
--  CategoryID: định danh của chủ đề câu hỏi
--  TypeID: định danh của loại câu hỏi
--  CreatorID: id của người tạo câu hỏi
--  CreateDate: ngày tạo câu hỏi
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id 	TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    content 		VARCHAR(2000) CHAR SET utf8mb4 NOT NULL,
    category_id 	TINYINT NOT NULL,
    type_id 		TINYINT NOT NULL,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (type_id) REFERENCES type_question(type_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm data vào bảng
INSERT INTO question(content, category_id, type_id, creator_id, create_date) 
VALUES 
	('content test 1'			, 2	, 1, 1	, '2021-10-11'),
	('content test 2'			, 4	, 2, 3	, '2021-10-11'),
	('content test 3'			, 3	, 1, 2	, '2021-10-11'),
	('content test 4'			, 5	, 1, 6	, '2021-10-11'),
	('content test 5'			, 8	, 1, 8	, '2021-10-11'),
	('content test 6'			, 7	, 1, 7	, '2021-10-11'),
	('content test 7'			, 6	, 1, 4	, '2021-10-11'),
	('content question test 8'	, 12, 2, 11	, '2021-01-11'),
	('content question test 9'	, 14, 1, 13	, '2021-01-11'),
	('câu hỏi question test 10'	, 13, 1, 12	, '2021-01-11'),
	('content question test 11'	, 15, 1, 16	, '2021-01-11'),
	('câu hỏi question test 12'	, 18, 2, 18	, '2021-01-11'),
	('câu hỏi question test 13'	, 19, 1, 17	, '2021-01-11'),
	('content question test 14'	, 15, 2, 16	, '2021-01-11'),
	('câu hỏi question test 15'	, 18, 1, 18	, '2021-01-11'),
	('content question test 16'	, 17, 1, 17	, '2021-01-11'),
	('câu hỏi question test 17'	, 20, 1, 14	, '2021-01-11');
    
-- Table 9: Answer
--  AnswerID: định danh của câu trả lời (auto increment)
--  Content: nội dung của câu trả lời
--  QuestionID: định danh của câu hỏi
--  isCorrect: câu trả lời này đúng hay sai
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	answer_id 		TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    content 		VARCHAR(5000) CHAR SET utf8mb4,
    question_id 	TINYINT NOT NULL,
    is_correct 		BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm data vào bảng
INSERT INTO answer(content, question_id, is_correct) 
VALUES 
	('content answer test 1'	, 2		, 1),
	('content answer test 2'	, 3		, 1),
	('content answer test 3'	, 3		, 1),
	('content answer test 4'	, 3		, 0),
	('content answer test 1'	, 1		, 0),
	('content answer test 22'	, 1		, 0),
	('content answer test 12'	, 1		, 0),
	('content answer test 6'	, 7		, 1),
	('content answer test 7'	, 6		, 1),
	('content answer test 8'	, 12	, 1),
	('content answer test 9'	, 2		, 1),
	('content answer test 10'	, 2		, 1),
	('content answer test 11'	, 2		, 1),
	('content answer test 12'	, 14	, 0),
	('content answer test 13'	, 13	, 1),
	('content answer test 14'	, 15	, 0),
	('content answer test 15'	, 11	, 1),
	('content answer test 16'	, 17	, 1),
	('content answer test 17'	, 16	, 1);
    
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
	exam_id 		TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `code` 			CHAR(10) UNIQUE NOT NULL,
    title 			VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    category_id 	TINYINT NOT NULL,
    duration 		TINYINT NOT NULL,
    creator_id 		INT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm data vào bảng
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date) 
VALUES 
	('RB'	, 'title ruby'		, 5		, 50	, 1		, '2021-05-05'),
	('VB'	, 'title vb 1'		, 6		, 120	, 3		, '2021-06-15'),
	('JS'	, 'title exam js'	, 8		, 60	, 2		, '2021-06-25'),
	('PM'	, 'title postman'	, 4		, 120	, 6		, '2021-09-05'),
	('SQ'	, 'title sql exam'	, 3		, 45	, 3		, '2021-10-11'),
	('C#'	, 'title exam C#'	, 7		, 15	, 5		, '2021-10-15'),
	('PH'	, 'title php'		, 9		, 50	, 11	, '2021-05-05'),
	('PT'	, 'title python'	, 10	, 120	, 13	, '2021-06-15'),
	('JQ'	, 'title jquery'	, 11	, 60	, 12	, '2021-06-25'),
	('RC'	, 'title react'		, 12	, 120	, 6		, '2021-09-05'),
	('HT'	, 'title html'		, 13	, 45	, 13	, '2021-10-11'),
	('CCS'	, 'title css'		, 14	, 120	, 15	, '2021-10-15'),
	('C+'	, 'title c++'		, 15	, 60	, 12	, '2021-06-25'),
	('C'	, 'title C'			, 16	, 120	, 16	, '2021-09-05'),
	('BT'	, 'title Bootstrap'	, 17	, 45	, 13	, '2021-10-11'),
	('AG'	, 'Angular'			, 18	, 120	, 15	, '2019-10-15'),
	('JN'	, 'Json'			, 19	, 120	, 15	, '2021-10-31'),
	('AJ'	, 'Ajax'			, 20	, 120	, 15	, '2021-11-01');
    
-- Table 11: ExamQuestion
--  ExamID: định danh của đề thi
--  QuestionID: định danh của câu hỏi
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
	exam_id 		TINYINT NOT NULL,
    question_id 	TINYINT NOT NULL,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (question_id) REFERENCES question(question_id)  ON DELETE CASCADE ON UPDATE CASCADE   
);
-- Thêm data vào bảng
INSERT INTO exam_question(exam_id, question_id) 
VALUES 
	(1	, 15),
    (1	, 5),
    (1	, 6),
    (1	, 7),
    (1	, 8),
    (1	, 9),
    (1	, 1),
    (1	, 2),
    (1	, 3),
    (1	, 4),
	(2	, 7),
	(3	, 6),
	(4	, 2),
	(5	, 3),
	(6	, 6),
	(10	, 8),
	(11	, 11),
	(12	, 9),
	(13	, 11),
	(13	, 14),
	(15	, 16),
	(16	, 12),
	(16	, 15),
    (17	, 13),
    (18	, 16);
