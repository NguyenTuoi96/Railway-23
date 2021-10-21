USE fresher_training_management; -- sử dụng database
-- Exercise 1: Tiếp tục với Database quản lý Fresher
-- Question 1: Thêm ít nhất 10 bản ghi vào table
INSERT INTO trainee(full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evaluation_notes, vti_account)
VALUES 
	('Nguyễn Thanh Anh'		, '1996-11-01', 'female'	, 15	, 18	, 45, 'A1', 'đánh giá 1', 'thanhanhVTIacc'),
    ('Nguyễn Phương Thảo'	, '1996-09-10', 'female'	, 14	, 19	, 40, 'A2', 'đánh giá 2', 'phuongthaoVTIacc'),
    ('Phạm Anh Dương'		, '1996-08-05', 'unknown'	, 6		, 10	, 35, 'A4', 'đánh giá 3', 'anhduongVTIacc'),
    ('Đào Thị Hà'			, '1996-12-01', 'female'	, 10	, 11	, 18, 'A2', 'đánh giá 4', 'hadaoVTIacc'),
    ('Hồ Thu Nguyệt'		, '1996-10-11', 'female'	, 12	, 12	, 33, 'A2', 'đánh giá 5', 'thunguyetVTIacc'),
    ('Hàn Trung Tú'			, '1996-07-16', 'male'		, 15	, 7		, 24, 'A3', 'đánh giá 6', 'trungtuVTIacc'),
    ('Trần Hoài Phương'		, '1996-01-29', 'female'	, 9		, 11	, 18, 'A2', 'đánh giá 7', 'hoaiphuongVTIacc'),
    ('Đoàn Tuấn Anh'		, '1996-02-21', 'male'		, 5		, 19	, 28, 'A3', 'đánh giá 8', 'tuananhVTIacc'),
    ('Võ Minh Huy'			, '1996-06-09', 'male'		, 11	, 18	, 44, 'A2', 'đánh giá 9', 'minhhuyVTIacc'),
    ('Tạ Ngọc Hà'			, '1996-11-04', 'female'	, 8		, 16	, 17, 'A1', 'đánh giá 10', 'ngochaVTIacc'),
    ('Hoàng Văn Nhã'		, '1996-08-23', 'male'		, 17	, 15	, 46, 'A1', 'đánh giá 11', 'anhnhaVTIacc'),
    ('Nguyễn Duy Đông'		, '1996-12-25', 'male'		, 16	, 19	, 48, 'A1', 'đánh giá 12', 'duydongVTIacc');

-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau 
-- SELECT trainee_id, birth_date, DATE_FORMAT(birth_date, '%m') FROM trainee; 
SELECT GROUP_CONCAT(full_name) AS group_trainee
FROM trainee 
GROUP BY month(birth_date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT full_name, birth_date, gender, training_class, vti_account 
FROM trainee
WHERE LENGTH(full_name) = 
	(SELECT MAX(LENGTH(full_name))
     FROM trainee);

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào với các tiêu chí sau đây:
--  ET_IQ + ET_Gmath>=20
--  ET_IQ>=8
--  ET_Gmath>=8
--  ET_English>=18
SELECT * 
FROM trainee 
WHERE (et_iq + et_gmath) >= 20
  AND et_iq >= 8
  AND et_gmath >= 8
  AND et_english >= 18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE FROM trainee
WHERE trainee_id = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE trainee 
SET training_class = '2'
WHERE trainee_id = '5';





