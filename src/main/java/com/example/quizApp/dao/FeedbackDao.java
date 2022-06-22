package com.example.quizApp.dao;

import com.example.quizApp.domain.FeedbackDomain;
import com.example.quizApp.domain.UserRegisterDomain;
import com.example.quizApp.entity.Feedback;
import com.example.quizApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("feedbackDao")
public class FeedbackDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    public void saveFeedback(FeedbackDomain feedbackDomain){
        Session currentSession = getCurrentSession();
       Feedback newFeedback = Feedback.builder()
                .review(feedbackDomain.getReview())
                .rating(feedbackDomain.getRating())
                .date(feedbackDomain.getDate())
                .build();
        currentSession.persist(newFeedback);
    }
}
