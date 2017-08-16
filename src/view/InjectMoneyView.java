package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import contract.InjectMoney;
import presenter.InjectMoneyPresenter;
import view.component.InputField;

public class InjectMoneyView extends BaseView implements InjectMoney.View  {

	private InjectMoney.Presenter presenter;
	private InputField valueField;
	private JButton injectMoneyButton;
	
	
	public InjectMoneyView() { 
		super();
		
		valueField = new InputField("Valor");
		valueField.setPosition(25, 50);
		injectMoneyButton = new JButton("Injetar Valor");
		injectMoneyButton.setBounds(75, 180, 150, 30);
		add(valueField);
		add(injectMoneyButton);
		
		presenter = new InjectMoneyPresenter(this);
		
		injectMoneyButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				presenter.injectMoney(Double.parseDouble(valueField.getText()));
			}
		});
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
	
	@Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 300);
        frame.setTitle("Injetar Valor em Conta");
        frame.setResizable(false);
    }

}
