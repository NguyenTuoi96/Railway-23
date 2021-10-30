-- Exercise 1: Tiếp tục với Database Testing System
use testing_system;
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
-- describe department;
drop procedure if exists sp_lay_account_theo_phong_ban;
DELIMITER $$
create procedure sp_lay_account_theo_phong_ban(in departmentName varchar(30) char set utf8mb4)
	begin
		select a.*
        from department d
        join `account` a on d.department_id = a.department_id
        where d.department_name = departmentName;
    end$$
DELIMITER ;
-- gọi thủ tục
call sp_lay_account_theo_phong_ban('Marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
drop procedure if exists sp_so_account_trong_moi_group;
DELIMITER $$
create procedure sp_so_account_trong_moi_group()
	begin
		select g.group_name, count(ga.account_id) as 'số account trong group'
        from `group` g
        left join group_account ga on g.group_id = ga.group_id
        group by g.group_id;
    end$$
DELIMITER ;
-- gọi thủ tục
call sp_so_account_trong_moi_group();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
drop procedure if exists sp_type_co_bao_nhieu_question_in_current_month;
DELIMITER $$
create procedure sp_type_co_bao_nhieu_question_in_current_month()
	begin
		select tp.type_name, count(q.question_id) 'số câu hỏi được tạo trong tháng'
		from type_question tp
		left join question q on tp.type_id = q.type_id
		where month(q.create_date) = month(curdate())
        and year(q.create_date) = year(curdate())
		group by tp.type_id;
    end$$
DELIMITER ;
-- gọi thủ tục
call sp_type_co_bao_nhieu_question_in_current_month();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
drop procedure if exists sp_lay_type_id_nhieu_cau_hoi_nhat;
DELIMITER $$
create procedure sp_lay_type_id_nhieu_cau_hoi_nhat(out type_id_most_question tinyint)
	begin
		select tp.type_id into type_id_most_question
		from type_question tp
		join question q on tp.type_id = q.type_id
		group by tp.type_id
		having count(q.question_id) = (
			select max(tmp.cnt_ques) from (
				select count(q.question_id) cnt_ques
				from question q
				group by q.type_id) tmp
		);
    end$$
DELIMITER ;
-- gọi thủ tục
set @id_type = '';
call sp_lay_type_id_nhieu_cau_hoi_nhat(@id_type);
select @id_type;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
drop procedure if exists sp_lay_ten_type_nhieu_cau_hoi_nhat;
DELIMITER $$
create procedure sp_lay_ten_type_nhieu_cau_hoi_nhat()
	begin
		declare tenLoaiCauHoi enum('Essay','Multiple-Choice');
		set @id_type = '';
		call sp_lay_type_id_nhieu_cau_hoi_nhat(@id_type);
        select type_name into tenLoaiCauHoi
        from type_question 
        where type_id = (select @id_type);
        select tenLoaiCauHoi;
    end$$
DELIMITER ;
-- gọi thủ tục
call sp_lay_ten_type_nhieu_cau_hoi_nhat();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào 
-- hoặc trả về user có username chứa chuỗi của người dùng nhập vào
drop procedure if exists sp_lay_group_or_user;
DELIMITER $$
create procedure sp_lay_group_or_user(in inputString varchar(50) char set utf8mb4)
	begin
		declare groupName varchar(50); 
        declare userFullName varchar(50);
		set @conditionStr = concat('%', inputString, '%');
        -- lấy group
        select group_name into groupName
			from `group`
			where group_name like @conditionStr collate utf8mb4_general_ci
            limit 1;
		-- lấy account
		select fullname into userFullName
			from `account`
			where username like @conditionStr collate utf8mb4_general_ci
            limit 1;
            
		if groupName is not null and userFullName is null
        then select group_name
			from `group`
			where group_name like @conditionStr collate utf8mb4_general_ci;
		elseif groupName is null and userFullName is not null
        then select fullname
			from `account`
			where username like @conditionStr collate utf8mb4_general_ci;
        elseif groupName is not null and userFullName is not null
        then select concat('group chứa chuỗi: ', group_name) 'group, account chứa chuỗi'
			from `group`
			where group_name like @conditionStr collate utf8mb4_general_ci 
            union all 
            select concat('user chứa chuỗi: ', fullname) 'group, account chứa chuỗi'
			from `account`
			where username like @conditionStr collate utf8mb4_general_ci;
        else select 'không có giá trị chứa chuỗi';
		end if;
    end$$
DELIMITER ;
-- gọi thủ tục
call sp_lay_group_or_user('nguyenỳgejsdfc');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
-- tạo phòng chờ
insert into department(department_name)
values ('Phòng chờ');

drop procedure if exists sp_insert_account;
DELIMITER $$
create procedure sp_insert_account(in fullnameInput varchar(50) char set utf8mb4, in emailInput varchar(50))
	begin
		-- khởi tạo biến
        declare userName varchar(20);
        declare positionId tinyint;
        declare departmentId tinyint;
        
		set userName = SUBSTRING_INDEX(emailInput, '@', 1);
        set positionId = null;
        set departmentId = null;
        
        -- set giá trị position_id
        select position_id into positionId
        from `position` 
        where position_name = 'Dev';
        
        -- set giá trị department_id
        select department_id into departmentId
        from department 
        where department_name = 'Phòng chờ';
        
        -- insert bảng account
        insert into `account`(email, username, fullname, department_id, position_id)
        values (emailInput, userName, fullnameInput, departmentId, positionId);
        
        -- in ra kết quả tạo thành công
        select * 
        from `account` 
        where account_id = (select max(account_id) max_id from `account`);
    end$$
DELIMITER ;
-- gọi thủ tục
call sp_insert_account('Hoàng Anh Nhã', 'nhahoang23081995@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
drop procedure if exists sp_cau_hoi_co_content_dai_nhat;
DELIMITER $$
create procedure sp_cau_hoi_co_content_dai_nhat(in typeName enum('Essay','Multiple-Choice'))
begin
	select q.content
	from type_question tq 
	join question q on tq.type_id = q.type_id
	where tq.type_name = typeName
	and length(q.content) = (
		select max(length(q.content))
		from type_question tq 
		join question q on tq.type_id = q.type_id
		where tq.type_name = typeName);
end$$
DELIMITER ;
-- gọi thủ tục
call sp_cau_hoi_co_content_dai_nhat('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
drop procedure if exists sp_delete_exam_by_id;
DELIMITER $$
create procedure sp_delete_exam_by_id(in examId tinyint)
begin
	delete from exam where exam_id = examId;
end$$
DELIMITER ;
-- gọi thủ tục
call sp_delete_exam_by_id(19);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
-- SELECT ROW_COUNT();
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date) 
VALUES 
	('RB1'	, 'title ruby1'		, 5		, 50	, 1		, '2018-05-05'),
	('VB1'	, 'title vb 11'		, 6		, 120	, 3		, '2017-06-15'),
	('VB61'	, 'title vb6 11'	, 6		, 120	, 3		, '2016-06-15');

drop procedure if exists sp_delete_exam_and_select_count_record;
DELIMITER $$
create procedure sp_delete_exam_and_select_count_record()
begin
	declare examId tinyint;
    declare delRowCntExam tinyint;
    declare delRowCntExamQuestion tinyint;

    -- biến để xem cursor đã đến dòng cuối chưa
	declare done boolean default false;
    -- tạo cursor các exam được tạo từ 3 năm trước
	declare myCursor cursor for
    select exam_id from exam where year(create_date) <= year(date_add(curdate(), interval -3 year));
    
    -- điều khiển hoạt động của cursor khi đến dòng cuối(set là true)
	declare continue handler for not found set done = true;  
    
    -- đếm số dòng sẽ xóa của bảng exam, exam_question
    select count(e.exam_id) cnt_ex into delRowCntExam
	from exam e
	where year(create_date) <= year(date_add(curdate(), interval -3 year));
    
    select count(eq.exam_id) cnt_ex_ques into delRowCntExamQuestion
	from exam e
	left join exam_question eq on e.exam_id = eq.exam_id
	where year(create_date) <= year(date_add(curdate(), interval -3 year));
    
    -- sử dụng store ở câu 9 để xóa
	-- mở cursor
	open myCursor;
		-- lặp từng dòng
		read_loop: loop
			-- đọc từng dòng của cursor
			fetch myCursor into examId;
			
			-- xóa dlieu
			call sp_delete_exam_by_id(examId);

			-- đến dòng cuối thì thoát đọc loop
			if done then
			  leave read_loop;
			end if;
		end loop;
	  
	-- đóng cursor
	close myCursor;	
    select concat('exam table ', delRowCntExam, ' record', ', exam_question table ', delRowCntExamQuestion, ' record') as 'số lượng record đã remove';
end$$
DELIMITER ;
-- gọi thủ tục
call sp_delete_exam_and_select_count_record();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
drop procedure if exists sp_delete_department_and_update_accunt;
DELIMITER $$
create procedure sp_delete_department_and_update_accunt(in departmentName varchar(30) char set utf8mb4)
begin
	-- describe department;
	declare idphongCho tinyint;
    -- lấy id phòng chờ
    select department_id into idphongCho from department where department_name = 'Phòng chờ';
    -- update account có phòng ban sẽ bị xóa --> phòng chờ 
	update `account` a
    join department d on a.department_id = d.department_id
    set a.department_id = idphongCho
    where d.department_name = departmentName;
    -- xóa phòng ban mà người dùng nhập vào
    delete from department where department_name = departmentName;
end$$
DELIMITER ;
-- gọi thủ tục
call sp_delete_department_and_update_accunt('Phát triển');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
drop procedure if exists sp_thong_ke_cau_hoi_cac_thang;
DELIMITER $$
create procedure sp_thong_ke_cau_hoi_cac_thang()
begin
	-- tạo bảng tạm
    drop temporary table if exists tmp_cac_thang;
    create temporary table tmp_cac_thang(
		thang_trong_nam tinyint
    ); 
    -- insert dữ liệu vào bảng tạm(12 tháng)
    set @i = 1;
    while (@i <= 12) do
		insert into tmp_cac_thang (thang_trong_nam)
        values (@i);
    set @i = @i + 1;
    end while;
    
    -- lấy kết quả câu hỏi được tạo trong năm nay
    select t.thang_trong_nam 'tháng', if(tmp.cnt is null, 0, tmp.cnt) 'số câu hỏi'
    from tmp_cac_thang t
    left join (
		select month(create_date) mth, count(question_id) cnt
		from question 
		where year(create_date) = year(curdate())
		group by month(create_date)
	) tmp on t.thang_trong_nam = tmp.mth 
    group by thang_trong_nam;
    
    -- dùng xong thì xóa bảng tạm
    drop temporary table if exists tmp_cac_thang;
end$$
DELIMITER ;
-- gọi thủ tục
call sp_thong_ke_cau_hoi_cac_thang();

-- fullStackOver......^^
drop procedure if exists sp_thong_ke_cau_hoi_cac_thang_1;
DELIMITER $$
create procedure sp_thong_ke_cau_hoi_cac_thang_1()
begin
	select 
		concat(sum(if(mth = '01', cnt, 0)), ' câu hỏi') AS 'Tháng 1',
		concat(sum(if(mth = '02', cnt, 0)), ' câu hỏi') AS 'Tháng 2',
		concat(sum(if(mth = '03', cnt, 0)), ' câu hỏi') AS 'Tháng 3',
		concat(sum(if(mth = '04', cnt, 0)), ' câu hỏi') AS 'Tháng 4',
		concat(sum(if(mth = '05', cnt, 0)), ' câu hỏi') AS 'Tháng 5',
		concat(sum(if(mth = '06', cnt, 0)), ' câu hỏi') AS 'Tháng 6',
		concat(sum(if(mth = '07', cnt, 0)), ' câu hỏi') AS 'Tháng 7',
		concat(sum(if(mth = '08', cnt, 0)), ' câu hỏi') AS 'Tháng 8',
		concat(sum(if(mth = '09', cnt, 0)), ' câu hỏi') AS 'Tháng 9',
		concat(sum(if(mth = '10', cnt, 0)), ' câu hỏi') AS 'Tháng 10',
		concat(sum(if(mth = '11', cnt, 0)), ' câu hỏi') AS 'Tháng 11',
		concat(sum(if(mth = '12', cnt, 0)), ' câu hỏi') AS 'Tháng 12'
	from
		(
			select month(create_date) mth, count(question_id) cnt
			from question 
			where year(create_date) = year(curdate())
			group by month(create_date)
		) tmp;
end$$
DELIMITER ;
-- gọi thủ tục
call sp_thong_ke_cau_hoi_cac_thang_1();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
drop procedure if exists sp_thong_ke_cau_hoi_6_thang;
DELIMITER $$
create procedure sp_thong_ke_cau_hoi_6_thang()
begin
	declare flg int;
    declare targetMonth tinyint;
    drop temporary table if exists tmp_so_cau_hoi;
    create temporary table tmp_so_cau_hoi(
    thang tinyint,
    so_cau_hoi varchar(50)
    );
    set @st = 0;
    set @en = 5;
    while (@st <= @en) do
		-- lấy tháng cần tính toán
        select month(date_add(curdate(), interval -@st month)) into targetMonth;
        -- xét xem tháng cần tính có câu hỏi không
		select count(*) into flg
        from question 
		where month(create_date) = targetMonth
			and year(create_date) = ((select year(date_add(curdate(), interval -@st month))));
		
		if flg <> 0
		then
			-- nếu có dữ liệu thì đếm số câu hỏi và insert vào bảng tạm
			insert into tmp_so_cau_hoi (thang, so_cau_hoi) 
				select targetMonth mth, concat(count(question_id), ' câu hỏi') cnt
				from question 
				where month(create_date) = targetMonth
				and year(create_date) = ((select year(date_add(curdate(), interval -@st month))))
				group by month(create_date);
		else 
			-- nếu không có thì in không có
			insert into tmp_so_cau_hoi (thang, so_cau_hoi)
			values (targetMonth, 'không có câu hỏi nào trong tháng');
		end if;
		
        set @st = @st + 1;
    end while;
    select * from tmp_so_cau_hoi order by thang;
    drop temporary table if exists tmp_so_cau_hoi;
end$$
DELIMITER ;
-- gọi thủ tục
call sp_thong_ke_cau_hoi_6_thang();

















