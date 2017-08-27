package model.pojo;

public class Misc extends Item {
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
    private String containerDescription;

    public Misc(Integer ownerId, String name, String description, char type) {
        super(ownerId, name, description, type);
    }
    
    public Misc(Integer ownerId, String name, String description, char type, Double length, Double width, Double height, Double weight, String containerDescription) {
        super(ownerId, name, description, type);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.containerDescription = containerDescription;
    }
    
    public void setLength(Double length) {
    	this.length = length;
    }
    
    public Double getLength() {
    	return this.length;
    }
    
    public void setWidth(Double width) {
    	this.width = width;
    }
    
    public Double getWidth() {
    	return this.width;
    }
    
    public void setHeight(Double height) {
    	this.height = height;
    }
    
    public Double getHeight() {
    	return this.height;
    }
    
    public void setWeight(Double weight) {
    	this.weight = weight;
    }
    
    public Double getWeight() {
    	return this.weight;
    }
    
    public void setContainerDesccription(String containerDescription) {
    	this.containerDescription = containerDescription;
    }
    
    public String getContainerDescription() {
    	return this.containerDescription;
    }
    
    @Override
    public String toString() {
        String str = super.toString();
		return str +
        		"," + length +
                "," + width +
                "," + height +
                "," + weight +
                "," + containerDescription;
    }
}
