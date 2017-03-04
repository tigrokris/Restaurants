package ru.demianko.restaurants.service;

import ru.demianko.restaurants.model.Restaurant;
import ru.demianko.restaurants.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Dmitriy on 25.02.2017.
 */
public interface RestaurantService {
    Restaurant get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Collection<Restaurant> getAll();

    Restaurant update(Restaurant r) throws NotFoundException;

    Restaurant save(Restaurant r);
}
