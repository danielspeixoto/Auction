package view;

import contract.CreateRealty;
import model.pojo.Realty;
import presenter.CreateRealtyPresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

import javax.swing.*;

public class CreateRealtyView extends BaseView implements CreateRealty.View {

	private InputField nameField;
	private InputField descriptionField;
	private InputField locationField;
	private InputField squareMetersField;
	private InputField constructionYearField;
    private SimpleButton submitButton;
    private CreateRealty.Presenter presenter;

    public CreateRealtyView() {
        super();
        nameField = new InputField("Nome");
        nameField.setLocation(25, 20);
        nameField.setSize(300,50);
        nameField.textField.setSize(300,30);
        
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        descriptionField.setSize(300,50);
        descriptionField.textField.setSize(300,30);
        
        locationField = new InputField("Localização");
        locationField.setLocation(25, 140);
        locationField.setSize(300,50);
        locationField.textField.setSize(300,30);
        
        squareMetersField = new InputField("Metros Quadrados");
        squareMetersField.setLocation(25, 200);
        squareMetersField.setSize(300,50);
        squareMetersField.textField.setSize(300,30);
        
        constructionYearField = new InputField("Ano de Construção");
        constructionYearField.setLocation(25, 260);
        constructionYearField.setSize(300,50);
        constructionYearField.textField.setSize(300,30);
        
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(100, 360);
        submitButton.addActionListener(e ->
                presenter.createRealty(new Realty(Global.getCurrentUser().getId(), nameField.getText(), descriptionField.getText(), 'r', locationField.getText(), Double.parseDouble(squareMetersField.getText()), Integer.parseInt(constructionYearField.getText())))
        );
        add(nameField);
        add(descriptionField);
        add(locationField);
        add(squareMetersField);
        add(constructionYearField);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(350, 450);
        frame.setResizable(false);
        frame.setTitle("Criar Realty");
        frame.setLocationRelativeTo(null);
        presenter = new CreateRealtyPresenter(this);
    }

    @Override
    public void onCreateSuccess(Realty realty) {
        frame.setResult(realty);
    }

}
