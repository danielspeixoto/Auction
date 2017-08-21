package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		injectMoneyButton.setBounds(75, 150, 150, 30);
		
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
	public void onInjectSuccess() {
		JOptionPane.showMessageDialog(null, "Sucesso");
		
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
        frame.setSize(300, 250);
        frame.setTitle("Injetar Valor em Conta");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }


}
