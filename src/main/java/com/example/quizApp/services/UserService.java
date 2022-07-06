package com.example.quizApp.services;

import com.example.quizApp.dao.UserDao;
import com.example.quizApp.domain.LoginDomain;
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
    public boolean saveUser(UserRegisterDomain userRegisterDomain){
        boolean isExisted = checkUserByEmail(userRegisterDomain.getEmail());
        if(!isExisted){
            userDao.saveOneUser(userRegisterDomain);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean checkUserByEmail(String email) {
        return userDao.findUserByEmailAddress(email) != null;
    }
    public User checkLogin(LoginDomain loginDomain){
        if(loginDomain.getEmail() == null && loginDomain.getPassword() == null){
            return null;
        }
        if (checkUserByEmail(loginDomain.getEmail())){
            return userDao.checkEmailAndPassword(loginDomain);
        }
        return null;
    }
    @Transactional
    public void updateUserStatus(String status, Integer userId) {
        userDao.updateUserStatusById(status,userId);
    }

    public User findUserByUserId(int userId) {
        return userDao.getUserById(userId);
    }
}
