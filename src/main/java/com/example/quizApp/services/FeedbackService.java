package com.example.quizApp.services;

import com.example.quizApp.dao.FeedbackDao;
import com.example.quizApp.domain.FeedbackDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    @Transactional
    public void submitFeedback(FeedbackDomain feedbackDomain){
        feedbackDao.saveFeedback(feedbackDomain);
    }
}
