package model.pojo;

import mock.Database;

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
	public static final char TYPE = 'v';
    
    public Vehicle(Integer ownerId, String name, String description, String mileage, String brand, String model,
				   int doors, String fuel, String color, int seats, String motorDescription, String chassis) {
        super(ownerId, name, description, TYPE);
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

	public Vehicle(Integer id, Integer ownerId, String name, String description, String mileage, String brand, String model,
				   int doors, String fuel, String color, int seats, String motorDescription, String chassis) {
		super(id, ownerId, name, description, TYPE);
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
        		Database.SPLIT + mileage +
                Database.SPLIT + brand +
                Database.SPLIT + model +
                Database.SPLIT + doors +
                Database.SPLIT + fuel +
                Database.SPLIT + color +
                Database.SPLIT + seats +
                Database.SPLIT + motorDescription +
                Database.SPLIT + chassis;
    }
	
}
