package view;

import model.pojo.Item;

import javax.swing.*;

public class ItemView extends BaseView {

    private JButton buyButton;

    public ItemView() {
        buyButton = new JButton("Comprar");
        buyButton.setBounds(20, 20, 100, 100);
        add(buyButton);
    }

    @Override
    public void setResult(Object result) {
        super.setResult(result);
        Item item = (Item) result;
        frame.setTitle(item.getDescription());
    }
}
