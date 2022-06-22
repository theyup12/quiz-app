package com.example.quizApp.dao;

import com.example.quizApp.domain.ContractDomain;
import com.example.quizApp.entity.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ContactDao {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveContractInfo(ContractDomain contractDomain) {
        Session currentSession = getCurrentSession();
        Contract newContract = Contract.builder()
                .firstName(contractDomain.getFirstName())
                .lastName(contractDomain.getLastName())
                .email(contractDomain.getEmail())
                .message(contractDomain.getMessage())
                .build();
        currentSession.persist(newContract);
    }
}