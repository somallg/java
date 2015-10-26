package com.somallg.spring.core.ch9.dao.impl;

import com.somallg.spring.core.ch9.dao.ContactDao;
import com.somallg.spring.core.ch9.domain.Contact;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by somallg on 11/6/2014.
 */

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Contact> findAll() {
        String sql = "from Contact c";
        return sessionFactory.getCurrentSession().createQuery(sql).list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Contact> findAllWithDetail() {
        String query = "Contact.findAllWithDetail";
        return sessionFactory.getCurrentSession().getNamedQuery(query).list();
    }

    @Override
    public Contact findById(Long id) {
        String query = "Contact.findById";
        return (Contact) sessionFactory.getCurrentSession().getNamedQuery(query).setParameter("id", id).uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        System.out.println("Contact saved with id: " + contact.getId());

        return contact;
    }

    @Override
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }
}
