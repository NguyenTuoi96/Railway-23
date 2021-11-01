drop database if exists project_managers;
create database project_managers;
use project_managers;
drop table if exists employee;
create table employee(
	employee_id 				int auto_increment primary key,
    employee_last_name 			varchar(20) char set utf8mb4 not null,
    employee_first_name 		varchar(30) char set utf8mb4 not null,
    employee_hire_date 			date,
    employee_status 			tinyint,
    supervisor_id				int,
    social_security_number		int,
    foreign key (supervisor_id) references employee(employee_id) on delete cascade on update cascade
);

insert into employee (employee_last_name, employee_first_name, employee_hire_date, employee_status, supervisor_id, social_security_number)
values
	('Nguyễn', 'Anh Thư', '2018-01-01', 1, null,123),
	('Nguyễn', 'Anh Dương', '2017-01-01', 1, null,123),
	('Phạm', 'Văn Hoàng', '2016-01-01', 1, 1,123),
	('Nguyễn', 'Chí hiếu', '2019-01-01', 1, 2,123),
	('Nguyễn', 'Quang Anh', '2019-01-01', 1, 1,123);

drop table if exists project;
create table project(
	project_id 				int auto_increment primary key,
    manager_id 				int not null,
    project_name 			varchar(50) char set utf8mb4 not null,
    project_start_date 		date,
    project_description 	text char set utf8mb4,
    project_detailt 		text char set utf8mb4,
    project_completed_one 	date,
    foreign key (manager_id) references employee(employee_id) on delete cascade on update cascade
);

insert into project (manager_id, project_name, project_start_date, project_description, project_detailt, project_completed_one)
values
	(1, 'dự án A', '2019-01-01', 'description dự án A', 'detailt dự án A', '2019-02-01'),
	(2, 'dự án B', '2021-09-05', 'description dự án B', 'detailt dự án B', '2021-10-01'),
	(2, 'dự án C', '2020-04-01', 'description dự án C', 'detailt dự án C', '2021-02-01'),
	(1, 'dự án D', '2021-10-01', 'description dự án D', 'detailt dự án D', '2022-03-01'),
	(3, 'dự án E', '2021-11-01', 'description dự án D', 'detailt dự án E', '2022-02-01');

drop table if exists project_modules;
create table project_modules(
	module_id 						int auto_increment primary key,
    project_id 						int not null,
    employee_id 					int not null,
    project_modules_date 			date,
    project_modules_compled_on 		date,
    project_modules_description 	text char set utf8mb4,
    foreign key (project_id) references project(project_id) on delete cascade on update cascade,
    foreign key (employee_id) references employee(employee_id) on delete cascade on update cascade
);

insert into project_modules (project_id, employee_id, project_modules_date, project_modules_compled_on, project_modules_description)
values
	(1, 2, '2019-01-05', '2019-01-06', 'project modules description 1'),
	(1, 1, '2019-01-10', '2019-01-09', 'project modules description 2'),
	(2, 3, '2021-09-09', '2021-09-10', 'project modules description 3'),
	(2, 2, '2021-09-15', '2021-09-17', 'project modules description 4'),
	(3, 1, '2021-09-15', '2021-09-17', 'project modules description 5'),
	(4, 4, '2021-09-15', null, 'project modules description 6'),
	(4, 3, '2021-09-15', null, 'project modules description 7'),
	(4, 4, '2021-09-15', '2021-11-15', 'project modules description 7');

drop table if exists work_done;
create table work_done(
	work_done_id 			int auto_increment primary key,
    employee_id 			int not null,
    module_id 				int not null,
    work_done_date 			date,
    work_done_description 	text char set utf8mb4,
    work_done_status 		tinyint,    
    foreign key (employee_id) references employee(employee_id) on delete cascade on update cascade,
    foreign key (module_id) references project_modules(module_id) on delete cascade on update cascade
);
insert into work_done (employee_id, module_id, work_done_date, work_done_description, work_done_status)
values
	(1, 1, '2019-01-06', 'work done description 1', 1),
	(1, 2, '2019-01-09', 'work done description 2', 1),
	(2, 3, '2021-09-10', 'work done description 3', 1),
	(2, 5, '2021-09-17', 'work done description 4', 1),
	(3, 5, '2021-09-17', 'work done description 5', 1),
	(2, 5, '2021-09-17', 'work done description 6', 1);

