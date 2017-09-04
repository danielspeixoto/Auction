package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contract.InjectMoney;
import presenter.InjectMoneyPresenter;
import view.component.InputField;
import view.component.SimpleButton;

public class InjectMoneyView extends BaseView implements InjectMoney.View  {

	private static final long serialVersionUID = 1L;
	private InjectMoney.Presenter presenter;
	private InputField valueField;
	private SimpleButton injectMoneyButton;
	
	
	public InjectMoneyView() { 
		super();

		valueField = new InputField("Valor");
		valueField.setPosition(25, 50);
		valueField.setSize(300,50);
		valueField.textField.setSize(300,30);
		injectMoneyButton = new SimpleButton("Injetar Valor");
		injectMoneyButton.setLocation(100, 150);
		add(valueField);
		add(injectMoneyButton);
		
		presenter = new InjectMoneyPresenter(this);
		
		injectMoneyButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.injectMoney(Double.parseDouble(valueField.getText()));
			}
		});
	}
	
	@Override
	public void onInjectSuccess(double newBalance) {
		 frame.setResult(newBalance);
		 close();
	}
		
	@Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(350, 250);
        frame.setTitle("Injetar Valor em Conta");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
