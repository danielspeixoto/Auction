package view;

import contract.Home;
import model.pojo.*;
import presenter.HomePresenter;
import util.Global;
import view.component.AuctionCellRenderer;
import view.component.ToolBarButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class HomeView extends BaseView implements Home.View {

    private static final int HOME_SENDER = 3;
    private JMenuBar menuBar;
    private JMenu mainMenu;
    private JMenu editMenu;
    private JMenu accountMenu;
    private JMenu auctionMenu;
    private JMenu helpMenu;
    private JMenuItem addValue;
    private JMenuItem editUser;
    private JMenuItem logOut;
    private JMenuItem createAuction;
    
    private JLabel programNameLabel;
    private JLabel accountValueLabel;
    private JLabel accountValueDescriptionLabel;
    private JLabel userName;
    private JPanel homeHeader;
    private JSeparator separator;

    private JToolBar toolBar;
    private ToolBarButton editToolBarButton;
    private ToolBarButton refreshButton;
    private ToolBarButton addValueToolBarButton;
    private ToolBarButton auctionToolBarButton;
    private ToolBarButton logoutToolBarButton;

    private JList list;
    private ArrayList<Auction> auctions = new ArrayList<>();

    private Home.Presenter presenter;
    
    public HomeView() {
        super();
        presenter = new HomePresenter(this);
        Double value;             
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(234, 234, 234));
        mainMenu = new JMenu("Arquivo");
        editMenu = new JMenu("Editar");
        accountMenu = new JMenu("Conta"); 
        auctionMenu = new JMenu("Leilão");
        helpMenu = new JMenu("Ajuda");
        addValue = new JMenuItem("Adicionar Valor");
        editUser = new JMenuItem("Editar Perfil");
        createAuction = new JMenuItem("Criar Leilão");
        logOut = new JMenuItem("Sair");
        
        menuBar.add(mainMenu);
        menuBar.add(editMenu);
        menuBar.add(accountMenu);
        menuBar.add(auctionMenu);
        menuBar.add(helpMenu);
        accountMenu.add(addValue);
        auctionMenu.add(createAuction);
        editMenu.add(editUser);
        mainMenu.add(logOut);
        
        toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 800, 35);
        toolBar.setBackground(new Color(234, 234, 234));   
        toolBar.setFloatable(false);
        toolBar.addSeparator();
        toolBar.add(auctionToolBarButton = new ToolBarButton("Criar Leilão","src//images//auction-icon.png"));
        toolBar.addSeparator();
        toolBar.add(addValueToolBarButton = new ToolBarButton("Injetar Valor","src//images//piggy-bank.png"));
        toolBar.addSeparator();
        toolBar.add(refreshButton = new ToolBarButton("Atualizar","src//images//nav_refresh.png"));
        toolBar.addSeparator();
        toolBar.add(editToolBarButton = new ToolBarButton("Editar Perfil","src//images//edit.png"));
        toolBar.addSeparator();
        toolBar.add(logoutToolBarButton = new ToolBarButton("Sair","src//images//exit.png"));

        userName = new JLabel("Olá, " + Global.getCurrentUser().getName().trim() + ". Encontre aqui o que procura!");
        userName.setForeground(Color.WHITE);
        userName.setBounds(20, 25, 480, 50);
        userName.setFont(new Font("Arial", Font.BOLD, 14)); 
        homeHeader = new JPanel();
        homeHeader.setBounds(0, 35, 800, 70);
        homeHeader.setBackground(Color.DARK_GRAY);
        homeHeader.setLayout(null);
        programNameLabel = new JLabel("Leilões & Cia");
        programNameLabel.setForeground(Color.WHITE);
        programNameLabel.setBounds(20, 5, 180, 50);
        programNameLabel.setFont(new Font("Arial", Font.PLAIN, 26)); 
        accountValueLabel = new JLabel("R$ "+ Double.toString((value = new Double(
                Global.getCurrentUser().getAccount().getBalance()))).format("%.2f",value));
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
        add(toolBar);

        list = new JList();
        list.setBounds(0, 105, 600, 0);
        list.setCellRenderer(new AuctionCellRenderer());
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Gerencia propriamente o tipo do item e manda para view específica
                AuctionView view;
                Auction auction = auctions.get(list.getSelectedIndex());
                Item item = auction.getItem();
                if(item instanceof Realty) {
                    view = new RealtyView();
                } else if(item instanceof Fluid) {
                    view = new FluidView();
                } else if(item instanceof Vehicle) {
                    view = new VehicleView();
                } else {
                    view = new MiscView();
                }
                frame.createForResult(view);
                view.setResult(HOME_SENDER, auction);
            }
        });
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(0, 105, 795, 447);
        add(scrollPane);
        presenter.syncAuctions();
        
        addValue.addActionListener(e -> {
			frame.createForResult(new InjectMoneyView());	
        });
        
        addValueToolBarButton.addActionListener(e -> {
			frame.createForResult(new InjectMoneyView());	
        });
        
        createAuction.addActionListener(e -> {
            frame.createForResult(new CreateAuctionView());
        });
        
        auctionToolBarButton.addActionListener(e -> {
            frame.createForResult(new CreateAuctionView());
        });

        refreshButton.addActionListener(e -> {
            presenter.syncAuctions();
        });
        
        logOut.addActionListener(e -> {	
			try {
				Global.logout();	
				close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
		});
        
        logoutToolBarButton.addActionListener(e -> {	
			try {
				Global.logout();	
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
		});
        
        editUser.addActionListener(e -> {
        	JOptionPane.showOptionDialog(null, "Não disponível!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null); 	
		});
        editToolBarButton.addActionListener(e -> {
        	JOptionPane.showOptionDialog(null, "Não disponível!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null);
		});
    }
   
    @Override
    public void setResult(int sender, Object result) {
    	super.setResult(sender, result);
        System.out.println(sender);
        presenter.syncAuctions();
    	if(sender == InjectMoneyView.INJECT_MONEY_SENDER) {
    	    accountValueLabel.setText("R$ "+ Double.toString((double) result).format("%.2f", result));
        }
    }

    @Override
    public void onReceiveAuction(Auction auction) {
        auctions.add(auction);
        list.setListData(auctions.toArray());
    }

    @Override
    public void clearAuctions() {
        auctions.clear();
        list.setListData(auctions.toArray());
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
