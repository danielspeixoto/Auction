package presenter;

import contract.Login;
import model.LoginModel;
import model.pojo.User;
import util.Global;
import util.Validate;
import view.HomeView;

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private Login.Model model;

    public LoginPresenter(Login.View view) {
        this.view = view;
        if (Global.isLogged()) {
            view.changePanel(new HomeView());
        }
        this.model = new LoginModel(this);
    }

    @Override
    public void login(String email, String password) {
        String result = Validate.email(email);
        if (result.equals(Validate.OK)) {
        	model.login(email, password);
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onLoginSuccess(User user) {
        Global.setCurrentUser(user);
        view.changePanel(new HomeView());
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}
