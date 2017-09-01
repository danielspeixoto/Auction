package presenter;

import contract.CreateVehicle;
import model.CreateVehicleModel;
import model.pojo.Vehicle;
import util.Validate;

public class CreateVehiclePresenter implements CreateVehicle.Presenter {

    private CreateVehicle.View view;
    private CreateVehicle.Model model;
    private Vehicle vehicle;

    public CreateVehiclePresenter(CreateVehicle.View view) {
        this.view = view;
        this.model = new CreateVehicleModel(this);
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        String result = Validate.validate(vehicle);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createVehicle(vehicle);
                }
            }).start();
            this.vehicle = vehicle;
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
        view.onCreateSuccess(vehicle);
        view.close();
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}