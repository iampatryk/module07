package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {
    private final SessionFactory sessionFactory = UserSessionFactory.getUserSessionFactory();

    public void saveUser(User u) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(u);
        transaction.commit();
        session.close();
    }
}
