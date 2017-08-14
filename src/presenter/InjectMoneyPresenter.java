package presenter;

import contract.InjectMoney;
import model.InjectMoneyModel;
import view.InjectMoneyView;

public class InjectMoneyPresenter implements InjectMoney.Presenter {

	private InjectMoney.Model model;
	private InjectMoney.View view;
	
	public InjectMoneyPresenter(InjectMoneyView view) {
		this.model = new InjectMoneyModel(this);
		this.view = view;
	}
	
	@Override
	public void onError(String message) {
		// TODO Auto-generated method stub
		
	}

}
