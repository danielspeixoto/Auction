package model;

import contract.Home;
import mock.AuctionDatabase;
import model.pojo.Auction;
import util.Transmitter;

public class HomeModel implements Home.Model {

    private Home.Presenter presenter;

    public HomeModel(Home.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public synchronized void getAuctions() {
        AuctionDatabase.getAll(new Transmitter() {
            @Override
            public void onReceived(Object obj) {
                Auction auction = (Auction) obj;
                if(auction.getRemainingTime() > 0) {
                    presenter.onReceiveAuction((Auction)obj);
                }
            }
        });
    }
}
