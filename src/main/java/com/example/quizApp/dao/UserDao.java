package com.example.quizApp.dao;

import com.example.quizApp.domain.UserRegisterDomain;
import com.example.quizApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    protected SessionFactory sessionFactory;
    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}
    public List<User> getUsers(){
        // get the current hibernate session
        Session currentSession = getCurrentSession();
        // create a query
        Query theQuery = currentSession.createQuery("FROM User");
        List<User> users = theQuery.getResultList();
        return users;
    }
    public void saveOneUser(UserRegisterDomain userRegisterDomain){
        Session currentSession = getCurrentSession();
        User newUser = User.builder()
                .firstName(userRegisterDomain.getFirstName())
                .lastName(userRegisterDomain.getLastName())
                .email(userRegisterDomain.getEmail())
                .password(userRegisterDomain.getPassword())
                .phone(userRegisterDomain.getPhone())
                .isActive((byte) 1)
                .isAdmin((byte) 0)
                .build();
        currentSession.persist(newUser);
    }
//    public String findEmail(String email){
//        try{
//            Session currentSession = getCurrentSession();
//            Query
//        }catch (NoResultException exc){
//            return null;
//        }
//    }
}
