package pl.edu.agh.internetshop;

import java.util.List;

public interface OrderHistoryInterface {
    void addOrder(Order order);
    List<Order> findOrderByStrategy(SearchStrategy strategy);
    List<Order> getOrders();
}
