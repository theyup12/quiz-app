package com.example.quizApp.services;

import com.example.quizApp.dao.UserDao;
import com.example.quizApp.domain.UserRegisterDomain;
import com.example.quizApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public List<User> findUser(){
        return userDao.getUsers();
    }

    @Transactional
    public void saveUser(UserRegisterDomain userRegisterDomain){
        userDao.saveOneUser(userRegisterDomain);
    }

//    @Transactional
//    public boolean checkEmail(String email){
//        userDao.findEmail(email);
//    }
}
