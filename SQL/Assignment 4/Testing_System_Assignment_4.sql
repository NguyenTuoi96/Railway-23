-- Tiếp tục với Database Testing System
USE testing_system;
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT * FROM `account`;
SELECT * FROM department;

SELECT ac.fullname, dp.* 
FROM `account` ac 
JOIN department dp ON ac.department_id = dp.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM `account`;

SELECT * 
FROM `account` 
WHERE create_date > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT * FROM `account`;
SELECT * FROM `position`;

SELECT ac.fullname
FROM `account` ac 
JOIN `position` po ON ac.position_id = po.position_id 
WHERE po.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT * FROM `account`;
SELECT * FROM department;

SELECT dp.department_name
FROM department dp
JOIN `account` ac ON dp.department_id = ac.department_id 
GROUP BY dp.department_id 
HAVING COUNT(ac.account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT * FROM question;
SELECT * FROM exam_question;

SELECT q.content -- q.*, cnt_exam 'số đề sử dụng câu hỏi' 
FROM question q 
JOIN  
	(SELECT qid, cnt_exam FROM (
		SELECT COUNT(eq.exam_id) cnt_exam, eq.question_id qid 
		FROM exam_question eq 
		GROUP BY eq.question_id) tmp -- lấy bảng có question_id và số đề sử dụng nó, tạm đặt là tmp
	WHERE tmp.cnt_exam = (SELECT MAX(tmp1.cnt_exam) 
						FROM (SELECT COUNT(eq.exam_id) cnt_exam, eq.question_id qid 
						FROM exam_question eq 
						GROUP BY eq.question_id) tmp1)) tmp2 -- tmp1 cũng giống như tmp, từ tmp1 lấy giá trị lớn nhất của cột số đề sử dụng nó để so sánh lấy ra question_id có số đề sử dụng nó nhiều nhất từ tmp --> tmp2;
ON q.question_id  = tmp2.qid;

-- cách 2
SELECT * FROM question;
SELECT * FROM exam_question;

SELECT q.content -- q.*, COUNT(eq.exam_id) 'số bài thi'
FROM question q
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id
HAVING COUNT(eq.exam_id) = (
	SELECT MAX(t1.exam_count)
	FROM (
		SELECT COUNT(eq.exam_id) as exam_count
		FROM exam_question eq
		GROUP BY eq.question_id) t1);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT * FROM category_question;
SELECT * FROM question;

SELECT cq.category_name, COUNT(q.question_id) AS 'số lượng question'
FROM category_question cq
LEFT JOIN question q ON cq.category_id = q.category_id 
GROUP BY cq.category_id;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT * FROM question;
SELECT * FROM exam_question;

SELECT q.content, COUNT(eq.exam_id) 'số lượng exam'
FROM question q 
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT * FROM question;
SELECT * FROM answer;

SELECT q.content -- , tmp2.cnt_answer 'số câu trả lời'
FROM question q 
JOIN (SELECT qid, cnt_answer FROM (
		SELECT COUNT(an.question_id) cnt_answer, an.question_id qid 
		FROM answer an 
		GROUP BY an.question_id) tmp -- lấy bảng có question_id và số câu trả lời của nó, tạm đặt là tmp
	 WHERE tmp.cnt_answer = (SELECT MAX(tmp1.cnt_answer) 
						FROM (SELECT COUNT(an.question_id) cnt_answer, an.question_id qid 
						FROM answer an 
						GROUP BY an.question_id) tmp1)) tmp2 -- tmp1 cũng giống như tmp, từ tmp1 lấy giá trị lớn nhất của cột số câu trả lời để so sánh lấy ra question_id có số câu trả lời nhiều nhất từ tmp --> tmp2
ON q.question_id = tmp2.qid;

-- cách 2 (chuẩn)
SELECT * FROM question;
SELECT * FROM answer;

SELECT q.content -- , COUNT(a.answer_id)
FROM question q 
JOIN answer a ON a.question_id = q.question_id
GROUP BY q.question_id
HAVING COUNT(a.answer_id) = (
SELECT MAX(tmp.ans_cnt) FROM
	(SELECT COUNT(answer_id) ans_cnt
    FROM answer 
    GROUP BY question_id) tmp
);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT * FROM `group`;
SELECT * FROM group_account;

SELECT gr.group_name, COUNT(ga.account_id) 'số lượng account' 
FROM `group` gr
LEFT JOIN group_account ga ON gr.group_id = ga.group_id
GROUP BY gr.group_id;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT * FROM `position`;
SELECT * FROM `account`;

SELECT tmp.position_name -- , tmp.cnt_acc 'số người' 
FROM 
	(SELECT p.*, COUNT(ac.position_id) cnt_acc
	FROM `position` p 
	LEFT JOIN `account` ac 
	ON p.position_id = ac.position_id GROUP BY p.position_id) tmp
WHERE tmp.cnt_acc = (
	SELECT MIN(cnt_acc) 
	FROM (SELECT COUNT(ac.position_id) cnt_acc
		FROM `position` p 
        LEFT JOIN `account` ac ON p.position_id = ac.position_id
		GROUP BY ac.position_id) tmp1);
        
-- cách 2
SELECT * FROM `position`;
SELECT * FROM `account`;

SELECT p.position_name -- , COUNT(a.account_id)
FROM `position` p
LEFT JOIN `account` a ON p.position_id = a.position_id 
GROUP BY p.position_id 
HAVING COUNT(a.account_id) = (
	SELECT MIN(tmp.cnt_acc) 
	FROM 
		(SELECT COUNT(ac.account_id) cnt_acc
		FROM `position` p 
		LEFT JOIN `account` ac ON p.position_id = ac.position_id
		GROUP BY p.position_id) tmp
);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT * FROM department;
SELECT * FROM `account`;
SELECT * FROM `position`;

SELECT tmp.department_name, GROUP_CONCAT(tmp.cnt_position) 'số nhân viên'
FROM (
	SELECT dp.department_id,dp.department_name, CONCAT(COUNT(ac.position_id), ' ',p.position_name) cnt_position
	FROM department dp 
	LEFT JOIN `account` ac ON dp.department_id = ac.department_id
	LEFT JOIN `position` p ON ac.position_id = p.position_id
	GROUP BY dp.department_id, p.position_id) tmp 
GROUP BY tmp.department_id;

-- cách 2 (chuẩn)
SELECT * FROM department;
SELECT * FROM `account`;
SELECT * FROM `position`;

SELECT d.department_name, p.position_name, COUNT(a.account_id) 'số nhân viên'
FROM department d 
LEFT JOIN `account` a ON d.department_id = a.department_id
LEFT JOIN `position` p ON a.position_id = p.position_id
GROUP BY d.department_id, p.position_id;


-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT * FROM question;
SELECT * FROM type_question;
SELECT * FROM category_question;
SELECT * FROM `account`;
SELECT * FROM answer;
SELECT * FROM exam_question;
SELECT * FROM exam;

SELECT q.question_id
		, q.content
        , q.create_date
        , caq.category_name 'chủ đề câu hỏi'
        , acc.fullname 'người tạo ra câu hỏi'
        , an.content 'câu trả lời'
        , e.`code` 'mã đề thi sử dụng câu hỏi'
FROM question q 
LEFT JOIN type_question tq ON q.type_id = tq.type_id 
LEFT JOIN category_question caq ON q.category_id = caq.category_id
LEFT JOIN `account` acc ON q.creator_id = acc.account_id
LEFT JOIN answer an ON q.question_id = an.question_id
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
LEFT JOIN exam e ON eq.exam_id = e.exam_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT * FROM type_question;
SELECT * FROM question;

SELECT tq.type_name, COUNT(q.question_id) 'số lượng câu hỏi' 
FROM type_question tq 
LEFT JOIN question q ON tq.type_id = q.type_id 
GROUP BY q.type_id;

-- Question 14:Lấy ra group không có account nào
-- Question 15: Lấy ra group không có account nào
SELECT * FROM `group`;
SELECT * FROM group_account;

SELECT gr.group_name 'group không có account' 
FROM `group` gr 
LEFT JOIN group_account gracc ON gr.group_id = gracc.group_id 
WHERE gracc.group_id IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT * FROM question;
SELECT * FROM answer;

SELECT q.* 
FROM question q 
LEFT JOIN answer an ON q.question_id = an.question_id 
WHERE an.question_id IS NULL;

-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT * FROM group_account;
SELECT * FROM `account`;

SELECT acc.fullname, gracc.group_id
FROM group_account gracc 
JOIN `account` acc ON gracc.account_id = acc.account_id
WHERE gracc.group_id = 1;

-- b) Lấy các account thuộc nhóm thứ 2
SELECT * FROM group_account;
SELECT * FROM `account`;

