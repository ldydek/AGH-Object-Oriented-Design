package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class PriceSearchStrategy implements SearchStrategy {

    private final BigDecimal price;

    public PriceSearchStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean search(Order order) {
        return order.getPrice().equals(price);
    }
}
