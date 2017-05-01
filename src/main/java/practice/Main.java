package practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import practice.Model.controller.DishController;
import practice.Model.controller.EmployeeController;
import practice.Model.controller.OrderController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 26/04/2017.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    private boolean reInit = true;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        applicationContext.getBean(Main.class).start();

    }

    public void init() {
        if (reInit) {
            System.out.println("removing from DB");
            orderController.removeAllOrders();
            dishController.removeAllDishes();
            employeeController.removeAllEmployees();

            System.out.println("populating DB");
            employeeController.initEmployee();
            dishController.initDish();
            orderController.initOrder();
        }

    }

    private void start() {

        employeeController.printEmployee(2L);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setReInit(String reInit) {
    }
}
