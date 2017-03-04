package ru.demianko.restaurants.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.model.Restaurant;
import ru.demianko.restaurants.model.User;
import ru.demianko.restaurants.service.DishService;
import ru.demianko.restaurants.service.RestaurantService;
import ru.demianko.restaurants.service.UserService;
import ru.demianko.restaurants.to.UserTo;
import ru.demianko.restaurants.util.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitriy on 25.02.2017.
 */
public abstract class AbstractRestaurantController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractRestaurantController.class);

    @Autowired
    private RestaurantService service;

    public Restaurant get(int id) {
        LOG.info("get restaurant {}", id);
        return service.get(id);
    }

    public void delete(int id) {
        LOG.info("delete restaurant {}", id);
        service.delete(id);
    }

    public List<Restaurant> getAll() {
        LOG.info("getAll{}");
        return service.getAll().stream().collect(Collectors.toList());
    }

    public void update(Restaurant restaurant,int id) {
        restaurant.setId(id);
        LOG.info("update {}", restaurant);
        service.update(restaurant);
    }

    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(null);
        LOG.info("create Restaurant {}", restaurant);
        return service.save(restaurant);
    }
}
