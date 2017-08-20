package view;

import contract.CreateMisc;
import model.pojo.Misc;
import presenter.CreateMiscPresenter;
import util.Global;
import view.component.InputField;

import javax.swing.*;

public class CreateMiscView extends BaseView implements CreateMisc.View {

	private InputField nameField;
	private InputField descriptionField;
	private InputField lengthField;
	private InputField widthField;
	private InputField heightField;
	private InputField weightField;
	private InputField containerDescriptionField;
    private JButton submitButton;
    private CreateMisc.Presenter presenter;

    public CreateMiscView() {
        super();
        nameField = new InputField("Nome");
        nameField.setLocation(10, 10);
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(10, 50);
        lengthField = new InputField("Comprimento");
        lengthField.setLocation(10, 90);
        widthField = new InputField("Largura");
        widthField.setLocation(10, 130);
        heightField = new InputField("Altura");
        heightField.setLocation(10, 170);
        weightField = new InputField("Peso");
        weightField.setLocation(10, 210);
        containerDescriptionField = new InputField("Descrição do Container");
        containerDescriptionField.setLocation(10, 250);
        submitButton = new JButton("Salvar");
        submitButton.setBounds(20, 290, 50, 50);
        //setar atributos de misc q item n tem. consertar indexes de misc
        submitButton.addActionListener(e ->
                presenter.createMisc(new Misc(Global.getCurrentUser().getId(), nameField.getText(), descriptionField.getText()))
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
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setTitle("Criar Misc");
        presenter = new CreateMiscPresenter(this);
    }

    @Override
    public void onCreateSuccess(Misc misc) {
        frame.setResult(misc);
    }

}
