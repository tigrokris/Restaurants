package ru.demianko.restaurants.to;

import org.hibernate.validator.constraints.NotEmpty;
import ru.demianko.restaurants.LoggedUser;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dmitriy on 21.02.2017.
 */
public class DishTo implements Serializable {
    private static final long serialVersionUID = 1L;

    protected int id;

    @NotEmpty
    protected String name;

    @NotEmpty
    protected Integer price;

    protected Integer restaurantId;

    public DishTo() {
    }

/*    public DishTo(int id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }*/

    public DishTo(int id, String name, Integer price, Integer restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "DishTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
