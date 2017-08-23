package presenter;

import contract.CreateUser;
import model.CreateUserModel;
import model.pojo.User;
import util.Validate;
import view.HomeView;


public class CreateUserPresenter implements CreateUser.Presenter {

    private CreateUser.View view;
    private CreateUser.Model model;

    public CreateUserPresenter(CreateUser.View view) {
        this.view = view;
        this.model = new CreateUserModel(this);
    }

    @Override
    public void createUser(User user) {
        String result = Validate.validate(user);
        if (result.equals(Validate.OK)) {
           new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createUser(user);
                }
           }).start();
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
    	view.changePanel(new HomeView());
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}