package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Discount {

    private final BigDecimal discountValue;
    public Discount(BigDecimal discountValue) {
        this.discountValue = discountValue;
        if((this.discountValue.compareTo(new BigDecimal(0)) < 0) ||
                (new BigDecimal(1).compareTo(this.discountValue)) < 0) {
            throw new IllegalArgumentException("Discount value has to be in range from 0 to 1, but was: " + this.discountValue);
        }
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public BigDecimal applyDiscount(BigDecimal price) {
        BigDecimal valueToMultiply = new BigDecimal(1).subtract(this.getDiscountValue());
        return price.multiply(valueToMultiply);
    }
}
