package view;

import contract.CreateFluid;
import model.pojo.Fluid;
import presenter.CreateFluidPresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

import javax.swing.*;

public class CreateFluidView extends BaseView implements CreateFluid.View {

	private InputField nameField;
	private InputField descriptionField;
	private InputField containerDescriptionField;
	private InputField containerLengthField;
	private InputField containerWidthField;
	private InputField containerHeightField;
	private InputField volumeField;
	private InputField radiusField;
	private InputField weightField;
    private SimpleButton submitButton;
    private CreateFluid.Presenter presenter;

    public CreateFluidView() {
        super();
        nameField = new InputField("Nome");
        nameField.setLocation(25, 20);
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        containerDescriptionField = new InputField("Descrição do Container");
        containerDescriptionField.setLocation(25, 140);
        containerLengthField = new InputField("Comprimento do Container");
        containerLengthField.setLocation(25, 200);
        containerWidthField = new InputField("Largura do Container");
        containerWidthField.setLocation(25, 260);
        containerHeightField = new InputField("Altura do Container");
        containerHeightField.setLocation(25, 320);
        volumeField = new InputField("Volume");
        volumeField.setLocation(25, 380);
        radiusField = new InputField("Raio");
        radiusField.setLocation(25, 440);
        weightField = new InputField("Peso");
        weightField.setLocation(25, 500);
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 600);
        submitButton.addActionListener(e ->
                presenter.createFluid(new Fluid(Global.getCurrentUser().getId(), nameField.getText(), descriptionField.getText(), 'f', containerDescriptionField.getText(), Double.parseDouble(containerLengthField.getText()), Double.parseDouble(containerWidthField.getText()), Double.parseDouble(containerHeightField.getText()), Double.parseDouble(volumeField.getText()), Double.parseDouble(radiusField.getText()), Double.parseDouble(weightField.getText())))
        );
        add(nameField);
        add(descriptionField);
        add(containerLengthField);
        add(containerWidthField);
        add(containerHeightField);
        add(volumeField);
        add(radiusField);
        add(weightField);
        add(containerDescriptionField);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 700);
        frame.setResizable(false);
        frame.setTitle("Criar Fluido");
        frame.setLocationRelativeTo(null);
        presenter = new CreateFluidPresenter(this);
    }

    @Override
    public void onCreateSuccess(Fluid fluid) {
        frame.setResult(fluid);
    }

}
