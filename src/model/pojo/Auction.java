package model.pojo;

import java.io.Serializable;

public class Auction implements Serializable {

    private Integer id;
    private Integer minPercentForNewBids;
    private long expirationTime;
    private long lastBidMillis;
    private Integer lastBidderId;
    private Integer itemId;
    private Integer ownerId;

    public Auction(Integer ownerId, Integer minPercentForNewBids, long expirationTime,
                   Integer itemId) {
        this.minPercentForNewBids = minPercentForNewBids;
        this.expirationTime = expirationTime;
        this.itemId = itemId;
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinPercentForNewBids() {
        return minPercentForNewBids;
    }

    public void setMinPercentForNewBids(Integer minPercentForNewBids) {
        this.minPercentForNewBids = minPercentForNewBids;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public long getLastBidMillis() {
        return lastBidMillis;
    }

    public void setLastBidMillis(long lastBidMillis) {
        this.lastBidMillis = lastBidMillis;
    }

    public Integer getLastBidderId() {
        return lastBidderId;
    }

    public void setLastBidderId(Integer lastBidderId) {
        this.lastBidderId = lastBidderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        String str = id == null ? "" : id.toString() + ",";
        return str +
                minPercentForNewBids + "," +
                expirationTime + "," +
                lastBidMillis + "," +
                lastBidderId + "," +
                itemId + "," +
                ownerId;
    }
}
