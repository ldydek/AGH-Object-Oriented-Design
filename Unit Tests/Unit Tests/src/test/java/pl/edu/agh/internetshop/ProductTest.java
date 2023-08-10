package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;

public class ProductTest {

    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

    @Test
    public void testProductName() throws Exception {
        //given

        // when
        Product product = new Product(NAME, PRICE, new Discount(new BigDecimal("0.5")));

        // then
        assertEquals(NAME, product.getName());
    }

    @Test
    public void testProductPrice() throws Exception {
        //given

        // when
        Product product = new Product(NAME, PRICE, new Discount(new BigDecimal("0.5")));

        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testProductDiscount() {
        // given
        Product product = new Product(NAME, PRICE, new Discount(new BigDecimal("0.5")));

        // when
        product.applyDiscount();
        BigDecimal discountedPrice = product.getPrice();

        // then
        assertBigDecimalCompareValue(BigDecimal.valueOf(0.5), discountedPrice);
    }

    @Test
    public void testProductWithFullDiscount() {
        // given
        Product product = new Product(NAME, PRICE, new Discount(new BigDecimal(1)));

        // when
        product.applyDiscount();
        BigDecimal discountedPrice = product.getPrice();

        // then
        assertBigDecimalCompareValue(BigDecimal.valueOf(0), discountedPrice);
    }

    @Test
    public void testProductWithoutDiscount() {
        // given
        Product product = new Product(NAME, PRICE, new Discount(new BigDecimal(0)));

        // when
        product.applyDiscount();
        BigDecimal discountedPrice = product.getPrice();

        // then
        assertBigDecimalCompareValue(PRICE, discountedPrice);
    }

    @Test
    public void testProductWithTooBigDiscount() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, PRICE, new Discount(new BigDecimal(2))));
    }

    @Test
    public void testProductWithTooSmallDiscount() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, PRICE, new Discount(new BigDecimal(-1))));
    }
}