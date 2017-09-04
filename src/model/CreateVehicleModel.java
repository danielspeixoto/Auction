package model;

import contract.CreateVehicle;
import mock.Database;
import mock.VehicleDatabase;
import model.pojo.Vehicle;

public class CreateVehicleModel implements CreateVehicle.Model {

    private CreateVehicle.Presenter presenter;

    public CreateVehicleModel(CreateVehicle.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createVehicle(Vehicle vehicle) {
        int result;
        try {
            result = Database.insert(VehicleDatabase.PATH_ITEMS, vehicle);
            vehicle.setId(result);
            presenter.onCreateSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}