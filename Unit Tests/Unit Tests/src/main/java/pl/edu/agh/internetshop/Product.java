package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private BigDecimal price;
    private final Discount discount;

    public Product(String name, BigDecimal price, Discount discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void applyDiscount() {
        this.price = this.discount.applyDiscount(this.price);
    }
}
