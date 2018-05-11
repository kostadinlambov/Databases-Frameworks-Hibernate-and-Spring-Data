package app;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.repositories.IngredientRepository;
import app.model.repositories.ShampooRepository;
import app.model.shampoos.BasicShampoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {

    private ShampooRepository shampooRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public ConsoleRunner(ShampooRepository shampooRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BasicIngredient apple = ingredientRepository.findOne(1L);

        //##Problem 1: Select Shampoos by Size
        List<BasicShampoo> bySize = this.shampooRepository.findBySizeOrderByBrand(Size.MEDIUM);

        for (BasicShampoo shampoo : bySize) {
            System.out.println(shampoo.getBrand());
        }


        //##Problem 5: Select Ingredients by Names
        ArrayList<String> names = new ArrayList<>();

        names.add("Apple");
        names.add("Nettle");
        names.add("asd");
        names.add("Aloe Vera");

        List<BasicIngredient> byNameIn = this.ingredientRepository.findByNameIn(names);

        for (BasicIngredient basicIngredient : byNameIn) {
            System.out.println(basicIngredient.getName());
        }

        //##Problem 6: Count Shampoos by Price

        Long aLong = this.shampooRepository.countByPriceLessThan(new BigDecimal(8.50));
        System.out.println("Count: " + aLong);

        //Problem 7. Select Shampoos by Ingredients
        //##Find Shampoo by Ingredient Oblect
        List<BasicIngredient> basicIngredients = Collections.singletonList(apple);

        List<BasicShampoo> byIngredient = this.shampooRepository.findByHavingIngredients(basicIngredients);

        for (BasicShampoo shampoo : byIngredient) {
            System.out.println(shampoo.getBrand());
        }

        //##Find Shampoo By IngredientId
        List<BasicShampoo> byIngredientId =
                this.shampooRepository.findByHavingIngredientIds(Collections.singletonList(1L));

        for (BasicShampoo shampoo : byIngredientId) {
            System.out.println(shampoo.getBrand());
        }

        //Problem 10. Delete Ingredients by name
//        this.ingredientRepository.deleteByName("Wild Rose");
    }
}
