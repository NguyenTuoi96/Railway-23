-- Exercise 1: Tiếp tục với Database Testing System
USE testing_system;
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
-- Sử dụng subquery
DROP VIEW IF EXISTS v_sale_account;
CREATE VIEW v_sale_account AS
	SELECT a.fullname 
    FROM `account` a
    WHERE a.department_id = (
		SELECT department_id
        FROM department
        WHERE department_name = 'Sale'
    );
-- xem lại view vừa tạo
SELECT * FROM v_sale_account;

-- sử dụng CTE
DROP VIEW IF EXISTS v_sale_account_CTE;
CREATE VIEW v_sale_account_CTE AS
	WITH 
		id_sale AS (
			SELECT d.department_id 
            FROM department d
            WHERE d.department_name = 'Sale')            
	SELECT a.fullname 
    FROM `account` a
    WHERE a.department_id = (SELECT department_id FROM id_sale);
-- xem lại view vừa tạo
SELECT * FROM v_sale_account_CTE;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
-- sử dụng subquery
DROP VIEW IF EXISTS v_accounts_join_most_groups;
CREATE VIEW v_accounts_join_most_groups AS
	SELECT a.*
    FROM `account` a
    JOIN group_account ga ON a.account_id = ga.account_id
    GROUP BY a.account_id
    HAVING count(ga.group_id) = (
		SELECT MAX(tmp.cnt_gr) 
        FROM (SELECT count(ga.group_id) cnt_gr
			FROM group_account ga
			GROUP BY ga.account_id) tmp);
-- xem lại view vừa tạo
SELECT * FROM v_accounts_join_most_groups;

-- sử dụng CTE
DROP VIEW IF EXISTS v_accounts_join_most_groups_CTE;
CREATE VIEW v_accounts_join_most_groups_CTE AS
	WITH 
		account_and_count_group AS(
			SELECT a.*, count(ga.group_id) cnt_gr
			FROM `account` a
			JOIN group_account ga ON a.account_id = ga.account_id
			GROUP BY a.account_id)
		SELECT a.account_id
			, a.email
            , a.username
            , a.fullname
            , a.department_id
            , a.position_id
            , a.create_date
        FROM account_and_count_group a
        WHERE a.cnt_gr = (
			SELECT MAX(cnt_gr) 
            FROM account_and_count_group
        );
