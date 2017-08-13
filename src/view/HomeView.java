package view;


import contract.Home;

import javax.swing.*;

public class HomeView extends BaseView implements Home.View {

    private JButton createAuctionButton;

    public HomeView() {
        super();
        createAuctionButton = new JButton("Criar leilão");
        createAuctionButton.setBounds(20, 20, 50, 50);
        createAuctionButton.addActionListener(e -> {
            frame.createForResult(new CreateAuctionView());
        });
        add(createAuctionButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.fillScreen();
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setTitle("Tela Inicial");
    }
}
