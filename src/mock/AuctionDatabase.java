package mock;

import model.pojo.Auction;
import util.Convert;
import util.Transmitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AuctionDatabase extends Database {

    public static final int PATH_MIN_PERCENT_FOR_NEW_BIDS = 1;
    public static final int PATH_EXPIRATION_TIME = 2;
    public static final int PATH_LAST_BID_MILLIS = 3;
    public static final int PATH_LAST_BIDDER_ID = 4;
    public static final int PATH_ITEM_ID = 5;
    public static final int PATH_OWNER_ID = 6;
    public static final String PATH_AUCTIONS = "src//data//auctions.txt";
    public static final int PATH_LAST_BID = 7;

    public static void getAll(Transmitter transmitter) {
        try (FileReader reader = new FileReader(PATH_AUCTIONS);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Auction auction = Convert.auctionFrom(line);
                auction.setItem(ItemDatabase.getItem(auction.getItemId()));
                transmitter.onReceived(auction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}