package presenter;

import javax.swing.JOptionPane;

import contract.CreateAccount;
import contract.CreateUser;
import model.CreateAccountModel;
import model.pojo.Account;
import view.CreateAccountView;
import view.CreateUserView;
import view.HomeView;

public class CreateAccountPresenter implements CreateAccount.Presenter {

	private CreateAccount.Model model;
	private CreateAccount.View view;
	
	public CreateAccountPresenter(CreateAccountView view) {
		this.model = new CreateAccountModel(this);
		this.view = view;
	}
	
	@Override
	public void createAccount(Account account, int user_id) {
		account.setUserId(user_id);
        model.createAccount(account); 
	}
	
	@Override
	public void onCreateSuccess() {
		view.onCreateSuccess();
	}
	
	@Override
	public void onError(String message) {
		view.showErrorDialog(message);
		
	}

	
}
