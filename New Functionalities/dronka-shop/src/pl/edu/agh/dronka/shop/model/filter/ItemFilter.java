package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.items.*;

public class ItemFilter {

    private final Item itemSpec;

    public ItemFilter(Category category){
        switch (category) {
            case BOOKS -> itemSpec = new Book();
            case ELECTRONICS -> itemSpec = new Device();
            case FOOD -> itemSpec = new Food();
            case MUSIC -> itemSpec = new Music();
            case SPORT -> itemSpec = new Sport();
            default -> itemSpec = new Item();
        }
    }

    public Item getItemSpec() {
        return itemSpec;
    }

    public boolean appliesTo(Item item) {
        if (itemSpec.getName() != null
                && !itemSpec.getName().equals(item.getName())) {
            return false;
        }
        if (itemSpec.getCategory() != null
                && !itemSpec.getCategory().equals(item.getCategory())) {
            return false;
        }

        // applies filter only if the flag (secondHand) is true)
        if (itemSpec.isSecondhand() && !item.isSecondhand()) {
            return false;
        }

        // applies filter only if the flag (polish) is true)
        if (itemSpec.isPolish() && !item.isPolish()) {
            return false;
        }

        switch (item.getCategory()) {
            case BOOKS -> {
                if (((item instanceof Book) && (itemSpec instanceof Book)) && (((Book) itemSpec).isHardCover() && !((Book) item).isHardCover())) {
                    return false;
                }
            }
            case ELECTRONICS -> {
                if (((item instanceof Device) && (itemSpec instanceof Device)) && (((Device) itemSpec).isMobile() && !((Device) item).isMobile())) {
                    return false;
                }
                if (((item instanceof Device) && (itemSpec instanceof Device)) && (((Device) itemSpec).isWarranty() && !((Device) item).isWarranty())) {
                    return false;
                }
            }
            case MUSIC -> {
                if (((item instanceof Music) && (itemSpec instanceof Music)) && (((Music) itemSpec).isHasVideo() && !((Music) item).isHasVideo())) {
                    return false;
                }
            }
            case FOOD, SPORT -> {
                return false;
            }
        }
        return true;
    }
}