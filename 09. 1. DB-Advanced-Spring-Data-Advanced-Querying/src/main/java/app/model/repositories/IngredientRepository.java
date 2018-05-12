package app.model.repositories;

import app.model.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface IngredientRepository extends CrudRepository<BasicIngredient, Long> {

    List<BasicIngredient> findByNameIn(List<String> names);

    @Transactional
    void deleteByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE BasicIngredient AS bi SET bi.price = bi.price*0.1 + bi.price" +
            " where  bi.name IN :names")
    void updatePriceForNames(@Param("names")ArrayList<String> names);

    @Transactional
    @Modifying
    @Query("UPDATE BasicIngredient AS bi SET bi.price= bi.price*0.2 + bi.price")
    void updateAllPrices();




//    @Modifying
//    void customDelete(String name);
}
