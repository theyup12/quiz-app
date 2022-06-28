package com.example.quizApp.dao;

import com.example.quizApp.domain.LoginDomain;
import com.example.quizApp.domain.UserRegisterDomain;
import com.example.quizApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    protected SessionFactory sessionFactory;
    protected final Session getCurrentSession(){return sessionFactory.getCurrentSession();}
    @Transactional
    public List<User> getUsers(){
        // get the current hibernate session
        Session currentSession = getCurrentSession();
        // create a query
        Query theQuery = currentSession.createQuery("FROM User");
        List<User> users = theQuery.getResultList();
        return users;
    }
    @Transactional
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
    @Transactional
    public User findUserByEmailAddress(String email) {
        try{
            Session currentSession = getCurrentSession();
            Query theQuery = currentSession.createQuery("FROM User u WHERE u.email = :email");
            theQuery.setParameter("email", email);
            User user = (User) theQuery.getSingleResult();
            return user;
        }catch (NoResultException e){
            System.out.println("No email found");
            return null;
        }
    }
    @Transactional
    public User checkEmailAndPassword(LoginDomain loginDomain){
        try{
            Session currentSession = getCurrentSession();
            Query theQuery = currentSession.createQuery("FROM User u WHERE u.email = :email AND u.password = :password");
            theQuery.setParameter("email", loginDomain.getEmail());
            theQuery.setParameter("password", loginDomain.getPassword());
            User user = (User) theQuery.getSingleResult();
            return user;
        }catch (NoResultException e){
            System.out.println("No email  and password found");
            return null;
        }
    }
}
