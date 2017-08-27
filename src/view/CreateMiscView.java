package view;

import contract.CreateMisc;
import model.pojo.Misc;
import presenter.CreateMiscPresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

import javax.swing.*;

public class CreateMiscView extends BaseView implements CreateMisc.View {

	private InputField nameField;
	private InputField descriptionField;
	private InputField lengthField;
	private InputField widthField;
	private InputField heightField;
	private InputField weightField;
	private InputField containerDescriptionField;
    private SimpleButton submitButton;
    private CreateMisc.Presenter presenter;

    public CreateMiscView() {
        super();
        nameField = new InputField("Nome");
        nameField.setLocation(25, 20);
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        lengthField = new InputField("Comprimento");
        lengthField.setLocation(25, 140);
        widthField = new InputField("Largura");
        widthField.setLocation(25, 200);
        heightField = new InputField("Altura");
        heightField.setLocation(25, 260);
        weightField = new InputField("Peso");
        weightField.setLocation(25, 320);
        containerDescriptionField = new InputField("Descrição do Container");
        containerDescriptionField.setLocation(25, 380);
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 440);
        //setar atributos de misc q item n tem. consertar indexes de misc
        submitButton.addActionListener(e ->
                presenter.createMisc(new Misc(Global.getCurrentUser().getId(), nameField.getText(), descriptionField.getText(), 'm', Double.parseDouble(lengthField.getText()), Double.parseDouble(widthField.getText()), Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText()), containerDescriptionField.getText()))
        );
        add(nameField);
        add(descriptionField);
        add(lengthField);
        add(widthField);
        add(heightField);
        add(weightField);
        add(containerDescriptionField);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 500);
        frame.setResizable(false);
        frame.setTitle("Criar Misc");
        frame.setLocationRelativeTo(null);
        presenter = new CreateMiscPresenter(this);
    }

    @Override
    public void onCreateSuccess(Misc misc) {
        frame.setResult(misc);
    }

}
