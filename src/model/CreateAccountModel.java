package model;

import contract.CreateAccount;
import mock.AccountDatabase;
import mock.Database;
import model.pojo.Account;

public class CreateAccountModel implements CreateAccount.Model {
	
	private CreateAccount.Presenter presenter; 
	
	public CreateAccountModel (CreateAccount.Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public void createAccount(Account account) {
		try {
			if (Database.getData(AccountDatabase.PATH_ACCOUNTS, AccountDatabase.INDEX_USER_ID, Integer.toString(account.getUserId())).equals("")) {
                Database.insert(AccountDatabase.PATH_ACCOUNTS, account);
                presenter.onCreateSuccess();
            } else {
                presenter.onError("Sua usuário já possui uma conta associada");
            }
		} catch(Exception e) {
			e.printStackTrace();
			presenter.onError("Erro Fatal");
		}	
	}
}