SELECT acc.fullname, gracc.group_id 
FROM group_account gracc 
JOIN `account` acc ON gracc.account_id = acc.account_id
WHERE gracc.group_id = 2;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT * FROM group_account;
SELECT * FROM `account`;

SELECT acc.fullname, gracc.group_id 
FROM group_account gracc 
JOIN `account` acc ON gracc.account_id = acc.account_id
WHERE gracc.group_id = 1
UNION
SELECT acc.fullname, gracc.group_id 
FROM group_account gracc 
JOIN `account` acc ON gracc.account_id = acc.account_id
WHERE gracc.group_id = 2;

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT * FROM `group`;
SELECT * FROM group_account;

SELECT gr.group_id, gr.group_name, COUNT(gracc.account_id)
FROM `group` gr 
JOIN group_account gracc ON gr.group_id = gracc.group_id
GROUP BY gr.group_id
HAVING COUNT(gracc.account_id) > 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT * FROM `group`;
SELECT * FROM group_account;

SELECT gr.group_id, gr.group_name, COUNT(gracc.account_id)
FROM `group` gr 
LEFT JOIN group_account gracc ON gr.group_id = gracc.group_id
GROUP BY gr.group_id
HAVING COUNT(gracc.account_id) < 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT * FROM `group`;
SELECT * FROM group_account;

SELECT gr.group_id, gr.group_name, COUNT(gracc.account_id)
FROM `group` gr 
JOIN group_account gracc ON gr.group_id = gracc.group_id
GROUP BY gr.group_id
HAVING COUNT(gracc.account_id) > 5
UNION ALL
SELECT gr.group_id, gr.group_name, COUNT(gracc.account_id)
FROM `group` gr 
LEFT JOIN group_account gracc ON gr.group_id = gracc.group_id
GROUP BY gr.group_id
HAVING COUNT(gracc.account_id) < 7
