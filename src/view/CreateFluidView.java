package view;

import contract.CreateFluid;
import model.pojo.Fluid;
import presenter.CreateFluidPresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

public class CreateFluidView extends CreateItemView implements CreateFluid.View {

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
        nameField.setSize(300,50);
        nameField.textField.setSize(300,30);
        
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        descriptionField.setSize(300,50);
        descriptionField.textField.setSize(300,30);
        
        containerDescriptionField = new InputField("Descrição do Container");
        containerDescriptionField.setLocation(25, 140);
        containerDescriptionField.setSize(300, 50);
        containerDescriptionField.textField.setSize(300,30);
        
        containerLengthField = new InputField("Comprimento");       
        containerLengthField.setLocation(25, 200);      
        containerLengthField.setSize(140, 50);
        containerLengthField.textField.setSize(140,30);
        
        containerWidthField = new InputField("Largura");
        containerWidthField.setLocation(185, 200);
        containerWidthField.setSize(140, 50);
        containerWidthField.textField.setSize(140,30);
        
        containerHeightField = new InputField("Altura do Container");
        containerHeightField.setLocation(25, 260);
        containerHeightField.setSize(140, 50);
        containerHeightField.textField.setSize(140,30);
        
        volumeField = new InputField("Volume");
        volumeField.setLocation(185, 260);
        volumeField.setSize(140, 50);
        volumeField.textField.setSize(140,30);
        
        radiusField = new InputField("Raio");
        radiusField.setLocation(25, 315);
        radiusField.setSize(140, 50);
        radiusField.textField.setSize(140,30);
        
        weightField = new InputField("Peso");
        weightField.setLocation(185, 315);
        weightField.setSize(140, 50);
        weightField.textField.setSize(140,30);    
        
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(100, 378);
        submitButton.addActionListener(e ->
                presenter.createFluid(new Fluid(Global.getCurrentUser().getId(), nameField.getText(),
                        descriptionField.getText(), containerDescriptionField.getText(),
                        Double.parseDouble(containerLengthField.getText()), Double.parseDouble(containerWidthField.getText()),
                        Double.parseDouble(containerHeightField.getText()), Double.parseDouble(volumeField.getText()),
                        Double.parseDouble(radiusField.getText()), Double.parseDouble(weightField.getText())))
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
        frame.setSize(350, 465);
        frame.setResizable(false);
        frame.setTitle("Criar Fluido");
        frame.setLocationRelativeTo(null);
        presenter = new CreateFluidPresenter(this);
    }

    @Override
    public void onCreateSuccess(Fluid fluid) {
        super.sendResult(fluid);
    }

}
