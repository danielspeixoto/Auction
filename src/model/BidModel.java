package model;

import contract.Bid;
import mock.AccountDatabase;
import mock.AuctionDatabase;
import mock.Database;
import model.pojo.Account;
import model.pojo.Auction;
import model.pojo.User;
import util.Convert;
import util.Global;

public class BidModel implements Bid.Model {

    private Bid.Presenter presenter;

    public BidModel(Bid.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bid(Auction auction, double value) {
        User user = Global.getCurrentUser();
        Account account = user.getAccount();
        try {
            account.addFrozenBalance(value);
            Database.update(AccountDatabase.PATH_ACCOUNTS, account, account.getUserId());

            if(auction.getLastBidderId() != -1) {
                int id = auction.getLastBidderId();
                Account lastBidder = Convert.accountFrom(Database.getData(AccountDatabase.PATH_ACCOUNTS,
                        Database.INDEX_ID, String.valueOf(id)));

                lastBidder.removeFrozenBalance(auction.getLastBid());
                Database.update(AccountDatabase.PATH_ACCOUNTS, lastBidder, id);
            }

            auction.setLastBidderId(user.getId());
            auction.setLastBid(value);
            auction.setLastBidMillis(System.currentTimeMillis());

            AuctionDatabase.update(auction);

            presenter.onBidSuccess(auction);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}