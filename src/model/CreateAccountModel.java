package model;

import contract.CreateAccount;
import model.pojo.Account;
import model.pojo.User;

public class CreateAccountModel implements CreateAccount.Model {
	
	private CreateAccount.Presenter presenter; 
	
	public CreateAccountModel (CreateAccount.Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public void createAccount(Account account, User user) {
		// TODO Auto-generated method stub
		
	}

}
