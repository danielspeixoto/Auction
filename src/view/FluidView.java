package view;

import model.pojo.Fluid;

public class FluidView extends BidView {

	public FluidView() {
		super();
	}
	
	@Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        infoTextArea.setText("Descrição: " + item.getDescription() + 
        		", comprimento do recipiente: " + ((Fluid) item).getContainerLength() + " m" +
        		", largura do recipiente: " + ((Fluid) item).getContainerWidth() + " m" +
        		", altura do recipiente: " + ((Fluid) item).getContainerHeight() + " m" +
        		", peso: " + ((Fluid) item).getWeight() + " g" +
        		", volume: " + ((Fluid) item).getVolume() + " m³" +
        		", raio: " + ((Fluid) item).getRadius() + " m" +
        		", recipiente: " + ((Fluid) item).getContainerDescription()+'.'
        );
	}
}