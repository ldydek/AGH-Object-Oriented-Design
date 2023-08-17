package pl.edu.agh.dronka.shop.view;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertiesPanel extends JPanel {

    private static final long serialVersionUID = -2804446079853846996L;
    private final ShopController shopController;
    private final ItemFilter filter = new ItemFilter();

    public PropertiesPanel(ShopController shopController) {
        this.shopController = shopController;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void fillProperties() {
        removeAll();

        filter.getItemSpec().setCategory(shopController.getCurrentCategory());
        add(createPropertyCheckbox("Tanie bo polskie", event -> {
            filter.getItemSpec().setPolish(
                    ((JCheckBox) event.getSource()).isSelected());
            shopController.filterItems(filter);
        }));

        add(createPropertyCheckbox("Używany", event -> {
            filter.getItemSpec().setSecondhand(
                    ((JCheckBox) event.getSource()).isSelected());
            shopController.filterItems(filter);
        }));

    }

    private JCheckBox createPropertyCheckbox(String propertyName,
                                             ActionListener actionListener) {

        JCheckBox checkBox = new JCheckBox(propertyName);
        checkBox.setSelected(false);
        checkBox.addActionListener(actionListener);

        return checkBox;
    }

}
