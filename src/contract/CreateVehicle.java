package contract;

import model.pojo.Vehicle;

public class CreateVehicle {

    public interface View extends Base.View {
        void onCreateSuccess(Vehicle vehicle);
    }

    public interface Presenter extends Base.Presenter {
        void createVehicle(Vehicle vehicle);
        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createVehicle(Vehicle vehicle);
    }
}
