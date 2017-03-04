package ru.demianko.restaurants.web.restaurant;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.demianko.restaurants.model.Restaurant;


import javax.validation.Valid;
import java.util.List;


/**
 * Created by Dmitriy on 25.02.2017.
 */
@RestController
@RequestMapping("/ajax/profile/restaurantsList")
public class RestaurantAjaxController extends AbstractRestaurantController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return super.get(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@Valid Restaurant restaurant) {
        if (restaurant.getId() == 0) {
            super.create(restaurant);
        } else {
            super.update(restaurant,restaurant.getId());
        }
    }
}
