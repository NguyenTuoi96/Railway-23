-- fresher_training_management
CREATE DATABASE fresher_training_management;
USE fresher_training_management;

CREATE TABLE trainee(
	trainee_id 			INT,
    full_name 			VARCHAR(50),
    birth_date 			DATE,
    gender 				ENUM('male', 'female', 'unknown'),
    et_iq 				INT CHECK(0 <= et_iq AND et_iq <= 20),
    et_gmath 			INT CHECK(0 <= et_gmath AND et_gmath <= 20),
    et_english 			INT CHECK(0 <= et_english AND et_english <= 50),
    training_class 		CHAR,
    evaluation_notes 	VARCHAR(500)
);