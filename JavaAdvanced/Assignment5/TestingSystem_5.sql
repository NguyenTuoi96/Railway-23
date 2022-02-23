-- create database
DROP DATABASE IF EXISTS testing_system_5;
CREATE DATABASE testing_system_5;
USE testing_system_5;

-- create table: Department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
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
						(N'Nhân viên bán hàng'	);