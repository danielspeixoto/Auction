package model;

import javax.swing.JOptionPane;
import java.util.StringTokenizer;
import contract.InjectMoney;
import mock.AccountDatabase;
import mock.Database;
import util.Global;

public class InjectMoneyModel implements InjectMoney.Model {
	
	private InjectMoney.Presenter presenter;

    public InjectMoneyModel(InjectMoney.Presenter presenter) {
        this.presenter = presenter;
    }

	@Override
	public void injectMoney(double value) {
		try {
			String currentLine = Database.getData(AccountDatabase.PATH_ACCOUNTS, AccountDatabase.INDEX_USER_ID, Integer.toString(Global.getCurrentUser().getId()));
			String currentBalance = currentLine.split(",")[AccountDatabase.INDEX_BALANCE];
			double newBalance = Double.parseDouble(currentBalance) + value;
			StringTokenizer str = new StringTokenizer(currentLine,",");  
			String newLine = str.nextToken();
			for (int i = 1; str.hasMoreTokens(); i++) {
				if(i == 2) {
					newLine += ','+Double.toString(newBalance);
					str.nextToken();
				} else {
					newLine += ','+str.nextToken();
				}
			}
			
			Database.replaceLine(AccountDatabase.PATH_ACCOUNTS, currentLine, newLine);
			presenter.onInjectSuccess();
		} catch(Exception e) {
			e.printStackTrace();
			presenter.onError("Ops... Parece que algo deu errado");
		}
	}
}
