USE testing_system;
-- Question 1: Thêm ít nhất 10 record vào mỗi table
-- Table 1: department
INSERT INTO department(department_name) 
VALUES 
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
-- Table 2: position
-- Giới hạn chỉ có 4 chức vụ nên không thêm
-- Table 3: account
INSERT INTO `account`(email, username, fullname, department_id, position_id, create_date) 
VALUES 
	('ngocha96@gmail.com'		, 'NgocHa96'		, 'Nguyễn Ngọc Hà'		, 13	, 2, '2019-11-18'),
    ('nguyenhuong12@gmail.com'	, 'HuongNguyen'		, 'Nguyễn Thanh Hương'	, 2		, 2, '2019-12-15'),
    ('huongnhai@gmail.com'		, 'HuongNhai'		, 'Phạm Hương Nhài'		, 2		, 3, '2020-11-15'),
    ('nhadan@gmail.com'			, 'NhaDan'			, 'Hoàng Nhã Đan'		, 16	, 4, '2020-08-20'),
    ('ngocanh@gmail.com'		, 'AnhNgoc'			, 'Nguyễn Ngọc Ánh'		, 18	, 4, '2019-05-03'),
    ('hoathanh@gmail.com'		, 'HoaThanh'		, 'Trần Thanh Hòa'		, 14	, 2, '2020-07-01'),
    ('minhanhtran@gmail.com'	, 'MinhAn'			, 'Trần Minh An'		, 17	, 3, '2020-11-25'),
    ('thanhanhnguyen@gmail.com'	, 'ThanhAnh'		, 'Nguyễn Thanh Anh'	, 19	, 2, '2020-03-13'),
    ('nguyenhuong@gmail.com'	, 'NguyenHuong'		, 'Trần Thị Hường'		, 15	, 3, '2019-04-21'),
    ('thanhlong@gmail.com'		, 'ThanhLong'		, 'Phạm Thanh Long'		, 20	, 4, '2020-08-25'),
	('thaiha@gmail.com'			, 'ThaiHa'			, 'Nguyễn Thái Hà'		, 13	, 2, '2019-11-18'),
    ('thanhthao@gmail.com'		, 'ThanhThao'		, 'Nguyễn Thanh Thảo'	, 11	, 2, '2019-12-15'),
    ('thuhuongpham@gmail.com'	, 'ThuHuongPham'	, 'Phạm Thu Hương'		, 11	, 3, '2020-11-15'),
    ('anhvu@gmail.com'			, 'AnhVu'			, 'Hoàng Anh Vũ'		, 16	, 4, '2020-08-20'),
    ('anhthu@gmail.com'			, 'AnhThu'			, 'Nguyễn Anh Thư'		, 20	, 2, '2019-05-03'),
    ('thanhhoatran@gmail.com'	, 'HoaTran'			, 'Trần Thanh Hoa'		, 14	, 2, '2020-07-01'),
    ('tranthienan@gmail.com'	, 'ThienAnTran'		, 'Trần Thiên Ân'		, 17	, 3, '2020-11-25'),
    ('nguyenmocmien@gmail.com'	, 'MocMien'			, 'Nguyễn Mộc Miên'		, 20	, 2, '2020-03-13'),
    ('thuhuongtran@gmail.com'	, 'ThuHuong'		, 'Trần Thu Hường'		, 15	, 2, '2019-04-21'),
    ('thanhngoc@gmail.com'		, 'ThanhNgoc'		, 'Phạm Thanh Ngọc'		, 20	, 4, '2020-08-25'),
    ('thanhhuong01@gmail.com'	, 'ThanhHuong'		, 'Nguyễn Thanh Hương'	, 3		, 3, '2020-08-25'),
    ('dangdao@gmail.com'		, 'DaoDang'			, 'Đặng Thanh Đào'		, 2		, 4, '2019-01-01');
-- Table 4: group
INSERT INTO `group`(group_name, creator_id, create_date) 
VALUES 
	('Nhóm A1', 11, '2021-10-18'),
	('Nhóm B1', 15, '2021-10-19'),
	('Nhóm C1', 13, '2021-09-10'),
	('Nhóm D1', 14, '2021-08-21'),
	('Nhóm E1', 17, '2021-10-01'),
	('Nhóm A2', 18, '2021-10-01'),
	('Nhóm B2', 19, '2021-10-01'),
	('Nhóm C2', 20, '2021-10-01'),
	('Nhóm D2', 12, '2021-10-01'),
	('Nhóm E2', 16, '2019-10-01');
