package com.example.quizApp.dao;

import com.example.quizApp.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("categoryDao")
public class CategoryDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}

    @Transactional
    public List<Category> getCategory(){
        Session session = getCurrentSession();
        Query theQuery = session.createQuery("FROM Category ");
        List<Category> categories = theQuery.getResultList();
        return categories;
    }
    @Transactional
    public Category getSingleCategory(Integer id){
        Session session = getCurrentSession();
        Query theQuery = session.createQuery("From Category  c WHERE c.categoryId = :id");
        theQuery.setParameter("id", id);
        return ((Category)theQuery.getSingleResult());
    }
}