-- Questions
-- a) Tạo table với các ràng buộc và kiểu dữ liệu và thêm ít nhất 3 bản ghi vào
-- mỗi table trên
-- b) Viết stored procedure (không có parameter) để Remove tất cả thông tin
-- project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
-- remove từ các table liên quan trong khi removing (dùng lệnh print)
drop procedure if exists sp_remote_thong_tin;
DELIMITER $$
create procedure sp_remote_thong_tin()
begin
	declare delRowCntPrj int;
	declare delRowCntModule int;
    declare delRowCntWorkDone int;
    -- đếm số project bị xóa
    select count(*) into delRowCntPrj
    from project 
    where project_completed_one <= date_add(curdate(), interval -3 month);
    
    -- đếm số module sẽ bị xóa
	select sum(cnt) into delRowCntModule from 
		(select p.project_id, pm.module_id, count(pm.module_id) cnt
		from project p
		join project_modules pm on p.project_id = pm.project_id
		where p.project_completed_one <= date_add(curdate(), interval -3 month)
		group by p.project_id) tmp;
	
    -- đếm số work_done sẽ bị xóa        
	select count(*) into delRowCntWorkDone
	from work_done where module_id in (select pm.module_id
		from project p
		join project_modules pm on p.project_id = pm.project_id
		where p.project_completed_one <= date_add(curdate(), interval -3 month));
	
    -- Remove tất cả thông tin project đã hoàn thành sau 3 tháng kể từ ngày hiện
    delete from project where project_completed_one <= date_add(curdate(), interval -3 month);
        
	-- in kết quả
    select concat('project table ', delRowCntPrj, ' record', ', project_modules table ', delRowCntModule, ' record', ', work_done table ', delRowCntWorkDone, ' record') as 'số lượng record đã remove';
end $$
DELIMITER ;

-- gọi thủ tục
call sp_remote_thong_tin();

-- c) Viết stored procedure (có parameter) để in ra các module đang được thực hiện)
-- các module đang thực hiện -> chưa có ngày hoàn thành hoặc trường hợp ngày hoàn thành > hôm nay
-- --> không cần param in
-- trả về 1 bảng --> không thể dùng param out
-- --> ??
drop procedure if exists sp_module_dang_duoc_thuc_hien;
DELIMITER $$
create procedure sp_module_dang_duoc_thuc_hien()
begin
	select * 
    from project_modules
    where project_modules_compled_on is null
		or project_modules_compled_on > curdate();
end $$
DELIMITER ;
-- gọi thủ tục
call sp_module_dang_duoc_thuc_hien();

-- có param out 
drop procedure if exists sp_module_dang_duoc_thuc_hien_param;
DELIMITER $$
create procedure sp_module_dang_duoc_thuc_hien_param(out result text)
begin
	-- tạo bảng tạm
    drop temporary table if exists tmp;
    create temporary table tmp(
		num tinyint,
        modl_id int
    ); 
    -- insert dữ liệu vào bảng tạm
    insert into tmp (
		select 1, module_id 
		from project_modules
		where project_modules_compled_on is null
			or project_modules_compled_on > curdate());
	-- lấy result
    select concat('các module có id sau đang được thực hiện: ' , group_concat(modl_id)) into result
    from tmp
    group by num;    
    -- dùng xong thì xóa bảng tạm
    drop temporary table if exists tmp;
end $$
DELIMITER ;
-- gọi thủ tục
set @ketqua = '';
call sp_module_dang_duoc_thuc_hien_param(@ketqua);
select @ketqua;

-- d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc
-- dù không ai giao việc cho nhân viên đó (trong bảng Works)
-- không có bảng works -- ???



















