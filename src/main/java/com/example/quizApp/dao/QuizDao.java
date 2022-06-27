package com.example.quizApp.dao;

import com.example.quizApp.domain.FeedbackDomain;
import com.example.quizApp.entity.Category;
import com.example.quizApp.entity.Feedback;
import com.example.quizApp.entity.Quiz;
import com.example.quizApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class QuizDao {
    @Autowired
    protected SessionFactory sessionFactory;
    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    public void saveQuizData(Integer userId, Integer categoryId, String startTime, String endTime) {
        Session currentSession = getCurrentSession();
        Query getUser = currentSession.createQuery("FROM User u WHERE u.userId = :id");
        getUser.setParameter("id", userId);
        Query getCategory = currentSession.createQuery("From Category c WHere c.categoryId = :id ");
        getCategory.setParameter("id", categoryId);
        Quiz newQuiz = Quiz.builder()
                .category((Category) getCategory.  getSingleResult())
                .user(((User)getUser.getSingleResult()))
                .startTime(startTime)
                .finishTime(endTime)
                .build();
        currentSession.persist(newQuiz);
    }
}
