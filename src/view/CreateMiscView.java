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
        nameField.setSize(300,50);
        nameField.textField.setSize(300,30);
       
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        descriptionField.setSize(300,50);
        descriptionField.textField.setSize(300,30);
        
        lengthField = new InputField("Comprimento");
        lengthField.setLocation(25, 140);
        lengthField.setSize(140, 50);
        lengthField.textField.setSize(140,30);
                
        widthField = new InputField("Largura");
        widthField.setLocation(185, 140);
        widthField.setSize(140, 50);
        widthField.textField.setSize(140,30);        
        
        heightField = new InputField("Altura");   
        heightField.setLocation(25, 200);
        heightField.setSize(140, 50);
        heightField.textField.setSize(140,30);
        
        weightField = new InputField("Peso");
        weightField.setLocation(185, 200);
        weightField.setSize(140, 50);
        weightField.textField.setSize(140,30);
        
        containerDescriptionField = new InputField("Descrição do Container");
        containerDescriptionField.setLocation(25, 260);
        containerDescriptionField.setSize(300,50);
        containerDescriptionField.textField.setSize(300,30);
        
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(100, 360);
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
        frame.setSize(350, 450);
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
