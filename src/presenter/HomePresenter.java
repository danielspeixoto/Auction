package presenter;

import contract.Home;
import model.HomeModel;
import model.pojo.Item;

public class HomePresenter implements Home.Presenter {

    private Home.View view;
    private Home.Model model;

    public HomePresenter(Home.View view) {
        this.view = view;
        model = new HomeModel(this);
    }

    @Override
    public void getAuctions() {
        model.getAuctions();
    }

    @Override
    public void onReceiveItem(Item item) {
        view.onReceiveItem(item);
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}
