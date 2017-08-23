package view;

import contract.Home;
import util.Global;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class HomeView extends BaseView implements Home.View {

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
    private JLabel userName;
    private JPanel homeHeader;
    private JPanel auctionsList;
    private JSeparator separator;
  
    public HomeView() {
        super();
        
        Double value;
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(234, 234, 234));
        accountMenu = new JMenu("Conta");
        mainMenu = new JMenu("Menu");
        auctionMenu = new JMenu("Leilão");
        addValue = new JMenuItem("Adicionar Valor");
        editUser = new JMenuItem("Editar Perfil");
        createAuction = new JMenuItem("Criar Leilão");
        separator = new JSeparator();
        logOut = new JMenuItem("Sair");
        
        menuBar.add(mainMenu);
        menuBar.add(accountMenu);
        menuBar.add(auctionMenu);
        accountMenu.add(addValue);
        auctionMenu.add(createAuction);
        mainMenu.add(editUser);
        mainMenu.add(separator);
        mainMenu.add(logOut);
        
        userName = new JLabel("Olá, "+Global.getCurrentUser().getName().trim()+". Encontre aqui o que procura!");
        userName.setForeground(Color.WHITE);
        userName.setBounds(20, 25, 480, 50);
        userName.setFont(new Font("Arial", Font.BOLD, 14)); 
        homeHeader = new JPanel();
        homeHeader.setBounds(0, 0, 800, 70);
        homeHeader.setBackground(Color.DARK_GRAY);
        homeHeader.setLayout(null);
        programNameLabel = new JLabel("Leilões & Cia");
        programNameLabel.setForeground(Color.WHITE);
        programNameLabel.setBounds(20, 5, 180, 50);
        programNameLabel.setFont(new Font("Arial", Font.PLAIN, 26)); 
        accountValueLabel = new JLabel("R$ "+ Double.toString((value = new Double(Global.getCurrentUser().getAccount().getBalance()))).format("%.2f",value));
        accountValueLabel.setForeground(Color.WHITE);
        accountValueLabel.setBounds(630, 20, 170, 50);
        accountValueLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        accountValueDescriptionLabel = new JLabel("Saldo Atual");
        accountValueDescriptionLabel.setForeground(Color.WHITE);
        accountValueDescriptionLabel.setBounds(630, 5, 170, 30);
        accountValueDescriptionLabel.setFont(new Font("Arial", Font.BOLD, 14));
            
        homeHeader.add(programNameLabel);
        homeHeader.add(userName);
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
				frame.createForResult(new InjectMoneyView());
			}
        });
        
        createAuction.addActionListener(e -> {
            frame.createForResult(new CreateAuctionView());
        });
        
        logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)  {	
				try {
					Global.logout();	
					close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
			}
		});
        
        editUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Função disponível apenas para assinantes da versão Premium do Leilões & Cia.Inc", "Aviso", JOptionPane.ERROR_MESSAGE);
			}
		});
    }
   
    @Override
    public void setResult(Object result) {	
    	super.setResult(result);
    	accountValueLabel.setText("R$ "+Double.toString((double) result).format("%.2f", result));
    }
    
    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.fillScreen();
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tela Inicial");
        frame.setJMenuBar(menuBar);
    }
}
