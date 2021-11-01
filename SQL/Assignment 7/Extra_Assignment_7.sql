-- Exercise 1: Tiếp tục với Database ở buổi 6
use project_managers;
-- Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
-- Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)
DROP TRIGGER IF EXISTS trigger_check_module_project;
DELIMITER $$
CREATE TRIGGER trigger_check_module_project
	BEFORE INSERT ON project_modules
    FOR EACH ROW
    BEGIN
		DECLARE projectStartDate DATE;
		DECLARE projectCompletedOne DATE;
		SELECT p.project_start_date, p.project_completed_one INTO projectStartDate, projectCompletedOne
        FROM project p
        WHERE p.project_id = NEW.project_id;
        IF NEW.project_modules_date < projectStartDate OR NEW.project_modules_compled_on > projectCompletedOne THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'thông tin không hợp lệ';
        END IF;
    END $$
DELIMITER ;
INSERT INTO project_modules (project_id, employee_id, project_modules_date, project_modules_compled_on, project_modules_description)
VALUES
	(5, 2, '2022-01-05', '2023-01-06', 'project modules description 1');

-- Exercise 2: View
-- Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là
-- ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số
-- điểm như sau:
--  ET_IQ + ET_Gmath>=20
--  ET_IQ>=8
--  ET_Gmath>=8
--  ET_English>=18
USE fresher_training_management;
DROP VIEW IF EXISTS v_thuc_tap_sinh_thoa_man;
CREATE VIEW v_thuc_tap_sinh_thoa_man AS 
	SELECT * 
	FROM trainee 
	WHERE (et_iq + et_gmath) >= 20
	  AND et_iq >= 8
	  AND et_gmath >= 8
	  AND et_english >= 18;