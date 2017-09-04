package model;

import contract.CreateFluid;
import mock.Database;
import mock.FluidDatabase;
import model.pojo.Fluid;

public class CreateFluidModel implements CreateFluid.Model {

    private CreateFluid.Presenter presenter;

    public CreateFluidModel(CreateFluid.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createFluid(Fluid fluid) {
        int result;
        try {
            result = Database.insert(FluidDatabase.PATH_ITEMS, fluid);
            fluid.setId(result);
            presenter.onCreateSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}