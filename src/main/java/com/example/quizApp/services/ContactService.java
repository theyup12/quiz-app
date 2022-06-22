package com.example.quizApp.services;


import com.example.quizApp.dao.ContactDao;
import com.example.quizApp.domain.ContactDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("contactService")
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    @Transactional
    public void saveContact(ContactDomain contactDomain){
        contactDao.saveContactInfo(contactDomain);
    }
}
