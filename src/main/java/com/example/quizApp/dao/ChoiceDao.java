package com.example.quizApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("choiceDao")
public class ChoiceDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

}
