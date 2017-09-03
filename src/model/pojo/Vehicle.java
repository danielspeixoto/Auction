package model.pojo;

public class Vehicle extends Item {
	
	private String mileage;
    private String brand;
    private String model;
    private int doors;
    private String fuel;
    private String color;
    private int seats;
    private String motorDescription;
    private String chassis;
    
    public Vehicle(Integer ownerId, String name, String description, char type) {
        super(ownerId, name, description, type);
    }
    
    public Vehicle(Integer ownerId, String name, String description, char type, String mileage, String brand, String model, int doors, String fuel, String color, int seats, String motorDescription, String chassis) {
        super(ownerId, name, description, type);
        this.mileage = mileage;
        this.brand = brand;
        this.model = model;
        this.doors = doors;
        this.fuel = fuel;
        this.color = color;
        this.seats = seats;
        this.motorDescription = motorDescription;
        this.chassis = chassis;
    }
	
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getMotorDescription() {
		return motorDescription;
	}
	public void setMotorDescription(String motorDescription) {
		this.motorDescription = motorDescription;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	
	@Override
    public String toString() {
        String str = super.toString();
		return str +
        		"," + mileage +
                "," + brand +
                "," + model +
                "," + doors +
                "," + fuel +
                "," + color +
                "," + seats +
                "," + motorDescription +
                "," + chassis;
    }
	
}
