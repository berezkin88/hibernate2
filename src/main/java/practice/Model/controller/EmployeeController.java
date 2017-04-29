package practice.Model.controller;

import org.springframework.transaction.annotation.Transactional;
import practice.Model.Employee;
import practice.Model.dao.Hibernate.EmployeeDao;
import practice.Model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexander on 28/04/2017.
 */

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee(){
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
//        employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setTelephoneNumber("555-55-55");
        employee.setSalary(25000.0F);
        if (!allEmployees.contains(employee)){
            employeeDao.save(employee);

        }
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
