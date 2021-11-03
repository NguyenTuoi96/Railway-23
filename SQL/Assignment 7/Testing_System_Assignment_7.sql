-- Exercise 1: Tiếp tục với Database Testing System
USE testing_system;
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước
DROP TRIGGER IF EXISTS trigger_check_insert_group;
DELIMITER $$
CREATE TRIGGER trigger_check_insert_group
	BEFORE INSERT ON `group`
	FOR EACH ROW
	BEGIN
		DECLARE targetCreateDate DATE; -- khởi tạo biến chứa ngày này 1 năm trước
        SELECT DATE_SUB(CURDATE(), INTERVAL 1 YEAR) INTO targetCreateDate;
		IF NEW.create_date < targetCreateDate THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'ngày tạo không hợp lệ';
        END IF;
	END $$
DELIMITER ;
INSERT INTO `group`(group_name, creator_id, create_date) 
VALUES 
	('Nhóm test'	, 1	, '2021-10-18');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS trigger_check_add_sale;
DELIMITER $$
CREATE TRIGGER trigger_check_add_sale
	BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		DECLARE idSale TINYINT;
        SELECT department_id INTO idSale
        FROM department
        WHERE department_name = 'Sale';
        IF NEW.department_id = idSale THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
    END $$
DELIMITER ;
INSERT INTO `account`(email, username, fullname, gender, department_id, position_id, create_date) 
VALUES 
	('nguyenhuyhoang@gmail.com', 'NguyenHoang', 'Nguyễn Huy Hoàng', 'M', 2, 2, '2010-10-18');
    
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS trigger_check_group_max_account;
DELIMITER $$
CREATE TRIGGER trigger_check_group_max_account
	BEFORE INSERT ON group_account
    FOR EACH ROW
    BEGIN
		DECLARE cntAccount TINYINT;
		SELECT COUNT(account_id) INTO cntAccount 
        FROM group_account 
        WHERE group_id = NEW.group_id GROUP BY group_id;
        IF cntAccount >= 5 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'group không được quá 5 thành viên';
        END IF;
    END $$
DELIMITER ;
INSERT INTO group_account(group_id, account_id, join_date) 
VALUES 
	(1, 32, '2021-10-18');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS trigger_check_exam_max_question;
DELIMITER $$
CREATE TRIGGER trigger_check_exam_max_question
	BEFORE INSERT ON exam_question
    FOR EACH ROW
    BEGIN
		DECLARE cntQuestion TINYINT;
		SELECT count(question_id) INTO cntQuestion 
        FROM exam_question 
        WHERE exam_id = NEW.exam_id GROUP BY exam_id;
        IF cntQuestion >= 10 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'bài thi không được quá 10 câu hỏi';
        END IF;
    END $$
DELIMITER ;
INSERT INTO exam_question(exam_id, question_id) 
VALUES 
	(2	, 14);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
-- tạo admin
INSERT INTO `account`(email, username, fullname, gender, department_id, position_id, create_date) 
VALUES 
	('admin@gmail.com', 'NguyenHoangAnh', 'Nguyễn Hoàng Anh', 'F', 3, 2, '2021-10-18');
DROP TRIGGER IF EXISTS trigger_check_admin
DELIMITER $$
CREATE TRIGGER trigger_check_admin
	BEFORE DELETE ON `account`
	FOR EACH ROW
	BEGIN
		IF OLD.email = 'admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'đây là tài khoản admin, không cho phép user xóa';
		END IF;
	END $$
DELIMITER ;
DELETE FROM `account` WHERE email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
INSERT INTO department(department_name) 
VALUES 
	('waiting Department');
DROP TRIGGER IF EXISTS trigger_check_department;
DELIMITER $$
CREATE TRIGGER trigger_check_department
	BEFORE INSERT ON `account`
	FOR EACH ROW
	BEGIN
		DECLARE departmentId TINYINT;
        SELECT department_id INTO departmentId
        FROM department 
        WHERE department_name = 'waiting Department';
		IF NEW.department_id is null THEN
			set NEW.department_id = departmentId;
        END IF;
	END $$
DELIMITER ;
INSERT INTO `account`(email, username, fullname, gender, department_id, position_id, create_date) 
VALUES 
	('phuonganh@gmail.com', 'phamphuonganh', 'Phạm Phương Anh', 'F', null, 2, '2021-10-18');

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
-- đáp án đúng: 1
-- đáp án sai: 0
DROP TRIGGER IF EXISTS trigger_check_answer;
DELIMITER $$
CREATE TRIGGER trigger_check_answer
	BEFORE INSERT ON answer
	FOR EACH ROW
	BEGIN
		DECLARE cntAnswer TINYINT;	-- biến chứa số đáp án của question nhập vào
        DECLARE cntTrueCorrect TINYINT;	-- biến chứa số đáp án đúng của question nhập vào
        -- lấy số đáp án của question nhập vào
		SELECT count(answer_id) INTO cntAnswer
		FROM answer
		WHERE question_id = NEW.question_id; -- question nhập vào
        
		-- lấy số đáp án đúng của question nhập vào
		SELECT count(is_correct) INTO cntTrueCorrect
		FROM answer
		WHERE question_id = NEW.question_id -- question nhập vào
		AND is_correct = 1;
        
        -- nếu question_id nhập vào đã có 4 câu trả lời hoặc question_id đó đã có 2 đáp án đúng thì show lỗi
        IF cntAnswer >= 4 OR (cntTrueCorrect >= 2 AND NEW.is_correct = 1) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'câu hỏi không được quá 4 answers và 2 đáp án đúng';
        END IF;       
	END $$
