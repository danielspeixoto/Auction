package presenter;

import contract.Bid;
import model.BidModel;
import model.pojo.Auction;
import model.pojo.User;
import util.Global;

public class BidPresenter implements Bid.Presenter {

    private Bid.View view;
    private Bid.Model model;

    public BidPresenter(Bid.View view) {
        this.view = view;
        this.model = new BidModel(this);
    }

    @Override
    public void bid(Auction auction, double value) {
        User user = Global.getCurrentUser();
        if(auction.getRemainingTime() <= 0) {
            view.showErrorDialog("Tempo esgotado");
        } else if(value < auction.getNextBidMin()) {
            view.showErrorDialog("Valor inserido não é grande o suficiente!");
        } else if(user.getAccount().getBalance() < value) {
            view.showErrorDialog("Saldo indisponível para esta transação!");
        } else {
            model.bid(auction, value);
        }
    }

    @Override
    public void onBidSuccess(Auction auction) {
        User user = Global.getCurrentUser();
        view.onBidSuccess(auction);
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}
