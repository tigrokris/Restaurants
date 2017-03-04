package ru.demianko.restaurants.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Дмитрий on 07.05.2016.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Restaurant.GET, query = "SELECT r FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT r FROM Restaurant r ORDER BY r.votes DESC"),
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
})
@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends NamedEntity {
    public static final String GET = "Restaurant.get";
    public static final String ALL_SORTED = "Restaurant.getAllSorted";
    public static final String DELETE = "Restaurant.delete";


    @Column(name = "votes",nullable = false)
    protected int votes;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "restaurant")
//    @JsonIgnore
    protected List<Dish> dishs;

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        this(r.id,r.name,r.votes);
    }

    public Restaurant(Integer id, String name, int votes) {
        super(id, name);
        this.votes = votes;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
                ", votes=" + votes +
                '}';
    }
}
