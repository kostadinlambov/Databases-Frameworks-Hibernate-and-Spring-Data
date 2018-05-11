package app.model.repositories;

import app.model.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface IngredientRepository extends CrudRepository<BasicIngredient, Long> {

    List<BasicIngredient> findByNameIn(List<String> names);

    @Transactional
    void deleteByName(String name);

//    @Modifying
//    void customDelete(String name);
}
