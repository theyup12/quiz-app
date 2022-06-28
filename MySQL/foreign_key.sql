-- add foreign key 
ALTER TABLE quiz
ADD FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE quiz
ADD FOREIGN KEY (category_id) REFERENCES category (category_id);

ALTER TABLE quiz_result
ADD FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id);

ALTER TABLE quiz_result
ADD FOREIGN KEY (question_id) REFERENCES question (question_id);

-- ALTER TABLE quiz_result
-- ADD FOREIGN KEY (choice_id) REFERENCES choice (choice_id);

ALTER TABLE feedback
ADD FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE question
ADD FOREIGN KEY (category_id) REFERENCES category (category_id);

ALTER TABLE choice
ADD FOREIGN KEY (question_id) REFERENCES question (question_id);