package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    public User findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> root = userQuery.from(User.class);
        userQuery.select(root).where(cb.equal(root.get("email"), email));

        return session.createQuery(userQuery).getSingleResult();
    }

    public void changeUserAge(String email, int age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User u = findUserByEmail(email);
        u.setAge(age);
        session.merge(u);
        transaction.commit();
        session.close();
    }

    public void deleteUser(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User u = findUserByEmail(email);
        session.remove(u);
        transaction.commit();
        session.close();
    }
}
