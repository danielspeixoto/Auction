package view;

import javax.swing.*;

import contract.CreateAccount;
import model.pojo.Account;
import presenter.CreateAccountPresenter;

public class CreateAccountView extends BaseView implements CreateAccount.View {
		
	private CreateAccount.Presenter presenter;
	
	public CreateAccountView() { 
		super();
		presenter = new CreateAccountPresenter(this);
	}

	@Override
	public void createAccount(Account account, int user_id) {
		presenter.createAccount(account, user_id);
	}

	@Override
	public void onCreateSuccess() {
		JOptionPane.showMessageDialog(null, "Sucesso ao criar conta!");
		
	}
}