DELIMITER ;
SELECT * from answer;
INSERT INTO answer(content, question_id, is_correct) 
VALUES 
	('content answer test 1'	, 3		, 0);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS trigger_check_gender;
DELIMITER $$
CREATE TRIGGER trigger_check_gender
	BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		IF NEW.gender = 'nam' then
			SET NEW.gender = 'M';
		END IF;
		IF NEW.gender = 'nữ' then
			SET NEW.gender = 'F';
		END IF;
		IF NEW.gender = 'chưa xác định' then
			SET NEW.gender = 'U';
        END IF;
    END $$
DELIMITER ;
INSERT INTO `account`(email, username, fullname, gender, department_id, position_id, create_date) 
VALUES 
	('hongphuc1@gmail.com', 'phamphongphuc1', 'Phạm Hồng Phúc', 'nam', 3, 2, '2021-10-18');
select * from `account`;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
-- Nghĩa là ngày 1 ngày 2 không xóa được
DROP TRIGGER IF EXISTS trigger_check_delete_exam;
DELIMITER $$
CREATE TRIGGER trigger_check_delete_exam
	BEFORE DELETE ON exam
	FOR EACH ROW
	BEGIN
		DECLARE beforeTwoDay DATE; -- biến chứa 2 ngày trước
        SELECT DATE_SUB(CURDATE(), INTERVAL 2 DAY) INTO beforeTwoDay;
        IF OLD.create_date > beforeTwoDay THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'không được phép xóa bài thi mới tạo được 2 ngày';
        END IF;        
	END $$
DELIMITER ;
select * from exam;
DELETE FROM exam WHERE exam_id = 18;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
-- check update
DROP TRIGGER IF EXISTS trigger_check_update_question
DELIMITER $$
CREATE TRIGGER trigger_check_update_question
	BEFORE UPDATE ON question
    FOR EACH ROW
	BEGIN
		IF OLD.question_id NOT IN (
			SELECT q.question_id
			FROM question q
			LEFT JOIN exam_question e ON q.question_id = e.question_id
			WHERE e.exam_id IS NULL) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'không được phép sửa câu hỏi đã được sử dụng trong bài thi';
		END IF;
	END $$
DELIMITER ;

UPDATE question 
	SET content = 'test'
WHERE question_id = '10'

-- check delete
DROP TRIGGER IF EXISTS trigger_check_delete_question
DELIMITER $$
CREATE TRIGGER trigger_check_delete_question
	BEFORE DELETE ON question
    FOR EACH ROW
	BEGIN
		IF OLD.question_id NOT IN (
			SELECT q.question_id
			FROM question q
			LEFT JOIN exam_question e ON q.question_id = e.question_id
			WHERE e.exam_id IS NULL) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'không được phép xóa câu hỏi đã được sử dụng trong bài thi';
		END IF;
	END $$
DELIMITER ;

DELETE FROM question WHERE question_id = '13';

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT * FROM exam;
SELECT exam_id
		, `code`
        , title
        , category_id
        , CASE WHEN duration <= 30 THEN 'Short time' 
			WHEN 30 < duration AND duration <= 60 THEN 'Medium time'
			WHEN duration > 60 THEN 'Long time'
		END duration
		, creator_id
        , create_date
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
		-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
		-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
		-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT g.group_id
	, COUNT(ga.account_id) cnt_acc
	, CASE WHEN COUNT(ga.account_id) <= 5 THEN 'few' 
		WHEN 5 < COUNT(ga.account_id) AND COUNT(ga.account_id) <= 20 THEN 'normal' 
        WHEN COUNT(ga.account_id) > 20 THEN 'higher' 
	END the_number_user_amount
    , IF(5 < COUNT(ga.account_id) AND COUNT(ga.account_id) <= 20, 0, 1)
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
use testing_system;
SELECT d.department_name
	, CASE WHEN COUNT(a.account_id) = 0 THEN 'Không có User' 
		ELSE  COUNT(a.account_id)
	END 'số user của phòng ban'
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id;

SELECT d.department_name
	, IF((COUNT(a.account_id) = 0), 'Không có User', COUNT(a.account_id)) 'số user của phòng ban'
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id