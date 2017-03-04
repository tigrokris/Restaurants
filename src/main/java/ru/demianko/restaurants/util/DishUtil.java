package ru.demianko.restaurants.util;

import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.to.DishTo;

/**
 * Created by Dmitriy on 21.02.2017.
 */
public class DishUtil {
    public static Dish createFromTo(DishTo newDish) {
        return new Dish(null, newDish.getName(),newDish.getPrice());
    }
    public static DishTo asTo(Dish dish) {
        return new DishTo(dish.getId(), dish.getName(), dish.getPrice(),dish.getRestaurant().getId());
    }
    public static Dish updateFromTo(Dish dish, DishTo dishTo) {
        dish.setName(dishTo.getName());
        dish.setPrice(dishTo.getPrice());
        return dish;
    }


}
