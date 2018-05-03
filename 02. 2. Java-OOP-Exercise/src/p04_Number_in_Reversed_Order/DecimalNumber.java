package p04_Number_in_Reversed_Order;

import java.math.BigDecimal;

public class DecimalNumber {

    private BigDecimal number;

    public DecimalNumber(BigDecimal number) {
        this.setNumber(number);
    }

    public BigDecimal getNumber() {
        return this.number;
    }

    private void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal reverseNum(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.number).reverse();

        return new BigDecimal(sb.toString());
    }

}
