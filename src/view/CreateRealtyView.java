package view;

import contract.CreateRealty;
import model.pojo.Realty;
import presenter.CreateRealtyPresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

public class CreateRealtyView extends CreateItemView implements CreateRealty.View {

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
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        locationField = new InputField("Localização");
        locationField.setLocation(25, 140);
        squareMetersField = new InputField("Metros Quadrados");
        squareMetersField.setLocation(25, 200);
        constructionYearField = new InputField("Ano de Construção");
        constructionYearField.setLocation(25, 260);
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 320);
        submitButton.addActionListener(e ->
                presenter.createRealty(new Realty(Global.getCurrentUser().getId(), nameField.getText(),
                        descriptionField.getText(), locationField.getText(),
                        Double.parseDouble(squareMetersField.getText()),
                        Integer.parseInt(constructionYearField.getText())))
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
        frame.setSize(300, 500);
        frame.setResizable(false);
        frame.setTitle("Criar Realty");
        frame.setLocationRelativeTo(null);
        presenter = new CreateRealtyPresenter(this);
    }

    @Override
    public void onCreateSuccess(Realty realty) {
        super.sendResult(realty);
    }

}
