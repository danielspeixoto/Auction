package presenter;

import contract.CreateMisc;
import model.CreateMiscModel;
import model.pojo.Misc;
import util.Validate;

public class CreateMiscPresenter implements CreateMisc.Presenter {

    private CreateMisc.View view;
    private CreateMisc.Model model;
    private Misc misc;

    public CreateMiscPresenter(CreateMisc.View view) {
        this.view = view;
        this.model = new CreateMiscModel(this);
    }

    @Override
    public void createMisc(Misc misc) {
        String result = Validate.validate(misc);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createMisc(misc);
                }
            }).start();
            this.misc = misc;
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
        view.onCreateSuccess(misc);
        view.close();
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}