package view;

import contract.Bid;
import model.pojo.Auction;
import model.pojo.Item;
import presenter.BidPresenter;
import util.BackgroundTask;
import util.Validate;
import view.component.InputField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public abstract class BidView extends BaseView implements Bid.View {

    protected JButton buyButton;
    protected InputField valueField;
    protected JLabel timeLeftLabel;
    protected JLabel minValueLabel;
    protected Auction auction;

    private int backTaskIndex = -1;

    protected Bid.Presenter presenter;

    public static final int BID_SENDER = 7;

    public BidView() {
        presenter = new BidPresenter(this);
        timeLeftLabel = new JLabel();
        timeLeftLabel.setBounds(20, 500, 100, 100);
        add(timeLeftLabel);
        minValueLabel = new JLabel();
        minValueLabel.setBounds(20, 300, 700, 100);
        add(minValueLabel);
        valueField = new InputField("Coloque o valor aqui");
        valueField.setLocation(20, 150);
        add(valueField);
        buyButton = new JButton("Comprar");
        buyButton.setBounds(20, 20, 700, 100);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Validate.numeric(valueField.getText()).equals(Validate.OK)) {
                    showErrorDialog("Formato colocado no valor não é válido");
                } else {
                    presenter.bid(auction, Double.parseDouble(valueField.getText()));
                }
            }
        });
        add(buyButton);
    }


    @Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        auction = (Auction) result;
        Item item = auction.getItem();
        frame.setTitle(item.getName());
        update();
    }

    public void updateTimer(long left) {
        if(left >= 0) {
            int hours = (int) left/3600;
            int minutes = (int) (left/60) % 60;
            int seconds = (int) left % 60;
            timeLeftLabel.setText(hours + ":" + minutes + ":" + seconds);
        }
    }

    @Override
    public void onBidSuccess(Auction auction) {
        this.auction = auction;
        if(backTaskIndex != -1) {
            BackgroundTask.removeSubscriber(backTaskIndex);
        }
        update();
        frame.setResult(BID_SENDER, auction);
    }

    private void update() {
        DecimalFormat df = new DecimalFormat("0.00");
        minValueLabel.setText("O último valor inserido foi de : R$" + df.format(auction.getLastBid()) +
                ", para um novo lance, o valor deve ser de: R$" +  df.format(auction.getNextBidMin()) + " ou mais");

        if(auction.getLastBidderId() != -1 && auction.getRemainingTime() > 0) {
            backTaskIndex = BackgroundTask.addSubscriber(new Runnable() {

                long left = auction.getRemainingTime() / 1000;

                @Override
                public void run() {
                    updateTimer(--left);
                }
            });
        }
    }
}
