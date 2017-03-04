package ru.demianko.restaurants.service;

import ru.demianko.restaurants.model.User;
import ru.demianko.restaurants.to.UserTo;
import ru.demianko.restaurants.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Дмитрий on 08.05.2016.
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

    void update(UserTo user);

    void evictCache();
}

