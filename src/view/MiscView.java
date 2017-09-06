package view;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.pojo.Misc;

public class MiscView extends BidView {
	
	public MiscView() {
		super();	
	}
	
	@Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        infoTextArea.setText("Descrição: " + item.getDescription() + 
        		", comprimento: " + ((Misc) item).getLength() + " m" +
        		", largura: " + ((Misc) item).getWidth() + " m" +
        		", altura: " + ((Misc) item).getHeight() + " m" +
        		", peso: " + ((Misc) item).getWeight() + " g" +
        		", recipiente: " + ((Misc) item).getContainerDescription()+'.'
        );
	}
}
