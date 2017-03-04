package ru.demianko.restaurants.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.demianko.restaurants.LoggedUser;
import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.service.DishService;
import ru.demianko.restaurants.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitriy on 21.02.2017.
 */
public abstract class AbstractDishController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDishController.class);

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    public Dish get(int id) {
        LOG.info("get dish {}", id);
        return dishService.get(id);
    }

    public void delete(int id) {
        LOG.info("delete dish {}", id);
        dishService.delete(id);
    }

    public List<Dish> getAll() {
        LOG.info("getAll{}");
        return dishService.getAll().stream().collect(Collectors.toList());
    }

    public void update(Dish dish,int id, int restaurantId) {
        dish.setId(id);
        LOG.info("update {}", dish);
        dishService.update(dish, restaurantId);
    }

    public Dish create(Dish dish, int restaurantId) {
        dish.setId(null);
        LOG.info("create {} for Restaurant {}", dish, restaurantId);
        return dishService.save(dish, restaurantId);
    }

    public void vote(int id){
        LOG.info("vote dish{} ", id);
        dishService.vote(id);
    }

    public Date getDateOfVote(){
        LOG.info("dateOfVote user{} ", LoggedUser.id());
        return userService.get(LoggedUser.id()).getDateOfVote();
    }
}
