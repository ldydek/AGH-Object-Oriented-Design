package pl.edu.agh.internetshop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderHistoryTest {

    private static final String customerName1 = "Adam Smith";
    private static final String customerName2 = "Adam Nowak";

    private static final BigDecimal productPrice1 = BigDecimal.valueOf(1.2);
    private static final BigDecimal productPrice2 = BigDecimal.valueOf(1.9);

    private static final String productName1 = "Milk";
    private static final String productName2 = "Apple";

    private static Order order1;
    private static Order order2;

    @BeforeAll
    static void addMockOrders() {

        Product product1 = new Product(productName1, productPrice1, new Discount(new BigDecimal(0)));
        Product product2 = new Product(productName2, productPrice2, new Discount(new BigDecimal(0)));

        List<Product> list1 = new ArrayList<>(Arrays.asList(product1, product1, product2));
        List<Product> list2 = new ArrayList<>(Arrays.asList(product1, product1));

        order1 = new Order(list1);
        order2 = new Order(list2);

        Address address1 = mock(Address.class);
        given(address1.getName()).willReturn(customerName1);

        Address address2 = mock(Address.class);
        given(address2.getName()).willReturn(customerName2);

        Shipment shipment1 = mock(Shipment.class);
        given(shipment1.getRecipientAddress()).willReturn(address1);

        Shipment shipment2 = mock(Shipment.class);
        given(shipment2.getRecipientAddress()).willReturn(address2);

        order1.setShipment(shipment1);
        order2.setShipment(shipment2);
    }

    @Test
    public void addAndGetOrderTest() {
        // given
        OrderHistory orderHistory = new OrderHistory();
        Order order = mock(Order.class);

        // when
        orderHistory.addOrder(order);
        Order order1 = orderHistory.getOrders().get(0);

        // then
        assertSame(order, order1);
    }

    @Test
    public void testClientNameSearch() {
        // given
        ClientNameSearchStrategy searchStrategy = new ClientNameSearchStrategy(customerName1);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        List<Order> actualOrders = orderHistory.findOrderByStrategy(searchStrategy);

        // then
        assertEquals(1, actualOrders.size());
        assertEquals(order1, actualOrders.get(0));
    }

    @Test
    public void testProductPriceSearch1() {
        // given
        BigDecimal expectedPrice = BigDecimal.valueOf(1.4);
        PriceSearchStrategy searchStrategy = new PriceSearchStrategy(expectedPrice);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        List<Order> actualOrders = orderHistory.findOrderByStrategy(searchStrategy);

        // then
        assertEquals(0, actualOrders.size());
    }

    @Test
    public void testProductPriceSearch2() {
        // given
        BigDecimal expectedPrice = order1.getPrice();
        PriceSearchStrategy searchStrategy = new PriceSearchStrategy(expectedPrice);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        List<Order> actualOrders = orderHistory.findOrderByStrategy(searchStrategy);

        // then
        assertEquals(1, actualOrders.size());
        assertEquals(order1, actualOrders.get(0));
    }

    @Test
    public void testProductNameSearch() {
        // given
        ProductNameSearchStrategy searchStrategy = new ProductNameSearchStrategy(productName2);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        List<Order> actualOrders = orderHistory.findOrderByStrategy(searchStrategy);

        // then
        assertEquals(1, actualOrders.size());
        assertEquals(order1, actualOrders.get(0));
    }

    @Test
    public void testCompositeSearch1() {
        // given
        ProductNameSearchStrategy productSearchStrategy = new ProductNameSearchStrategy(productName2);
        ClientNameSearchStrategy clientSearchStrategy = new ClientNameSearchStrategy(customerName1);
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();

        searchStrategy.addStrategy(productSearchStrategy);
        searchStrategy.addStrategy(clientSearchStrategy);

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        List<Order> actualOrders = orderHistory.findOrderByStrategy(searchStrategy);

        // then
        assertEquals(1, actualOrders.size());
        assertEquals(order1, actualOrders.get(0));
    }

    @Test
    public void testCompositeSearch2() {
        // given
        ProductNameSearchStrategy productSearchStrategy = new ProductNameSearchStrategy(productName2);
        ClientNameSearchStrategy clientSearchStrategy = new ClientNameSearchStrategy(customerName2);
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();

        searchStrategy.addStrategy(productSearchStrategy);
        searchStrategy.addStrategy(clientSearchStrategy);

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        List<Order> actualOrders = orderHistory.findOrderByStrategy(searchStrategy);

        // then
        assertEquals(0, actualOrders.size());
    }
}
