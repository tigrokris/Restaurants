package ru.demianko.restaurants.model;

import javax.persistence.*;

/**
 * Created by Дмитрий on 07.05.2016.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Dish.GET, query = "SELECT d FROM Dish d WHERE d.id=:id"),
        @NamedQuery(name = Dish.ALL_SORTED, query = "SELECT d FROM Dish d ORDER BY d.price DESC"),
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId"),
})
@Entity
@Table(name = "DISHES",uniqueConstraints ={@UniqueConstraint(columnNames = {"name","restaurant_id"}, name = "dishes_unique_name_restaurant_id_idx")})
public class Dish extends NamedEntity {
    public static final String GET = "Dish.get";
    public static final String ALL_SORTED = "Dish.getAllSorted";
    public static final String DELETE = "Dish.delete";

    @Column(name = "price",nullable = false)
    protected int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
