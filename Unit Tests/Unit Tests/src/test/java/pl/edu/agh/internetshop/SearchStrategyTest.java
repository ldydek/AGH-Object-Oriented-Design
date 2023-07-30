package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SearchStrategyTest {

    @Test
    public void clientNameSearchStrategyTest() {
        // given
        String wantedClientName = "Kowalski";

        Address address1 = mock(Address.class);
        given(address1.getName()).willReturn(wantedClientName);
        Shipment shipment1 = mock(Shipment.class);
        given(shipment1.getRecipientAddress()).willReturn(address1);
        Order goodOrder = mock(Order.class);
        given(goodOrder.getShipment()).willReturn(shipment1);

        Address address2 = mock(Address.class);
        given(address2.getName()).willReturn("wrong name");
        Shipment shipment2 = mock(Shipment.class);
        given(shipment2.getRecipientAddress()).willReturn(address2);
        Order badOrder = mock(Order.class);
        given(badOrder.getShipment()).willReturn(shipment2);

        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy(wantedClientName);

        // when, then
        assertTrue(clientNameSearchStrategy.search(goodOrder));
        assertFalse(clientNameSearchStrategy.search(badOrder));
    }

    @Test
    public void priceSearchStrategyTest() {
        // given
        BigDecimal wantedPrice = new BigDecimal(2);

        Product product1 = mock(Product.class);
        given(product1.getPrice()).willReturn(wantedPrice);
        Order goodOrder = new Order(Collections.singletonList(product1));

        Product product2 = mock(Product.class);
        given(product2.getPrice()).willReturn(BigDecimal.valueOf(3.7));
        Order badOrder = new Order(Collections.singletonList(product2));

        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(wantedPrice);

        // when, then
        assertTrue(priceSearchStrategy.search(goodOrder));
        assertFalse(priceSearchStrategy.search(badOrder));
    }

    @Test
    public void productNameSearchStrategyTest() {
        // given
        String wantedProductName = "Piłka";

        Product product1 = mock(Product.class);
        given(product1.getName()).willReturn(wantedProductName);
        Order goodOrder = new Order(Collections.singletonList(product1));

        Product product2 = mock(Product.class);
        given(product2.getName()).willReturn("Pompka");
        Order badOrder = new Order(Collections.singletonList(product2));

        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy(wantedProductName);

        // when, then
        assertTrue(productNameSearchStrategy.search(goodOrder));
        assertFalse(productNameSearchStrategy.search(badOrder));
    }

    @Test
    public void compositeSearchStrategyTest() {
        // given
        String wantedProductName = "Piłka";
        BigDecimal wantedPrice = new BigDecimal(2);

        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy(wantedProductName);
        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(wantedPrice);
        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy();

        compositeSearchStrategy.addStrategy(priceSearchStrategy);
        compositeSearchStrategy.addStrategy(productNameSearchStrategy);

        Product product1 = mock(Product.class);
        given(product1.getName()).willReturn(wantedProductName);
        given(product1.getPrice()).willReturn(wantedPrice);
        Order goodOrder = new Order(Collections.singletonList(product1));

        Product product2 = mock(Product.class);
        given(product2.getName()).willReturn("wrong name");
        given(product2.getPrice()).willReturn(wantedPrice);
        Order badOrder1 = new Order(Collections.singletonList(product2));

        Product product3 = mock(Product.class);
        given(product3.getName()).willReturn(wantedProductName);
        given(product3.getPrice()).willReturn(BigDecimal.valueOf(3.7));
        Order badOrder2 = new Order(Collections.singletonList(product3));

        // when, then
        assertTrue(compositeSearchStrategy.search(goodOrder));
        assertFalse(compositeSearchStrategy.search(badOrder1));
        assertFalse(compositeSearchStrategy.search(badOrder2));
    }
}
