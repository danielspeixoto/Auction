package presenter;

import contract.CreateRealty;
import model.CreateRealtyModel;
import model.pojo.Realty;
import util.Validate;

public class CreateRealtyPresenter implements CreateRealty.Presenter {

    private CreateRealty.View view;
    private CreateRealty.Model model;
    private Realty realty;

    public CreateRealtyPresenter(CreateRealty.View view) {
        this.view = view;
        this.model = new CreateRealtyModel(this);
    }

    @Override
    public void createRealty(Realty realty) {
        String result = Validate.validate(realty);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createRealty(realty);
                }
            }).start();
            this.realty = realty;
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
        view.onCreateSuccess(realty);
        view.close();
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}