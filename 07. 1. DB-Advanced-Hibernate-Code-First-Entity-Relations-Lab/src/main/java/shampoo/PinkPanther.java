package shampoo;

import label.BasicLabel;
import size.Size;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PinkPanther extends BasicShampoo {

    public static final String PINK_PANTHER = "Pink Panter";
   // public static final BasicLabel PINK_PANTHER_LABEL = new BasicLabel("It’s made of Lavender and Nettle");
    public static final BigDecimal PRICE = BigDecimal.valueOf(8.50);

    public PinkPanther(BasicLabel label) {
        super(PINK_PANTHER, Size.MEDIUM, label, PRICE);
    }
}
