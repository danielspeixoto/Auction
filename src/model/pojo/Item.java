package model.pojo;

public class Item {
    private Integer id;
    private Integer ownerId;
    private String description;
    private Integer auctionId;

    public Item(Integer ownerId, String description) {
        this.ownerId = ownerId;
        this.description = description;
    }

    public Item(Integer ownerId, Integer auctionId, String description) {
        this.ownerId = ownerId;
        this.auctionId = auctionId;
        this.description = description;
    }

    public Item(Integer id, Integer ownerId, Integer auctionId, String description) {
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

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public String toString() {
        String str = id == null ? "" : id.toString() + ",";
        if (auctionId == null) throw new NullPointerException();
        return str + ownerId +
                "," + auctionId +
                "," + description;
    }
}
