package ru.demianko.restaurants.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.demianko.restaurants.model.Dish;


import java.util.List;

/**
 * Created by Dmitriy on 21.02.2017.
 */
@Transactional(readOnly = true)
public interface ProxyDishRepository extends JpaRepository<Dish,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Dish save(Dish item);

    @Query("SELECT d FROM Dish d WHERE d.id=:id")
    Dish get(@Param("id") int id);

/*    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId ORDER BY d.price DESC")
    List<Dish> getAll(@Param("restaurantId") int restaurantId);*/

    @Query("SELECT d FROM Dish d ORDER BY d.price DESC")
    List<Dish> getAll();

    @Override
    Dish findOne(Integer integer);


/*    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.id = ?1 and d.restaurant.id = ?2")
    Dish getWithRestaurant(Integer id, Integer restaurantId);*/
}
