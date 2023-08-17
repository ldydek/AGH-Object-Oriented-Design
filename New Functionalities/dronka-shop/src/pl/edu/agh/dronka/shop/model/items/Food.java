package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

import java.util.Date;

public class Food extends Item {

    private final Date eatByDate;

    public Food(String name, Category category, int price, int quantity, Date eatByDate) {
        super(name, category, price, quantity);
        this.eatByDate = eatByDate;
    }

    public Date getEatByDate() {
        return eatByDate;
    }
}
