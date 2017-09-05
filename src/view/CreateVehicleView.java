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
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(25, 80);
        mileageField = new InputField("Quilometragem");
        mileageField.setLocation(25, 140);
        brandField = new InputField("Marca");
        brandField.setLocation(25, 200);
        modelField = new InputField("Modelo");
        modelField.setLocation(25, 260);
        doorsField = new InputField("Quantidade de Portas");
        doorsField.setLocation(25, 320);
        fuelField = new InputField("Combustível");
        fuelField.setLocation(25, 380);
        colorField = new InputField("Cor");
        colorField.setLocation(25, 440);
        seatsField = new InputField("Quantidade de Acentos");
        seatsField.setLocation(25, 500);
        motorDescriptionField = new InputField("Motor");
        motorDescriptionField.setLocation(25, 560);
        chassisField = new InputField("Chassis");
        chassisField.setLocation(25, 620);
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 680);
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
        frame.setSize(300, 800);
        frame.setResizable(false);
        frame.setTitle("Criar Vehicle");
        frame.setLocationRelativeTo(null);
        presenter = new CreateVehiclePresenter(this);
    }

    @Override
    public void onCreateSuccess(Vehicle vehicle) {
        super.sendResult(vehicle);
    }

}
