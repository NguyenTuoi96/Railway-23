USE fresher_training_management; -- sử dụng database
-- Exercise 1:
-- Cho table sau:
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
-- Question 2: Thêm ít nhất 10 bản ghi vào table
-- Department (Department_Number, Department_Name)
DROP TABLE IF EXISTS department; 
CREATE TABLE department (
	department_number 	TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    department_name 	VARCHAR(30) CHAR SET utf8mb4 NOT NULL
);
-- Thêm bản ghi
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
    ('Bảo vệ');

-- Employee_Table (Employee_Number, Employee_Name, Department_Number)
DROP TABLE IF EXISTS employee; 
CREATE TABLE employee (
	employee_number 	INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    employee_name  		VARCHAR(50) CHAR SET utf8mb4 NOT NULL, 
    department_number  	TINYINT NOT NULL, 
    FOREIGN KEY (department_number) REFERENCES department(department_number) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm bản ghi
INSERT INTO employee(employee_name, department_number) 
VALUES 
	('Nguyễn Ngọc Anh', 	'1'),
	('Nguyễn Thanh Anh', 	'7'),
    ('Phạm Thanh Thảo', 	'3'),
    ('Hoàng Văn Nhã', 		'3'),
    ('Phạm Thị Nhung', 		'4'),
    ('Nguyễn Ngọc Mai', 	'5'),
    ('Nguyễn Duy Đông', 	'8'),
    ('Trần Hoài Phương', 	'2'),
    ('Nguyễn Phương Ly', 	'9'),
    ('Lê Thu Hiền', 		'2'),
    ('Lê Thu Trang', 		'3'),
    ('Hồ Thị Nguyệt', 		'2'),
    ('Võ Anh Tuấn', 		'2'),
    ('Vũ Thị Thu', 			'4');

-- Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered)
DROP TABLE IF EXISTS employee_skill; 
CREATE TABLE employee_skill (
	employee_number 	INT NOT NULL,
    skill_code  		VARCHAR(30) NOT NULL, 
    date_registered  	DATE, 
    PRIMARY KEY (employee_number, skill_code),
    FOREIGN KEY (employee_number) REFERENCES employee(employee_number) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Thêm bản ghi
INSERT INTO employee_skill(employee_number, skill_code, date_registered) 
VALUES 
	(1, 'Java', 		'2020-11-01'),
    (1, 'C#', 			'2019-03-05'),
    (2, 'JavaScrip', 	'2020-09-06'),
    (3, 'Java', 		'2019-11-09'),
    (4, 'SQL', 			'2020-05-04'),
    (5, 'C#', 			'2020-10-12'),
    (6, 'Python', 		'2020-09-15'),
    (7, 'Ruby', 		'2020-12-19'),
    (8, 'Java', 		'2020-06-25'),
    (9, 'Html', 		'2020-08-01'),
    (10, 'Css', 		'2020-10-17'),
    (11, 'Java', 		'2020-06-21'),
    (12, 'C#', 			'2020-04-05'),
    (13, 'Java', 		'2020-01-02');    

-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT e.employee_name 'nhân viên có skill Java'
FROM employee e 
JOIN employee_skill es ON e.employee_number = es.employee_number
WHERE es.skill_code = 'Java';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT d.*, COUNT(e.department_number) 'số nhân viên'
FROM employee e 
JOIN department d ON e.department_number = d.department_number
GROUP BY e.department_number 
HAVING COUNT(e.department_number) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
SELECT d.department_name, GROUP_CONCAT(e.employee_name)
FROM department d
LEFT JOIN employee e ON d.department_number = e.department_number
GROUP BY d.department_number;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
SELECT e.*, COUNT(es.employee_number) 'số lượng skill của nhân viên'
FROM employee e 
JOIN employee_skill es ON e.employee_number = es.employee_number
GROUP BY e.employee_number
HAVING COUNT(es.employee_number) > 1








