package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class Device extends Item {
    private boolean mobile;
    private boolean warranty;

    public Device(String name, Category category, int price, int quantity, boolean mobile, boolean warranty) {
        super(name, category, price, quantity);
        this.mobile = mobile;
        this.warranty = warranty;
    }

    public boolean isMobile() {
        return mobile;
    }

    public boolean isWarranty() {
        return warranty;
    }
}
