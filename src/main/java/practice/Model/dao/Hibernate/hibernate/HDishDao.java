package practice.Model.dao.Hibernate.hibernate;

import org.hibernate.SessionFactory;
import practice.Model.Dish;
import practice.Model.dao.Hibernate.DishDao;

import java.util.List;

/**
 * Created by Alexander on 29/04/2017.
 */
public class HDishDao implements DishDao{

    private SessionFactory sessionFactory;

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
