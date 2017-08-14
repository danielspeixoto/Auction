package view;


import contract.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeView extends BaseView implements Home.View {

    private JButton createItemButton;
    private JMenuBar menuBar;
    private JMenu accountMenu;
    private JMenu mainMenu;
    private JMenuItem addValue;

    public HomeView() {
        super();
        
        menuBar = new JMenuBar();
        accountMenu = new JMenu("Conta");
        mainMenu = new JMenu("Menu");
        addValue = new JMenuItem("Adicionar Valor");
        menuBar.add(mainMenu);
        menuBar.add(accountMenu);
        accountMenu.add(addValue);
        
        addValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Em implementação");
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
        frame.setJMenuBar(menuBar);
    }
}
