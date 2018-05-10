package shampoo;

import label.BasicLabel;
import size.Size;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FiftyShades extends BasicShampoo {

    public static final String FIFTY_SHADES = "Fifty Shades";
    //public static final BasicLabel FIFTY_SHADES_LABEL = new BasicLabel("It’s made of Strawberry and Nettle");
    public static final BigDecimal PRICE = BigDecimal.valueOf(6.69);

    public FiftyShades( BasicLabel label) {
        super(FIFTY_SHADES, Size.SMALL, label, PRICE);
    }
}
