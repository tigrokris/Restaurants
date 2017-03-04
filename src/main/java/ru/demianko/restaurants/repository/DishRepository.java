package ru.demianko.restaurants.repository;

import org.springframework.transaction.annotation.Transactional;
import ru.demianko.restaurants.model.Dish;

import java.util.List;

/**
 * Created by Дмитрий on 08.05.2016.
 */
public interface DishRepository {

    Dish save(Dish dish, int restaurantId);

    // false if not found
    boolean delete(int id);

    // null if not found
    Dish get(int id);

    List<Dish> getAll();

    void vote(int id);

/*    Dish getWithRestaurant(Integer id, Integer restaurantId);*/
}
