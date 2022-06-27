package com.example.quizApp.services;

import com.example.quizApp.dao.FeedbackDao;
import com.example.quizApp.domain.FeedbackDomain;
import com.example.quizApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
    @Transactional
    public void submitFeedback(FeedbackDomain feedbackDomain, Integer user_id){
        feedbackDao.saveFeedback(feedbackDomain, user_id, getTime());
    }
}
