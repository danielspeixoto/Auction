package model;

import contract.CreateItem;
import mock.Database;
import mock.ItemDatabase;
import model.pojo.Item;

import java.io.IOException;

public class CreateItemModel implements CreateItem.Model {

    private CreateItem.Presenter presenter;

    public CreateItemModel(CreateItem.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createItem(Item item) {
        int result;
        try {
            result = Database.insert(ItemDatabase.PATH_ITEMS, item);
            item.setId(result);
            presenter.onCreateSuccess();
        } catch (IOException e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}