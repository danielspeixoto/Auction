package model.pojo;

import mock.Database;

import java.io.Serializable;

public class Auction implements Serializable {

    private Integer id;
    private Integer minPercentForNewBids;
    private long expirationTime;
    private long lastBidMillis = 0;
    private Integer lastBidderId = -1;
    private Integer itemId;
    private Integer ownerId;
    private Item item;
    private Double lastBid = 0.0;



    public Auction(Integer ownerId, Integer minPercentForNewBids, long expirationTime,
                   Integer itemId, Double lastBid) {
        this.minPercentForNewBids = minPercentForNewBids;
        this.expirationTime = expirationTime;
        this.itemId = itemId;
        this.ownerId = ownerId;
        this.lastBid = lastBid;
    }

    public Auction(Integer id, Integer minPercentForNewBids, long expirationTime,
                   long lastBidMillis, Integer lastBidderId, Integer itemId, Integer ownerId, Double lastBid) {
        this.id = id;
        this.minPercentForNewBids = minPercentForNewBids;
        this.expirationTime = expirationTime;
        this.lastBidMillis = lastBidMillis;
        this.lastBidderId = lastBidderId;
        this.itemId = itemId;
        this.ownerId = ownerId;
        this.lastBid = lastBid;
    }

    public long getRemainingTime() {
        if(getLastBidderId() != -1) {
            return (getExpirationTime() + getLastBidMillis() - System.currentTimeMillis());
        }
        return 1;
    }

    public Double getLastBid() {
        return lastBid;
    }

    public void setLastBid(Double lastBid) {
        this.lastBid = lastBid;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public double getNextBidMin() {
        return (minPercentForNewBids/100.0 + 1) * lastBid + 1;
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
        String str = id == null ? "" : id.toString() + Database.SPLIT;
        return str +
                minPercentForNewBids + Database.SPLIT +
                expirationTime + Database.SPLIT +
                lastBidMillis + Database.SPLIT +
                lastBidderId + Database.SPLIT +
                itemId + Database.SPLIT +
                ownerId + Database.SPLIT +
                lastBid;
    }
}
