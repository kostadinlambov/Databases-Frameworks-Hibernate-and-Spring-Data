package shampoo;

import label.BasicLabel;
import size.Size;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FreshNuke extends BasicShampoo {

    public static final String FRESH_NUKE = "Fresh Nuke";
    public static final String FRESH_NUKE_LABEL = "It’s made of Mint, Nettle and Ammonium Chloride";
   // public static final BasicLabel BASIC_LABEL = new BasicLabel(FRESH_NUKE_LABEL);
    public static final BigDecimal PRICE = BigDecimal.valueOf(9.33);

    public FreshNuke(BasicLabel label) {
        super(FRESH_NUKE, Size.LARGE, label, PRICE);
    }
}
