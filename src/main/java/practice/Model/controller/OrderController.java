package practice.Model.controller;

import org.springframework.transaction.annotation.Transactional;
import practice.Model.Dish;
import practice.Model.DishCategory;
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
    public void initOrder(){
        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");

        createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Plov");
        dishes2.add("Potato");

        createOrder("John", dishes2, 2);

        List<String> dishes3 = new ArrayList<>();
        dishes3.add("Potato");
        dishes3.add("Salad");

        createOrder("Mary", dishes3, 3);

        orderDao.save(createOrderWithIceCream());
    }

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());
        orderDao.save(order);
    }

    public Orders createOrderWithIceCream(){
        List<Dish> dishes = new ArrayList<>();

        Dish iceCream = new Dish();
        iceCream.setName("Ice Cream");
        iceCream.setCategory(DishCategory.DESERT);
        iceCream.setWeight(100.0F);
        iceCream.setPrice(3.0F);

        dishes.add(iceCream);

        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName("Mary"));
        order.setDishes(dishes);
        order.setTableNumber(4);
        order.setOrderDate(new Date());
        return  order;
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

    @Transactional
    public void removeAllOrders() {
        orderDao.removeAll();
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
