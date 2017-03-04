package ru.demianko.restaurants.repository;

import ru.demianko.restaurants.model.Restaurant;

import java.util.List;

/**
 * Created by Дмитрий on 08.05.2016.
 */
public interface RestaurantRepository {
    List<Restaurant> getAll();

    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);
}
