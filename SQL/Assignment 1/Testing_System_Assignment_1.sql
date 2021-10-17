-- tạo cơ sở dữ liệu 'testing_system'
CREATE DATABASE testing_system;
USE testing_system;

-- department
CREATE TABLE department(
	department_id 		INT,
    department_name 	VARCHAR(50)
);
-- position
CREATE TABLE `position`(
	position_id 	INT,
    position_name 	VARCHAR(50)
);
-- account
CREATE TABLE `account`(
	account_id 		INT,
    email 			VARCHAR(50),
    username 		VARCHAR(50),
    fullname 		VARCHAR(50),
    department_id 	INT,
    position_id 	INT,
    create_date 	DATE
);
-- group
CREATE TABLE `group`(
	group_id 		INT,
    group_name 		VARCHAR(50),
    creator_id 		INT,
    create_date 	DATE
);
-- group_account
CREATE TABLE group_account(
	group_id 		INT,
    account_id 		INT,
    join_date 		DATE
);
-- type_question
CREATE TABLE type_question(
	type_id 	INT,
    type_name 	VARCHAR(50)
);
-- category_question
CREATE TABLE category_question(
	category_id 	INT,
    category_name 	VARCHAR(50)
);
-- question
CREATE TABLE question(
	question_id 	INT,
    content 		VARCHAR(1000),
    caregory_id 	INT,
    type_id 		INT,
    creator_id 		INT,
    create_date 	DATE
);
-- answer
CREATE TABLE answer(
	answer_id 		INT,
    content 		VARCHAR(1000),
    question_id 	INT,
    is_correct 		BOOLEAN
);
-- exam
CREATE TABLE exam(
	exam_id 		INT,
    `code` 			VARCHAR(50),
    title 			VARCHAR(50),
    category_id 	INT,
    duration 		INT,
    creator_id 		INT,
    create_date 	DATE
);
-- exam_question
CREATE TABLE exam_question(
	exam_id 		INT,
    question_id 	INT
);