-- Table 5: group_account
INSERT INTO group_account(group_id, account_id, join_date) 
VALUES 
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
-- Table 6: type_question
-- Giới hạn chỉ có 2 kiểu câu hỏi nên không thêm
-- Table 7: category_question
INSERT INTO category_question(category_name) 
VALUES 
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
-- Table 8: question
INSERT INTO question(content, category_id, type_id, creator_id, create_date) 
VALUES 
	('content question test 8'	, 12, 2, 11, '2021-01-11'),
	('content question test 9'	, 14, 1, 13, '2021-01-11'),
	('câu hỏi question test 10'	, 13, 1, 12, '2021-01-11'),
	('content question test 11'	, 15, 1, 16, '2021-01-11'),
	('câu hỏi question test 12'	, 18, 2, 18, '2021-01-11'),
	('câu hỏi question test 13'	, 19, 1, 17, '2021-01-11'),
	('content question test 14'	, 15, 2, 16, '2021-01-11'),
	('câu hỏi question test 15'	, 18, 1, 18, '2021-01-11'),
	('content question test 16'	, 17, 1, 17, '2021-01-11'),
	('câu hỏi question test 17'	, 20, 1, 14, '2021-01-11');
-- Table 9: answer
INSERT INTO answer(content, question_id, is_correct) 
VALUES 
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
-- Table 10: exam
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date) 
VALUES 
	('PH'	, 'title php'		, 9		, 50	, 11	, '2021-05-05'),
	('PT'	, 'title python'	, 10	, 120	, 13	, '2021-06-15'),
	('JQ'	, 'title jquery'	, 11	, 60	, 12	, '2021-06-25'),
	('RC'	, 'title react'		, 12	, 120	, 6		, '2021-09-05'),
	('HT'	, 'title html'		, 13	, 45	, 13	, '2021-10-11'),
	('CCS'	, 'title css'		, 14	, 120	, 15	, '2021-10-15'),
	('C+'	, 'title c++'		, 15	, 60	, 12	, '2021-06-25'),
	('C'	, 'title C'			, 16	, 120	, 16	, '2021-09-05'),
	('BT'	, 'title Bootstrap'	, 17	, 45	, 13	, '2021-10-11'),
	('AG'	, 'Angular'			, 18	, 120	, 15	, '2021-10-15'),
	('JN'	, 'Json'			, 19	, 120	, 15	, '2019-10-15'),
	('AJ'	, 'Ajax'			, 20	, 120	, 15	, '2021-10-15');
-- Table 11: exam_question
INSERT INTO exam_question(exam_id, question_id) 
VALUES 
	(10, 8),
	(11, 11),
	(12, 9),
	(13, 11),
	(13, 14),
	(15, 16),
	(16, 12),
	(16, 15),
    (17, 13),
    (18, 17);

-- Question 2: lấy ra tất cả các phòng ban
SELECT department_name 
FROM department;
-- Question 3: lấy ra id của phòng ban "Sale"
SELECT department_id 
FROM department 
WHERE department_name = 'Sale';
-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * 
FROM `account` 
WHERE length(fullname) = (SELECT MAX(LENGTH(fullname)) FROM `account`);
-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * 
FROM `account`
WHERE length(fullname) = (SELECT MAX(LENGTH(fullname)) FROM `account`)
  AND department_id = 3;
-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT group_name 
FROM `group` 
WHERE create_date < '2019/12/20';
-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT question_id, COUNT(answer_id) 
FROM answer 
GROUP BY question_id 
HAVING COUNT(answer_id) >= 4;
-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019  
SELECT `code` 
FROM exam 
WHERE duration >= 60 
  AND create_date < '2019-12-20';
-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * 
FROM `group` 
ORDER BY create_date DESC 
LIMIT 5;
-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(*) 
FROM `account` 
WHERE department_id = 2;
-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * 
FROM `account` 
WHERE fullname LIKE 'D%o';
-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM exam WHERE create_date < '2019-12-20';
-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM question WHERE content LIKE 'câu hỏi%';
-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `account` 
SET fullname = 'Nguyễn Bá Lộc',
	email = 'loc.nguyenba@vti.com.vn'
WHERE account_id = 5;
-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE group_account 
SET group_id = '4' 
WHERE account_id = '5'