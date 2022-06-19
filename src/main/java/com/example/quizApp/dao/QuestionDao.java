package com.example.quizApp.dao;

import com.example.quizApp.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Query;
import java.util.List;

@Repository
public class QuestionDao {
    @Autowired
    protected SessionFactory sessionFactory;
    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    public List<Question> getQuestions(Integer categoryId){
        // get the current hibernate session
        Session currentSession = getCurrentSession();
        // create a query
        Query theQuery = currentSession
                        .createQuery(String.format("FROM Question q WHERE q.category.categoryId = :categoryId ORDER BY RAND()"));
        theQuery.setParameter("categoryId", categoryId);
        theQuery.setMaxResults(10);
        List<Question> questions = theQuery.getResultList();
        for(Question q: questions){
            q.getChoices().size();
        }
        return questions;
    }
}
