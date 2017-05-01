package practice.Model.controller;

import org.springframework.transaction.annotation.Transactional;

import practice.Model.Employee;
import practice.Model.Waiter;
import practice.Model.dao.Hibernate.EmployeeDao;
import practice.Model.Position;

import java.util.List;

/**
 * Created by Alexander on 28/04/2017.
 */

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void initEmployee(){
//        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Waiter john = new Waiter();
//        employee.setId(1L);
        john.setName("John");
        john.setSurname("Smith");
        john.setPosition(Position.WAITER);
        john.setTelephoneNumber("555-55-55");
        john.setSalary(25000.0F);
//        if (!allEmployees.contains(employee)){
//            employeeDao.save(employee);
//
//        }
        employeeDao.save(john);


        Waiter mary = new Waiter();
        mary.setName("Mary");
        mary.setSurname("Smith");
        mary.setPosition(Position.WAITER);
        mary.setTelephoneNumber("555-55-55");
        mary.setSalary(25000.0F);
        employeeDao.save(mary);


    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional
    public void removeAllEmployees() {
        employeeDao.removeAll();
    }

    @Transactional
    public void printWaiter(){
        employeeDao.findAll().forEach(System.out::println);
    }

    @Transactional
    public void printEmployee(long id) {
        System.out.println(employeeDao.load(id));
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
