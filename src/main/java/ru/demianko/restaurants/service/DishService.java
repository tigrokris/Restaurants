package ru.demianko.restaurants.service;

import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.util.exception.NotFoundException;

import java.util.Collection;
import java.util.List;

/**
 * Created by Dmitriy on 21.02.2017.
 */
public interface DishService {
    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Collection<Dish> getAll();

    Dish update(Dish dish,int restaurantId) throws NotFoundException;

    Dish save(Dish dish, int restaurantId);

    void vote(int id);

/*    Dish getWithRestaurant(Integer id, Integer restaurantId);*/
}
