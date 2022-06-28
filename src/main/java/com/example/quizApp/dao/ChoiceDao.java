package com.example.quizApp.dao;

import com.example.quizApp.entity.Choice;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("choiceDao")
public class ChoiceDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}
    @Transactional
    public List<Integer> getChoicesByQuestions(List<Question> questions){
        Session currentSession = getCurrentSession();
        List<Integer> correctChoiceIds = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Query theQuery = currentSession
                    .createQuery("FROM Choice c Where c.question.questionId = :questionId and c.isCorrect = :isCorrect");
            theQuery.setParameter("questionId", questions.get(i).getQuestionId());
            theQuery.setParameter("isCorrect", (byte) 1);
            correctChoiceIds.add(((Choice) theQuery.getSingleResult()).getChoiceId());
        }
        return correctChoiceIds;
    }
    @Transactional
    public Choice getChoicesById(Integer id) {
        Session currentSession = getCurrentSession();
        Query theQuery = currentSession.createQuery("From Choice c Where c.choiceId = :id");
        theQuery.setParameter("id", id);
        return (Choice) theQuery.getSingleResult();
    }
}
