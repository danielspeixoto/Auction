package model.pojo;

public class Item {
    private Integer id;
    private Integer ownerId;
    private String description;

    public Item(Integer ownerId, String description) {
        this.ownerId = ownerId;
        this.description = description;
    }

    public Item(Integer id, Integer ownerId, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String str = id == null ? "" : id.toString() + ",";
        return str + ownerId +
                "," + description;
    }
}
