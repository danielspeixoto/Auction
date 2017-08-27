package model.pojo;

public class Item {
    private Integer id;
    private Integer ownerId;
    private String name;
    private String description;
    private char type;

    public Item(Integer ownerId, String name, String description, char type) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Item(Integer id, Integer ownerId, String name, String description, char type) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public char getType() {
        return this.type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String str = id == null ? "" : id.toString() + ",";
        return str + ownerId +
                "," + name +
                "," + description +
                "," + type;
    }
}
