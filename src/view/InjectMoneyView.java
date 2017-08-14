package view;

import contract.InjectMoney;
import presenter.InjectMoneyPresenter;

public class InjectMoneyView implements InjectMoney.View  {

	private InjectMoney.Presenter presenter;
	
	public InjectMoneyView() { 
		super();
		presenter = new InjectMoneyPresenter(this);
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showErrorDialog(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePanel(BaseView view) {
		// TODO Auto-generated method stub
		
	}

}
