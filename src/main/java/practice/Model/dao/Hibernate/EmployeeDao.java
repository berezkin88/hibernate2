package practice.Model.dao.Hibernate;

import practice.Model.Employee;

import java.util.List;

/**
 * Created by Alexander on 28/04/2017.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    void remove(Employee employee);
}
