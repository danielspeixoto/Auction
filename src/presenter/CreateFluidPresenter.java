package presenter;

import contract.CreateFluid;
import model.CreateFluidModel;
import model.pojo.Fluid;
import util.Validate;

public class CreateFluidPresenter implements CreateFluid.Presenter {

    private CreateFluid.View view;
    private CreateFluid.Model model;
    private Fluid fluid;

    public CreateFluidPresenter(CreateFluid.View view) {
        this.view = view;
        this.model = new CreateFluidModel(this);
    }

    @Override
    public void createFluid(Fluid fluid) {
        String result = Validate.validate(fluid);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createFluid(fluid);
                }
            }).start();
            this.fluid = fluid;
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
        view.onCreateSuccess(fluid);
        view.close();
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}