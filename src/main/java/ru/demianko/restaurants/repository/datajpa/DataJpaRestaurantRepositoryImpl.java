package ru.demianko.restaurants.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.demianko.restaurants.model.Restaurant;
import ru.demianko.restaurants.repository.RestaurantRepository;

import java.util.List;

/**
 * Created by Dmitriy on 21.02.2017.
 */
@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {
    @Autowired
    private ProxyRestaurantRepository proxy;
    @Override
    public List<Restaurant> getAll() {
        return proxy.findAll();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return proxy.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return proxy.findOne(id);
    }
}
