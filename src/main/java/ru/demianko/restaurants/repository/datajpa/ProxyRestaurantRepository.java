package ru.demianko.restaurants.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.demianko.restaurants.model.Restaurant;


import java.util.List;

/**
 * Created by Dmitriy on 21.02.2017.
 */

@Transactional(readOnly = true)
public interface ProxyRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant restaurant);

    @Override
    Restaurant findOne(Integer id);

    @Override
    List<Restaurant> findAll();

/*    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.dishs WHERE r.id = ?1")
    Restaurant getWithMeals(Integer id);*/
}

