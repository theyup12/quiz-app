package com.example.quizApp.services;

import com.example.quizApp.dao.QuizDao;
import com.example.quizApp.domain.ContactDomain;
import com.example.quizApp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;

    @Transactional
    public Quiz saveQuiz(Integer userId, Integer categoryId, String startTime, String endTime) {
        return quizDao.saveQuizData(userId, categoryId, startTime, endTime);
    }
}
