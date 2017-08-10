package presenter;

import contract.CreateAccount;
import contract.CreateUser;
import model.CreateAccountModel;
import model.pojo.Account;

public class CreateAccountPresenter implements CreateAccount.Presenter {

	private CreateAccount.Model model;
	private CreateAccount.View view;
	private CreateUser.Presenter userPresenter; 
	
	public CreateAccountPresenter(CreateAccount.View view) {
		this.model = new CreateAccountModel(this);
		this.view = view;
	}
	
	@Override
	public void createAccount(Account account, int user_id) {
		account.setUserId(user_id);
		new Thread(new Runnable() {
            @Override
            public void run() {
                model.createAccount(account);
            }
        }).start();
	}
	
	@Override
	public void onCreateSuccess() {
		userPresenter.onCreateSuccess();
	}
	
	@Override
	public void onError(String message) {
		view.showErrorDialog(message);
		
	}

	
}
