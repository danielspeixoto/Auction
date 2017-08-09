package presenter;

import contract.CreateAccount;
import model.CreateAccountModel;
import model.pojo.Account;
import model.pojo.User;

public class CreateAccountPresenter implements CreateAccount.Presenter {

	private CreateAccount.Model model;
	private CreateAccount.View view;
	
	public CreateAccountPresenter(CreateAccount.View view) {
		this.model = new CreateAccountModel(this);
		this.view = view;
	}
	
	@Override
	public void onError(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateSuccsses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccount(Account account, User user) {
		// TODO Auto-generated method stub
		
	}

}
