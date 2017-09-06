package view;

import model.pojo.Vehicle;

public class VehicleView extends BidView {

	public VehicleView() {
		super();
	}
	
	@Override
    public void setResult(int sender, Object result) {
        super.setResult(sender, result);
        infoTextArea.setText("Descrição: " + item.getDescription() +         		        		
        		", quilometragem: " + ((Vehicle) item).getMileage() + " km" +
        		", marca: " + ((Vehicle) item).getBrand() +
        		", modelo: " + ((Vehicle) item).getModel() +
        		", combustível: " + ((Vehicle) item).getFuel() +
        		", quantidade de portas: " + ((Vehicle) item).getDoors() +
        		", cor: " + ((Vehicle) item).getColor() +
        		", quantidade de assentos: " + ((Vehicle) item).getSeats() +
        		", descrição do motor: " + ((Vehicle) item).getMotorDescription() +
        		", número de chassis: " + ((Vehicle) item).getChassis() +'.'            		        
        );
	}
}