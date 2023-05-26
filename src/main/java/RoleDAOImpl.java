
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    @Override
    public void create(Roles roles) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(roles);
        transaction.commit();
        session.close();
    }



    @Override
    public Roles getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Roles.class, id);
    }

    @Override
    public List<Roles> getAllRoles() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Roles").list();
        }
    }


    @Override
    public void delete(Roles roles) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(roles);
        transaction.commit();
        session.close();
    }
}