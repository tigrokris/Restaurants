package ru.demianko.restaurants.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.demianko.restaurants.LoggedUser;
import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.model.Restaurant;
import ru.demianko.restaurants.model.User;
import ru.demianko.restaurants.repository.DishRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Dmitriy on 21.02.2017.
 */
@Repository
public class DataJpaDishRepositoryImpl implements DishRepository {
    @Autowired
    private ProxyDishRepository proxy;

    @Autowired
    private ProxyRestaurantRepository restaurantProxy;

    @Autowired
    private ProxyUserRepository userRepository;

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        if (!dish.isNew() && get(dish.getId()) == null) {
            return null;
        }
        dish.setRestaurant(restaurantProxy.getOne(restaurantId));
        return proxy.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        return proxy.get(id);
    }

    @Override
    public List<Dish> getAll() {
/*        return proxy.getAll(LoggedUser.id());*/
        return proxy.getAll();
    }

    @Override
    public void vote(int id) {
        int votes = proxy.findOne(id).getRestaurant().getVotes()+1;
        Restaurant restaurant = proxy.findOne(id).getRestaurant();
        User user = userRepository.findOne(LoggedUser.id());
        restaurant.setVotes(votes);
        user.setDateOfVote(new Date());
        restaurantProxy.save(restaurant);
        userRepository.save(user);
    }


/*    @Override
    public Dish getWithRestaurant(Integer id, Integer restaurantId) {
        return proxy.getWithRestaurant(id, restaurantId);
    }*/
}

