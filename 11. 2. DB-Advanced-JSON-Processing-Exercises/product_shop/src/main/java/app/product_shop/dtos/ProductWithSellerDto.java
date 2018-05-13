package app.product_shop.dtos;

import app.product_shop.entities.Product;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductWithSellerDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String sellerName;

    public ProductWithSellerDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.sellerName = product.getSeller().getLastName();
    }

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

    public String getSellerName() {
        return this.sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
