package com.example.quizApp.services;

import com.example.quizApp.dao.ChoiceDao;
import com.example.quizApp.dao.QuizDao;
import com.example.quizApp.dao.QuizResultDao;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import com.example.quizApp.entity.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizResultService {
    @Autowired
    private QuizDao quizDao;

    @Autowired
    private ChoiceDao choiceDao;
    @Autowired
    private QuizResultDao quizResultDao;
    @Transactional
    public void saveQuizResult(int quizId, List<Question> questions, Integer[] answerArray) {
        //is_marked = false;
        QuizResult quizResult;
        Quiz quiz = quizDao.getQuizById(quizId);
        List<Integer> correctChoices= choiceDao.getCorrectChoicesByQuestions(questions);
        for(int i = 0; i < 10; i++){
            quizResult = QuizResult.builder()
                    .quiz(quiz)
                    .question(questions.get(i))
                    .userChoice(answerArray[i])
                    .correctChoice(correctChoices.get(i))
                    .order(i)
                    .isMarked((byte) 0)
                    .build();
            quizResultDao.addQuizResult(quizResult);
        }
    }
    @Transactional
    public List<QuizResult> getResultList(Integer quizId) {
        return quizResultDao.getResultListByQuizId(quizId);
    }
    @Transactional
    public List<Question> getQuestionList(List<QuizResult> quizResultList) {
        List<Question> questionList = new ArrayList<>();
        for(QuizResult quizResult : quizResultList){
            questionList.add(quizResult.getQuestion());
        }
        return questionList;
    }
}

