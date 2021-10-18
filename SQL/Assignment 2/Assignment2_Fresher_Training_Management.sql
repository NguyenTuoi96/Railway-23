DROP DATABASE IF EXISTS fresher_training_management; -- nếu tồn tại database tên là testing_system thì xóa đi
CREATE DATABASE fresher_training_management; -- khởi tạo database
USE fresher_training_management; -- sử dụng database

ALTER DATABASE fresher_training_management CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; -- sửa DB khi không sử dụng được NVARCHAR

-- nếu đã tồn tại table trainee thì xóa
DROP TABLE IF EXISTS trainee; 
-- tạo table trainee
CREATE TABLE trainee (
	trainee_id 			INT AUTO_INCREMENT PRIMARY KEY,
    full_name 			VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    birth_date 			DATE NOT NULL,
    gender 				ENUM('male', 'female', 'unknown'),
    et_iq 				TINYINT CHECK(0 <= et_iq AND et_iq <= 20) NOT NULL,
    et_gmath 			TINYINT CHECK(0 <= et_gmath AND et_gmath <= 20) NOT NULL,
    et_english 			TINYINT CHECK(0 <= et_english AND et_english <= 50) NOT NULL,
    training_class 		CHAR(20) CHAR SET utf8mb4 NOT NULL,
    evaluation_notes 	TEXT CHAR SET utf8mb4 
);
-- Thêm vào table trainee trường vti_account với ràng buộc not-null và unique
ALTER TABLE trainee ADD vti_account VARCHAR(50) NOT NULL UNIQUE;