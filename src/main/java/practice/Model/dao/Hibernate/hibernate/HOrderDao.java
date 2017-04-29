package practice.Model.dao.Hibernate.hibernate;

import org.hibernate.SessionFactory;
import practice.Model.Order;
import practice.Model.dao.Hibernate.OrderDao;

/**
 * Created by Alexander on 29/04/2017.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
