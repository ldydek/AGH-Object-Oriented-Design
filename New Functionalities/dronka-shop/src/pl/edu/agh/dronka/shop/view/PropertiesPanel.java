package pl.edu.agh.dronka.shop.view;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;
import pl.edu.agh.dronka.shop.model.items.Book;
import pl.edu.agh.dronka.shop.model.items.Device;
import pl.edu.agh.dronka.shop.model.items.Item;
import pl.edu.agh.dronka.shop.model.items.Music;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PropertiesPanel extends JPanel {

    private static final long serialVersionUID = -2804446079853846996L;
    private final ShopController shopController;
    private ItemFilter filter;

    public PropertiesPanel(ShopController shopController) {
        this.shopController = shopController;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void fillProperties() {
        removeAll();
        this.filter = new ItemFilter( shopController.getCurrentCategory());

        filter.getItemSpec().setCategory(shopController.getCurrentCategory());

        add(createPropertyCheckbox("Tanie bo polskie", event -> {
            filter.getItemSpec().setPolish(((JCheckBox) event.getSource()).isSelected());
            shopController.filterItems(filter);
        }));

        add(createPropertyCheckbox("Używany", event -> {
            filter.getItemSpec().setSecondhand(((JCheckBox) event.getSource()).isSelected());
            shopController.filterItems(filter);
        }));


        Item item = filter.getItemSpec();

        switch (shopController.getCurrentCategory()) {
            case BOOKS -> add(createPropertyCheckbox("Twarda okładka", event -> {
                if (!(item instanceof Book)) return;
                ((Book) item).setHardCover(((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }));
            case ELECTRONICS -> {
                add(createPropertyCheckbox("Mobilny", event -> {
                    if (!(item instanceof Device)) return;
                    ((Device) item).setMobile(((JCheckBox) event.getSource()).isSelected());
                    shopController.filterItems(filter);
                }));
                add(createPropertyCheckbox("Gwarancja", event -> {
                    ((Device) item).setWarranty(((JCheckBox) event.getSource()).isSelected());
                    shopController.filterItems(filter);
                }));
            }
            case MUSIC -> add(createPropertyCheckbox("Wideo", event -> {
                if (!(item instanceof Music)) return;
                ((Music) item).setVideo(((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }));
        }
    }

    private JCheckBox createPropertyCheckbox(String propertyName,
                                             ActionListener actionListener) {
        JCheckBox checkBox = new JCheckBox(propertyName);
        checkBox.setSelected(false);
        checkBox.addActionListener(actionListener);

        return checkBox;
    }

}
