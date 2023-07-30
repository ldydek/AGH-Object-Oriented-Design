package pl.edu.agh.internetshop;

public class ProductNameSearchStrategy implements SearchStrategy {

    private final String productName;

    public ProductNameSearchStrategy(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean search(Order order) {
        return order.getProducts().stream()
                .anyMatch(product -> product.getName().equals(productName));
    }
}
