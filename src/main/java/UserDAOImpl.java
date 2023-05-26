import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public User createUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class,id);
    }

    @Override
    public List<User> getAllUser() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User").list();
        }
    }

    @Override
    public void  updateUser(User user) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
