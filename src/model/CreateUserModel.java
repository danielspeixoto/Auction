package model;

import contract.CreateUser;
import mock.Database;
import mock.UserDatabase;
import model.pojo.User;


public class CreateUserModel implements CreateUser.Model {

    private CreateUser.Presenter presenter;

    public CreateUserModel(CreateUser.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createUser(User user) {
        int result;
        try {
            if (Database.getData(UserDatabase.PATH_USERS, UserDatabase.INDEX_EMAIL, user.getEmail()) == null) {
                result = Database.insert(UserDatabase.PATH_USERS, user);
                user.setId(result);
                presenter.onCreateSuccess(result);
            } else {
                presenter.onError("O email já está cadastrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}
