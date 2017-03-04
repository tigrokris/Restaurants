package ru.demianko.restaurants.web.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.demianko.restaurants.LoggedUser;
import ru.demianko.restaurants.model.Dish;
import ru.demianko.restaurants.model.User;
import ru.demianko.restaurants.service.UserService;
import ru.demianko.restaurants.to.DishTo;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static ru.demianko.restaurants.util.DishUtil.createFromTo;

/**
 * Created by Dmitriy on 21.02.2017.
 */
@RestController
@RequestMapping("/ajax/profile/dishes")
public class DishAjaxController extends AbstractDishController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/dateOfVote", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Date getDateOfVote() {
        return super.getDateOfVote();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id) {
        return super.get(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void vote(@PathVariable("id") int id) {
        super.vote(id);
    }

    //Настроить валидацию
    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(DishTo dishTo) {
        if (dishTo.getId() == 0) {
            super.create(createFromTo(dishTo),dishTo.getRestaurantId());
        } else {
            super.update(createFromTo(dishTo),dishTo.getId(),dishTo.getRestaurantId());
        }
    }

}
