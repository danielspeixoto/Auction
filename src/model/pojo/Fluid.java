package model.pojo;

public class Fluid extends Item {
	
	private String containerDescription;
	private double containerLength;
	private double containerWidth;
	private double containerHeight;
	private double volume;
	private double radius;
	private double weight;
	public static final char TYPE = 'f';
	
	public Fluid(Integer ownerId, String name, String description, String containerDescription,
				 double containerLength, double containerWidth, double containerHeight,
				 double volume, double radius, double weight) {
		super(ownerId, name, description, TYPE);
		this.containerDescription = containerDescription;
		this.containerLength = containerLength;
		this.containerWidth = containerWidth;
		this.containerHeight = containerHeight;
		this.volume = volume;
		this.radius = radius;
		this.weight = weight;
	}

	public Fluid(Integer id, Integer ownerId, String name, String description, String containerDescription,
				 double containerLength, double containerWidth, double containerHeight,
				 double volume, double radius, double weight) {
		super(id, ownerId, name, description, TYPE);
		this.containerDescription = containerDescription;
		this.containerLength = containerLength;
		this.containerWidth = containerWidth;
		this.containerHeight = containerHeight;
		this.volume = volume;
		this.radius = radius;
		this.weight = weight;
	}
	
	public String getContainerDescription() {
		return containerDescription;
	}
	public void setContainerDescription(String containerDescription) {
		this.containerDescription = containerDescription;
	}
	public double getContainerLength() {
		return containerLength;
	}
	public void setContainerLength(double containerLength) {
		this.containerLength = containerLength;
	}
	public double getContainerWidth() {
		return containerWidth;
	}
	public void setContainerWidth(double containerWidth) {
		this.containerWidth = containerWidth;
	}
	public double getContainerHeight() {
		return containerHeight;
	}
	public void setContainerHeight(double containerHeight) {
		this.containerHeight = containerHeight;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}	

	@Override
    public String toString() {
        String str = super.toString();
		return str +
        		"," + containerDescription +
        		"," + containerLength +
        		"," + containerWidth +
        		"," + containerHeight +
        		"," + volume +
        		"," + radius +
        		"," + weight;
    }
}
