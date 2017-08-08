package model.pojo;

public class Item {
    private int id;
    private User owner;
    private String description;
    private Auction auction;

    public Item(User owner, String description) {
        this.owner = owner;
        this.description = description;
    }

    public Item(int id, User owner, String description) {
        this.id = id;
        this.owner = owner;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public String toString() {
        return id +
                "," + owner +
                ",'" + description;
    }
}
