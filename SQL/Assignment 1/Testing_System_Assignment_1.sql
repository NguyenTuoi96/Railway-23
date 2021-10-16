-- testing_system
CREATE DATABASE testing_system;
USE testing_system;
-- table1
CREATE TABLE department (
	department_id 		INT,
    department_name 	VARCHAR(50)
);
-- table2
CREATE TABLE position (
	position_id 		INT,
    position_name 		VARCHAR(50)
);
-- table3
CREATE TABLE account (
	account_id 			INT,
    email 				VARCHAR(50),
    username 			VARCHAR(50),
    fullname 			VARCHAR(50),
    department_id 		INT,
    position_id 		INT,
    create_date 		DATE
);
-- table4
CREATE TABLE `group` (
	group_id 			INT,
    group_name 			VARCHAR(50),
    creator_id 			INT,
    create_date 		DATE
);
-- table5
CREATE TABLE group_account (
	group_id 			INT,
    account_id 			INT,
    join_date 			DATE
);
-- table6
CREATE TABLE type_question (
	type_id 			INT,
    type_name 			VARCHAR(100)
);
-- table7
CREATE TABLE category_question (
	category_id 		INT,
    category_name 		VARCHAR(50)
);
-- table8
CREATE TABLE question (
	question_id 		INT,
    content 			VARCHAR(100),
    caregory_id 		INT,
    type_id 			INT,
    creator_id 			INT,
    create_date 		DATE
);
-- table9
CREATE TABLE answer (
	answer_id 			INT,
    content 			VARCHAR(100),
    question_id 		INT,
    is_correct 			INT
);
-- table10
CREATE TABLE exam (
	exam_id 			INT,
    code 				VARCHAR(50),
    title 				VARCHAR(50),
    category_id 		INT,
    duration 			VARCHAR(20),
    creator_id 			INT,
    create_date 		DATE
);
-- table11
CREATE TABLE exam_question (
	exam_id 			INT,
    question_id 		INT
);

-- fresher_training_management
CREATE DATABASE fresher_training_management;
USE fresher_training_management;
CREATE TABLE trainee (
	trainee_id 			INT,
    full_name 			VARCHAR(50),
    birth_date 			DATE,
    gender 				ENUM('male', 'female', 'unknown'),
    et_iq 				INT CHECK(0 <= ET_IQ AND ET_IQ <= 20),
    et_gmath 			INT CHECK(0 <= ET_Gmath AND ET_Gmath <= 20),
    et_english 			INT CHECK(0 <= ET_English AND ET_English <= 50),
    training_class 		VARCHAR(20),
    evaluation_notes 	VARCHAR(500)
);
ALTER TABLE trainee ADD vti_account VARCHAR(50) NOT NULL;