package com.example.quizApp.services;

import com.example.quizApp.dao.ChoiceDao;
import com.example.quizApp.dao.QuizDao;
import com.example.quizApp.domain.ContactDomain;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;

    @Autowired
    private ChoiceDao choiceDao;
    @Transactional
    public Quiz saveQuiz(Integer userId, Integer categoryId, String startTime, String endTime, Integer count) {
        return quizDao.saveQuizData(userId, categoryId, startTime, endTime, count);
    }

    @Transactional
    public List<Quiz> getQuizByUser(Integer userId) {
        return quizDao.getQuizByUserId(userId);
    }

    @Transactional
    public Integer checkScore(List<Question> questions, Integer[] answerArray) {
        Integer count = 0;
        List<Integer> correctChoices= choiceDao.getCorrectChoicesByQuestions(questions);
        for(int i =0; i < 10; i++){
            if(correctChoices.get(i).equals(answerArray[i])){
                count++;
            }
        }
        return count;
    }
    @Transactional
    public Quiz getQuizByQuizId(Integer quizId) {
        return quizDao.getQuizById(quizId);
    }

    @Transactional
    public List<Quiz> getAllQuiz() {
        return quizDao.getQuiz();
    }
}
