package presenter;

import contract.CreateItem;
import model.CreateItemModel;
import model.pojo.Item;
import util.Validate;

public class CreateItemPresenter implements CreateItem.Presenter {

    private CreateItem.View view;
    private CreateItem.Model model;

    public CreateItemPresenter(CreateItem.View view) {
        this.view = view;
        this.model = new CreateItemModel(this);
    }

    @Override
    public void createItem(Item item) {
        String result = Validate.validate(item);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createItem(item);
                }
            }).start();
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
        view.close();
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}