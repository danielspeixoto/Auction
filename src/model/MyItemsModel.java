package model;

import contract.Home;
import mock.AuctionDatabase;
import model.pojo.Auction;
import util.Global;
import util.Transmitter;

public class MyItemsModel implements Home.Model {

    private Home.Presenter presenter;

    public MyItemsModel(Home.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public synchronized void getAuctions() {
        AuctionDatabase.getAll(new Transmitter() {
            @Override
            public void onReceived(Object obj) {
                Auction auction = (Auction) obj;
                if(auction.getRemainingTime() < 0 && auction.getLastBidderId() == Global.getCurrentUser().getId()) {
                    presenter.onReceiveAuction((Auction)obj);
                }
            }
        });
    }
}
