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

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();
        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");

        orderController.createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Potato");
        dishes2.add("Salad");

        orderController.createOrder("John", dishes2, 2);

        orderController.getAllOrders();
        orderController.printAllOrders();
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
}
