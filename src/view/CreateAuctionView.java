package view;

import contract.CreateAuction;
import model.pojo.Auction;
import model.pojo.Item;
import model.pojo.Misc;
import model.pojo.Fluid;
import model.pojo.Vehicle;
//import model.pojo.Realty;
import presenter.CreateAuctionPresenter;
import util.Global;
import util.Validate;
import view.component.InputField;
import view.component.SimpleButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CreateAuctionView extends BaseView implements CreateAuction.View {

    private InputField minPercentForNewBidsField;
    private InputField expirationTimeField;
    private SimpleButton submitButton;
    private SimpleButton createMiscButton;
    private SimpleButton createFluidButton;
    private SimpleButton createVehicleButton;
    //private SimpleButton createRealtyButton;
    private CreateAuction.Presenter presenter;
    private Integer itemId;

    public CreateAuctionView() {
        super();
        
        minPercentForNewBidsField = new InputField("Diferença mínima entre lances (%)");
        minPercentForNewBidsField.setLocation(25, 20);
        expirationTimeField = new InputField("Tempo máximo sem lances (min)");
        expirationTimeField.setLocation(25, 80);
        createMiscButton = new SimpleButton("Criar Misc");
        createMiscButton.setLocation(75, 140);
        createMiscButton.addActionListener(e -> {
            frame.createForResult(new CreateMiscView());
        });
        createFluidButton = new SimpleButton("Criar Fluido");
        createFluidButton.setLocation(75, 190);
        createFluidButton.addActionListener(e -> {
            frame.createForResult(new CreateFluidView());
        });  
        createVehicleButton = new SimpleButton("Criar Veiculo");
        createVehicleButton.setLocation(75, 240);
        createVehicleButton.addActionListener(e -> {
            frame.createForResult(new CreateVehicleView());
        });  
//        createRealtyButton = new SimpleButton("Criar Imovel");
//        createRealtyButton.setLocation(75, 290);
//        createRealtyButton.addActionListener(e -> {
//            frame.createForResult(new CreateRealtyView());
//        });  
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 360);
        submitButton.addActionListener(e -> {
            String expirationTime = expirationTimeField.getText();
            String minPercentForNewBidsFields = minPercentForNewBidsField.getText();
            if (!Validate.integer(expirationTime).equals(Validate.OK)) {
                showErrorDialog("Insira números inteiros no campo de tempo para expiração");
            } else if (!Validate.integer(minPercentForNewBidsFields).equals(Validate.OK)) {
                showErrorDialog("Insira números inteiros no campo de diferença mínima entre lances");
            } else if (itemId == null) {
                showErrorDialog("Associe um item para este leilÃ£o");
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
        //add(createRealtyButton);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Criar Leilão");
        presenter = new CreateAuctionPresenter(this);
    }

    @Override
    public void setResult(Object result) {
        super.setResult(result);
        Item item = (Item) result;
        itemId = item.getId();
        frame.setTitle(item.getDescription());
    }
}
