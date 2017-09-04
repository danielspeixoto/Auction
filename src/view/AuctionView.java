package view;

import model.pojo.Auction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AuctionView extends BaseView {

    protected JButton buyButton;
    protected Auction auction;

    public AuctionView() {
        buyButton = new JButton("Comprar");
        buyButton.setBounds(20, 20, 100, 100);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(buyButton);
    }

    @Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        auction = (Auction) result;
        frame.setTitle(auction.getItem().getName());
    }
}
