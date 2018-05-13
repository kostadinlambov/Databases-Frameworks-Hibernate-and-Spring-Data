package app.product_shop.dtos;

import com.google.gson.annotations.Expose;

public class CategoryDto {
    @Expose
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
