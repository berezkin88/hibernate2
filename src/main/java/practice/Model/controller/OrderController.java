package practice.Model.controller;

import org.springframework.transaction.annotation.Transactional;
import practice.Model.Dish;
import practice.Model.Orders;
import practice.Model.dao.Hibernate.DishDao;
import practice.Model.dao.Hibernate.EmployeeDao;
import practice.Model.dao.Hibernate.OrderDao;

import java.util.*;

/**
 * Created by Alexander on 29/04/2017.
 */
public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());

//        Set<Orders> orders = new HashSet<>(orderDao.findAll());
//
//        if (!orders.contains(order)){
//            orderDao.save(order);
//        }
        orderDao.save(order);
    }

    @Transactional
    public List<Orders> getAllOrders(){
        return orderDao.findAll();
    }

    @Transactional
    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


}
