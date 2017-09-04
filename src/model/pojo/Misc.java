package model.pojo;

import mock.Database;

public class Misc extends Item {
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
    private String containerDescription;
    public static final char TYPE = 'm';

    public Misc(Integer ownerId, String name, String description, Double length, Double width, Double height, Double weight, String containerDescription) {
        super(ownerId, name, description, TYPE);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.containerDescription = containerDescription;
    }

    public Misc(Integer id, Integer ownerId, String name, String description, Double length, Double width, Double height, Double weight, String containerDescription) {
        super(id, ownerId, name, description, TYPE);
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
        		Database.SPLIT + length +
                Database.SPLIT + width +
                Database.SPLIT + height +
                Database.SPLIT + weight +
                Database.SPLIT + containerDescription;
    }
}
