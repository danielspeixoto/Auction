package model;

import contract.Home;
import mock.ItemDatabase;
import model.pojo.Item;
import util.ItemTransmitter;

public class HomeModel implements Home.Model {

    private Home.Presenter presenter;

    public HomeModel(Home.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getAuctions() {
        ItemDatabase.getAll(new ItemTransmitter() {
            @Override
            public void onItemReceived(Item item) {
                presenter.onReceiveItem(item);
            }
        });
    }
}
