package view;

import model.pojo.Vehicle;

public class VehicleView extends BidView {

	public VehicleView() {
		super();
	}
	
	@Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        infoTextArea.setText("Descri��o: " + item.getDescription() +         		        		
        		", quilometragem: " + ((Vehicle) item).getMileage() + " km" +
        		", marca: " + ((Vehicle) item).getBrand() +
        		", modelo: " + ((Vehicle) item).getModel() +
        		", combust�vel: " + ((Vehicle) item).getFuel() +
        		", quantidade de portas: " + ((Vehicle) item).getDoors() +
        		", cor: " + ((Vehicle) item).getColor() +
        		", quantidade de assentos: " + ((Vehicle) item).getSeats() +
        		", descri��o do motor: " + ((Vehicle) item).getMotorDescription() +
        		", n�mero de chassis: " + ((Vehicle) item).getChassis() +'.'            		        
        );
	}
}