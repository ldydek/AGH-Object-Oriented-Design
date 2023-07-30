package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory implements OrderHistoryInterface {

    private final List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> findOrderByStrategy(SearchStrategy strategy) {
        return this.orders.stream()
                .filter(strategy::search)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
}
