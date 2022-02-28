-- create database
DROP DATABASE IF EXISTS java_advanced_midterm_testing_exam_nguyen_thi_tuoi;
CREATE DATABASE java_advanced_midterm_testing_exam_nguyen_thi_tuoi;
USE java_advanced_midterm_testing_exam_nguyen_thi_tuoi;
                        
-- create table: user
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	user_id				INT AUTO_INCREMENT PRIMARY KEY,
    full_name		VARCHAR(100) CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    email			VARCHAR(50) NOT NULL UNIQUE KEY, 
    phone			VARCHAR(15) NOT NULL UNIQUE KEY,
    `password`		VARCHAR(30) NOT NULL
);

INSERT INTO `user`(  full_name	 		, email					, phone			, `password`)
VALUES 				('nguyen van an' 	,'nguyenvana@gmail.com' , '08039062410', 'nguyenA' ),
					('nguyen van b' 	,'nguyenvanb@gmail.com' , '08039062411', 'nguyenB' ),
                    ('nguyen van c' 	,'nguyenvanc@gmail.com' , '08039062412', 'nguyenC' ),
                    ('nguyen van d' 	,'nguyenvand@gmail.com' , '08039062413', 'nguyenD' ),
                    ('nguyen van e' 	,'nguyenvane@gmail.com' , '08039062414', 'nguyenE' ),
                    ('nguyen van f' 	,'nguyenvanf@gmail.com' , '08039062415', 'nguyenF' ),
                    ('nguyen van g' 	,'nguyenvang@gmail.com' , '08039062416', 'nguyenG' ),
                    ('nguyen van h' 	,'nguyenvanh@gmail.com' , '08039062417', 'nguyenH' ),
                    ('nguyen van i' 	,'nguyenvani@gmail.com' , '08039062418', 'nguyenI' ),
                    ('nguyen van j' 	,'nguyenvanj@gmail.com' , '08039062419', 'nguyenJ' );

-- create table: device
DROP TABLE IF EXISTS device;
CREATE TABLE device(
	device_id 				INT AUTO_INCREMENT PRIMARY KEY,
    device_name 	VARCHAR(50) CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE KEY,
    quantity 		INT
);

INSERT INTO device(device_name, quantity) 
VALUES
						('iphone 13', 5	),
						('ipad', 4	),
						('chuột', 10		),
						('Bàn phím', 10	),
						('Màn hình', 5	);
                    
-- create table: user_device
DROP TABLE IF EXISTS user_device;
CREATE TABLE user_device(
	user_id					INT NOT NULL,
    device_id				INT NOT NULL,
    borrow_date				DATETIME DEFAULT NOW(),
    repaid_date				DATETIME,
    PRIMARY KEY (user_id,device_id),
    FOREIGN KEY(user_id) REFERENCES `user` (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(device_id) REFERENCES device (device_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO user_device(user_id, device_id, borrow_date, repaid_date) 
VALUES
						(1 , 1, '2022-01-01', null),
						(1 , 2, '2022-02-01', null),
						(1 , 4, '2022-02-01', null),
						(2 , 3, '2022-01-01', null),
						(2 , 2, '2022-02-01', null),
						(3 , 1, '2022-01-01', '2022-02-01'),
						(3 , 2, '2022-02-01', null),
						(5 , 5, '2022-02-01', null);