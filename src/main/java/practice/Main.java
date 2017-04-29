package practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import practice.Model.controller.DishController;
import practice.Model.controller.EmployeeController;

/**
 * Created by Alexander on 26/04/2017.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();
        dishController.getAllDishes().forEach(System.out::println);
        employeeController.getAllEmployees().forEach(System.out::println);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
