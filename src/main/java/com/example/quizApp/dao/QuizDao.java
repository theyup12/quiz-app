package com.example.quizApp.dao;

import com.example.quizApp.entity.Category;
import com.example.quizApp.entity.Quiz;
import com.example.quizApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class QuizDao {
    @Autowired
    protected SessionFactory sessionFactory;
    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}
    @Transactional
    public Quiz saveQuizData(Integer userId, Integer categoryId, String startTime, String endTime, Integer count) {
        Session currentSession = getCurrentSession();
        Query getUser = currentSession.createQuery("FROM User u WHERE u.userId = :id");
        getUser.setParameter("id", userId);
        Query getCategory = currentSession.createQuery("From Category c WHere c.categoryId = :id ");
        getCategory.setParameter("id", categoryId);
        Quiz newQuiz = Quiz.builder()
                .category((Category) getCategory.getSingleResult())
                .user(((User)getUser.getSingleResult()))
                .startTime(startTime)
                .finishTime(endTime)
                .score(count)
                .build();
        currentSession.persist(newQuiz);
        return newQuiz;
    }
    @Transactional
    public Quiz getQuizById(int quizId) {
        Session currentSession = getCurrentSession();
        Query query = currentSession.createQuery("From Quiz q where q.quizId =:id");
        query.setParameter("id", quizId);
        return (Quiz) query.getSingleResult();
    }
    @Transactional
    public List<Quiz> getQuizByUserId(Integer userId) {
        Session currentSession = getCurrentSession();
        Query theQuery = currentSession.createQuery("From Quiz q where q.user.userId =:id");
        theQuery.setParameter("id", userId);
        List<Quiz> quizList = theQuery.getResultList();
        return quizList;
    }
    @Transactional
    public List<Quiz> getQuiz() {
        Session currentSession = getCurrentSession();
        Query theQuery = currentSession.createQuery("From Quiz q");
        List<Quiz> quizzes = theQuery.getResultList();
        return quizzes;
    }
}
