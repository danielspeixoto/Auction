package view;

import contract.CreateVehicle;
import model.pojo.Vehicle;
import presenter.CreateVehiclePresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

public class CreateVehicleView extends CreateItemView implements CreateVehicle.View {

	private InputField nameField;
	private InputField descriptionField;
	private InputField mileageField;
	private InputField brandField;
	private InputField modelField;
	private InputField doorsField;
	private InputField fuelField;
	private InputField colorField;
	private InputField seatsField;
	private InputField motorDescriptionField;
	private InputField chassisField;
    private SimpleButton submitButton;
    private CreateVehicle.Presenter presenter;

    public CreateVehicleView() {
        super();
        nameField = new InputField("Nome");
        nameField.setLocation(25, 20);
        nameField.setSize(300,50);
        nameField.textField.setSize(300,30);
        
        descriptionField = new InputField("Descrição");      
        descriptionField.setLocation(25, 80);
        descriptionField.setSize(300,50);
        descriptionField.textField.setSize(300,30);
        
        mileageField = new InputField("Quilometragem");
        mileageField.setLocation(25, 140);
        mileageField.setSize(140, 50);
        mileageField.textField.setSize(140,30);
       
        
        brandField = new InputField("Marca");
        brandField.setLocation(185, 140);
        brandField.setSize(140, 50);
        brandField.textField.setSize(140,30); 
        
        modelField = new InputField("Modelo");
        modelField.setLocation(25, 200);
        modelField.setSize(140, 50);
        modelField.textField.setSize(140,30);
        
        doorsField = new InputField("Qtd de Portas");
        doorsField.setLocation(185, 200);
        doorsField.setSize(140, 50);
        doorsField.textField.setSize(140,30);
        
        fuelField = new InputField("Combustível");
        fuelField.setLocation(25, 260);
        fuelField.setSize(140,50);
        fuelField.textField.setSize(140,30);
        
        colorField = new InputField("Cor");
        colorField.setLocation(185, 260);
        colorField.setSize(140,50);
        colorField.textField.setSize(140,30);
        
        seatsField = new InputField("Qtd de Acentos");
        seatsField.setLocation(25, 315);
        seatsField.setSize(140,50);
        seatsField.textField.setSize(140,30);
        
        motorDescriptionField = new InputField("Motor");
        motorDescriptionField.setLocation(185, 315);
        motorDescriptionField.setSize(140,50);
        motorDescriptionField.textField.setSize(140,30);
        
        chassisField = new InputField("Chassis");
        chassisField.setLocation(25, 370);
        chassisField.setSize(300,50);
        chassisField.textField.setSize(300,30);
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(100, 430);
        submitButton.addActionListener(e ->
                presenter.createVehicle(new Vehicle(Global.getCurrentUser().getId(), nameField.getText(),
                        descriptionField.getText(), mileageField.getText(), brandField.getText(),
                        modelField.getText(), Integer.parseInt(doorsField.getText()), fuelField.getText(),
                        colorField.getText(), Integer.parseInt(seatsField.getText()), motorDescriptionField.getText(),
                        chassisField.getText()))
        );
        add(nameField);
        add(descriptionField);
        add(mileageField);
        add(brandField);
        add(modelField);
        add(doorsField);
        add(fuelField);
        add(colorField);
        add(seatsField);
        add(motorDescriptionField);
        add(chassisField);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(350, 515);
        frame.setResizable(false);
        frame.setTitle("Criar Veículo");
        frame.setLocationRelativeTo(null);
        presenter = new CreateVehiclePresenter(this);
    }

    @Override
    public void onCreateSuccess(Vehicle vehicle) {
        super.sendResult(vehicle);
    }

}
