package view;

import contract.Bid;
import model.pojo.Auction;
import model.pojo.Item;
import presenter.BidPresenter;
import util.BackgroundTask;
import util.Validate;
import view.component.InputField;
import view.component.SimpleButton;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public abstract class BidView extends BaseView implements Bid.View {

    protected SimpleButton buyButton;
    protected InputField valueField;
    protected JLabel timeLeftLabel;
    protected JLabel timeLeftLabelDescription;
    protected JLabel infoLabel;
    protected JTextArea infoTextArea;
    protected JTextArea minValueTextArea;
    protected Auction auction;
    protected Item item;

    private int backTaskIndex = -1;

    protected Bid.Presenter presenter;

    public static final int BID_SENDER = 7;

    public BidView() {
        presenter = new BidPresenter(this);
        infoLabel = new JLabel();
        timeLeftLabel = new JLabel();
        timeLeftLabelDescription = new JLabel();
        minValueTextArea = new JTextArea();
        valueField = new InputField("Faça um lance para este produto (R$)");
        buyButton = new SimpleButton("Comprar");
        infoTextArea = new JTextArea();
    }


    @Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        auction = (Auction) result;
        item = auction.getItem();
        if(auction.getRemainingTime() > 0) {
        	valueField.setLocation(25, 20);
            valueField.setSize(300,50);
            valueField.textField.setSize(300,30);
            add(valueField);
        	
            minValueTextArea.setLineWrap(true);
            minValueTextArea.setWrapStyleWord(true);
            minValueTextArea.setEditable(false);
            minValueTextArea.setFocusable(false);
            minValueTextArea.setBounds(25, 80, 300, 50);
            minValueTextArea.setBackground(frame.getBackground());
            add(minValueTextArea);
            
            infoLabel.setBounds(25, 130, 150, 50);
            infoLabel.setText("Informações Gerais");
            add(infoLabel);
            
            infoTextArea.setLineWrap(true);
    		infoTextArea.setWrapStyleWord(true);
    		infoTextArea.setEditable(false);
    		infoTextArea.setFocusable(false);
    		infoTextArea.setBounds(25, 165, 300, 100);
    		infoTextArea.setBackground(frame.getBackground());
    		add(infoTextArea);
    		
    		timeLeftLabel.setBounds(100, 280, 140, 50);
            timeLeftLabel.setFont(new Font("Arial", Font.PLAIN, 32));
            add(timeLeftLabel);
            
            timeLeftLabelDescription.setBounds(180, 280, 200, 100);
            timeLeftLabelDescription.setFont(new Font("Dialog", Font.ITALIC, 12));
            add(timeLeftLabelDescription);
            
            buyButton.setBounds(25, 360, 300, 30);
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
        frame.setTitle(item.getName());
        update();
    }

    public void updateTimer(long left) {
        if(left >= 0) {
            int hours = (int) left/3600;
            int minutes = (int) (left/60) % 60;
            int seconds = (int) left % 60;
            String hoursStr = String.format("%02d", hours);
            String minutesStr = String.format("%02d", minutes);
            String secondsStr = String.format("%02d", seconds);
            timeLeftLabel.setText(hoursStr + ":" + minutesStr + ":" + secondsStr); 
            timeLeftLabelDescription.setText("time left");
        } else {
            buyButton.setVisible(false);
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
        minValueTextArea.setText("O último lance realizado foi de R$" + df.format(auction.getLastBid()) +
                ". Para um novo lance, o valor deve ser de no mínimo R$" +  df.format(auction.getNextBidMin()) + " ou mais.");
        
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
    
    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.fillScreen();
        frame.setSize(350, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
