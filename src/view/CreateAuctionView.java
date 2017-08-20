package view;

import contract.CreateAuction;
import model.pojo.Auction;
import model.pojo.Misc;
import presenter.CreateAuctionPresenter;
import util.Global;
import util.Validate;
import view.component.InputField;

import javax.swing.*;

public class CreateAuctionView extends BaseView implements CreateAuction.View {

    private InputField minPercentForNewBidsField;
    private InputField expirationTimeField;
    private JButton submitButton;
    private JButton createMiscButton;
    private CreateAuction.Presenter presenter;
    private Integer miscId;

    public CreateAuctionView() {
        super();
        minPercentForNewBidsField = new InputField("Quanto cada oferta deve aumentar em relação à anterior?");
        minPercentForNewBidsField.setLocation(5, 5);
        expirationTimeField = new InputField("Tempo para em expiração em minutos");
        expirationTimeField.setLocation(5, 300);
        submitButton = new JButton("Salvar");
        submitButton.setBounds(80, 80, 100, 100);
        submitButton.addActionListener(e -> {
            String expirationTime = expirationTimeField.getText();
            String minPercentForNewBidsFields = minPercentForNewBidsField.getText();
            if (!Validate.integer(expirationTime).equals(Validate.OK)) {
                showErrorDialog("Coloque números inteiros no campo de tempo para expiração");
            } else if (!Validate.integer(minPercentForNewBidsFields).equals(Validate.OK)) {
                showErrorDialog("Coloque números inteiros no campo de quanto a oferta deve aumentar em relação à anterior");
            } else if (miscId == null) {
                showErrorDialog("Associe um misc para este leilão");
            } else {
                presenter.createAuction(new Auction(Global.getCurrentUser().getId(),
                        Integer.valueOf(minPercentForNewBidsField.getText()),
                        Integer.valueOf(expirationTimeField.getText()) * 60000,
                        miscId));

            }

        });
        createMiscButton = new JButton("Criar Misc");
        createMiscButton.setBounds(20, 20, 100, 100);
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
        frame.setSize(800, 600);
        frame.setResizable(false);
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
