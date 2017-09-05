package view;

import contract.CreateAuction;
import model.pojo.Auction;
import model.pojo.Item;
import presenter.CreateAuctionPresenter;
import util.Global;
import util.Validate;
import view.component.InputField;
import view.component.SimpleButton;

//import model.pojo.Realty;

public class CreateAuctionView extends BaseView implements CreateAuction.View {

    private static final int CREATED_AUCTION_SENDER = 4;
    private InputField minPercentForNewBidsField;
    private InputField expirationTimeField;
    private SimpleButton submitButton;
    private SimpleButton createMiscButton;
    private SimpleButton createFluidButton;
    private SimpleButton createVehicleButton;
    private SimpleButton createRealtyButton;
    private CreateAuction.Presenter presenter;
    private Integer itemId;

    public CreateAuctionView() {
        super();
        
        minPercentForNewBidsField = new InputField("Diferença mínima entre lances (%)");
        minPercentForNewBidsField.setLocation(25, 20);
        minPercentForNewBidsField.setSize(300,50);
        minPercentForNewBidsField.textField.setSize(300,30);
        expirationTimeField = new InputField("Tempo máximo sem lances (min)");
        expirationTimeField.setLocation(25, 80);
        expirationTimeField.setSize(300,50);
        expirationTimeField.textField.setSize(300,30);
        
     
        createMiscButton = new SimpleButton("Criar Misc");
        createMiscButton.setBounds(25, 150, 140,30);
        createMiscButton.addActionListener(e -> {
            frame.createForResult(new CreateMiscView());
        });
        createFluidButton = new SimpleButton("Criar Fluido");
        createFluidButton.setBounds(185, 150, 140,30);
        createFluidButton.addActionListener(e -> {
            frame.createForResult(new CreateFluidView());
        });  
        createVehicleButton = new SimpleButton("Criar Veiculo");
        createVehicleButton.setBounds(25, 195, 140,30);
        createVehicleButton.addActionListener(e -> {
            frame.createForResult(new CreateVehicleView());
        });  
        createRealtyButton = new SimpleButton("Criar Imovel");
        createRealtyButton.setBounds(185, 195, 140,30);
        createRealtyButton.addActionListener(e -> {
            frame.createForResult(new CreateRealtyView());
        });  
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(100, 360);
        submitButton.addActionListener(e -> {
            String expirationTime = expirationTimeField.getText();
            String minPercentForNewBidsFields = minPercentForNewBidsField.getText();
            if (!Validate.integer(expirationTime).equals(Validate.OK)) {
                showErrorDialog("Insira números inteiros no campo de tempo para expiração");
            } else if (!Validate.integer(minPercentForNewBidsFields).equals(Validate.OK)) {
                showErrorDialog("Insira números inteiros no campo de diferença mínima entre lances");
            } else if (itemId == null) {
                showErrorDialog("Associe um item para este leilão");
            } else {
                presenter.createAuction(new Auction(Global.getCurrentUser().getId(),
                        Integer.valueOf(minPercentForNewBidsField.getText()),
                        Integer.valueOf(expirationTimeField.getText()) * 60000, itemId));
            }

        });
        
        add(minPercentForNewBidsField);
        add(expirationTimeField);
        add(createMiscButton);
        add(createFluidButton);
        add(createVehicleButton);
        add(createRealtyButton);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(350, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Criar Leilão");
        presenter = new CreateAuctionPresenter(this);
    }

    @Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        Item item = (Item) result;
        itemId = item.getId();
        frame.setTitle(item.getName());
    }

    @Override
    public void onCreateSuccess() {
        //frame.setResult(CREATED_AUCTION_SENDER, null);
    }
}
