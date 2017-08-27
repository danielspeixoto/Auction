package view.component;

import model.pojo.Item;

import javax.swing.*;
import java.awt.*;

public class ItemCellRenderer extends JPanel implements ListCellRenderer<Item> {

    private JLabel nameText;

    // A parte visual de cada item da lista deve ser definida aqui
    public ItemCellRenderer() {
        nameText = new JLabel();
        add(nameText);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        nameText.setText(value.getDescription());
        return this;
    }
}
