package contract;

import model.pojo.Fluid;

public class CreateFluid {

    public interface View extends Base.View {
        void onCreateSuccess(Fluid fluid);
    }

    public interface Presenter extends Base.Presenter {
        void createFluid(Fluid fluid);
        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createFluid(Fluid fluid);
    }
}
