package shampoo;

import batch.ProductionBatch;
import ingrediant.Basic.BasicIngredient;
import label.BasicLabel;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {

    public long getId();

    public void setId(long id);

    public String getBrand();

    public void setBrand(String brand);

    public BasicLabel getLabel();

    public void setLabel(BasicLabel label);

    public ProductionBatch getBatch();

    public void setBatch(ProductionBatch batch);

    public BigDecimal getPrice();

    public void setPrice(BigDecimal price);

//    public size.Size getSize();
//
//    public void setSize(size.Size size);

    public Set<BasicIngredient> getIngredients();

    public void setIngredients(Set<BasicIngredient> ingredients);
}
