package practice.Model.dao.Hibernate.hibernate;

import org.hibernate.SessionFactory;
import practice.Model.Orders;
import practice.Model.dao.Hibernate.OrderDao;

import java.util.List;

/**
 * Created by Alexander on 29/04/2017.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Orders order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Orders> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
