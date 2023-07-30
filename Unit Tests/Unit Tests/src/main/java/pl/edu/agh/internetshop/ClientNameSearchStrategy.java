package pl.edu.agh.internetshop;

public class ClientNameSearchStrategy implements SearchStrategy {

    private final String clientName;

    public ClientNameSearchStrategy(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean search(Order order) {
        Shipment shipment = order.getShipment();
        Address recipientAddress = shipment.getRecipientAddress();
        String name = recipientAddress.getName();
        return order.getShipment().getRecipientAddress().getName().equals(clientName);
    }
}
