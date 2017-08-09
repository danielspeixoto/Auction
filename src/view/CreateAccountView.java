package view;

import contract.CreateAccount;
import presenter.CreateAccountPresenter;

public class CreateAccountView extends BaseView implements CreateAccount.View {
	
	private CreateAccount.Presenter presenter;
	
	public CreateAccountView() { 
		this.presenter = new CreateAccountPresenter(this);
	}
	
}

