package com.example.quizApp.services;

import com.example.quizApp.dao.ChoiceDao;
import com.example.quizApp.dao.QuestionDao;
import com.example.quizApp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("questionService")
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private ChoiceDao choiceDao;
    @Transactional
    public List<Question> getQuestionsWithType(Integer categoryId){
        List<Question> curr = questionDao.getQuestions(categoryId);

        return curr;

    }
    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
