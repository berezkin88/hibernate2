package practice.Model.dao.Hibernate;

import practice.Model.Dish;

import java.util.List;

/**
 * Created by Alexander on 29/04/2017.
 */
public interface DishDao {

    void save (Dish dish);
    List<Dish> findAll();
}
