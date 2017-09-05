package model;

import contract.InjectMoney;
import mock.AccountDatabase;
import util.Global;

public class InjectMoneyModel implements InjectMoney.Model {
	
	private InjectMoney.Presenter presenter;

    public InjectMoneyModel(InjectMoney.Presenter presenter) {
        this.presenter = presenter;
    }

	@Override
	public void injectMoney(double value) {
		try {
			presenter.onInjectSuccess(AccountDatabase.injectMoney(Global.getCurrentUser().getAccount(), value));
		} catch(Exception e) {
			e.printStackTrace();
			presenter.onError("Ops... Parece que algo deu errado");
		}
	}
}
