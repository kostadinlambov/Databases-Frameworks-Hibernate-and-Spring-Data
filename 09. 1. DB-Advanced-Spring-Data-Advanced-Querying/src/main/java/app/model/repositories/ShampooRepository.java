package app.model.repositories;

import app.model.enums.Size;
import app.model.ingredients.Ingredient;
import app.model.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ShampooRepository extends JpaRepository<BasicShampoo, Long> {

    List<BasicShampoo> findBySizeOrderByBrand(Size size);

    Long countByPriceLessThan(BigDecimal price);

    //Find by List from Objects(Ingredients)
    @Query("SELECT i.shampoos FROM BasicIngredient AS i " +
            "where  i IN :ingredients")
    List<BasicShampoo> findByHavingIngredients(@Param("ingredients") List<? extends Ingredient> ingredients);

    //Find by List from Ids
    @Query("SELECT i.shampoos FROM BasicIngredient AS i " +
            "where i.id IN (:ingredientIds)")
    List<BasicShampoo> findByHavingIngredientIds(@Param("ingredientIds") List<Long> ingredients);
}
