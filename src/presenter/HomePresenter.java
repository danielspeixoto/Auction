package presenter;

import contract.Home;
import model.HomeModel;
import model.pojo.Auction;

public class HomePresenter implements Home.Presenter {

    private Home.View view;
    private Home.Model model;

    public HomePresenter(Home.View view) {
        this.view = view;
        model = new HomeModel(this);
    }

    @Override
    public void syncAuctions() {
        view.clearAuctions();
        model.getAuctions();
    }

    @Override
    public void onReceiveAuction(Auction auction) {
        view.onReceiveAuction(auction);
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}
