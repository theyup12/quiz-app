package com.example.quizApp.dao;

import com.example.quizApp.entity.Choice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("choiceDao")
public class ChoiceDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    public List<Choice> getChoicesByQuestionId(Integer questionId){
        Session currentSession = getCurrentSession();
        Query theQuery = currentSession
                    .createQuery(String.format("FROM Choice c Where c.question.questionId = :questionId"));
        theQuery.setParameter("questionId", questionId);
        List<Choice> choices = theQuery.getResultList();
        return choices;
    }
}
