package practice.Model.controller;

import org.springframework.transaction.annotation.Transactional;
import practice.Model.Dish;
import practice.Model.DishCategory;
import practice.Model.dao.Hibernate.DishDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexander on 29/04/2017.
 */
public class DishController {

    private DishDao dishDao;

    @Transactional
    public void createDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(5.00F);
        plov.setWeight(300F);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SALAD);
        salad.setPrice(2.00F);
        salad.setWeight(200F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(3.00F);
        potato.setWeight(100F);

        Set<Dish> dishes = new HashSet<>(dishDao.findAll());

        if (!dishes.contains(plov)){
            dishDao.save(plov);
        }

        if (!dishes.contains(salad)){
            dishDao.save(salad);
        }

        if (!dishes.contains(potato)){
            dishDao.save(potato);
        }
    }

    @Transactional
    public List<Dish> getAllDishes(){
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName (String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
