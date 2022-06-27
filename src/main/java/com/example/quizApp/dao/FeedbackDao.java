package com.example.quizApp.dao;

import com.example.quizApp.domain.FeedbackDomain;
import com.example.quizApp.entity.Feedback;
import com.example.quizApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository("feedbackDao")
public class FeedbackDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    public void saveFeedback(FeedbackDomain feedbackDomain, Integer user_id, String date){
        Session currentSession = getCurrentSession();
        Query theQuery = currentSession.createQuery("From User u WHERE u.user_id = :id");
        theQuery.setParameter("id", user_id);
        User user = (User)theQuery.getSingleResult();
        Feedback newFeedback = Feedback.builder()
                .user(user)
                .type(feedbackDomain.getType())
                .review(feedbackDomain.getReview())
                .rating(feedbackDomain.getRating())
                .date(date)
                .build();
        currentSession.persist(newFeedback);
    }
}
