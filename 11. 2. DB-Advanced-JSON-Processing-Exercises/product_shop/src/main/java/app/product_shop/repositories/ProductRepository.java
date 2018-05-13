package app.product_shop.repositories;

import app.product_shop.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal from , BigDecimal to);
}
