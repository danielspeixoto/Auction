package model;

import contract.CreateUser;
import mock.Database;
import model.pojo.User;

import java.io.IOException;


public class CreateUserModel implements CreateUser.Model {

    private CreateUser.Presenter presenter;

    public CreateUserModel(CreateUser.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createUser(User user) {
        int result;
        try {
            if (Database.getUserLine(user.getEmail()).equals("")) {
                result = Database.insert(user);
                user.setId(result);
                presenter.onCreateSuccess();
            } else {
                presenter.onError("O email já está cadastrado");
            }
        } catch (IOException e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}
