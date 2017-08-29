package view;

import contract.CreateAuction;
import model.pojo.Auction;
import model.pojo.Misc;
import model.pojo.Fluid;
import model.pojo.Vehicle;
import model.pojo.Realty;
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
    private SimpleButton createRealtyButton;
    private CreateAuction.Presenter presenter;
    private Integer miscId;

    public CreateAuctionView() {
        super();
        
        minPercentForNewBidsField = new InputField("Diferen�a m�nima entre lances (%)");
        minPercentForNewBidsField.setLocation(25, 20);
        expirationTimeField = new InputField("Tempo m�ximo sem lances (min)");
        expirationTimeField.setLocation(25, 80);
        createMiscButton = new SimpleButton("Criar Misc");
        createMiscButton.setLocation(75, 150);
        createMiscButton.addActionListener(e -> {
            frame.createForResult(new CreateMiscView());
        });
        createFluidButton = new SimpleButton("Criar Fluido");
        createFluidButton.setLocation(75, 220);
        createFluidButton.addActionListener(e -> {
            frame.createForResult(new CreateFluidView());
        });  
        createVehicleButton = new SimpleButton("Criar Veiculo");
        createVehicleButton.setLocation(75, 290);
        createVehicleButton.addActionListener(e -> {
            frame.createForResult(new CreateVehicleView());
        });  
        createRealtyButton = new SimpleButton("Criar Imovel");
        createRealtyButton.setLocation(75, 360);
        createRealtyButton.addActionListener(e -> {
            frame.createForResult(new CreateRealtyView());
        });  
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 400);
        submitButton.addActionListener(e -> {
            String expirationTime = expirationTimeField.getText();
            String minPercentForNewBidsFields = minPercentForNewBidsField.getText();
            if (!Validate.integer(expirationTime).equals(Validate.OK)) {
                showErrorDialog("Insira n�meros inteiros no campo de tempo para expira��o");
            } else if (!Validate.integer(minPercentForNewBidsFields).equals(Validate.OK)) {
                showErrorDialog("Insira n�meros inteiros no campo de diferen�a m�nima entre lances");
            } else if (miscId == null) {
                showErrorDialog("Associe um misc para este leilão");
            } else {
                presenter.createAuction(new Auction(Global.getCurrentUser().getId(),
                        Integer.valueOf(minPercentForNewBidsField.getText()),
                        Integer.valueOf(expirationTimeField.getText()) * 60000, miscId));
            }

        });
        
        add(minPercentForNewBidsField);
        add(expirationTimeField);
        add(createMiscButton);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Criar Leil�o");
        presenter = new CreateAuctionPresenter(this);
    }

    @Override
    public void setResult(Object result) {
        super.setResult(result);
        Misc misc = (Misc) result;
        miscId = misc.getId();
        frame.setTitle(misc.getDescription());
    }
}
