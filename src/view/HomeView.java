package view;

import contract.Home;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeView extends BaseView implements Home.View {

    private JButton createItemButton;
    private JMenuBar menuBar;
    private JMenu accountMenu;
    private JMenu mainMenu;
    private JMenu auctionMenu;
    private JMenuItem addValue;
    private JMenuItem editUser;
    private JMenuItem logOut;
    private JMenuItem createAuction;
    
    private JLabel programNameLabel;
    private JLabel accountValueLabel;
    private JLabel accountValueDescriptionLabel;
    private JLabel programValue;
    private JPanel homeHeader;
    private JPanel auctionsList;
    
    private JButton createAuctionButton;

    public HomeView() {
        super();
        
        createAuctionButton = new JButton("Criar leilÃ£o");
        createAuctionButton.setBounds(20, 20, 50, 50);
        createAuctionButton.addActionListener(e -> {
            frame.createForResult(new CreateAuctionView());
        });
        add(createAuctionButton);
        
        menuBar = new JMenuBar();
        accountMenu = new JMenu("Conta");
        mainMenu = new JMenu("Menu");
        auctionMenu = new JMenu("Leilão");
        addValue = new JMenuItem("Adicionar Valor");
        editUser = new JMenuItem("Editar Perfil");
        createAuction = new JMenuItem("Criar Leilão");
        logOut = new JMenuItem("Sair");
        
        menuBar.add(mainMenu);
        menuBar.add(accountMenu);
        menuBar.add(auctionMenu);
        accountMenu.add(addValue);
        auctionMenu.add(createAuction);
        mainMenu.add(editUser);
        mainMenu.add(logOut);
        
        homeHeader = new JPanel();
        homeHeader.setBounds(0, 0, 800, 70);
        homeHeader.setBackground(Color.DARK_GRAY);
        homeHeader.setLayout(null);
        programNameLabel = new JLabel("Leilões & Cia");
        programNameLabel.setForeground(Color.WHITE);
        programNameLabel.setBounds(20, 10, 180, 50);
        programNameLabel.setFont(new Font("Dialog", Font.PLAIN, 26));
        accountValueLabel = new JLabel("R$ 0.00");
        accountValueLabel.setForeground(Color.WHITE);
        accountValueLabel.setBounds(650, 20, 150, 50);
        accountValueLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        accountValueDescriptionLabel = new JLabel("Saldo Atual");
        accountValueDescriptionLabel.setForeground(Color.WHITE);
        accountValueDescriptionLabel.setBounds(650, 0, 150, 30);
        accountValueDescriptionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
            
        homeHeader.add(programNameLabel);
        homeHeader.add(accountValueLabel);
        homeHeader.add(accountValueDescriptionLabel);
        add(homeHeader);
        
        auctionsList = new JPanel();
        auctionsList.setBounds(0, 70, 800, 530);
        auctionsList.setBackground(new Color(234,234,234));
        auctionsList.setLayout(new GridLayout());
        
        add(auctionsList);
        
        addValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.create(new InjectMoneyView());
			}
        });
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.fillScreen();
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setTitle("Tela Inicial");
        frame.setJMenuBar(menuBar);
    }
}
