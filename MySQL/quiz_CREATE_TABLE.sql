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
	quiz_type VARCHAR(20),
    rating INT,
    feedback_date VARCHAR(30));

CREATE TABLE quiz(
	quiz_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT,
    category_id INT,
    start_time VARCHAR(30),
    finish_time VARCHAR(30));

CREATE TABLE quiz_result(
	quiz_result_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
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
	contact_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    first_name VARCHAR(20),
    last_name VARCHAR(20),
	contact_email VARCHAR(50),
    contact_message VARCHAR(200));
