package model;

import contract.CreateAuction;
import mock.AuctionDatabase;
import mock.Database;
import model.pojo.Auction;

public class CreateAuctionModel implements CreateAuction.Model {

    private CreateAuction.Presenter presenter;

    public CreateAuctionModel(CreateAuction.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createAuction(Auction auction) {
        int result;
        try {
            result = Database.insert(AuctionDatabase.PATH_AUCTIONS, auction);
            auction.setId(result);
            presenter.onCreateSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}