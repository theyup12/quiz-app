use quiz;
CREATE TABLE user(
	user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    user_email VARCHAR(50),
    user_password VARCHAR(20),
    user_phone VARCHAR(20),
    is_active TINYINT(1),
    is_admin TINYINT(1));

CREATE TABLE category(
	category_id INT PRIMARY KEY,
    category_name VARCHAR(20),
    category_description VARCHAR(200));
    
CREATE TABLE feedback(
	feedback_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT,
    review VARCHAR(200),
    rating INT,
    feedback_date DATETIME);

CREATE TABLE quiz(
	quiz_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT,
    category_id INT,
    quiz_name VARCHAR(20),
    start_time DATETIME,
    finish_time DATETIME);

CREATE TABLE quiz_result(
	quiz_result_id INT PRIMARY KEY,
    quiz_id INT,
    question_id INT,
    choice_id INT,
    order_num INT,
    is_marked TINYINT(1));

CREATE TABLE question(
	question_id INT PRIMARY KEY,
    category_id INT,
    question_content VARCHAR(200),
    question_status VARCHAR(10));

CREATE TABLE choice(
	choice_id INT PRIMARY KEY,
    question_id INT,
    option_content VARCHAR(200),
    is_correct TINYINT(1));

CREATE TABLE contact(
	contract_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    contract_message VARCHAR(200));
