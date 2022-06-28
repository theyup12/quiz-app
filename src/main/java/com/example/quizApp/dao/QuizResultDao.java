package com.example.quizApp.dao;

import com.example.quizApp.entity.QuizResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuizResultDao {
    @Autowired
    protected SessionFactory sessionFactory;
    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    @Transactional
    public void addQuizResult(QuizResult quizResult) {
        Session currentSession = getCurrentSession();
        currentSession.merge(quizResult);
    }
}
