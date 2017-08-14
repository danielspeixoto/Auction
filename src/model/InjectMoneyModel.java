package model;

import contract.InjectMoney;

public class InjectMoneyModel implements InjectMoney.Model {
	
	private InjectMoney.Presenter presenter;

    public InjectMoneyModel(InjectMoney.Presenter presenter) {
        this.presenter = presenter;
    }
}
