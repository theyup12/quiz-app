package com.example.quizApp.dao;

import com.example.quizApp.domain.ContactDomain;
import com.example.quizApp.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ContactDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Transactional
    public void saveContactInfo(ContactDomain contactDomain) {
        Session currentSession = getCurrentSession();
        Contact newContact = Contact.builder()
                .firstName(contactDomain.getFirstName())
                .lastName(contactDomain.getLastName())
                .email(contactDomain.getEmail())
                .message(contactDomain.getMessage())
                .build();
        currentSession.persist(newContact);
    }
}