package com.trunghuynh.validateregisterform.service.impl;

import com.trunghuynh.validateregisterform.model.User;
import com.trunghuynh.validateregisterform.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class HibernateUserServiceImpl implements UserService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> findAll() {
        String queryStr = "SELECT c FROM User AS c";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        return query.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        String queryStr = "SELECT c FROM User AS c where c.email = :email";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public User findOne(Long id) {
        String queryStr = "SELECT c FROM User AS c WHERE c.id = :id";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public User save(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User origin = findOne(user.getId());
            origin.setEmail(user.getEmail());
            origin.setPhoneNumber(user.getPhoneNumber());
            origin.setFirstName(user.getFirstName());
            origin.setLastName(user.getLastName());
            origin.setAge(user.getAge());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<User> save(List<User> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(User customer) {

    }

    @Override
    public void delete(List<User> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
