package view;


import contract.Home;

import javax.swing.*;

public class HomeView extends BaseView implements Home.View {

    private JButton createItemButton;

    public HomeView() {
        super();
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
