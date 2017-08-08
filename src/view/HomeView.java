package view;


import contract.Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends BaseView implements Home.View {

    private JButton createItemButton;

    public HomeView() {
        super();
        createItemButton = new JButton("Criar conta");
        createItemButton.setBounds(75, 200, 150, 30);

        add(createItemButton);

        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window.create(new CreateItemView());
            }
        });
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
