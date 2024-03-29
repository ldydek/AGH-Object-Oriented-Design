package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class Book extends Item {

    private int pageNumber;
    private boolean hardCover;

    public Book(String name, Category category, int price, int quantity, int pageNumber, boolean hardCover) {
        super(name, category, price, quantity);
        this.pageNumber = pageNumber;
        this.hardCover = hardCover;
    }

    public Book() { }

    public int getPageNumber() {
        return pageNumber;
    }

    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }
}