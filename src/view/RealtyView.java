package view;

import javax.swing.JTextArea;

import model.pojo.Realty;

public class RealtyView extends BidView {
	public RealtyView() {
		super();
	}
	
	@Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        infoTextArea.setText("Descrição: " + item.getDescription() + 
        		", local: " + ((Realty) item).getLocation() + 
        		", metros quadrados: " + ((Realty) item).getSquareMeters() + " m²" +
        		", ano de construção: " + ((Realty) item).getConstructionYear()+'.'
        );
	}
}
