package model;

import contract.CreateUser;
import mock.AccountDatabase;
import mock.Database;
import mock.UserDatabase;
import model.pojo.User;
import model.pojo.Account;


public class CreateUserModel implements CreateUser.Model {

    private CreateUser.Presenter presenter;

    public CreateUserModel(CreateUser.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createUser(User user) {
        int result;
        Account account = new Account();
        try {
            if (Database.getData(UserDatabase.PATH_USERS, UserDatabase.INDEX_EMAIL, user.getEmail()) == null) {
                result = Database.insert(UserDatabase.PATH_USERS, user);
                user.setId(result);
                account.setUserId(result);
                Database.insert(AccountDatabase.PATH_ACCOUNTS, account);         
                presenter.onCreateSuccess();
            } else {
                presenter.onError("O email já está cadastrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}
