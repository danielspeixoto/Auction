package presenter;

import contract.Home;
import model.MyItemsModel;
import model.pojo.Auction;

public class MyItemsPresenter implements Home.Presenter {

    private Home.View view;
    private Home.Model model;

    public MyItemsPresenter(Home.View view) {
        this.view = view;
        model = new MyItemsModel(this);
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
