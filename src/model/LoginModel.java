package model;

import contract.Login;
import mock.AccountDatabase;
import mock.UserDatabase;
import model.pojo.Account;
import model.pojo.User;
import util.Global;


public class LoginModel implements Login.Model {

    private Login.Presenter presenter;

    public LoginModel(Login.Presenter presenter) {
        this.presenter = presenter;
    }

    public void login(String email, String password) {
        User user;
        try {
            user = UserDatabase.login(email, password);
            if (user != null) {
            	Account account = AccountDatabase.getAccount(user.getId());
                user.setAccount(account);
            	Global.setCurrentUser(user);
                presenter.onLoginSuccess();
            } else {
                presenter.onError("Email ou senha incorretos");
            }
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }

}
