package ru.demianko.restaurants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.repository.DishRepository;
import ru.demianko.restaurants.util.exception.ExceptionUtil;
import ru.demianko.restaurants.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Dmitriy on 21.02.2017.
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository repository;

    @Override
    public Dish get(int id) {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }


    @Override
    public Collection<Dish> getAll() {
        return repository.getAll();
    }

    @Override
    public Dish update(Dish dish, int restaurantId) {
        return ExceptionUtil.check(repository.save(dish, restaurantId), dish.getId());
    }

    @Override
    public Dish save(Dish dish, int restaurantId) {
        return repository.save(dish, restaurantId);
    }

    @Override
    @Transactional
    public void vote(int id) {
        repository.vote(id);
    }


}
