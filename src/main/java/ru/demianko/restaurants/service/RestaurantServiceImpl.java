package ru.demianko.restaurants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.demianko.restaurants.model.Restaurant;
import ru.demianko.restaurants.repository.RestaurantRepository;
import ru.demianko.restaurants.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Dmitriy on 25.02.2017.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository repository;

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return repository.get(id);
    }


    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public Collection<Restaurant> getAll() {
        return repository.getAll();
    }


    @Transactional
    @Override
    public Restaurant update(Restaurant r) throws NotFoundException {
        return repository.save(r);
    }

    @Override
    public Restaurant save(Restaurant r) {
        return repository.save(r);
    }
}
