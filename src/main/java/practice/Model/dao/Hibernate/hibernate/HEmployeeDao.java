package practice.Model.dao.Hibernate.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import practice.Model.Employee;
import practice.Model.dao.Hibernate.EmployeeDao;

import java.util.List;

/**
 * Created by Alexander on 28/04/2017.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT e from Employee e").list();
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
