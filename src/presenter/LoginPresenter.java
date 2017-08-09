package presenter;

import contract.Login;
import model.LoginModel;
import util.Global;
import util.Validate;
import view.HomeView;

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private Login.Model model;

    public LoginPresenter(Login.View view) {
        this.view = view;
        if (Global.isLogged()) {
            onLoginSuccess();
        }
        this.model = new LoginModel(this);
    }

    @Override
    public void login(String email, String password) {
        String result = Validate.email(email);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.login(email, password);
                }
            }).start();
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onLoginSuccess() {
        view.changePanel(new HomeView());
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}
