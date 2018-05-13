package app.product_shop.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

public class ProductDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
