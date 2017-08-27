package view;

import contract.CreateAuction;
import model.pojo.Auction;
import model.pojo.Misc;
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
    private CreateAuction.Presenter presenter;
    private Integer miscId;

    public CreateAuctionView() {
        super();
        
        minPercentForNewBidsField = new InputField("Diferença mínima entre lances (%)");
        minPercentForNewBidsField.setLocation(25, 20);
        expirationTimeField = new InputField("Tempo máximo sem lances (min)");
        expirationTimeField.setLocation(25, 80);
        createMiscButton = new SimpleButton("Criar Misc");
        createMiscButton.setLocation(75, 150);
        createMiscButton.addActionListener(e -> {
            frame.createForResult(new CreateItemView());
        });  
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 190);
        submitButton.addActionListener(e -> {
            String expirationTime = expirationTimeField.getText();
            String minPercentForNewBidsFields = minPercentForNewBidsField.getText();
            if (!Validate.integer(expirationTime).equals(Validate.OK)) {
                showErrorDialog("Insira números inteiros no campo de tempo para expiração");
            } else if (!Validate.integer(minPercentForNewBidsFields).equals(Validate.OK)) {
                showErrorDialog("Insira números inteiros no campo de diferença mínima entre lances");
            } else if (miscId == null) {
                showErrorDialog("Associe um misc para este leilÃ£o");
            } else {
                presenter.createAuction(new Auction(Global.getCurrentUser().getId(),
                        Integer.valueOf(minPercentForNewBidsField.getText()),
                        Integer.valueOf(expirationTimeField.getText()) * 60000, miscId));
            }

        });
        createMiscButton = new SimpleButton("Criar Misc");
        createMiscButton.addActionListener(e -> {
            frame.createForResult(new CreateMiscView());
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
        frame.setTitle("Criar Leilão");
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
