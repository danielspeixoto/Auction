package view;

import javax.swing.JButton;

import contract.CreateAccount;
import presenter.CreateAccountPresenter;
import view.component.InputField;
import view.component.PasswordField;

public class CreateAccountView extends BaseView implements CreateAccount.View {
		
	private CreateAccount.Presenter presenter;
	
	public CreateAccountView() { 
		super();
	}
}

