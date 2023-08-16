package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.items.*;

public class PropertiesHelper {

    public static Map<String, Object> getPropertiesMap(Item item) {
        Map<String, Object> propertiesMap = new LinkedHashMap<>();

        propertiesMap.put("Nazwa", item.getName());
        propertiesMap.put("Cena", item.getPrice());
        propertiesMap.put("Kategoria", item.getCategory().getDisplayName());
        propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
        propertiesMap.put("Tanie bo polskie", item.isPolish());
        propertiesMap.put("Używany", item.isSecondhand());

        if (item instanceof Book) {
            propertiesMap.put("Liczba stron", ((Book) item).getPageNumber());
            propertiesMap.put("Twarda oprawa", ((Book) item).isHardCover());
        } else if (item instanceof Device) {
            propertiesMap.put("Mobilny", ((Device) item).isMobile());
            propertiesMap.put("Gwarancja", ((Device) item).isWarranty());
        } else if (item instanceof Food) {
            propertiesMap.put("Data przydatności", ((Food) item).getEatByDate());
        } else if (item instanceof Music) {
            propertiesMap.put("Gatunek muzyczny", ((Music) item).getGenre());
            propertiesMap.put("Czy ma wideo", ((Music) item).isHasVideo());
        }

        return propertiesMap;
    }
}
