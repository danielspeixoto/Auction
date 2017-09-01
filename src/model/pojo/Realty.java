package model.pojo;

public class Realty extends Item {
    private String location;
    private Double squareMeters;
    private int constructionYear;

    public Realty(Integer ownerId, String name, String description, char type) {
        super(ownerId, name, description, type);
    }
    
    public Realty(Integer ownerId, String name, String description, char type, String location, Double squareMeters, int constructionYear) {
        super(ownerId, name, description, type);
        this.location = location;
        this.squareMeters = squareMeters;
        this.constructionYear = constructionYear;
    }
    
    public void setLocation(String location) {
    	this.location = location;
    }
    
    public String getLocation() {
    	return this.location;
    }
    
    public void setSquareMeters(Double squareMeters) {
    	this.squareMeters = squareMeters;
    }
    
    public Double getSquareMeters() {
    	return this.squareMeters;
    }
    
    public void setConstructionYear(int constructionYear) {
    	this.constructionYear = constructionYear;
    }
    
    public int getConstructionYear() {
    	return this.constructionYear;
    }
    
    @Override
    public String toString() {
        String str = super.toString();
		return str +
        		"," + location +
                "," + squareMeters +
                "," + constructionYear;
    }
}
