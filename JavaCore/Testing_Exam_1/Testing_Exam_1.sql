-- tạo cơ sở dữ liệu 'testing_exam_java'
DROP DATABASE IF EXISTS testing_exam_java;
CREATE DATABASE testing_exam_java;
-- sử dụng database testing_exam_java
USE testing_exam_java;
-- Tạo bảng
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id	 		INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fullname 	VARCHAR(30) CHAR SET utf8mb4 NOT NULL,
    email 		VARCHAR(50) NOT NULL,
    `password`	VARCHAR(20) NOT NULL,
    exp_in_year TINYINT,
    pro_skill 	VARCHAR(50) CHAR SET utf8mb4,
    user_type 	TINYINT NOT NULL
);

-- Thêm data vào bảng
INSERT INTO `user`(fullname, email, `password`, exp_in_year, pro_skill, user_type) 
VALUES 
	('Nguyễn Văn A', 'nguyenvana@gmail.com', 'Anguyen', 1, null, 1),
	('Nguyễn Văn B', 'nguyenvanb@gmail.com', 'Bnguyen', null, 'Java', 2),
	('Nguyễn Văn C', 'nguyenvanc@gmail.com', 'Cnguyen', 1, null, 1),
	('Nguyễn Văn D', 'nguyenvand@gmail.com', 'Dnguyen', null, 'SQL', 2),
	('Nguyễn Văn E', 'nguyenvane@gmail.com', 'Enguyen', null, 'test', 2);
    
SELECT * FROM `user`;