-- xem lại view vừa tạo
SELECT * FROM v_accounts_join_most_groups_CTE;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
-- tạo data
INSERT INTO question (content, category_id, type_id, creator_id, create_date)
VALUES
		('Có 1 người đứng ở chân cầu. Ở giữa cầu có một con gấu rất hung dữ không cho ai qua cầu hết. Người đó sẽ mất hết 5 phút để đi từ chân cầu cho đến giữa cầu và con gấu cũng chỉ ngủ có 5 phút là tỉnh dậy. 
        Hỏi người đó làm sao để qua được bên kia?Có 1 người đứng ở chân cầu. Ở giữa cầu có một con gấu rất hung dữ không cho ai qua cầu hết. 
        Người đó sẽ mất hết 5 phút để đi từ chân cầu cho đến giữa cầu và con gấu cũng chỉ ngủ có 5 phút là tỉnh dậy. Hỏi người đó làm sao để qua được bên kia?
        Có 1 người đứng ở chân cầu. Ở giữa cầu có một con gấu rất hung dữ không cho ai qua cầu hết. Người đó sẽ mất hết 5 phút để đi từ chân cầu cho đến giữa cầu và con gấu cũng chỉ ngủ có 5 phút là tỉnh dậy. 
        Hỏi người đó làm sao để qua được bên kia?Có 1 người đứng ở chân cầu. Ở giữa cầu có một con gấu rất hung dữ không cho ai qua cầu hết. 
        Người đó sẽ mất hết 5 phút để đi từ chân cầu cho đến giữa cầu và con gấu cũng chỉ ngủ có 5 phút là tỉnh dậy. Hỏi người đó làm sao để qua được bên kia?
        Có 1 người đứng ở chân cầu. Ở giữa cầu có một con gấu rất hung dữ không cho ai qua cầu hết. Người đó sẽ mất hết 5 phút để đi từ chân cầu cho đến giữa cầu và con gấu cũng chỉ ngủ có 5 phút là tỉnh dậy. 
        Hỏi người đó làm sao để qua được bên kia?Có 1 người đứng ở chân cầu. Ở giữa cầu có một con gấu rất hung dữ không cho ai qua cầu hết. 
        Người đó sẽ mất hết 5 phút để đi từ chân cầu cho đến giữa cầu và con gấu cũng chỉ ngủ có 5 phút là tỉnh dậy. Hỏi người đó làm sao để qua được bên kia?', 1, 2, 3, '2021-10-27');

DROP VIEW IF EXISTS v_question_long_than_300;
CREATE VIEW v_question_long_than_300 AS
	SELECT q.content 
    FROM question q
    WHERE LENGTH(q.content) - LENGTH(REPLACE(q.content, ' ', '')) + 1 > 300;
-- xem lại view vừa tạo
SELECT * FROM v_question_long_than_300;
-- xóa view
DELETE FROM v_question_long_than_300;

-- sử dụng CTE
DROP VIEW IF EXISTS v_question_long_than_300_CTE;
CREATE VIEW v_question_long_than_300_CTE AS
	WITH
		id_question_over_300 AS(
			SELECT q.question_id
			FROM question q 
            WHERE LENGTH(q.content) - LENGTH(REPLACE(q.content, ' ', '')) + 1 > 300) 
		SELECT content
        FROM question q 
        WHERE q.question_id IN (
			SELECT question_id
            FROM id_question_over_300
		);
-- xem lại view vừa tạo
SELECT * FROM v_question_long_than_300_CTE;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
-- sử dụng subquery
DROP VIEW IF EXISTS v_departments_most_account;
CREATE VIEW v_departments_most_account AS
	SELECT d.department_name
    FROM department d
    JOIN `account` a ON d.department_id = a.department_id
    GROUP BY d.department_id
    HAVING count(a.account_id) = (
		SELECT MAX(tmp.cnt_acc) 
        FROM (SELECT count(a.account_id) cnt_acc
			FROM `account` a
			GROUP BY a.department_id) tmp);
-- xem lại view vừa tạo
SELECT * FROM v_departments_most_account;

-- sử dụng CTE
DROP VIEW IF EXISTS v_departments_most_account_CTE;
CREATE VIEW v_departments_most_account_CTE AS(
	WITH
		so_nhanvien_tung_phong AS(
			SELECT d.*, COUNT(a.account_id) cnt_acc
            FROM department d
            JOIN `account` a ON d.department_id = a.department_id
            GROUP BY d.department_id
        )
	SELECT s.department_name
    FROM so_nhanvien_tung_phong s
    WHERE s.cnt_acc = (
		SELECT MAX(cnt_acc)
        FROM so_nhanvien_tung_phong
    )
);
-- xem lại view vừa tạo
SELECT * FROM v_departments_most_account_CTE;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS v_question_from_nguyen;
CREATE VIEW v_question_from_nguyen AS
	SELECT q.content
	FROM question q
	JOIN `account` a ON q.creator_id = a.account_id
    WHERE a.fullname IN (
		SELECT fullname
        FROM `account`
        WHERE fullname LIKE 'Nguyễn%'
    );
-- xem lại view vừa tạo
SELECT * FROM v_question_from_nguyen;

-- sử dụng CTE
DROP VIEW IF EXISTS v_question_from_nguyen_CTE;
CREATE VIEW v_question_from_nguyen_CTE AS(
	WITH 
		id_nguyen AS(
			SELECT a.account_id 
            FROM `account` a
            WHERE a.fullname LIKE 'Nguyễn%'
        )
	SELECT q.content 
    FROM question q
    WHERE q.creator_id IN (
		SELECT account_id
        FROM id_nguyen
    )
);
-- xem lại view vừa tạo
SELECT * FROM v_question_from_nguyen_CTE;












