package model;

import contract.Login;
import mock.Database;
import model.pojo.User;

import java.io.IOException;

/**
 * Created by daniel on 22/07/17.
 */
public class LoginModel implements Login.Model {

    private Login.Presenter presenter;

    public LoginModel(Login.Presenter presenter) {
        this.presenter = presenter;
    }


    public void login(String email, String password) {
        User user;
        try {
            user = Database.login(email, password);
            if (user != null) {
                presenter.onLoginSuccess();
            } else {
                presenter.onError("Email ou senha incorretos");
            }
        } catch (IOException e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }

}
